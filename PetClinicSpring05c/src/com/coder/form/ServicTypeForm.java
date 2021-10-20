package com.coder.form;

public class ServicTypeForm {
	private String servicTypeId;
	private String servicTypeName;
	private String servicTypeDesc;
	private String averageTime;
	public String getServicTypeName() {
		return servicTypeName;
	}
	public void setServicTypeName(String servicTypeName) {
		this.servicTypeName = servicTypeName;
	}
	public String getServicTypeDesc() {
		return servicTypeDesc;
	}
	public void setServicTypeDesc(String servicTypeDesc) {
		this.servicTypeDesc = servicTypeDesc;
	}
	public String getServicTypeId() {
		return servicTypeId;
	}
	public void setServicTypeId(String servicTypeId) {
		this.servicTypeId = servicTypeId;
	}
	public String getAverageTime() {
		return averageTime;
	}
	public void setAverageTime(String averageTime) {
		this.averageTime = averageTime;
	}
}
