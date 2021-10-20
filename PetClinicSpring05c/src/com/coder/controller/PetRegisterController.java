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

import com.coder.form.DoctorRegisterForm;
import com.coder.form.OwnerRegisterForm;
import com.coder.form.PetLoginForm;
import com.coder.form.PetRegisterForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.model.PetLogin;
import com.coder.servic.DoctorServic;
import com.coder.servic.OwnerServic;
import com.coder.servic.PetServic;
import com.coder.servic.ServicServic;
import com.coder.servic.ServicTypeServic;


@Controller
@Transactional
public class PetRegisterController {
	@Autowired
	private PetServic petServic;
	@RequestMapping("/petRegisterPath")
	public String servicRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{
		PetRegisterForm petRegisterForm=new PetRegisterForm();
		HttpSession session=req.getSession(true);	
		PetLogin petLogin=(PetLogin) session.getAttribute("petLogin");
		//System.out.println("pet login="+petLogin.getLoginId());
		petRegisterForm.setOwnerId(petLogin.getLoginId());
		modelMap.addAttribute("petRegisterForm",petRegisterForm);
		petServic.preparPetRegister(petRegisterForm);
		return "petRegister";
	}
	
	@RequestMapping("/petRegisterSubmitPath")
	public String petRegisterSubmitDispatcher(@ModelAttribute("petRegisterForm") PetRegisterForm petRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	    {	
		String finish=req.getParameter("Exit");
		String save=req.getParameter("save");
		HttpSession session=req.getSession(true);	
		PetLoginForm petLogin=(PetLoginForm) session.getAttribute("petLogin");
		//System.out.println("petLogin="+petLogin);
		petRegisterForm.setOwnerId(petLogin.getLoginId());
		if(save!=null){
		petServic.preparPetRegister(petRegisterForm);
		modelMap.addAttribute("petRegisterForm",petRegisterForm);
	    return "petRegister";
	    }else{
	    return "userHome";
	    }
      }
	
	
}
