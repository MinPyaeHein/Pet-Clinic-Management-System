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

import com.coder.form.DoctorForm;
import com.coder.form.DoctorRegisterForm;
import com.coder.form.PetLoginForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.model.PetLogin;
import com.coder.servic.DoctorServic;
import com.coder.servic.PetLoginServic;
import com.coder.servic.ServicServic;
import com.coder.servic.ServicTypeServic;


@Controller
@Transactional
public class DoctorRegisterController {
	@Autowired
	private PetLoginServic petLoginServic;
	@Autowired
	private DoctorServic doctorServic;
	@RequestMapping("/doctorRegisterPath")
	public String servicRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{
		DoctorRegisterForm doctorRegisterForm=new DoctorRegisterForm();
		modelMap.addAttribute("doctorRegisterForm",doctorRegisterForm);
		doctorServic.preparDoctorRegister(doctorRegisterForm);
		return "doctorRegister";
	}
	
	@RequestMapping("/doctorRegisterSubmitPath")
	public String servicTypeRegisterSubmitDispatcher(@ModelAttribute("doctorRegisterForm") DoctorRegisterForm doctorRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("Exit");
		String save=req.getParameter("save");
		if(save!=null){
	     DoctorForm doctorForm=doctorRegisterForm.getDoctorForm();
	    PetLoginForm petLoginForm=new PetLoginForm();
	    String id=doctorForm.getDoctorId();
	    System.out.println("doctorId="+id);
	    petLoginForm.setLoginId(id);
	    petLoginForm.setUserName(doctorForm.getDoctorName());
	    petLoginForm.setPassword(doctorForm.getPassword());
	    this.petLoginServic.petLoginRegister(petLoginForm);
	    HttpSession session=req.getSession(true);	
	    session.setAttribute("doctorId",id);
		doctorServic.preparDoctorRegister(doctorRegisterForm);
		
		 modelMap.addAttribute("doctorRegisterForm",doctorRegisterForm);
	     return "doctorRegister";
	     }else{
	     return "adminHome";
	     }
      }
	@RequestMapping("/showDoctorScheduleByDoctorPath")
	public String showDoctorScheduleByDoctorDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{    HttpSession session=req.getSession(true);
	    PetLogin petLogin=(PetLogin)session.getAttribute("petLogin");
		DoctorRegisterForm doctorRegisterForm=new DoctorRegisterForm();
		doctorRegisterForm.setDoctorId(petLogin.getLoginId());
		doctorServic.showDoctorSchedules(doctorRegisterForm);
		modelMap.addAttribute("doctorRegisterForm",doctorRegisterForm);
		return "doctorScheduleByDoctor";
	}
	
	
}
