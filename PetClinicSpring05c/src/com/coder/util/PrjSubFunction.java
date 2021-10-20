package com.coder.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.coder.form.ShortestJobFirstForm;
import com.coder.form.ShowAppointmentForm;
import com.coder.model.Appointment;
import com.coder.model.AppointmentServic;
import com.coder.model.DoctorSchedule;
import com.coder.model.Owner;
import com.coder.model.ScheduleServic;
import com.coder.model.Servic;

import sun.java2d.pipe.AAShapePipe;

public class PrjSubFunction {
public static Integer convertId(String strId,String type){
	int id=-1;
	if(type.equals("oid")){
		 id=Integer.parseInt(strId.substring(4,strId.length()));	
	}else if(type.equals("did")){
		 id=Integer.parseInt(strId.substring(4,strId.length()));	
	}else if(type.equals("id")){
		 id=Integer.parseInt(strId.substring(3,strId.length()));	
	}
	return id;}

public static String[] getDataTimeArr(){
	String[] timeArr=new String[24];
	timeArr[0]="01:00 PM";
	timeArr[1]="02:00 PM";
	timeArr[2]="03:00 PM";
	timeArr[3]="04:00 PM";
	timeArr[4]="05:00 PM";
	timeArr[5]="06:00 PM";
	timeArr[6]="07:00 PM";
	timeArr[7]="08:00 PM";
	timeArr[8]="09:00 PM";
	timeArr[9]="10:00 PM";
	timeArr[10]="11:00 PM";
	timeArr[11]="12:00 PM";
	timeArr[12]="01:00 AM";
	timeArr[13]="02:00 AM";
	timeArr[14]="03:00 AM";
	timeArr[15]="04:00 AM";
	timeArr[16]="05:00 AM";
	timeArr[17]="06:00 AM";
	timeArr[18]="07:00 AM";
	timeArr[19]="08:00 AM";
	timeArr[20]="09:00 AM";
	timeArr[21]="10:00 AM";
	timeArr[22]="11:00 AM";
	timeArr[23]="12:00 AM";
	return timeArr;
	
}
public static String[] getDataDayNamesArr(){
	String[] dayArr=new String[7];
	dayArr[0]="MON";
	dayArr[1]="TUE";
	dayArr[2]="WED";
	dayArr[3]="THU";
	dayArr[4]="FRI";
	dayArr[5]="SAT";
	dayArr[6]="SUN";
	
	return dayArr;
}
public static int shortestJobGet(List<Appointment> appointments){
	Appointment tempApp=appointments.get(0);
	int tempTime=servicTimeCollect(tempApp.getAppointmentServics());
	int i=0;
	int temp=0;
	for(Appointment app:appointments){
		int servicTime=servicTimeCollect(app.getAppointmentServics());
		if(tempTime>servicTime){
			tempTime=servicTime;
			temp=i;
		}
		i++;
	}
	return temp;
}
public static ArrayList<Appointment> sortJob(List<Appointment> appointments) {
	ArrayList<Appointment> appSjf=new ArrayList<>();
	while(appointments.size()!=0){
		int index=shortestJobGet(appointments);
		Appointment app=appointments.get(index);
		appSjf.add(app);
		appointments.remove(index);
	}
	return appSjf;
	
}
public static ArrayList<Appointment> sortJobById(List<Appointment> appointments) {
	ArrayList<Appointment> appSjf=new ArrayList<>();
	while(appointments.size()!=0){
		int index=shortestAppIdGet(appointments);
		Appointment app=appointments.get(index);
		appSjf.add(app);
		appointments.remove(index);
	}
	return appSjf;
	
}
public static int shortestAppIdGet(List<Appointment> appointments){
	Appointment tempApp=appointments.get(0);
	int tempId=tempApp.getAppointmentId();
	int i=0;
	int temp=0;
	for(Appointment app:appointments){
		int appId=app.getAppointmentId();
		if(tempId>appId){
			tempId=appId;
			temp=i;
		}
		i++;
	}
	return temp;
}
public static ArrayList<ShortestJobFirstForm> sortShortestJobForm(List<ShortestJobFirstForm> shortestJobFirstForms) {
	ArrayList<ShortestJobFirstForm> appSjf=new ArrayList<>();
	while(shortestJobFirstForms.size()!=0){
		int index=getShortestJobFormById(shortestJobFirstForms);
		ShortestJobFirstForm app=shortestJobFirstForms.get(index);
		appSjf.add(app);
		shortestJobFirstForms.remove(index);
	}
	return appSjf;
}
public static int getShortestJobFormById(List<ShortestJobFirstForm> shortestJobFirstForms){
	ShortestJobFirstForm tempApp=shortestJobFirstForms.get(0);
	int tempId=Integer.parseInt(tempApp.getAppId());
	int i=0;
	int temp=0;
	for(ShortestJobFirstForm shortestJobFirstForm:shortestJobFirstForms){
		int ownerId=Integer.parseInt(shortestJobFirstForm.getAppId());
		if(tempId>ownerId){
			tempId=ownerId;
			temp=i;
		}
		i++;
	}
	System.out.println("temp="+temp);
	return temp;
}

public static ShowAppointmentForm shortestJobFirstCal(List<Appointment> appointments,String type,ShowAppointmentForm showAppointmentForm){
	ArrayList<ShortestJobFirstForm> jobFirstForms=new ArrayList<>();
	
	int waitingTime=0;
	int wtotal=0;
	int completionTotal=0;
	int sum=appointments.size();
	for(Appointment app:appointments){
		ShortestJobFirstForm shortestJobFirstForm = new ShortestJobFirstForm();
		shortestJobFirstForm.setWaitingTime(waitingTime+"");
		wtotal=wtotal+waitingTime;
		shortestJobFirstForm.setAppintmentId(app.getAppointmentId()+"");
		shortestJobFirstForm.setServicTime(servicTimeCollect(app.getAppointmentServics())+"");
		waitingTime+=servicTimeCollect(app.getAppointmentServics());
		shortestJobFirstForm.setCompletionTime(waitingTime+"");
		shortestJobFirstForm.setTurnaroundTime(waitingTime+"");
		completionTotal+=waitingTime;
		Owner owner=app.getOwner();
		shortestJobFirstForm.setAppId(app.getAppointmentId()+"");
		shortestJobFirstForm.setOwnerId(owner.getOwnerId()+"");
		shortestJobFirstForm.setOwnerName(owner.getOwnerName());
		jobFirstForms.add(shortestJobFirstForm);
		
		}

	double watAvg=0.0;
	double turnAvg=0.0;
	if(sum!=0){
	 watAvg=wtotal/sum;
	 turnAvg=completionTotal/sum;
	}
	
	if(type.equals("sjf")){
	
		showAppointmentForm.setShortestJobFirstForms(jobFirstForms);
		showAppointmentForm.setWatingAvg(watAvg);
		showAppointmentForm.setTurnAvg(turnAvg);}
	else{
		
		showAppointmentForm.setNoShortestJobFirstForms(jobFirstForms);
		showAppointmentForm.setNoWatingAvg(watAvg);
		showAppointmentForm.setNoTurnAvg(turnAvg);
	}
	
	return showAppointmentForm;
	
}
public static int servicTimeCollect(Set<AppointmentServic> appointmentServices){
	int total=0;
	for(AppointmentServic appointmentServic:appointmentServices){
		Servic servic=appointmentServic.getServic();
		total+=servic.getServicMinute();
	    }
	return total;
	
}
public static ArrayList<Integer> getScheduleByAppServicMinute(DoctorSchedule doctorSchedule,Date date){
	String strDate=DateFormat.dateToString_DB_Format(date);
	ArrayList<Integer> minutes=new ArrayList<>();
	 Set<Appointment> appointments=doctorSchedule.getAppointments();
	// System.out.println("appointments.size()="+appointments.size());
	 for(Appointment appointment:appointments){
		 int servicMinute=0;
		 if(strDate.equals(appointment.getAppointmentDate()+"")){
	    Set<com.coder.model.AppointmentServic> appointmentServics=appointment.getAppointmentServics();
	    for(com.coder.model.AppointmentServic appointmentServic:appointmentServics ){
	 //  	System.out.println(strDate+"="+appointment.getAppointmentDate()+":"+date.equals(appointment.getAppointmentDate()+""));
	    	if(appointmentServic!=null){
	    		
	    	Servic servic=appointmentServic.getServic();
	    	servicMinute+=servic.getServicMinute();
	   
	    }
	 }
	    minutes.add(servicMinute);
     }
	 }
	 return minutes;
}

public static List<Appointment> collectAppByDate(String date,DoctorSchedule doctorSchedule){
	List<Appointment> app=new ArrayList<>();
	Set<Appointment> appSets=doctorSchedule.getAppointments();
	for(Appointment appoint:appSets){
		if(date.equals(appoint.getAppointmentDate()+"")){
			app.add(appoint);
		}
	}
	return app;
	
}
public static int minIndexSJF( List<ShortestJobFirstForm> firstForms){
	int index = 0;
	ShortestJobFirstForm sjfTemp=firstForms.get(0);
	int temp=Integer.parseInt(sjfTemp.getAppId());
	int count=0;
	for(ShortestJobFirstForm sjf:firstForms){
		int id=Integer.parseInt(sjf.getAppId());
		if(id<temp){
			temp=id;
			index=count;
		}
		count++;
	}
	return index;
}
public static List<ShortestJobFirstForm> sortByIdSJF( List<ShortestJobFirstForm> firstForms){
	List<ShortestJobFirstForm> firstForms1=new ArrayList<>();
	firstForms1=firstForms;
	List<ShortestJobFirstForm> firstForms2=new ArrayList<>();
	while(firstForms1.size()!=0){
		int index=minIndexSJF(firstForms1);
		firstForms2.add(firstForms1.get(index));
		firstForms1.remove(index);
	}
	return firstForms2;
	
}
}
