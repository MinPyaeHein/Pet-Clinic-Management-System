package com.coder.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coder.model.Appointment;
import com.coder.model.AppointmentServic;
import com.coder.model.Doctor;
import com.coder.model.DoctorSchedule;
import com.coder.model.ScheduleServic;
import com.coder.model.Servic;
import com.coder.model.ServicType;
@Repository("doctorScheduleDao")
public class DoctorScheduleDao extends AbstractDao<Integer,DoctorSchedule>{
	
	public Integer saveDoctorSchedule(DoctorSchedule doctorSchedule)
	{
	return (Integer)super.persist(doctorSchedule);

		}
	public DoctorSchedule getDoctorScheduleById(int id){
		DoctorSchedule doctorSchedule=super.criteriaQuerryGetObjectById(id,"scheduleId");
		return doctorSchedule;
		}
	public List<DoctorSchedule> getDoctorScheduleByDay(String day){
		List<DoctorSchedule> doctorSchedules=super.criteriaQuerryGetObjectsByName(day,"dayName");
		return doctorSchedules;
	}
  
public void  updateDoctorSchedule(DoctorSchedule doctorSchedule)
{
super.update(doctorSchedule);

}
public void  deleteDoctorSchedule(DoctorSchedule doctorSchedule)
{
super.delete(doctorSchedule);

}

public List<DoctorSchedule> getDoctorSchedules() {
	List<DoctorSchedule> doctorSchedule=(List<DoctorSchedule>)super.getAllEntity();
		return doctorSchedule;
	}
public  List<DoctorSchedule> getDoctorScheduleByDoctor(Doctor doctor){
	Transaction transaction=null;
	 List<DoctorSchedule> doctorSchedules=new ArrayList<DoctorSchedule>();
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);    
         Root<DoctorSchedule> doctorScheduleRoot = criteriaQuery.from(DoctorSchedule.class);
         criteriaQuery.multiselect(doctorScheduleRoot);
   	     criteriaQuery.where(builder.equal(doctorScheduleRoot.get("doctor"),doctor)  );
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
         System.out.println("list.size()="+list.size());
         for (Object object : list) {
        	 DoctorSchedule doctorSchedule=(DoctorSchedule)object;
        	 doctorSchedules.add(doctorSchedule);
         }
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
       
         if (transaction != null) {
            transaction.rollback();
         }
      }
      return doctorSchedules;
   }


public  List<DoctorSchedule> getDoctorScheduleByDayType(String dayName,ServicType servicType){
	Transaction transaction=null;
	 List<DoctorSchedule> doctorSchedules=new ArrayList<DoctorSchedule>();
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);   
         Root<ScheduleServic> scheduleServicRoot = criteriaQuery.from(ScheduleServic.class);
         Root<DoctorSchedule> doctorScheduleRoot = criteriaQuery.from(DoctorSchedule.class);
         criteriaQuery.multiselect(doctorScheduleRoot);
   	     criteriaQuery.where(builder.and(builder.equal(scheduleServicRoot.get("servicType"),servicType),
   	    		                         builder.equal(scheduleServicRoot.get("doctorSchedule"),doctorScheduleRoot.get("scheduleId")),
   	    		                         builder.equal(doctorScheduleRoot.get("dayName"),dayName)
   	    		                          ) );
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
         System.out.println("list.size()="+list.size());
         for (Object object : list) {
        	 DoctorSchedule doctorSchedule=(DoctorSchedule)object;
        	 doctorSchedules.add(doctorSchedule);
         }
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
       
         if (transaction != null) {
            transaction.rollback();
         }
      }
      return doctorSchedules;
   }

}

