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
import com.coder.form.DoctorScheduleRegisterForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.model.Doctor;
import com.coder.servic.DoctorScheduleServic;
import com.coder.servic.DoctorServic;
import com.coder.servic.ServicServic;
import com.coder.servic.ServicTypeServic;


@Controller
@Transactional
public class DoctorScheduleController {
	@Autowired
	private DoctorScheduleServic doctorSchduleServic; 
	@RequestMapping("/selectDoctorPath")
	public String selectDoctorDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{
		DoctorScheduleRegisterForm doctorScheduleRegisterForm=new DoctorScheduleRegisterForm();
		doctorSchduleServic.preparDoctorScheduleRegister(doctorScheduleRegisterForm);
		modelMap.addAttribute("doctorScheduleRegisterForm",doctorScheduleRegisterForm);
		return "selectDoctor";
	}
	@RequestMapping("/doctorScheduleRegisterPath")
	public String servicRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   String frmDoctorId=req.getParameter("frmDoctorId");
	HttpSession session=req.getSession(true);	
	
	DoctorScheduleRegisterForm doctorScheduleRegisterForm=new DoctorScheduleRegisterForm();
	doctorScheduleRegisterForm.setDoctorId(frmDoctorId);
		modelMap.addAttribute("doctorScheduleRegisterForm",doctorScheduleRegisterForm);
		doctorSchduleServic.preparDoctorScheduleRegister(doctorScheduleRegisterForm);
		session.setAttribute("doctor",doctorScheduleRegisterForm.getDoctor());
		return "doctorScheduleRegister";
	}
	
	@RequestMapping("/doctorScheduleRegisterSubmitPath")
	public String servicTypeRegisterSubmitDispatcher(@ModelAttribute("doctorScheduleRegisterForm") DoctorScheduleRegisterForm doctorScheduleRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	HttpSession session=req.getSession(true);
		String finish=req.getParameter("Exit");
		String save=req.getParameter("save");
		if(save!=null){
			Doctor doctor=(Doctor) session.getAttribute("doctor");
			doctorScheduleRegisterForm.setDoctorId(doctor.getDoctorId()+"");
		    doctorSchduleServic.preparDoctorScheduleRegister(doctorScheduleRegisterForm);
		    modelMap.addAttribute("doctorScheduleRegisterForm",doctorScheduleRegisterForm);
	     return "doctorScheduleRegister";
	     }else{
	     return "adminHome";
	     }
      }
	
	
}
