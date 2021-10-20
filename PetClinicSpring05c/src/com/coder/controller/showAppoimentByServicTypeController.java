package com.coder.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.exal.ExalToBarByCompareAppSchedule;
import com.coder.exal.ExalToBarByScheduleNormal;
import com.coder.exal.ExalToBarByScheduleSJF;
import com.coder.exal.ExalToBarByServicTypeNormal;
import com.coder.exal.ExalToBarByServicTypeSJF;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.form.ShowAppointmentForm;
import com.coder.servic.ServicTypeServic;
import com.coder.servic.ShowAppointmentServic;


@Controller
@Transactional
public class showAppoimentByServicTypeController {
	@Autowired
	private ShowAppointmentServic showAppointmentServic;
	@Autowired
	private ServicTypeServic servicTypeServic;
	@RequestMapping("/showAppoinmentByServicTypePath")
	public String servicTypeRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{
		ServicTypeRegisterForm servicTypeRegisterForm=new ServicTypeRegisterForm();
		servicTypeServic.preparServicTypeRegister(servicTypeRegisterForm);
		modelMap.addAttribute("servicTypeRegisterForm",servicTypeRegisterForm);
		return "showAppByType0";
	}
	@RequestMapping("/exalByDoctorSchedule")
	public String exalByDoctorScheduleDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) throws FileNotFoundException, IOException
	{   ExalToBarByScheduleNormal barByScheduleNormal=new ExalToBarByScheduleNormal();
	    ExalToBarByScheduleSJF barByScheduleSJF=new ExalToBarByScheduleSJF();
	    List<ShowAppointmentForm> appointmentForms=showAppointmentServic.ShowAppointmentByDoctorSchedule();
	    XSSFWorkbook wb=new XSSFWorkbook();
	    barByScheduleNormal.barColumnChart(appointmentForms, wb);
	    barByScheduleSJF.barColumnChart(appointmentForms, wb);
	    ExalToBarByCompareAppSchedule exalToBarByCompareAppSchedule=new ExalToBarByCompareAppSchedule();
	    exalToBarByCompareAppSchedule.stackedBarChart(appointmentForms);
		ServicTypeRegisterForm servicTypeRegisterForm=new ServicTypeRegisterForm();
		modelMap.addAttribute("servicTypeRegisterForm",servicTypeRegisterForm);
		servicTypeServic.preparServicTypeRegister(servicTypeRegisterForm);
		return "showAppByType0";
	}
	@RequestMapping("/exalByDoctorScheduleCompersion")
	public String exalByDoctorScheduleCompDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) throws FileNotFoundException, IOException
	{   
	    List<ShowAppointmentForm> appointmentForms=showAppointmentServic.ShowAppointmentByDoctorSchedule();
	   
	   
	    ExalToBarByCompareAppSchedule exalToBarByCompareAppSchedule=new ExalToBarByCompareAppSchedule();
	    exalToBarByCompareAppSchedule.stackedBarChart(appointmentForms);
		ServicTypeRegisterForm servicTypeRegisterForm=new ServicTypeRegisterForm();
		modelMap.addAttribute("servicTypeRegisterForm",servicTypeRegisterForm);
		servicTypeServic.preparServicTypeRegister(servicTypeRegisterForm);
		return "adminHome";
	}
	@RequestMapping("/exalByServicType")
	public String exalByServicTypeDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) throws FileNotFoundException, IOException
	{   ExalToBarByServicTypeNormal exalToBarByServicTypeNormal=new ExalToBarByServicTypeNormal();
	    ExalToBarByServicTypeSJF exalToBarByServicTypeSJF=new ExalToBarByServicTypeSJF();
	    List<ShowAppointmentForm> appointmentForms=showAppointmentServic.sjfFormByServicType();
	    XSSFWorkbook wb=new XSSFWorkbook();
	    exalToBarByServicTypeNormal.barColumnChart(appointmentForms, wb);
	    exalToBarByServicTypeSJF.barColumnChart(appointmentForms, wb);
		ServicTypeRegisterForm servicTypeRegisterForm=new ServicTypeRegisterForm();
		modelMap.addAttribute("servicTypeRegisterForm",servicTypeRegisterForm);
		servicTypeServic.preparServicTypeRegister(servicTypeRegisterForm);
		return "showAppByType0";
	}
	
	@RequestMapping("/showAppoinmentByServicTypeSubmitPath")
	public String servicTypeRegisterSubmitDispatcher(@ModelAttribute("servicTypeRegisterForm") ServicTypeRegisterForm servicTypeRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String frmServicTypeId=req.getParameter("frmServicTypeId");
		ShowAppointmentForm showAppointmentForm=this.showAppointmentServic.showAppoimentByServicType(frmServicTypeId);
		modelMap.addAttribute("showAppointmentForm",showAppointmentForm);
	     return "showAppByType1";
	   
      }
	
	
}
