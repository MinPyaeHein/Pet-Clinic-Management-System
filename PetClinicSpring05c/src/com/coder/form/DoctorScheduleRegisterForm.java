package com.coder.form;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.model.Doctor;
import com.coder.model.DoctorSchedule;

public class DoctorScheduleRegisterForm {
private List<DoctorSchedule> doctorSchedules;
private List<Doctor> doctors;
private Doctor doctor;
private String doctorId;
private DoctorScheduleForm doctorScheduleForm;
private String[] dayNames;
private String[] times;
private Map<String,String> mapDayNames=new HashedMap<String,String>();
private Map<String,String> mapTimes=new HashedMap<String,String>();
private Map<String,String> mapServicTypes=new HashedMap<String,String>();
private Map<String,String> mapDoctors=new HashedMap<String,String>();
public List<DoctorSchedule> getDoctorSchedules() {
	return doctorSchedules;
}
public void setDoctorSchedules(List<DoctorSchedule> doctorSchedules) {
	this.doctorSchedules = doctorSchedules;
}
public List<Doctor> getDoctors() {
	return doctors;
}
public void setDoctors(List<Doctor> doctors) {
	this.doctors = doctors;
}
public DoctorScheduleForm getDoctorScheduleForm() {
	return doctorScheduleForm;
}
public void setDoctorScheduleForm(DoctorScheduleForm doctorScheduleForm) {
	this.doctorScheduleForm = doctorScheduleForm;
}
public Map<String, String> getMapServicTypes() {
	return mapServicTypes;
}
public void setMapServicTypes(Map<String, String> mapServicTypes) {
	this.mapServicTypes = mapServicTypes;
}
public Map<String, String> getMapDoctors() {
	return mapDoctors;
}
public void setMapDoctors(Map<String, String> mapDoctors) {
	this.mapDoctors = mapDoctors;
}
public String getDoctorId() {
	return doctorId;
}
public void setDoctorId(String doctorId) {
	this.doctorId = doctorId;
}
public Doctor getDoctor() {
	return doctor;
}
public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}
public Map<String, String> getMapDayNames() {
	return mapDayNames;
}
public Map<String, String> getMapTimes() {
	return mapTimes;
}
public void setMapDayNames(Map<String, String> mapDayNames) {
	this.mapDayNames = mapDayNames;
}
public void setMapTimes(Map<String, String> mapTimes) {
	this.mapTimes = mapTimes;
}
public String[] getDayNames() {
	return dayNames;
}
public void setDayNames(String[] dayNames) {
	this.dayNames = dayNames;
}
public String[] getTimes() {
	return times;
}
public void setTimes(String[] times) {
	this.times = times;
}

}
