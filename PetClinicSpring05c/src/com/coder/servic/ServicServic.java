package com.coder.servic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.ServicDao;
import com.coder.dao.ServicTypeDao;
import com.coder.form.ServicForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.model.Servic;
import com.coder.model.ServicType;

@Service
@Repository("servicServic")
public class ServicServic {
	@Autowired
	private ServicDao servicDao;
	@Autowired
	private ServicTypeDao servicTypeDao;
	
	public void preparServicRegister(ServicRegisterForm servicRegisterForm){
		ServicForm servicForm=servicRegisterForm.getServicForm();
		if(servicForm!=null){
			this.servicRegister(servicForm);
			servicForm=null;
		  }
		servicRegisterForm.setServicForm(servicForm);
		List<ServicType> servicTypes=this.servicTypeDao.getServicTypes();
		List<Servic> servics=this.servicDao.getServics();
		servicRegisterForm.setServics(servics);
		for( ServicType be:servicTypes){
		servicRegisterForm.getMapServicTypes().put(""+be.getServicTypeId(),""+be.getServicTypeName());
		}
         }
	
	private int servicRegister(ServicForm servicForm){
		Servic servic=new Servic();
		servic.setServicName(servicForm.getServicName());
		servic.setServicMinute(Integer.parseInt(servicForm.getServicMinute()));
		servic.setServicPoint(Integer.parseInt(servicForm.getServicPoint()));
		servic.setServicAbout(servicForm.getServicAbout());
	    ServicType servicType=new ServicType();
	    servicType.setServicTypeId(Integer.parseInt(servicForm.getServicTypeId()));
	    servic.setServicType(servicType);
		int id=this.servicDao.saveServic(servic);
		return id; 
	}
	
	public void preparServicUpdate(ServicRegisterForm servicRegisterForm){
	ServicForm servicForm=servicRegisterForm.getServicForm();
	int servicId=Integer.parseInt(servicForm.getServicId());
	Servic servic=this.servicDao.getServicById(servicId);
	servicForm.setServicId(servic.getServicId()+"");
	servicForm.setServicName(servic.getServicName());
	servicForm.setServicMinute(servic.getServicMinute()+"");
	servicForm.setServicPoint(servic.getServicPoint()+"");
	servicForm.setServicAbout(servic.getServicAbout());
	ServicType servicType=servic.getServicType();
	servicRegisterForm.setSelectServicType(servicType);
	servicRegisterForm.setServicForm(servicForm);
	List<ServicType> servicTypes=this.servicTypeDao.getServicTypes();
	for( ServicType be:servicTypes){
		if(be.getServicTypeId()!=servicType.getServicTypeId())
		servicRegisterForm.getMapServicTypes().put(""+be.getServicTypeId(),""+be.getServicTypeName());
		}
	}
	
	public void servicUpdate(ServicRegisterForm servicRegisterForm){
		ServicForm servicForm=servicRegisterForm.getServicForm();
		Servic servic=new Servic();
		servic.setServicId(Integer.parseInt(servicForm.getServicId()));
		servic.setServicName(servicForm.getServicName());
		servic.setServicAbout(servicForm.getServicAbout());
		servic.setServicMinute(Integer.parseInt(servicForm.getServicMinute()));
		servic.setServicPoint(Integer.parseInt(servicForm.getServicPoint()));
		ServicType servicType=new ServicType();
		servicType.setServicTypeId(Integer.parseInt(servicForm.getServicTypeId()));
		servic.setServicType(servicType);
		this.servicDao.updateServic(servic);
		servicForm=null;
		servicRegisterForm.setServicForm(servicForm);
	}
	public void servicDelete(ServicRegisterForm servicRegisterForm){
		ServicForm servicForm=servicRegisterForm.getServicForm();
		int id=Integer.parseInt(servicForm.getServicId());
		Servic servic=this.servicDao.getServicById(id);
        this.servicDao.deleteServic(servic);
		servicForm=null;
		servicRegisterForm.setServicForm(servicForm);
		
	}

}
