package com.coder.form;

import com.coder.model.Rank;

public class DoctorForm {
	private String doctorId;
	private String password;
	private String rankId;
	private String doctorName;
	private String doctorGmail;
	private String doctorAddress;
	private String doctorAbout;
	private String doctorGender;
	private String doctorPhone;
	private String[] selectServicTypes;
	
	public String getRankId() {
		return rankId;
	}
	public void setRankId(String rankId) {
		this.rankId = rankId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorGmail() {
		return doctorGmail;
	}
	public void setDoctorGmail(String doctorGmail) {
		this.doctorGmail = doctorGmail;
	}
	public String getDoctorAddress() {
		return doctorAddress;
	}
	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}
	public String getDoctorAbout() {
		return doctorAbout;
	}
	public void setDoctorAbout(String doctorAbout) {
		this.doctorAbout = doctorAbout;
	}
	public String getDoctorGender() {
		return doctorGender;
	}
	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}
	public String getDoctorPhone() {
		return doctorPhone;
	}
	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}
	public String[] getSelectServicTypes() {
		return selectServicTypes;
	}
	public void setSelectServicTypes(String[] selectServicTypes) {
		this.selectServicTypes = selectServicTypes;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
