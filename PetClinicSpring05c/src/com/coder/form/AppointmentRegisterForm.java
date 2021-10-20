package com.coder.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.model.Appointment;
import com.coder.model.DoctorSchedule;

public class AppointmentRegisterForm {
private String OwnerId;
private String servicTypeId;
private String doctorScheduleId;
private String tokenNo;
private DoctorSchedule doctorSchedule;
private AppointmentForm appointmentForm;
private List<Appointment> appointments;
private List<CountAppByScheduleDateForm> countAppByScheduleDateForms;
private ArrayList<String> services=new ArrayList<>();
private ArrayList<Integer> timeSlots=new ArrayList<>();
private Map<String,String> mapPets=new HashedMap<String,String>();
private Map<String,String> mapServicTypes=new HashedMap<String,String>();
private Map<String,String> mapServices=new HashedMap<String,String>();
private List<DoctorSchedule> doctorSchedules;
private ArrayList<DoctorScheduleForm> doctorScheduleForms=new ArrayList<>();
public Map<String, String> getMapServices() {
	return mapServices;
}
public void setMapServices(Map<String, String> mapServices) {
	this.mapServices = mapServices;
}
public Map<String, String> getMapServicTypes() {
	return mapServicTypes;
}
public void setMapServicTypes(Map<String, String> mapServicTypes) {
	this.mapServicTypes = mapServicTypes;
}
public List<DoctorSchedule> getDoctorSchedules() {
	return doctorSchedules;
}
public void setDoctorSchedules(List<DoctorSchedule> doctorSchedules) {
	this.doctorSchedules = doctorSchedules;
}

public String getDoctorScheduleId() {
	return doctorScheduleId;
}
public void setDoctorScheduleId(String doctorScheduleId) {
	this.doctorScheduleId = doctorScheduleId;
}
public String getServicTypeId() {
	return servicTypeId;
}
public void setServicTypeId(String servicTypeId) {
	this.servicTypeId = servicTypeId;
}
public AppointmentForm getAppointmentForm() {
	return appointmentForm;
}
public void setAppointmentForm(AppointmentForm appointmentForm) {
	this.appointmentForm = appointmentForm;
}
public List<CountAppByScheduleDateForm> getCountAppByScheduleDateForms() {
	return countAppByScheduleDateForms;
}
public void setCountAppByScheduleDateForms(List<CountAppByScheduleDateForm> countAppByScheduleDateForms) {
	this.countAppByScheduleDateForms = countAppByScheduleDateForms;
}
public ArrayList<Integer> getTimeSlots() {
	return timeSlots;
}
public void setTimeSlots(ArrayList<Integer> timeSlots) {
	this.timeSlots = timeSlots;
}
public List<Appointment> getAppointments() {
	return appointments;
}
public void setAppointments(List<Appointment> appointments) {
	this.appointments = appointments;
}
public ArrayList<DoctorScheduleForm> getDoctorScheduleForms() {
	return doctorScheduleForms;
}
public Map<String, String> getMapPets() {
	return mapPets;
}
public void setMapPets(Map<String, String> mapPets) {
	this.mapPets = mapPets;
}
public void setDoctorScheduleForms(ArrayList<DoctorScheduleForm> doctorScheduleForms) {
	this.doctorScheduleForms = doctorScheduleForms;
}
public String getOwnerId() {
	return OwnerId;
}
public void setOwnerId(String ownerId) {
	OwnerId = ownerId;
}
public String getTokenNo() {
	return tokenNo;
}

public ArrayList<String> getServices() {
	return services;
}
public void setServices(ArrayList<String> services) {
	this.services = services;
}
public DoctorSchedule getDoctorSchedule() {
	return doctorSchedule;
}
public void setTokenNo(String tokenNo) {
	this.tokenNo = tokenNo;
}
public void setDoctorSchedule(DoctorSchedule doctorSchedule) {
	this.doctorSchedule = doctorSchedule;
}

}
