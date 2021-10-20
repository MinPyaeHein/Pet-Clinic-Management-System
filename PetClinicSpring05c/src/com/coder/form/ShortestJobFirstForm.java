package com.coder.form;

public class ShortestJobFirstForm {
private String ownerId;
private String appId;
private String ownerName;
private String appintmentId;
private String completionTime;
private String waitingTime;
private String turnaroundTime;
private String servicTime;
public String getCompletionTime() {
	return completionTime;
}
public String getWaitingTime() {
	return waitingTime;
}
public String getTurnaroundTime() {
	return turnaroundTime;
}

public void setCompletionTime(String completionTime) {
	this.completionTime = completionTime;
}
public void setWaitingTime(String waitingTime) {
	this.waitingTime = waitingTime;
}
public void setTurnaroundTime(String turnaroundTime) {
	this.turnaroundTime = turnaroundTime;
}
public String getOwnerId() {
	return ownerId;
}
public void setOwnerId(String ownerId) {
	this.ownerId = ownerId;
}
public String getServicTime() {
	return servicTime;
}
public String getAppintmentId() {
	return appintmentId;
}
public String getOwnerName() {
	return ownerName;
}
public void setOwnerName(String ownerName) {
	this.ownerName = ownerName;
}
public void setAppintmentId(String appintmentId) {
	this.appintmentId = appintmentId;
}
public String getAppId() {
	return appId;
}
public void setAppId(String appId) {
	this.appId = appId;
}
public void setServicTime(String servicTime) {
	this.servicTime = servicTime;
}
}
