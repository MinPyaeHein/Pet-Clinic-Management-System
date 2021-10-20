package com.coder.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.servic.ServicTypeServic;


@Controller
@Transactional
public class ServicTypeUpdateDeleteController {
	@Autowired
	private ServicTypeServic servicTypeServic;
	
	@RequestMapping("/servicTypeUpdatePath")
	public String servicTypeUpdateDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{ 
		ServicTypeRegisterForm servicTypeRegisterForm=new ServicTypeRegisterForm();
		ServicTypeForm servicTypeForm=new ServicTypeForm();
		String frmServicTypeId=req.getParameter("frmServicTypeId");
		servicTypeForm.setServicTypeId(frmServicTypeId);
		servicTypeRegisterForm.setServicTypeForm(servicTypeForm);
        modelMap.addAttribute("servicTypeRegisterForm",servicTypeRegisterForm);
		servicTypeServic.preparServicTypeUpdate(servicTypeRegisterForm);
		return "servicTypeUpdate";
	}
	
	@RequestMapping("/servicTypeUpdateSubmitPath")
	public String servicTypeUpdateSubmitDispatcher(@ModelAttribute("servicTypeRegisterForm") ServicTypeRegisterForm servicTypeRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	String cancle=req.getParameter("cancle");
		String update=req.getParameter("update");
		if(update!=null){
		servicTypeServic.servicTypeUpdate(servicTypeRegisterForm);
		
     }else if(cancle!=null){
    	 servicTypeRegisterForm.setServicTypeForm(null);
    	 servicTypeServic.servicTypeUpdate(servicTypeRegisterForm); 
     }
		this.servicTypeServic.preparServicTypeRegister(servicTypeRegisterForm);
		 modelMap.addAttribute("servicTypeRegisterForm",servicTypeRegisterForm);
		 return "servicTypeRegister";
	  }
	@RequestMapping("/servicTypeDeletePath")
	public String servicTypeDeleteDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{ 
		ServicTypeRegisterForm servicTypeRegisterForm=new ServicTypeRegisterForm();
		ServicTypeForm servicTypeForm=new ServicTypeForm();
		String frmServicTypeId=req.getParameter("frmServicId");
		servicTypeForm.setServicTypeId(frmServicTypeId);
		servicTypeRegisterForm.setServicTypeForm(servicTypeForm);
       
		this.servicTypeServic.servicTypeDelete(servicTypeRegisterForm);
		this.servicTypeServic.preparServicTypeRegister(servicTypeRegisterForm);
		 modelMap.addAttribute("servicTypeRegisterForm",servicTypeRegisterForm);
		return "servicTypeRegister";
	}
	
}
