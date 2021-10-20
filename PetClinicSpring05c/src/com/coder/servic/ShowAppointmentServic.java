package com.coder.servic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.hpsf.Array;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.AppointmentServicDao;
import com.coder.dao.AppointmentDao;
import com.coder.dao.DoctorDao;
import com.coder.dao.DoctorScheduleDao;
import com.coder.dao.DoctorServicDao;
import com.coder.dao.OwnerDao;
import com.coder.dao.PetDao;
import com.coder.dao.RankDao;
import com.coder.dao.ScheduleServicDao;
import com.coder.dao.ServicDao;
import com.coder.dao.ServicTypeDao;
import com.coder.dao.SpeciesDao;
import com.coder.exal.ExalToBarByCompareComplicationTime;
import com.coder.exal.ExalToBarByOwnerNormal;
import com.coder.exal.ExalToBarByOwnerSJF;
import com.coder.form.AppointmentForm;
import com.coder.form.AppointmentRegisterForm;
import com.coder.form.DoctorForm;
import com.coder.form.DoctorRegisterForm;
import com.coder.form.DoctorScheduleForm;
import com.coder.form.ExalForm;
import com.coder.form.PetForm;
import com.coder.form.PetRegisterForm;
import com.coder.form.ServicForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.form.ShortestJobFirstForm;
import com.coder.form.ShowAppointmentForm;
import com.coder.model.Appointment;
import com.coder.model.AppointmentServicId;
import com.coder.model.Doctor;
import com.coder.model.DoctorSchedule;
import com.coder.model.DoctorServicId;
import com.coder.model.Owner;
import com.coder.model.Pet;
import com.coder.model.Rank;
import com.coder.model.ScheduleServic;
import com.coder.model.Servic;
import com.coder.model.ServicType;
import com.coder.model.Species;
import com.coder.util.DateFormat;
import com.coder.util.PrjSubFunction;
import javafx.scene.input.DataFormat;

@Service
@Repository("showAppointmentServic")
public class ShowAppointmentServic {
	
	
	@Autowired
	private ServicTypeDao servicTypeDao;
	@Autowired
	private DoctorScheduleDao doctorScheduleDao;
	@Autowired
	private AppointmentDao appointmentDao;
	public void preparShowAppointment(ShowAppointmentForm showAppointmentForm){
		showAppointmentForm.setDoctorSchedules(doctorScheduleDao.getDoctorSchedules());
         }
	
	/*public ShowAppointmentForm  preparShowAppoimentSubmit(ShowAppointmentForm showAppointmentForm) throws FileNotFoundException, IOException{
		String scheduleId=showAppointmentForm.getDoctorScheduleId();
		if(scheduleId!=null){
			DoctorSchedule doctorSchedule=this.doctorScheduleDao.getDoctorScheduleById(Integer.parseInt(scheduleId));
			Set<Appointment> appointments=doctorSchedule.getAppointments();
			ArrayList<Appointment> appointmentsList=new ArrayList<>();
			Date date=DateFormat.stringToDateFormat_dd_mm_yyyy(showAppointmentForm.getDate());
			
			String dateDb=DateFormat.dateToString_DB_Format(date);
			showAppointmentForm.setDate(dateDb);
			for(Appointment app:appointments){
				String appDate=app.getAppointmentDate()+"";
	            String strDate=showAppointmentForm.getDate();	
	            System.out.println("appDate="+appDate+",strDate="+strDate);
	             if(appDate.equals(strDate)){
	            	appointmentsList.add(app);
	             }
			}
			appointmentsList=PrjSubFunction.sortJobById(appointmentsList);
			showAppointmentForm=new ShowAppointmentForm();
			showAppointmentForm=PrjSubFunction.shortestJobFirstCal(appointmentsList,"normal",showAppointmentForm);
			
			ArrayList<Appointment> sjfList=PrjSubFunction.sortJob(appointmentsList);
		    showAppointmentForm=PrjSubFunction.shortestJobFirstCal(sjfList,"sjf",showAppointmentForm);
		}  
		List<ShortestJobFirstForm> shortestJobFirstForms=showAppointmentForm.getShortestJobFirstForms();
		List<ShortestJobFirstForm> noShortestJobFirstForms=showAppointmentForm.getNoShortestJobFirstForms();
		List<ShortestJobFirstForm> saveList=new ArrayList<>();
		List<ShortestJobFirstForm> saveList1=new ArrayList<>();
		for(ShortestJobFirstForm sjf:shortestJobFirstForms){
			saveList.add(sjf);
		}
		for(ShortestJobFirstForm sjf:noShortestJobFirstForms){
			saveList1.add(sjf);
		}
		
		
		ShowAppointmentForm showAppointmentForm2=new ShowAppointmentForm();
		showAppointmentForm2=showAppointmentForm;
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		ExalToBarByOwnerSJF.barColumnChart(showAppointmentForm2,workbook);
		ExalToBarByOwnerNormal.barColumnChart(showAppointmentForm2,workbook);
		
		showAppointmentForm.setShortestJobFirstForms(saveList);
		showAppointmentForm.setNoShortestJobFirstForms(saveList1);
		
		return showAppointmentForm;
	}*/
	
