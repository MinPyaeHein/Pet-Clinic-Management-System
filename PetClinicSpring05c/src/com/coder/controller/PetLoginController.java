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
import com.coder.form.PetLoginRegisterForm;
import com.coder.form.PetRegisterForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.form.SpeciesRegisterForm;
import com.coder.model.PetLogin;
import com.coder.servic.DoctorServic;
import com.coder.servic.OwnerServic;
import com.coder.servic.PetLoginServic;
import com.coder.servic.PetServic;
import com.coder.servic.ServicServic;
import com.coder.servic.ServicTypeServic;
import com.coder.servic.SpeciesServic;


@Controller
@Transactional
public class PetLoginController {
	@Autowired
	private PetLoginServic petLoginServic;
	@Autowired
	private OwnerServic ownerServic;
	@RequestMapping("/petLoginPath")
	public String speciesRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{
		PetLoginRegisterForm petLoginRegisterForm=new PetLoginRegisterForm();
		modelMap.addAttribute("petLoginRegisterForm",petLoginRegisterForm);
		return "petLogin";
	}
	
	@RequestMapping("/petLoginSubmitPath")
	public String ownerRegisterSubmitDispatcher(@ModelAttribute("petLoginRegisterForm") PetLoginRegisterForm petLoginRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String newacount=req.getParameter("newacount");
		String login=req.getParameter("login");
	
		//exalToBar.main(null);
		if(login!=null){
		PetLoginForm petLoginForm=petLoginRegisterForm.getPetLoginForm();
		PetLogin petLogin=petLoginServic.petLoginUser(petLoginForm);
	
		if(petLogin!=null){
		String id=petLogin.getLoginId();
		HttpSession session=req.getSession(true);	
		session.setAttribute("idType","oid");
		
		if(id.startsWith("oid")){
			session.setAttribute("petLogin",petLogin);
			session.setAttribute("idType","oid");
			return "userHome";
		}else if(id.startsWith("did")){
			
			session.setAttribute("petLogin",petLogin);
			session.setAttribute("idType","doctor");
			return "doctorHome";
		}else if(id.startsWith("id")){
			
			session.setAttribute("idType","id");
			return "adminHome";
		}
		
		}else{
			req.setAttribute("error","Incorrect User Name And Password!");
		}
	    
	     }else{
	    	 OwnerRegisterForm ownerRegisterForm=new OwnerRegisterForm();
	 		 ownerServic.preparOwnerRegister(ownerRegisterForm);
	 		 modelMap.addAttribute("ownerRegisterForm",ownerRegisterForm);
	 		
	 		return "ownerRegister";
	    
	     }
		
		return "petLogin";
      }
	
	
}
