package com.coder.servic;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.AppointmentServicDao;
import com.coder.dao.AppointmentDao;
import com.coder.dao.DoctorDao;
import com.coder.dao.DoctorScheduleDao;
import com.coder.dao.DoctorServicDao;
import com.coder.dao.OwnerDao;
import com.coder.dao.PetDao;
import com.coder.dao.RankDao;
import com.coder.dao.ScheduleServicDao;
import com.coder.dao.ServicDao;
import com.coder.dao.ServicTypeDao;
import com.coder.dao.SpeciesDao;
import com.coder.form.AppointmentForm;
import com.coder.form.AppointmentRegisterForm;
import com.coder.form.CountAppByScheduleDateForm;
import com.coder.form.DoctorForm;
import com.coder.form.DoctorRegisterForm;
import com.coder.form.DoctorScheduleForm;
import com.coder.form.PetForm;
import com.coder.form.PetRegisterForm;
import com.coder.form.ServicForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;

import com.coder.model.Appointment;
import com.coder.model.AppointmentServicId;
import com.coder.model.Doctor;
import com.coder.model.DoctorSchedule;
import com.coder.model.DoctorServicId;
import com.coder.model.Owner;
import com.coder.model.Pet;
import com.coder.model.Rank;
import com.coder.model.ScheduleServic;
import com.coder.model.Servic;
import com.coder.model.ServicType;
import com.coder.model.Species;
import com.coder.util.DateFormat;
import com.coder.util.PrjSubFunction;

import javafx.scene.input.DataFormat;

@Service
@Repository("appointmentServic")
public class AppointmentServic {
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Autowired
	private ServicTypeDao servicTypeDao;
	@Autowired
	private DoctorScheduleDao doctorScheduleDao;
	@Autowired
	private OwnerDao ownerDao;
	@Autowired
	private PetDao petDao;
	@Autowired
	private AppointmentServicDao appointmentServicDao;
	@Autowired
	private ServicDao servicDao;
	public void preparAppointmentRegister1(AppointmentRegisterForm appointmentRegisterForm){
		 if(appointmentRegisterForm.getOwnerId()!=null){
			 appointmentRegisterForm.getMapServicTypes().put("1","Gneral Consulation"); 
			 appointmentRegisterForm.getMapServicTypes().put("4","Dental Treatment"); 
		 }else{
		 List<ServicType> servicTypes=servicTypeDao.getServicTypes();
		
		 for(ServicType st:servicTypes){
			 appointmentRegisterForm.getMapServicTypes().put(st.getServicTypeId()+"",st.getServicTypeName());
		 }}
         }
/*	public void preparAppointmentRegister2(AppointmentRegisterForm appointmentRegisterForm) throws ParseException{
		 AppointmentForm appointmentForm=appointmentRegisterForm.getAppointmentForm();
		 ServicType servicType=this.servicTypeDao.getServicTypeById(Integer.parseInt(appointmentForm.getServicTypeId()));
		 String dayName=DateFormat.dateFormat_EEE(appointmentForm.getAppointmentDate());
		 List<DoctorSchedule> doctorSchedules=this. doctorScheduleDao.getDoctorScheduleByDay(dayName.toUpperCase());
		 
		 List<DoctorSchedule> doctorSchedulesSelect=new ArrayList<>();
		 if(doctorSchedules!=null){
	     for(DoctorSchedule ds:doctorSchedules){
			Set<ScheduleServic> scheduleServics= ds.getScheduleServics();
			Boolean flag=false;
			for(ScheduleServic sc:scheduleServics){
				String servicTypeName=sc.getServicType().getServicTypeName();
				if(servicTypeName.equals(servicType.getServicTypeName())){
					flag=true;
				}
			}
			if(flag){
			doctorSchedulesSelect.add(ds);
			}
		 }
		 }
		 ArrayList<DoctorScheduleForm> doctorScheduleForms=new ArrayList<>();
		 for(DoctorSchedule ds:doctorSchedulesSelect){
			 
			 DoctorScheduleForm doctorScheduleForm=new DoctorScheduleForm();
			 doctorScheduleForm.setDayName(ds.getDayName());
			 doctorScheduleForm.setStartTime(ds.getStartTime()+"");
			 doctorScheduleForm.setEndTime(ds.getEndTime()+"");
			 doctorScheduleForm.setScheduleId(ds.getScheduleId()+"");
			ArrayList<Integer> minutes=PrjSubFunction.getScheduleByAppServicMinute(ds,DateFormat.stringToDateFormat_dd_mm_yyyy(appointmentForm.getAppointmentDate()));
			
			int timeSlot=DateFormat.timeDifference1(ds.getStartTime()+"",ds.getEndTime()+"");
			int temp=servicType.getAverageTime();
			for(int min: minutes){
			timeSlot=timeSlot-min;
			}
			int count=-1;
			boolean flag=true;
			while(flag){
				System.out.println("timeSlot-temp="+timeSlot+"-"+temp);
				if((timeSlot-temp)<0){
					flag=false;
				}else{
				    timeSlot=timeSlot-temp;
			        System.out.println("timeSlot="+timeSlot);
				}
				count++;
			}
			 doctorScheduleForm.setTimeSlot(count);
			 doctorScheduleForms.add(doctorScheduleForm);
		 }
		
	     appointmentRegisterForm.setDoctorScheduleForms(doctorScheduleForms);
        }*/
	
