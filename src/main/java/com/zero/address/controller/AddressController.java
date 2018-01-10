package com.zero.address.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zero.address.domain.request.AddressGetRequest;
import com.zero.address.domain.response.AddressVo;
import com.zero.address.domain.service.AddressService;

/**
 * HTTP 接口
 * @date 2018年1月10日 下午5:40:15
 * @author zero
 */
@RestController
@RequestMapping(value="/address", produces="application/json; charset=UTF-8")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	/**
	 * 获取三级地址信息
	 * @param request
	 * @param reqObj
	 * @return
	 */
	@RequestMapping(value="/scan", method= {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<AddressVo> getAddressInfo(HttpServletRequest request, AddressGetRequest reqObj) {
		Assert.notNull(reqObj, "请求参数有误");
		AddressVo address = addressService.scanAddress(reqObj);
		return ResponseEntity.ok(address);
	}
	
}
