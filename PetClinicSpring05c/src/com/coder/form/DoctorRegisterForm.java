package com.coder.form;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.model.Doctor;
import com.coder.model.DoctorSchedule;
import com.coder.model.ServicType;

public class DoctorRegisterForm {
private String doctorId;
private DoctorForm doctorForm;
private List<Doctor> doctors;
private List<DoctorSchedule> doctorSchedules;
private Map<String,String> mapRanks=new HashedMap<String,String>();
private Map<String,String> mapServicTypes=new HashedMap<String,String>();
public DoctorForm getDoctorForm() {
	return doctorForm;
}
public void setDoctorForm(DoctorForm doctorForm) {
	this.doctorForm = doctorForm;
}

public Map<String, String> getMapRanks() {
	return mapRanks;
}
public void setMapRanks(Map<String, String> mapRanks) {
	this.mapRanks = mapRanks;
}
public Map<String, String> getMapServicTypes() {
	return mapServicTypes;
}
public void setMapServicTypes(Map<String, String> mapServicTypes) {
	this.mapServicTypes = mapServicTypes;
}
public List<Doctor> getDoctors() {
	return doctors;
}
public List<DoctorSchedule> getDoctorSchedules() {
	return doctorSchedules;
}
public void setDoctorSchedules(List<DoctorSchedule> doctorSchedules) {
	this.doctorSchedules = doctorSchedules;
}
public void setDoctors(List<Doctor> doctors) {
	this.doctors = doctors;
}
public String getDoctorId() {
	return doctorId;
}
public void setDoctorId(String doctorId) {
	this.doctorId = doctorId;
}

}
