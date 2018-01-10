package com.zero.address.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.zero.address.dao.entity.Area;
import com.zero.address.dao.entity.AreaExample;
import com.zero.address.dao.repository.AreaMapper;
import com.zero.address.domain.request.AddressGetRequest;
import com.zero.address.domain.response.AddressVo;
import com.zero.address.domain.service.AddressService;

/**
 * 三级地址服务实现
 * @date 2018年1月10日 下午5:38:33
 * @author zero
 */
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AreaMapper areaMapper;
	
	/**
	 * 获取下一级三级地址
	 * @param reqObj
	 * @return
	 */
	@Override
	public AddressVo scanAddress(AddressGetRequest reqObj) {
		AreaExample example = new AreaExample();
		if(!StringUtils.isEmpty(reqObj.getAreaCode())) {
			example.createCriteria().andAreaCodeEqualTo(reqObj.getAreaCode());
		}
		List<Area> areas = areaMapper.selectByExample(example);
		Assert.notEmpty(areas, "传入的地区编码有误");
		AddressVo vo = buildFromArea(areas.get(0));
		if(!reqObj.getChildren()) {
			return vo;
		}
		// 获取下一级地区列表
		example = new AreaExample();
		example.createCriteria().andParentCodeEqualTo(vo.getAreaCode());
		areas = areaMapper.selectByExample(example);
		if(areas == null || areas.isEmpty()) {
			return vo;
		} else {
			List<AddressVo> children = areas.stream().map(area -> buildFromArea(area)).collect(Collectors.toList());
			vo.setChildren(children);
			return vo;
		}
	}
	private AddressVo buildFromArea(Area area) {
		AddressVo child = new AddressVo();
		child.setAliaName(area.getAliaName());
		child.setAreaCode(area.getAreaCode());
		child.setLevel(area.getLevel());
		child.setName(area.getName());
		child.setParentCode(area.getParentCode());
		child.setType(area.getType());
		return child;
	}

}