	public void preparAppointmentRegister2(AppointmentRegisterForm appointmentRegisterForm) throws ParseException{
	 AppointmentForm appointmentForm=appointmentRegisterForm.getAppointmentForm();
	 ServicType servicType=this.servicTypeDao.getServicTypeById(Integer.parseInt(appointmentForm.getServicTypeId()));
	 String dayName=DateFormat.dateFormat_EEE(appointmentForm.getAppointmentDate());
	 List<DoctorSchedule> doctorSchedulesSelect=this.doctorScheduleDao.getDoctorScheduleByDayType(dayName, servicType);
	
	 ArrayList<DoctorScheduleForm> doctorScheduleForms=new ArrayList<>();
	 for(DoctorSchedule ds:doctorSchedulesSelect){
		 
		 DoctorScheduleForm doctorScheduleForm=new DoctorScheduleForm();
		 doctorScheduleForm.setDayName(ds.getDayName());
		 doctorScheduleForm.setStartTime(ds.getStartTime()+"");
		 doctorScheduleForm.setEndTime(ds.getEndTime()+"");
		 doctorScheduleForm.setScheduleId(ds.getScheduleId()+"");
		ArrayList<Integer> minutes=PrjSubFunction.getScheduleByAppServicMinute(ds,DateFormat.stringToDateFormat_dd_mm_yyyy(appointmentForm.getAppointmentDate()));
		
		int timeSlot=DateFormat.timeDifference1(ds.getStartTime()+"",ds.getEndTime()+"");
		int temp=servicType.getAverageTime();
		for(int min: minutes){
		timeSlot=timeSlot-min;
		}
		int count=-1;
		boolean flag=true;
		while(flag){
			System.out.println("timeSlot-temp="+timeSlot+"-"+temp);
			if((timeSlot-temp)<0){
				flag=false;
			}else{
			    timeSlot=timeSlot-temp;
		        System.out.println("timeSlot="+timeSlot);
			}
			count++;
		}
		 doctorScheduleForm.setTimeSlot(count);
		 doctorScheduleForms.add(doctorScheduleForm);
	 }
	
    appointmentRegisterForm.setDoctorScheduleForms(doctorScheduleForms);
   }
	
