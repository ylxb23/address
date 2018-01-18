package com.zero.address.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zero.address.domain.request.AddressScanRequest;
import com.zero.address.domain.response.AddressVo;
import com.zero.address.domain.response.CountryVo;
import com.zero.address.domain.service.AddressService;

/**
 * RESTful(Representational State Transfer) HTTP 接口
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
	@RequestMapping(value="/areas", method= {RequestMethod.GET})
	public ResponseEntity<AddressVo> getAddressInfo(HttpServletRequest request, AddressScanRequest reqObj) {
		if(reqObj == null) {
			reqObj = new AddressScanRequest();
		}
		AddressVo address = addressService.scanAddress(reqObj);
		return ResponseEntity.ok(address);
	}
	
	/**
	 * 获取国家列表
	 * @return
	 */
	@RequestMapping(value="/countries", method= {RequestMethod.GET})
	public ResponseEntity<List<CountryVo>> getCountryList() {
		List<CountryVo> countries = addressService.countries();
		return ResponseEntity.ok(countries);
	}
}
