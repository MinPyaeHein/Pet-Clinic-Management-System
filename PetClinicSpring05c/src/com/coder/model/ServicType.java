package com.coder.model;
// Generated Jul 17, 2020 9:43:20 PM by Hibernate Tools 5.0.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ServicType generated by hbm2java
 */
@Entity
@Table(name = "servic_type", catalog = "pet_clinic1")
public class ServicType implements java.io.Serializable {

	private Integer servicTypeId;
	private String servicTypeName;
	private int averageTime;
	private String servicTypeDesc;
	private Set<Servic> servics = new HashSet<Servic>(0);
	private Set<DoctorServic> doctorServics = new HashSet<DoctorServic>(0);
	private Set<ScheduleServic> scheduleServics = new HashSet<ScheduleServic>(0);

	public ServicType() {
	}

	public ServicType(String servicTypeName, String servicTypeDesc,int averageTime) {
		this.servicTypeName = servicTypeName;
		this.servicTypeDesc = servicTypeDesc;
		this.averageTime=averageTime;
	}

	public ServicType(String servicTypeName, String servicTypeDesc,int averageTime, Set<Servic> servics,
		Set<DoctorServic> doctorServics, Set<ScheduleServic> scheduleServics) {
		this.servicTypeName = servicTypeName;
		this.servicTypeDesc = servicTypeDesc;
		this.averageTime=averageTime;
		this.servics = servics;
		this.doctorServics = doctorServics;
		this.scheduleServics = scheduleServics;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "servic_type_id", unique = true, nullable = false)
	public Integer getServicTypeId() {
		return this.servicTypeId;
	}

	public void setServicTypeId(Integer servicTypeId) {
		this.servicTypeId = servicTypeId;
	}

	@Column(name = "servic_type_name", nullable = false, length = 30)
	public String getServicTypeName() {
		return this.servicTypeName;
	}

	public void setServicTypeName(String servicTypeName) {
		this.servicTypeName = servicTypeName;
	}

	@Column(name = "servic_type_desc", nullable = false, length = 100)
	public String getServicTypeDesc() {
		return this.servicTypeDesc;
	}

	public void setServicTypeDesc(String servicTypeDesc) {
		this.servicTypeDesc = servicTypeDesc;
	}
	@Column(name = "average_time", nullable = false)
	public int getAverageTime() {
		return this.averageTime;
	}

	public void setAverageTime(int averageTime) {
		this.averageTime = averageTime;
	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "servicType")
	public Set<Servic> getServics() {
		return this.servics;
	}

	public void setServics(Set<Servic> servics) {
		this.servics = servics;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "servicType")
	public Set<DoctorServic> getDoctorServics() {
		return this.doctorServics;
	}

	public void setDoctorServics(Set<DoctorServic> doctorServics) {
		this.doctorServics = doctorServics;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "servicType")
	public Set<ScheduleServic> getScheduleServics() {
		return this.scheduleServics;
	}

	public void setScheduleServics(Set<ScheduleServic> scheduleServics) {
		this.scheduleServics = scheduleServics;
	}

}
