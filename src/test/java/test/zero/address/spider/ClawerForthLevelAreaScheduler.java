package test.zero.address.spider;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zero.address.dao.entity.Area;
import com.zero.address.dao.entity.AreaExample;
import com.zero.address.dao.repository.AreaMapper;
import com.zero.address.domain.request.AddressScanRequest;
import com.zero.address.domain.response.AddressVo;
import com.zero.address.domain.service.AddressService;

import test.zero.address.TestBasic;

/**
 * 抓取街道（第四级）信息
 * @date 2018年1月11日 下午3:58:54
 * @author zero
 */
public class ClawerForthLevelAreaScheduler extends TestBasic {
	private final Logger logger = LoggerFactory.getLogger(ClawerForthLevelAreaScheduler.class);
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AreaMapper areaMapper;
	
	private static AtomicInteger countDistrict = new AtomicInteger(0);
	private static AtomicInteger countStreat = new AtomicInteger(0);
	
	/**
	 * do not execute this !!!
	 * clawer all
	 */
//	@Test
	public void clawer() {
		long start = System.currentTimeMillis();
		final HttpClient httpclient = buildHttpClient();
		final AddressScanRequest reqObj = new AddressScanRequest();
		// 获取第一级
		AddressVo china = addressService.scanAddress(reqObj);
		china.getChildren().forEach(province -> {
			// 获取第二级
			String l1 = province.getAreaCode();
			reqObj.setAreaCode(l1);
			AddressVo provincePro = addressService.scanAddress(reqObj);
			province.setChildren(provincePro.getChildren());
			// 获取第三级
			if(provincePro.getChildren() == null) return;
			provincePro.getChildren().forEach(city -> {
				String l2 = city.getAreaCode();
				reqObj.setAreaCode(l2);
				AddressVo cityPro = addressService.scanAddress(reqObj);
				city.setChildren(cityPro.getChildren());
				
				if(cityPro.getChildren() == null) return;
				cityPro.getChildren().forEach(district -> {
					countDistrict.incrementAndGet();
					String l3 = district.getAreaCode();
					doClawer(httpclient, l1, l2, l3, district);
					try { Thread.sleep(100L); } catch (InterruptedException e) {}
				});
			});
		});
		
		long stop = System.currentTimeMillis();
		logger.info("用时: {}ms", (stop-start));
		logger.info("共有区/县[{}]个, 抓取到街道数量[{}]个.", countDistrict.get(), countStreat.get());
	}
	
	private void updateToDone(AddressVo district) {
		AreaExample example = new AreaExample();
		example.createCriteria().andAreaCodeEqualTo(district.getAreaCode());
		Area record = new Area();
		// 因为没有设置成功的标识位，采用临时解决方案
		record.setLevel((byte) (district.getLevel() + (byte) 10));
		areaMapper.updateByExampleSelective(record, example);
	}

	private String uriBuilder(String l1, String l2, String l3) {
		return new StringBuilder("https://lsp.wuliu.taobao.com/locationservice/addr/output_address_town_array.do?l1=")
				.append(l1).append("&l2=").append(l2).append("&l3=").append(l3).append("&lang=zh-S").toString();
	}
	
	private void doClawer(HttpClient httpclient, String l1, String l2, String l3, AddressVo district) {
		String uri = uriBuilder(l1, l2, l3);
		HttpGet get = new HttpGet(uri);
		try {
			HttpResponse response = httpclient.execute(get);
			HttpEntity entity = response.getEntity();
			int status = response.getStatusLine().getStatusCode();
			if(status == HttpStatus.SC_OK) {
				String res = EntityUtils.toString(entity);
				String text = res.substring(9, res.length()-2);
				logger.info("Fetch [{}th] msg by area code l1[{}], l2[{}], l3[{}], response: {}", countDistrict.get(), l1, l2, l3, text);
				parse(text);
				updateToDone(district);
			} else {
				logger.error("Fetch uri[{}] failure, status[{}], response header[{}]", uri, status, entity.getContentType().toString());
			}
		} catch (IOException e) {
			logger.error("Fetch area code l1[{}], l2[{}], l3[{}] failure.", l1, l2, l3, e);
		}
	}
	private void parse(String text) {
		JSONObject json = JSONObject.parseObject(text);
		JSONArray arr = json.getJSONArray("result");
		for(int i=0; i<arr.size(); i++) {
			JSONArray item = arr.getJSONArray(i);
			Area area = new Area();
			area.setAreaCode(item.getString(0));
			area.setName(item.getString(1));
			area.setParentCode(item.getString(2));
			area.setAliaName(item.getString(3));
			area.setType((byte) 0);
			area.setLevel((byte) 4);
			
			areaMapper.insertSelective(area);
			countStreat.incrementAndGet();
		}
	}
	private HttpClient buildHttpClient() {
		return HttpClientBuilder.create()
				.disableCookieManagement()
				.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
				.build();
	}
	
}
