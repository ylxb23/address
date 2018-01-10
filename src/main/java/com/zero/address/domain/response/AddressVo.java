package com.zero.address.domain.response;

import java.io.Serializable;
import java.util.List;

/**
 * 地址展示对象
 * @date 2018年1月10日 下午5:43:26
 * @author zero
 */
public class AddressVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8666574177529678887L;

	private String areaCode;
	private String name;
	private String aliaName;
	private String parentCode;
	private Byte level;
	private Byte type;
	
	private List<AddressVo> children;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAliaName() {
		return aliaName;
	}

	public void setAliaName(String aliaName) {
		this.aliaName = aliaName;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Byte getLevel() {
		return level;
	}

	public void setLevel(Byte level) {
		this.level = level;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public List<AddressVo> getChildren() {
		return children;
	}

	public void setChildren(List<AddressVo> children) {
		this.children = children;
	}
	
}
