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

import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.servic.ServicServic;
import com.coder.servic.ServicTypeServic;


@Controller
@Transactional
public class ServicRegisterController {
	@Autowired
	private ServicServic servicServic;
	@RequestMapping("/servicRegisterPath")
	public String servicRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{
		ServicRegisterForm servicRegisterForm=new ServicRegisterForm();
		modelMap.addAttribute("servicRegisterForm",servicRegisterForm);
		servicServic.preparServicRegister(servicRegisterForm);
		return "servicRegister";
	}
	
	@RequestMapping("/servicRegisterSubmitPath")
	public String servicTypeRegisterSubmitDispatcher(@ModelAttribute("servicRegisterForm") ServicRegisterForm servicRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("Exit");
		String save=req.getParameter("save");
		if(save!=null){
		servicServic.preparServicRegister(servicRegisterForm);
		 modelMap.addAttribute("servicTypeRegisterForm",servicRegisterForm);
	     return "servicRegister";
	     }else{
	     return "adminHome";
	     }
      }
	
	
}
