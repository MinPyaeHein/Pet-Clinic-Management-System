package com.coder.servic;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.AppointmentDao;
import com.coder.dao.DoctorScheduleDao;
import com.coder.dao.OwnerDao;
import com.coder.form.ExalForm;
import com.coder.form.MailForm;
import com.coder.form.ShortestJobFirstForm;
import com.coder.form.ShowAppointmentForm;
import com.coder.model.Appointment;
import com.coder.model.AppointmentServic;
import com.coder.model.DoctorSchedule;
import com.coder.model.Owner;
import com.coder.util.DateFormat;
import com.coder.util.PrjSubFunction;

@Service
@Repository("autoMailServic")
public class AutoMailServic {


@Autowired
private DoctorScheduleDao  doctorScheduleDao;
@Autowired
private ShowAppointmentServic showAppoimentServic;
@Autowired
private OwnerDao ownerDao;
@Autowired
private GeneralService generalService;
@Autowired
private AppointmentDao appointmentDao;
/*@Scheduled(fixedDelay=50000)
public void autoMail() throws IOException, ParseException{
	//System.out.println("@Scheduled process");
	Date date=DateFormat.subDays(+1);
	List<DoctorSchedule> doctorSchedules=this.doctorScheduleDao.getDoctorSchedules();
	for(DoctorSchedule ds:doctorSchedules){
		int timeSlot=DateFormat.timeDifference1(ds.getStartTime()+"",ds.getEndTime()+"");
		Set<Appointment> appointmentSets=ds.getAppointments();
	    List<Appointment> appointments=new ArrayList<Appointment>();
	for(Appointment app:appointmentSets){
		
		String date2=app.getAppointmentDate()+"";
		String dateStr=DateFormat.dateToString_DB_Format(date);
		//System.out.println("date2="+date2+"::"+"dateStr="+dateStr);
		if(date2.equals(dateStr)){
			appointments.add(app);
		}
	}
	if(appointments.size()!=0){
	Appointment apptemp=appointments.get(appointments.size()-1);
	timeSlot-=PrjSubFunction.servicTimeCollect(apptemp.getAppointmentServics());
	}
	for(Appointment app:appointments){
		System.out.println("app.getAppointmentDate="+app.getAppointmentDate());
		if(timeSlot>=0){
		Set<AppointmentServic> appointmentServices=app.getAppointmentServics();
		int stime=PrjSubFunction.servicTimeCollect(appointmentServices);
		timeSlot-=stime;
		}
	}
	System.out.println("timeSlot="+timeSlot);
	if(timeSlot<=0){
	
	if(appointments.size()!=0){
	List<Appointment> appSort=PrjSubFunction.sortJob(appointments);
	ShowAppointmentForm showAppointmentForm=new ShowAppointmentForm();
	ShowAppointmentForm appointmentForm=PrjSubFunction.shortestJobFirstCal(appSort,"sjf", showAppointmentForm);
	List<ShortestJobFirstForm> firstForms=appointmentForm.getShortestJobFirstForms();
	int tokenNo=1;
	for(ShortestJobFirstForm fs:firstForms){
	Appointment appointment=this.appointmentDao.getAppointmentById(Integer.parseInt(fs.getAppintmentId())); 
	if(appointment.getAppointmentTime()==null){
	MailForm mailForm=new MailForm();
	mailForm.setContent("Dear Customer");
	Owner owner=this.ownerDao.getOwnerById(Integer.parseInt(fs.getOwnerId()));
	Appointment app=this.appointmentDao.getAppointmentById(Integer.parseInt(fs.getAppintmentId()));
	mailForm.setToMail(owner.getOwnerEmail().trim());
	Set<AppointmentServic> appointmentServics=app.getAppointmentServics();
	String servic="";
	servic+="\nToken N0="+tokenNo;
	servic+="\nPet Owner="+owner.getOwnerName();
	servic+="\nPet Name="+app.getPet().getPetName();
	Date arrTime=DateFormat.addDateInMinute(Integer.parseInt(fs.getWaitingTime()),app.getDoctorSchedule().getStartTime());
	String arrTimeStr=DateFormat.dateToDayAM_PM(arrTime);
	servic+="\nArrival Time="+arrTimeStr;
	servic+="\nAppointment Date="+date;
	servic+="\n";
	for(AppointmentServic appointmentServic:appointmentServics){
		servic+=""+appointmentServic.getServic().getServicName()+":";
	}
	tokenNo++;
	mailForm.setSubject(servic);
	appointment.setAppointmentTime(arrTime);
	this.appointmentDao.update(appointment);
	System.out.println("Send Mail");
    generalService.processSendMail(mailForm);
	
	}
	
}
}
}
	}
}*/
@Scheduled(fixedDelay=50000)
public void autoMail() throws IOException, ParseException{
	//System.out.println("@Scheduled process");
	Date date=DateFormat.subDays(+1);
	List<DoctorSchedule> doctorSchedules=this.doctorScheduleDao.getDoctorSchedules();
	for(DoctorSchedule ds:doctorSchedules){
		int timeSlot=DateFormat.timeDifference1(ds.getStartTime()+"",ds.getEndTime()+"");
		
	List<Appointment> appointments=this.appointmentDao.getAppoimentByToSent(ds,date);
	   
	if(appointments.size()!=0){
		System.out.println("doctorSchdule="+ds.getScheduleId());
		System.out.println("appointments="+appointments.size());
	Appointment apptemp=appointments.get(appointments.size()-1);
	timeSlot-=PrjSubFunction.servicTimeCollect(apptemp.getAppointmentServics());
	}
	for(Appointment app:appointments){
		//System.out.println("app.getAppointmentDate="+app.getAppointmentDate());
		if(timeSlot>=0){
		Set<AppointmentServic> appointmentServices=app.getAppointmentServics();
		int stime=PrjSubFunction.servicTimeCollect(appointmentServices);
		timeSlot-=stime;
		}
	}
	System.out.println("timeSlot="+timeSlot);
	if(timeSlot<=0){
	
	if(appointments.size()!=0){
	List<Appointment> appSort=PrjSubFunction.sortJob(appointments);
	ShowAppointmentForm showAppointmentForm=new ShowAppointmentForm();
	ShowAppointmentForm appointmentForm=PrjSubFunction.shortestJobFirstCal(appSort,"sjf", showAppointmentForm);
	List<ShortestJobFirstForm> firstForms=appointmentForm.getShortestJobFirstForms();
	int tokenNo=1;
	for(ShortestJobFirstForm fs:firstForms){
	Appointment appointment=this.appointmentDao.getAppointmentById(Integer.parseInt(fs.getAppintmentId())); 
	if(appointment.getAppointmentTime()==null){
	MailForm mailForm=new MailForm();
	mailForm.setContent("Dear Customer");
	Owner owner=this.ownerDao.getOwnerById(Integer.parseInt(fs.getOwnerId()));
	Appointment app=this.appointmentDao.getAppointmentById(Integer.parseInt(fs.getAppintmentId()));
	mailForm.setToMail(owner.getOwnerEmail().trim());
	Set<AppointmentServic> appointmentServics=app.getAppointmentServics();
	String servic="";
	servic+="\nToken N0="+tokenNo;
	servic+="\nPet Owner="+owner.getOwnerName();
	servic+="\nPet Name="+app.getPet().getPetName();
	Date arrTime=DateFormat.addDateInMinute(Integer.parseInt(fs.getWaitingTime()),app.getDoctorSchedule().getStartTime());
	String arrTimeStr=DateFormat.dateToDayAM_PM(arrTime);
	servic+="\nArrival Time="+arrTimeStr;
	servic+="\nAppointment Date="+date;
	servic+="\n";
	for(AppointmentServic appointmentServic:appointmentServics){
		servic+=""+appointmentServic.getServic().getServicName()+":";
	}
	tokenNo++;
	mailForm.setSubject(servic);
	appointment.setAppointmentTime(arrTime);
	this.appointmentDao.update(appointment);
	System.out.println("Send Mail");
    generalService.processSendMail(mailForm);
	
	}
	
}
}
}
	}
}
}
