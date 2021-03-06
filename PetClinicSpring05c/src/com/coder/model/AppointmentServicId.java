package com.coder.model;
// Generated Jul 17, 2020 9:43:20 PM by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AppointmentServicId generated by hbm2java
 */
@Embeddable
public class AppointmentServicId implements java.io.Serializable {

	private int servicId;
	private int appointmentId;

	public AppointmentServicId() {
	}

	public AppointmentServicId(int servicId, int appointmentId) {
		this.servicId = servicId;
		this.appointmentId = appointmentId;
	}

	@Column(name = "servic_id", nullable = false)
	public int getServicId() {
		return this.servicId;
	}

	public void setServicId(int servicId) {
		this.servicId = servicId;
	}

	@Column(name = "appointment_id", nullable = false)
	public int getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AppointmentServicId))
			return false;
		AppointmentServicId castOther = (AppointmentServicId) other;

		return (this.getServicId() == castOther.getServicId())
				&& (this.getAppointmentId() == castOther.getAppointmentId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getServicId();
		result = 37 * result + this.getAppointmentId();
		return result;
	}

}
