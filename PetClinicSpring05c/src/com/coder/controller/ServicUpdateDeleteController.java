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

import com.coder.form.ServicForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.servic.ServicServic;
import com.coder.servic.ServicTypeServic;


@Controller
@Transactional
public class ServicUpdateDeleteController {
	@Autowired
	private ServicServic servicServic;
	
	@RequestMapping("/servicUpdatePath")
	public String servicTypeUpdateDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{ 
		ServicRegisterForm servicRegisterForm=new ServicRegisterForm();
		ServicForm servicForm=new ServicForm();
		String frmServicId=req.getParameter("frmServicId");
		servicForm.setServicId(frmServicId);
		servicRegisterForm.setServicForm(servicForm);
        modelMap.addAttribute("servicRegisterForm",servicRegisterForm);
		servicServic.preparServicUpdate(servicRegisterForm);
		return "servicUpdate";
	}
	
	@RequestMapping("/servicUpdateSubmitPath")
	public String servicTypeUpdateSubmitDispatcher(@ModelAttribute("servicRegisterForm") ServicRegisterForm servicRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	String cancle=req.getParameter("cancle");
		String update=req.getParameter("update");
		if(update!=null){
		servicServic.servicUpdate(servicRegisterForm);
		
     }
		this.servicServic.preparServicRegister(servicRegisterForm);
		 modelMap.addAttribute("servicRegisterForm",servicRegisterForm);
		 return "servicRegister";
	  }
	@RequestMapping("/servicDeletePath")
	public String servicTypeDeleteDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{ 
		ServicRegisterForm servicRegisterForm=new ServicRegisterForm();
		ServicForm servicForm=new ServicForm();
		String frmServicId=req.getParameter("frmServicId");
		servicForm.setServicId(frmServicId);
		servicRegisterForm.setServicForm(servicForm);
        this.servicServic.servicDelete(servicRegisterForm);
		this.servicServic.preparServicRegister(servicRegisterForm);
		 modelMap.addAttribute("servicRegisterForm",servicRegisterForm);
		return "servicRegister";
	}
	
}
