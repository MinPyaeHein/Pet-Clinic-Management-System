package com.coder.form;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.model.Servic;
import com.coder.model.ServicType;

public class ServicRegisterForm {
private ServicForm servicForm;
private List<Servic> servics;
private ServicType selectServicType;
private Map<String,String> mapServicTypes=new HashedMap<String,String>();
public ServicForm getServicForm() {
	return servicForm;
}
public void setServicForm(ServicForm servicForm) {
	this.servicForm = servicForm;
}

public List<Servic> getServics() {
	return servics;
}
public void setServics(List<Servic> servics) {
	this.servics = servics;
}
public ServicType getSelectServicType() {
	return selectServicType;
}
public void setSelectServicType(ServicType selectServicType) {
	this.selectServicType = selectServicType;
}
public Map<String, String> getMapServicTypes() {
	return mapServicTypes;
}
public void setMapServicTypes(Map<String, String> mapServicTypes) {
	this.mapServicTypes = mapServicTypes;
}
}
