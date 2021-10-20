package com.coder.form;

import java.util.List;

import com.coder.model.ServicType;

public class ServicTypeRegisterForm {
private ServicTypeForm servicTypeForm;
private List<ServicType> servicTypes;

public ServicTypeForm getServicTypeForm() {
	return servicTypeForm;
}

public void setServicTypeForm(ServicTypeForm servicTypeForm) {
	this.servicTypeForm = servicTypeForm;
}

public List<ServicType> getServicTypes() {
	return servicTypes;
}

public void setServicTypes(List<ServicType> servicTypes) {
	this.servicTypes = servicTypes;
}


}
