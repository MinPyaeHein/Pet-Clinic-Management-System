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
import com.coder.form.PetRegisterForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.form.SpeciesRegisterForm;
import com.coder.servic.DoctorServic;
import com.coder.servic.OwnerServic;
import com.coder.servic.PetServic;
import com.coder.servic.ServicServic;
import com.coder.servic.ServicTypeServic;
import com.coder.servic.SpeciesServic;


@Controller
@Transactional
public class SpeciesRegisterController {
	@Autowired
	private SpeciesServic speciesServic;
	
	@RequestMapping("/speciesRegisterPath")
	public String speciesRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{
		SpeciesRegisterForm speciesRegisterForm=new SpeciesRegisterForm();
		
		speciesServic.preparSpeciesRegister(speciesRegisterForm);
		modelMap.addAttribute("speciesRegisterForm",speciesRegisterForm);
		return "speciesRegister";
	}
	
	@RequestMapping("/speciesRegisterSubmitPath")
	public String ownerRegisterSubmitDispatcher(@ModelAttribute("speciesRegisterForm") SpeciesRegisterForm speciesRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("Exit");
		String save=req.getParameter("save");
		
		if(save!=null){
		speciesServic.preparSpeciesRegister(speciesRegisterForm);
		
		modelMap.addAttribute("speciesRegisterForm",speciesRegisterForm);
	     return "speciesRegister";
	     }else{
	     return "adminHome";
	     }
      }
	
	
}