	public ShowAppointmentForm  preparShowAppoimentSubmit(ShowAppointmentForm showAppointmentForm) throws FileNotFoundException, IOException{
	String scheduleId=showAppointmentForm.getDoctorScheduleId();
	
	if(scheduleId!=null){
		DoctorSchedule doctorSchedule=this.doctorScheduleDao.getDoctorScheduleById(Integer.parseInt(scheduleId));
		Date date=DateFormat.stringToDateFormat_dd_mm_yyyy(showAppointmentForm.getDate());
		List<Appointment> appointmentsList=this.appointmentDao.getAppoimentByDoctorSchedule(doctorSchedule, date);
		appointmentsList=PrjSubFunction.sortJobById(appointmentsList);
		showAppointmentForm=new ShowAppointmentForm();
		showAppointmentForm=PrjSubFunction.shortestJobFirstCal(appointmentsList,"normal",showAppointmentForm);
		ArrayList<Appointment> sjfList=PrjSubFunction.sortJob(appointmentsList);
	    showAppointmentForm=PrjSubFunction.shortestJobFirstCal(sjfList,"sjf",showAppointmentForm);
	}  
	
	List<ShortestJobFirstForm> shortestJobFirstForms=showAppointmentForm.getShortestJobFirstForms();
	List<ShortestJobFirstForm> noShortestJobFirstForms=showAppointmentForm.getNoShortestJobFirstForms();
	List<ShortestJobFirstForm> saveList=new ArrayList<>();
	List<ShortestJobFirstForm> saveList1=new ArrayList<>();
	List<ShortestJobFirstForm> saveList2=new ArrayList<>(shortestJobFirstForms);
	List<ShortestJobFirstForm> saveList3=new ArrayList<>(noShortestJobFirstForms);
	for(ShortestJobFirstForm sjf:shortestJobFirstForms){
		saveList.add(sjf);
	}
	for(ShortestJobFirstForm sjf:noShortestJobFirstForms){
		saveList1.add(sjf);
	}
	
	
	ShowAppointmentForm showAppointmentForm2=new ShowAppointmentForm();
	showAppointmentForm2=showAppointmentForm;

	
	XSSFWorkbook workbook=new XSSFWorkbook();
	List<ShortestJobFirstForm> noshortestJobFirstForms=showAppointmentForm2.getNoShortestJobFirstForms();
	System.out.println("noshortestJobFirstForms.size()="+shortestJobFirstForms.size());
	ExalToBarByCompareComplicationTime exalToBarByCompareComplicationTime=new ExalToBarByCompareComplicationTime();
	exalToBarByCompareComplicationTime.stackedBarChart(saveList2,saveList3);

	ExalToBarByOwnerSJF.barColumnChart(showAppointmentForm2,workbook);
	ExalToBarByOwnerNormal.barColumnChart(showAppointmentForm2,workbook);
	
	
	
	showAppointmentForm.setShortestJobFirstForms(saveList);
	showAppointmentForm.setNoShortestJobFirstForms(saveList1);
	
	
	return showAppointmentForm;
}
	
