package com.coder.servic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.coder.dao.ServicTypeDao;

import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;

import com.coder.model.ServicType;

@Service
@Repository("servicTypeServic")
public class ServicTypeServic {
	@Autowired
	private ServicTypeDao servicTypeDao;
	
	
	public void preparServicTypeRegister(ServicTypeRegisterForm servicTypeRegisterForm){
		ServicTypeForm servicTypeForm=servicTypeRegisterForm.getServicTypeForm();
		if(servicTypeForm!=null){
			this.servicTypeRegister(servicTypeForm);
			servicTypeForm=null;
		  }
		servicTypeRegisterForm.setServicTypeForm(servicTypeForm);
		List<ServicType> servicTypes=this.servicTypeDao.getServicTypes();
		servicTypeRegisterForm.setServicTypes(servicTypes);
         }
	
	private int servicTypeRegister(ServicTypeForm servicTypeForm){
		ServicType servicType=new ServicType();
		servicType.setServicTypeName(servicTypeForm.getServicTypeName());
		servicType.setServicTypeDesc(servicTypeForm.getServicTypeDesc());
		servicType.setAverageTime(Integer.parseInt(servicTypeForm.getAverageTime()));
		int id=this.servicTypeDao.saveServicType(servicType);
		return id; 
	}
	
	public void preparServicTypeUpdate(ServicTypeRegisterForm servicTypeRegisterForm){
		ServicTypeForm servicTypeForm=servicTypeRegisterForm.getServicTypeForm();
	int servicTypeId=Integer.parseInt(servicTypeForm.getServicTypeId());
	ServicType servicType=this.servicTypeDao.getServicTypeById(servicTypeId);
	servicTypeForm.setServicTypeId(servicType.getServicTypeId()+"");
	servicTypeForm.setServicTypeName(servicType.getServicTypeName());
	servicTypeForm.setServicTypeDesc(servicType.getServicTypeDesc());
	servicTypeForm.setAverageTime(servicType.getAverageTime()+"");
	servicTypeRegisterForm.setServicTypeForm(servicTypeForm);
	}
	
	public void servicTypeUpdate(ServicTypeRegisterForm servicTypeRegisterForm){
		ServicTypeForm servicTypeForm=servicTypeRegisterForm.getServicTypeForm();
		if(servicTypeForm!=null){
		ServicType servicType=new ServicType();
		servicType.setServicTypeId(Integer.parseInt(servicTypeForm.getServicTypeId()));
		servicType.setServicTypeName(servicTypeForm.getServicTypeName());
		servicType.setServicTypeDesc(servicTypeForm.getServicTypeDesc());
		servicType.setAverageTime(Integer.parseInt(servicTypeForm.getAverageTime()));
		this.servicTypeDao.updateServicType(servicType);
		}
		servicTypeForm=null;
		servicTypeRegisterForm.setServicTypeForm(servicTypeForm);
	}
	public void servicTypeDelete(ServicTypeRegisterForm servicTypeRegisterForm){
		ServicTypeForm servicTypeForm=servicTypeRegisterForm.getServicTypeForm();
		int id=Integer.parseInt(servicTypeForm.getServicTypeId());
		ServicType servicType=this.servicTypeDao.getServicTypeById(id);
		
		
		this.servicTypeDao.deleteServicType(servicType);
		servicTypeForm=null;
		servicTypeRegisterForm.setServicTypeForm(servicTypeForm);
		
	}

}
