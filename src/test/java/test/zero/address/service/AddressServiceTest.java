package test.zero.address.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.zero.address.domain.request.AddressScanRequest;
import com.zero.address.domain.response.AddressVo;
import com.zero.address.domain.response.CountryVo;
import com.zero.address.domain.service.AddressService;

import test.zero.address.TestBasic;

/**
 * 地址服务测试
 * @date 2018年1月10日 下午10:22:45
 * @author zero
 */
public class AddressServiceTest extends TestBasic {
	private final Logger logger = LoggerFactory.getLogger(AddressServiceTest.class);
	
	@Autowired
	private AddressService addressService;
	
	@Test
	public void testScanAddress() {
		AddressScanRequest reqObj = new AddressScanRequest();
		reqObj.setAreaCode("310100");	// 上海
		AddressVo address = addressService.scanAddress(reqObj);
		logger.info("scan address[{}] result: {}", JSONObject.toJSONString(reqObj), JSONObject.toJSONString(address));
		Assert.assertNotNull("address for ShangHai should not be null", address);
		Assert.assertNotNull("children for ShangHai should not be empty", address.getChildren());
	}
	
	@Test
	public void testGetCountries() {
		List<CountryVo> countries = addressService.countries();
		logger.info("total {} countries", countries.size());
		Assert.assertNotNull("countries should not be empty!", countries);
	}
	
}
