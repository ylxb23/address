package com.zero.address.domain.service;

import com.zero.address.domain.request.AddressScanRequest;
import com.zero.address.domain.response.AddressVo;

/**
 * 三级地址服务
 * @date 2018年1月10日 下午5:38:51
 * @author zero
 */
public interface AddressService {

	/**
	 * 三级地址查询
	 * @param reqObj
	 * @return
	 */
	AddressVo scanAddress(AddressScanRequest reqObj);

}
