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
import com.coder.form.OwnerForm;
import com.coder.form.OwnerRegisterForm;
import com.coder.form.PetLoginForm;
import com.coder.form.PetRegisterForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.model.Owner;
import com.coder.model.PetLogin;
import com.coder.servic.DoctorServic;
import com.coder.servic.OwnerServic;
import com.coder.servic.PetLoginServic;
import com.coder.servic.PetServic;
import com.coder.servic.ServicServic;
import com.coder.servic.ServicTypeServic;


@Controller
@Transactional
public class OwnerRegisterController {
	@Autowired
	private PetLoginServic petLoginServic;
	@Autowired
	private PetServic petServic;
	@Autowired
	private OwnerServic ownerServic;
	@RequestMapping("/ownerRegisterPath")
	public String servicRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{
		OwnerRegisterForm ownerRegisterForm=new OwnerRegisterForm();
		ownerServic.preparOwnerRegister(ownerRegisterForm);
		modelMap.addAttribute("ownerRegisterForm",ownerRegisterForm);
		return "ownerRegister";
	}
	
	@RequestMapping("/ownerRegisterSubmitPath")
	public String ownerRegisterSubmitDispatcher(@ModelAttribute("ownerRegisterForm") OwnerRegisterForm ownerRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("Exit");
		String save=req.getParameter("save");
		HttpSession session=req.getSession(true);	
		if(save!=null){
			PetRegisterForm petRegisterForm=new PetRegisterForm();
			PetLoginForm petLoginForm=new PetLoginForm();
			OwnerForm ownerForm =ownerRegisterForm.getOwnerForm();
			petRegisterForm.setOwnerId(ownerForm.getOwnerId());
            petLoginForm.setLoginId(ownerForm.getOwnerId());
			petLoginForm.setPassword(ownerForm.getOwnerPassword());
			petLoginForm.setUserName(ownerForm.getOwnerName());
			session.setAttribute("petLogin",petLoginForm);
			session.setAttribute("idType","oid");
		ownerServic.preparOwnerRegister(ownerRegisterForm);
		petLoginServic.petLoginRegister(petLoginForm);
		petServic.preparPetRegister(petRegisterForm);
		
		modelMap.addAttribute("petRegisterForm",petRegisterForm);
	     return "petRegister";
	     }else{
	     return "userHome";
	     }
      }
	
	@RequestMapping("/ownerInfoPath")
	public String ownerInfoDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   HttpSession session=req.getSession(true);	
	PetLogin petLogin=(PetLogin) session.getAttribute("petLogin");
		String exit=req.getParameter("exit");
		if(exit==null){
		Owner owner=this.ownerServic.getOwnerById(petLogin.getLoginId());
		modelMap.addAttribute("owner",owner);
		
		return "ownerInfo";
		}else{
		return "userHome";	
		}
	}
}
