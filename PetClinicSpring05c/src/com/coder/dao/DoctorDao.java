package com.coder.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coder.model.Doctor;
import com.coder.model.ServicType;
@Repository("doctorDao")
public class DoctorDao extends AbstractDao<Integer,Doctor>{
	
	public Integer saveDoctor(Doctor doctor)
	{
	return (Integer)super.persist(doctor);

		}
	public Doctor getDoctorById(int id){
		Doctor doctor=super.criteriaQuerryGetObjectById(id,"doctorId");
		return doctor;
		}
  
public void  updateDoctor(Doctor doctor)
{
super.update(doctor);

}
public void  deleteDoctor(Doctor doctor)
{
super.delete(doctor);

}

public List<Doctor> getDoctors() {
	List<Doctor> doctor=(List<Doctor>)super.getAllEntity();
		return doctor;
	}


}
