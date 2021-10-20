  package com.coder.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
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

import com.coder.form.AppointmentForm;
import com.coder.form.AppointmentRegisterForm;
import com.coder.form.DoctorRegisterForm;
import com.coder.form.OwnerRegisterForm;
import com.coder.form.PetRegisterForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.form.ShowAppointmentForm;
import com.coder.model.Appointment;
import com.coder.model.PetLogin;
import com.coder.servic.AppointmentServic;
import com.coder.servic.DoctorServic;
import com.coder.servic.OwnerServic;
import com.coder.servic.PetServic;
import com.coder.servic.ServicServic;
import com.coder.servic.ServicTypeServic;
import com.coder.servic.ShowAppointmentServic;


@Controller
@Transactional
public class ShowAppointmentController {
	@Autowired
	private ShowAppointmentServic showAppointmentServic;
	@RequestMapping("/showAppointmentPath1")
	public String showAppointmentDispatcher1(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
	   	ShowAppointmentForm showAppointmentForm=new ShowAppointmentForm();
		this.showAppointmentServic.preparShowAppointment(showAppointmentForm);
		modelMap.addAttribute("showAppointmentForm", showAppointmentForm);
		return "selectDoctorSchedule";
	}
	@RequestMapping("/showAppointmentPath2")
	public String showAppointmentDispatcher2(@ModelAttribute("showAppointmentForm") ShowAppointmentForm showAppointmentForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp) throws ParseException
	    {
		String frmScheduleId=req.getParameter("frmScheduleId");
		HttpSession session=req.getSession(true);
		if(frmScheduleId!=null){
		session.setAttribute("frmScheduleId",frmScheduleId );
		}
		 
		 modelMap.addAttribute("showAppointmentForm",showAppointmentForm);
		 return "showAppointment";
	     }  
			 
	    
	@RequestMapping("/showAppointmentPath3")
	public String showAppointmentDispatcher3(@ModelAttribute("showAppointmentForm") ShowAppointmentForm showAppointmentForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp) throws ParseException, FileNotFoundException, IOException
	    {	
		
		String exit=req.getParameter("exit");
		String refresh=req.getParameter("refresh");
		HttpSession session=req.getSession(true);
		String frmScheduleId=(String)session.getAttribute("frmScheduleId");
		showAppointmentForm.setDoctorScheduleId(frmScheduleId);
	    String idType=(String) session.getAttribute("idType");
	   // System.out.println(" refresh="+refresh);
		if(refresh!=null){
			//System.out.println("Arrive refresh");
		 showAppointmentForm=this.showAppointmentServic.preparShowAppoimentSubmit(showAppointmentForm);
		// System.out.println("Show App="+showAppointmentForm.getShortestJobFirstForms().size());
		 modelMap.addAttribute("showAppointmentForm",showAppointmentForm);
		 return "showAppointment";
	     }else if(exit!=null){
			 if(idType.equals("doctor")){
			      return "doctorHome";
			     }else  if(idType.equals("oid")){
				  return "userHome";
				 } else{
				  return "adminHome"; 
				 }
			 }else{
				 return "showAppointment";
			 }
      }
	@RequestMapping("/showAppointmentSubmitPath")
	public String showAppointmentSubmitDispatcher(@ModelAttribute("showAppointmentForm") ShowAppointmentForm showAppointmentForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp) throws ParseException, FileNotFoundException, IOException
	    {	
		
		String exit=req.getParameter("exit");
		String refresh=req.getParameter("refresh");
		HttpSession session=req.getSession(true);
		String frmScheduleId=(String)session.getAttribute("frmScheduleId");
		showAppointmentForm.setDoctorScheduleId(frmScheduleId);
	    String idType=(String) session.getAttribute("idType");
			if(refresh!=null){
		 showAppointmentForm=this.showAppointmentServic.preparShowAppoimentSubmit(showAppointmentForm);
		 System.out.println("Show App="+showAppointmentForm.getShortestJobFirstForms().size());
		 modelMap.addAttribute("showAppointmentForm",showAppointmentForm);
		 return "showAppointment";
	     }else if(exit!=null){
			 if(idType.equals("doctor")){
			      return "doctorHome";
			     }else  if(idType.equals("oid")){
				  return "userHome";
				 } else{
				  return "adminHome"; 
				 }
			 }else{
				 return "showAppointment";
			 }
      }
	
	@RequestMapping("/showAllAppointmentPath")
	public String showAllAppointmentDispatcher(@ModelAttribute("appointmentRegisterForm") AppointmentRegisterForm appointmentRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp) throws ParseException
	    {
		List<Appointment> appointments=this.showAppointmentServic.showAllAppoiment();
		 appointmentRegisterForm=new AppointmentRegisterForm();
		 appointmentRegisterForm.setAppointments(appointments);
		modelMap.addAttribute("appointmentRegisterForm",appointmentRegisterForm);
			return "showAllAppointment";	
	    }
	
}
