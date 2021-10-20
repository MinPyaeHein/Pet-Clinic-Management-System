package com.coder.form;

import java.util.ArrayList;
import java.util.List;

import com.coder.model.DoctorSchedule;

public class ShowAppointmentForm {
private List<DoctorSchedule> doctorSchedules;
private String doctorScheduleId;
private String date;
private String servicTypeName;
private double noWatingAvg;
private double noTurnAvg;
private double watingAvg;
private double turnAvg;
private int burstTime;
private List<ShortestJobFirstForm> shortestJobFirstForms;
private List<ShortestJobFirstForm> noShortestJobFirstForms;
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
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

public void setTurnAvg(int turnAvg) {
	this.turnAvg = turnAvg;
}
public int getBurstTime() {
	return burstTime;
}
public void setBurstTime(int burstTime) {
	this.burstTime = burstTime;
}

public void setNoShortestJobFirstForms(ArrayList<ShortestJobFirstForm> noShortestJobFirstForms) {
	this.noShortestJobFirstForms = noShortestJobFirstForms;
}
public double getNoWatingAvg() {
	return noWatingAvg;
}
public void setNoWatingAvg(double noWatingAvg) {
	this.noWatingAvg = noWatingAvg;
}
public double getNoTurnAvg() {
	return noTurnAvg;
}
public void setNoTurnAvg(double noTurnAvg) {
	this.noTurnAvg = noTurnAvg;
}
public double getWatingAvg() {
	return watingAvg;
}
public void setWatingAvg(double watingAvg) {
	this.watingAvg = watingAvg;
}
public double getTurnAvg() {
	return turnAvg;
}
public String getServicTypeName() {
	return servicTypeName;
}
public void setServicTypeName(String servicTypeName) {
	this.servicTypeName = servicTypeName;
}
public void setTurnAvg(double turnAvg) {
	this.turnAvg = turnAvg;
}
public List<ShortestJobFirstForm> getShortestJobFirstForms() {
	return shortestJobFirstForms;
}
public void setShortestJobFirstForms(List<ShortestJobFirstForm> shortestJobFirstForms) {
	this.shortestJobFirstForms = shortestJobFirstForms;
}
public List<ShortestJobFirstForm> getNoShortestJobFirstForms() {
	return noShortestJobFirstForms;
}
public void setNoShortestJobFirstForms(List<ShortestJobFirstForm> noShortestJobFirstForms) {
	this.noShortestJobFirstForms = noShortestJobFirstForms;
}



}
