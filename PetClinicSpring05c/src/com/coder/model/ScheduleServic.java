package com.coder.model;
// Generated Jul 17, 2020 9:43:20 PM by Hibernate Tools 5.0.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ScheduleServic generated by hbm2java
 */
@Entity
@Table(name = "schedule_servic", catalog = "pet_clinic1")
public class ScheduleServic implements java.io.Serializable {

	private ScheduleServicId id;
	private DoctorSchedule doctorSchedule;
	private ServicType servicType;

	public ScheduleServic() {
	}

	public ScheduleServic(ScheduleServicId id, DoctorSchedule doctorSchedule, ServicType servicType) {
		this.id = id;
		this.doctorSchedule = doctorSchedule;
		this.servicType = servicType;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "servicTypeId", column = @Column(name = "servic_type_id", nullable = false)),
			@AttributeOverride(name = "scheduleId", column = @Column(name = "schedule_id", nullable = false)) })
	public ScheduleServicId getId() {
		return this.id;
	}

	public void setId(ScheduleServicId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "schedule_id", nullable = false, insertable = false, updatable = false)
	public DoctorSchedule getDoctorSchedule() {
		return this.doctorSchedule;
	}

	public void setDoctorSchedule(DoctorSchedule doctorSchedule) {
		this.doctorSchedule = doctorSchedule;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "servic_type_id", nullable = false, insertable = false, updatable = false)
	public ServicType getServicType() {
		return this.servicType;
	}

	public void setServicType(ServicType servicType) {
		this.servicType = servicType;
	}

}
