package com.coder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.jpl7.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.form.PetLoginRegisterForm;



@Controller
@Transactional
public class HomeController {
	
	
	@RequestMapping("/")
	public String TypeRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		PetLoginRegisterForm petLoginRegisterForm=new PetLoginRegisterForm();
		modelMap.addAttribute("petLoginRegisterForm",petLoginRegisterForm);
		
		return "petLogin";
	}
	@RequestMapping("/logOutPath")
	public String logOutDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		HttpSession session=req.getSession(true);
		session.removeAttribute("petLogin");
		session.removeAttribute("idType");
		PetLoginRegisterForm petLoginRegisterForm=new PetLoginRegisterForm();
		modelMap.addAttribute("petLoginRegisterForm",petLoginRegisterForm);
		
		return "petLogin";
	}
	

}
