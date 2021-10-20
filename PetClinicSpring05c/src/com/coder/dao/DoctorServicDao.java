package com.coder.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coder.model.DoctorServic;

@Repository("doctorServicDoa")
public class DoctorServicDao extends AbstractDao<Integer,DoctorServic>{
	
	public Object saveDoctorServic(DoctorServic doctorServic)
	  {
	  return (Object)super.persistMtoM(doctorServic);
      }
	
	public DoctorServic getDoctorServicById(int id){
		DoctorServic doctorServic=super.criteriaQuerryGetObjectById(id,"doctorServicId");
		return doctorServic;
		}
	public List<DoctorServic>  getDoctorServicByDoctorId(int id){
		List<DoctorServic> doctorServics=super.criteriaQuerryGetObjectsById(id,"doctorId");
		return doctorServics;
		}
	
	public void  updateDoctorServic(DoctorServic doctorServic)
       {
       super.update(doctorServic);
       }

public Boolean deleteDoctorServic(DoctorServic doctorServic){
	return super.delete(doctorServic);
}

}
