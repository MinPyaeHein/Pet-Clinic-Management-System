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
import com.coder.model.ScheduleServic;

@Repository("scheduleServicDoa")
public class ScheduleServicDao extends AbstractDao<Integer,ScheduleServic>{
	
	public Object saveScheduleServic(ScheduleServic scheduleServic)
	  {
	  return (Object)super.persistMtoM(scheduleServic);
      }
	
	public ScheduleServic getScheduleServicById(int id){
		ScheduleServic scheduleServic=super.criteriaQuerryGetObjectById(id,"doctorServicId");
		return scheduleServic;
		}
	
	public void  updateScheduleServic(ScheduleServic scheduleServic)
       {
       super.update(scheduleServic);
       }

public Boolean deleteScheduleServic(ScheduleServic scheduleServic){
	return super.delete(scheduleServic);
}

}
