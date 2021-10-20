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
public class ServicTypeRegisterController {
	@Autowired
	private ServicTypeServic servicTypeServic;
	@RequestMapping("/servicTypeRegisterPath")
	public String servicTypeRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{
		ServicTypeRegisterForm servicTypeRegisterForm=new ServicTypeRegisterForm();
		modelMap.addAttribute("servicTypeRegisterForm",servicTypeRegisterForm);
		servicTypeServic.preparServicTypeRegister(servicTypeRegisterForm);
		return "servicTypeRegister";
	}
	
	@RequestMapping("/servicTypeRegisterSubmitPath")
	public String servicTypeRegisterSubmitDispatcher(@ModelAttribute("servicTypeRegisterForm") ServicTypeRegisterForm servicTypeRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("Exit");
		String save=req.getParameter("save");
		if(save!=null){
		servicTypeServic.preparServicTypeRegister(servicTypeRegisterForm);
		 modelMap.addAttribute("servicTypeRegisterForm",servicTypeRegisterForm);
	     return "servicTypeRegister";
	     }else{
	     return "adminHome";
	     }
      }
	
	
}