	public void preparAppointmentRegister3(AppointmentRegisterForm appointmentRegisterForm){
		String servicTypeId=appointmentRegisterForm.getServicTypeId();
		ServicType servicType=this.servicTypeDao.getServicTypeById(Integer.parseInt(servicTypeId));
        Owner owner=this.ownerDao.getOwnerById(PrjSubFunction.convertId(appointmentRegisterForm.getOwnerId(),"oid"));
		Set<Servic> servicSets=servicType.getServics();
		Set<Pet> petSets=owner.getPets();
		System.out.println("petSets="+petSets.size());
		for(Pet pet:petSets){
			appointmentRegisterForm.getMapPets().put(pet.getPetId()+"",pet.getPetName()+"("+pet.getSpecies().getSpeciesName()+")");
		}
		for(Servic s:servicSets){
			appointmentRegisterForm.getMapServices().put(s.getServicId()+"",s.getServicName());
		}		
	}
	public void appointmentRegister(AppointmentRegisterForm appointmentRegisterForm){
		AppointmentForm appointmentForm=appointmentRegisterForm.getAppointmentForm();
		Appointment appointment=new Appointment();
		Date date=DateFormat.stringToDateFormat_dd_mm_yyyy(appointmentForm.getAppointmentDate());
		appointment.setAppointmentDate(date);
		appointment.setAppointmentTime(null);
		appointment.setAppointmentInfo(appointmentForm.getAppointmentInfo());
		DoctorSchedule doctorSchedule=this.doctorScheduleDao.getDoctorScheduleById(Integer.parseInt(appointmentRegisterForm.getDoctorScheduleId()));
		Doctor doctor=doctorSchedule.getDoctor();
		String strId=appointmentForm.getOwnerId();
		if(strId==null){
			strId=appointmentRegisterForm.getOwnerId();
		}
	    int id=PrjSubFunction.convertId(strId,"oid");
	    System.out.println("oid="+id);
		Owner owner=ownerDao.getOwnerById(id);
		Pet pet=petDao.getPetById(Integer.parseInt(appointmentForm.getPetId()));
		appointment.setPet(pet);
		appointment.setOwner(owner);
		appointment.setDoctor(doctor);
		appointment.setDoctorSchedule(doctorSchedule);
		int Id=this.appointmentDao.saveAppointment(appointment);
		String[] selectServic=appointmentForm.getSelectedServices();
		ArrayList<String> servics=new ArrayList<>();
		for(String s:selectServic){
		Servic servic=this.servicDao.getServicById(Integer.parseInt(s));
		servics.add(servic.getServicName());		}
		List<Appointment> appointments=this.appointmentDao.getAppointmentByNow(date);
		List<Appointment> appointments1=this.appointmentDao.getAppointmentByNow(date);
		int count=0;
		System.out.println("appointments.size()="+appointments.size());
		for(Appointment app:appointments){
			if(appointments1.size()>count&&app.getDoctorSchedule().getScheduleId()!=doctorSchedule.getScheduleId()){
				appointments1.remove(count);
			}
			count++;
		}
		appointmentRegisterForm.setTokenNo((appointments1.size())+"");
		appointmentRegisterForm.setServices(servics);
		if(selectServic!=null){
			for(String servicId:selectServic){
			AppointmentServicId appointmentServicId=new AppointmentServicId();
			appointmentServicId.setAppointmentId(Id);
			appointmentServicId.setServicId(Integer.parseInt(servicId));
			com.coder.model.AppointmentServic appointmentServic=new com.coder.model.AppointmentServic();
			appointmentServic.setId(appointmentServicId);
			appointmentServicDao.saveAppointmentServic(appointmentServic);
			appointmentRegisterForm.setDoctorSchedule(doctorSchedule);
			}
		}
	}
	public void prepareCountAppointmentByDate(AppointmentRegisterForm appointmentRegisterForm){
		DoctorSchedule doctorSchedule=this.doctorScheduleDao.getDoctorScheduleById(Integer.parseInt(appointmentRegisterForm.getDoctorScheduleId()));
		List<Date> dates=this.appointmentDao.getAppoimentDateBySchedule(doctorSchedule);
		List<CountAppByScheduleDateForm> countAppByScheduleDateForms=new ArrayList<>();
		for(Date date:dates){
		CountAppByScheduleDateForm countAppByScheduleDateForm=new CountAppByScheduleDateForm();
		List<Appointment> appointments=this.appointmentDao.getAppoimentByDoctorSchedule(doctorSchedule, date);
		countAppByScheduleDateForm.setDate(DateFormat.dateToStringFormat_dd_mm_yyyy(date));
		countAppByScheduleDateForm.setCount(appointments.size()+"");
		countAppByScheduleDateForm.setScheduleId(doctorSchedule.getScheduleId()+"");
		countAppByScheduleDateForms.add(countAppByScheduleDateForm);
		}
		appointmentRegisterForm.setCountAppByScheduleDateForms(countAppByScheduleDateForms);
	}
	
}