	public ShowAppointmentForm  appListByAvg(List<Appointment> appointments ){
			List<Appointment> appointmentsList=PrjSubFunction.sortJobById(appointments);
			ShowAppointmentForm showAppointmentForm=new ShowAppointmentForm();
			showAppointmentForm=PrjSubFunction.shortestJobFirstCal(appointmentsList,"normal",showAppointmentForm);
			ArrayList<Appointment> sjfList=PrjSubFunction.sortJob(appointmentsList);
			showAppointmentForm=PrjSubFunction.shortestJobFirstCal(sjfList,"sjf",showAppointmentForm);
			return showAppointmentForm;	 
			
		}  

	
	
	public  List<ShowAppointmentForm> ShowAppointmentByDoctorSchedule(){
		List<DoctorSchedule> doctorSchedules=this.doctorScheduleDao.getDoctorSchedules();
	    List<ShowAppointmentForm> showAppointmentForms=new ArrayList<>();
		for(DoctorSchedule docSche:doctorSchedules){
			Set<Appointment> appointments=docSche.getAppointments();
			ArrayList<Appointment> appointmentsList=new ArrayList<>();
			for(Appointment app:appointments){
			appointmentsList.add(app);
			}
			System.out.println("ShowAppointmentByDoctorSchedule="+appointmentsList.size());
			ShowAppointmentForm showAppointmentForm=new ShowAppointmentForm();
			showAppointmentForm=PrjSubFunction.shortestJobFirstCal(appointmentsList,"normal",showAppointmentForm);
			ArrayList<Appointment> sjfList=PrjSubFunction.sortJob(appointmentsList);
		    showAppointmentForm=PrjSubFunction.shortestJobFirstCal(sjfList,"sjf",showAppointmentForm);
		    showAppointmentForm.setDoctorScheduleId(docSche.getScheduleId()+"");
		    showAppointmentForms.add(showAppointmentForm);
		}
		return showAppointmentForms;
	}
/*	
	public ShowAppointmentForm showAppoimentByServicType(String sid){
		ShowAppointmentForm showAppointmentForm=new ShowAppointmentForm();
		ServicType servicType=this.servicTypeDao.getServicTypeById(Integer.parseInt(sid));
		Set<Servic> servics=servicType.getServics();
		ArrayList<Appointment> appointments=new ArrayList<>();
		for(Servic s:servics){
			Set<com.coder.model.AppointmentServic> appointmentServics=s.getAppointmentServics();
			for(com.coder.model.AppointmentServic apps:appointmentServics){
				appointments.add(apps.getAppointment());}
		}
		System.out.println("showAppoimentByServicType="+appointments.size());
		showAppointmentForm=PrjSubFunction.shortestJobFirstCal(appointments,"normal",showAppointmentForm);
	    ArrayList<Appointment> sjfList=PrjSubFunction.sortJob(appointments);
	    showAppointmentForm=PrjSubFunction.shortestJobFirstCal(sjfList,"sjf",showAppointmentForm);
		return showAppointmentForm;
		
	}
	*/
	public ShowAppointmentForm showAppoimentByServicType(String sid){
		ShowAppointmentForm showAppointmentForm=new ShowAppointmentForm();
		ServicType servicType=this.servicTypeDao.getServicTypeById(Integer.parseInt(sid));
		List<Appointment> appointments=this.appointmentDao.getAppoimentByServicType(servicType);
		System.out.println("showAppoimentByServicType="+appointments.size());
		showAppointmentForm=PrjSubFunction.shortestJobFirstCal(appointments,"normal",showAppointmentForm);
	    ArrayList<Appointment> sjfList=PrjSubFunction.sortJob(appointments);
	    showAppointmentForm=PrjSubFunction.shortestJobFirstCal(sjfList,"sjf",showAppointmentForm);
		return showAppointmentForm;
		
	}
	public List<ShowAppointmentForm> sjfFormByServicType(){
		List<ServicType> servicTypes=this.servicTypeDao.getServicTypes();
		List<ShowAppointmentForm> appointmentForms=new ArrayList<>();
		for(ServicType st:servicTypes){
			ShowAppointmentForm showAppointmentForm=showAppoimentByServicType(st.getServicTypeId()+"");
			showAppointmentForm.setServicTypeName(st.getServicTypeName());
			appointmentForms.add(showAppointmentForm);
		}
		return appointmentForms;
	}
	public ShowAppointmentForm showAllAppoimentSjf(){
		ShowAppointmentForm showAppointmentForm=new ShowAppointmentForm();
		List<Appointment> appointments=this.appointmentDao.getAppointments();
	    ArrayList<Appointment> sjfList=PrjSubFunction.sortJob(appointments);
	    showAppointmentForm=PrjSubFunction.shortestJobFirstCal(sjfList,"sjf",showAppointmentForm);
		return showAppointmentForm;
		
	}
	public List<Appointment> showAllAppoiment(){
	return	this.appointmentDao.getAppointments();
	}
	public List<ShowAppointmentForm> showAppointmentByDate(ShowAppointmentForm showAppointmentForm) throws FileNotFoundException, IOException{
		List<ShowAppointmentForm> showAppointmentForms=new ArrayList<>();
		for(int i=0;i<10;i++){
		Date addDate=DateFormat.subDays(+i);
		//System.out.println("addDate="+addDate);
		String getDate=DateFormat.dateToStringFormat_dd_mm_yyyy(addDate);
		ShowAppointmentForm shp2=new ShowAppointmentForm();
		shp2.setDoctorScheduleId(showAppointmentForm.getDoctorScheduleId());
		shp2.setDate(getDate);
		
		ShowAppointmentForm showAppointmentForm2=this.preparShowAppoimentSubmit(shp2);
		showAppointmentForm2.setDoctorScheduleId(showAppointmentForm.getDoctorScheduleId());
		showAppointmentForm2.setDate(getDate);
		showAppointmentForms.add(showAppointmentForm2);
		}
		for(ShowAppointmentForm shp:showAppointmentForms){
			System.out.println("Date:"+shp.getDate()+" ScheduleId:"+shp.getDoctorScheduleId()+" NoSJF:"+shp.getNoWatingAvg()+" SJF:"+shp.getWatingAvg());
		}
		return showAppointmentForms;
	}
	public List<ExalForm> showAppointmentBySchedule(int rang){
		List<DoctorSchedule> doctorSchedules=this.doctorScheduleDao.getDoctorSchedules();
		List<ExalForm> exalForms=new ArrayList<>();
		for(DoctorSchedule doctorSchedule:doctorSchedules){
			double avgWt=0;
			double avgWtSjf=0;
			for(int i=0;i<rang;i++){
				Date date=DateFormat.subDays(-i);
				String dateStr=DateFormat.dateToString_DB_Format(date);
			List<Appointment> apps=PrjSubFunction.collectAppByDate(dateStr, doctorSchedule);
			ShowAppointmentForm showAppointmentForm=this.appListByAvg(apps);
			avgWtSjf+=showAppointmentForm.getWatingAvg();
			avgWt+=showAppointmentForm.getNoWatingAvg();
			}
			
			if((avgWtSjf+avgWt)!=0){
			ExalForm exalForm=new ExalForm();
			exalForm.setAvgWt(avgWt+"");
			exalForm.setSjfAvgWt(avgWtSjf+"");
			exalForm.setScheduleId(doctorSchedule.getScheduleId()+"");
			exalForms.add(exalForm);
			}
			
		}
		return exalForms;
			
		}
	
	
}

