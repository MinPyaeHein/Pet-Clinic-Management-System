package com.coder.dao;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.coder.model.Appointment;
import com.coder.model.AppointmentServic;
import com.coder.model.Doctor;
import com.coder.model.Owner;
import com.coder.model.ServicType;

@Repository("appointmentServicDao")
public class AppointmentServicDao extends AbstractDao<Integer,AppointmentServic>{
	
	public void saveAppointmentServic(AppointmentServic appointmentServic)
	{
	 super.persistVoid(appointmentServic);
    }
	
	public AppointmentServic getAppoimentServicById(int id){
		AppointmentServic appoimentServic=super.criteriaQuerryGetObjectById(id,"appointmentId");
	return appoimentServic;}
  
public void  updateAppointmentServic(AppointmentServic appointmentServic)
{
super.update(appointmentServic);

}
public void  deleteAppointmentServic(AppointmentServic appointmentServic)
{
super.delete(appointmentServic);

}

public List<AppointmentServic> getAppointmentServics() {
	List<AppointmentServic> appointmentServics=(List<AppointmentServic>)super.getAllEntity();
		return appointmentServics;
	}

}
