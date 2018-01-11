package com.zero.address.domain.request;

/**
 * 请求地址服务对象
 * @date 2018年1月10日 下午5:44:15
 * @author zero
 */
public class AddressScanRequest {
	
	private String areaCode = "1";
	
	private Byte level = 0;
	
	private Boolean children = Boolean.TRUE;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Boolean getChildren() {
		return children;
	}

	public void setChildren(Boolean children) {
		this.children = children;
	}

	public Byte getLevel() {
		return level;
	}

	public void setLevel(Byte level) {
		this.level = level;
	}
	
	
}
