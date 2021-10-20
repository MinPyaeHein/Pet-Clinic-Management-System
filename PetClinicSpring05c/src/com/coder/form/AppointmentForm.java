package com.coder.form;

import java.util.Date;

import com.coder.model.Doctor;
import com.coder.model.DoctorSchedule;
import com.coder.model.Owner;
import com.coder.model.Servic;

public class AppointmentForm {
	private String ownerId;
	private String appointmentId;
	private String petId;
	private String[] selectedServices;
	private String servicTypeId;
	private String appointmentDate;
	private String appointmentTime;
	private String appointmentInfo;
	public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getAppointmentInfo() {
		return appointmentInfo;
	}
	public void setAppointmentInfo(String appointmentInfo) {
		this.appointmentInfo = appointmentInfo;
	}
	public String getServicTypeId() {
		return servicTypeId;
	}
	public void setServicTypeId(String servicTypeId) {
		this.servicTypeId = servicTypeId;
	}
	public String[] getSelectedServices() {
		return selectedServices;
	}
	public void setSelectedServices(String[] selectedServices) {
		this.selectedServices = selectedServices;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getPetId() {
		return petId;
	}
	public void setPetId(String petId) {
		this.petId = petId;
	}
}
