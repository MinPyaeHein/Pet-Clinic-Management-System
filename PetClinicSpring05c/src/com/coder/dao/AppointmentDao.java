package com.coder.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.annotations.Nullability;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coder.model.Appointment;
import com.coder.model.AppointmentServic;
import com.coder.model.Doctor;
import com.coder.model.DoctorSchedule;
import com.coder.model.Owner;
import com.coder.model.Servic;
import com.coder.model.ServicType;
@Repository("appointmentDao")
public class AppointmentDao extends AbstractDao<Integer,Appointment>{
	
	public Integer saveAppointment(Appointment appointment)
	{
	return (Integer)super.persist(appointment);
    }
	
	public Appointment getAppointmentById(int id){
		Appointment appointment=super.criteriaQuerryGetObjectById(id,"appointmentId");
	return appointment;}
	
	public List<Appointment> getAppointmentByNow(Date date){
		System.out.println("getAppointmentByNow:date="+date);
		//List<Appointment> appointments=(List<Appointment>) super.getObjectTwoParam(scheduleId,"doctorSchedule.scheduleId", date,"appointmentDate");
		List<Appointment> appointments=super.criteriaQuerryGetObjectsByDate(date,"appointmentDate");
		//System.out.println("Nowappointments="+appointments.size());
		return appointments;
	}
	public List<Appointment> getAppointmentByNowApptime(Date date){
		System.out.println("getAppointmentByNow:date="+date);
		//List<Appointment> appointments=(List<Appointment>) super.getObjectTwoParam(scheduleId,"doctorSchedule.scheduleId", date,"appointmentDate");
		List<Appointment> appointments=super.criteriaQuerryGetObjectsByDates(date,"appointmentDate","appointmentTime",null);
		System.out.println("Nowappointments="+appointments.size());
		return appointments;
	}
  
public void  updateAppointment(Appointment appointment)
{
super.update(appointment);

}
public void  deleteAppointment(Appointment appointment)
{
super.delete(appointment);

}

public List<Appointment> getAppointments() {
	List<Appointment> appointment=(List<Appointment>)super.getAllEntity();
		return appointment;
	}
public  List<Appointment> getAppoimentByServicType(ServicType servicType){
	Transaction transaction=null;
	 List<Appointment> appointments=new ArrayList<Appointment>();
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<Servic> servicRoot = criteriaQuery.from(Servic.class);
         Root<Appointment> appointmentRoot = criteriaQuery.from(Appointment.class);
         Root<AppointmentServic> appointmentServicRoot = criteriaQuery.from(AppointmentServic.class);
         criteriaQuery.multiselect(appointmentRoot);
   	     criteriaQuery.where(builder.and(builder.equal(servicRoot.get("servicType"),servicType),
   	    		                         builder.equal(appointmentServicRoot.get("servic"),servicRoot.get("servicId")),
   	    		                         builder.equal(appointmentServicRoot.get("appointment"),appointmentRoot.get("appointmentId"))
   	    		                         ));
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
         System.out.println("list.size()="+list.size());
         for (Object object : list) {
        	 Appointment appointment=(Appointment)object;
             appointments.add(appointment);
         }
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
       
         if (transaction != null) {
            transaction.rollback();
         }
      }
      return appointments;
   }
public  List<Appointment> getAppoimentByDoctorSchedule(DoctorSchedule doctorSchedule,Date date){
	Transaction transaction=null;
	 List<Appointment> appointments=new ArrayList<Appointment>();
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<Appointment> appointmentRoot = criteriaQuery.from(Appointment.class);
         criteriaQuery.multiselect(appointmentRoot);
   	     criteriaQuery.where(builder.and(builder.equal(appointmentRoot.get("doctorSchedule"),doctorSchedule),
   	    		                         builder.equal(appointmentRoot.get("appointmentDate"),date)
   	    		                        
   	    		                         ));
   	     criteriaQuery.distinct(true);
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
         System.out.println("list.size()="+list.size());
         for (Object object : list) {
        	 Appointment appointment=(Appointment)object;
             appointments.add(appointment);
         }
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
       
         if (transaction != null) {
            transaction.rollback();
         }
      }
      return appointments;
   }
public  List<Appointment> getAppoimentByToSent(DoctorSchedule doctorSchedule,Date date){
	Transaction transaction=null;
	 List<Appointment> appointments=new ArrayList<Appointment>();
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        
         Root<Appointment> appointmentRoot = criteriaQuery.from(Appointment.class);
       
         criteriaQuery.multiselect(appointmentRoot);
   	     criteriaQuery.where(builder.and(builder.equal(appointmentRoot.get("doctorSchedule"),doctorSchedule),
   	    		                         builder.equal(appointmentRoot.get("appointmentDate"),date),
   	    		                         builder.isNull(appointmentRoot.get("appointmentTime"))
   	    		                         ));
   	     criteriaQuery.distinct(true);
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
         System.out.println("list.size()="+list.size());
         for (Object object : list) {
        	 Appointment appointment=(Appointment)object;
             appointments.add(appointment);
         }
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
       
         if (transaction != null) {
            transaction.rollback();
         }
      }
      return appointments;
   }
public  List<Date> getAppoimentDateBySchedule(DoctorSchedule doctorSchedule){
	Transaction transaction=null;
	 List<Date> dates=new ArrayList<Date>();
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        
         Root<Appointment> appointmentRoot = criteriaQuery.from(Appointment.class);
         criteriaQuery.multiselect(appointmentRoot.get("appointmentDate"));
   	     criteriaQuery.where(builder.equal(appointmentRoot.get("doctorSchedule"),doctorSchedule)  );
   	     criteriaQuery.distinct(true);
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
         System.out.println("list.size()="+list.size());
         for (Object object : list) {
        	 Date date=(Date)object;
             dates.add(date);
         }
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
       
         if (transaction != null) {
            transaction.rollback();
         }
      }
      return dates;
   }
}
