package com.coder.form;

import com.coder.model.ServicType;

public class ServicForm {
	private String servicId;
	private String servicTypeId;
	private String servicName;
	private String servicPoint;
	private String servicMinute;
	private String servicAbout;
	
	public String getServicName() {
		return servicName;
	}
	public void setServicName(String servicName) {
		this.servicName = servicName;
	}
	
	public String getServicAbout() {
		return servicAbout;
	}
	public void setServicAbout(String servicAbout) {
		this.servicAbout = servicAbout;
	}
	public String getServicId() {
		return servicId;
	}
	public void setServicId(String servicId) {
		this.servicId = servicId;
	}
	public String getServicPoint() {
		return servicPoint;
	}
	public void setServicPoint(String servicPoint) {
		this.servicPoint = servicPoint;
	}
	public String getServicMinute() {
		return servicMinute;
	}
	public void setServicMinute(String servicMinute) {
		this.servicMinute = servicMinute;
	}
	public String getServicTypeId() {
		return servicTypeId;
	}
	public void setServicTypeId(String servicTypeId) {
		this.servicTypeId = servicTypeId;
	}
}
