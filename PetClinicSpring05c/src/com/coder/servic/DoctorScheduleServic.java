package com.coder.servic;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.DoctorDao;
import com.coder.dao.DoctorScheduleDao;
import com.coder.dao.DoctorServicDao;
import com.coder.dao.RankDao;
import com.coder.dao.ScheduleServicDao;
import com.coder.dao.ServicDao;
import com.coder.dao.ServicTypeDao;
import com.coder.form.DoctorForm;
import com.coder.form.DoctorRegisterForm;
import com.coder.form.DoctorScheduleForm;
import com.coder.form.DoctorScheduleRegisterForm;
import com.coder.form.ServicForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.model.Doctor;
import com.coder.model.DoctorSchedule;
import com.coder.model.DoctorServic;
import com.coder.model.DoctorServicId;
import com.coder.model.Rank;
import com.coder.model.ScheduleServic;
import com.coder.model.ScheduleServicId;
import com.coder.model.Servic;
import com.coder.model.ServicType;
import com.coder.util.DateFormat;
import com.coder.util.PrjSubFunction;

@Service
@Repository("doctorScheduleServic")
public class DoctorScheduleServic {
	@Autowired
	private ScheduleServicDao scheduleServicDao;
	@Autowired
	private DoctorScheduleDao doctorScheduleDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private DoctorServicDao doctorServicDao;
	public void preparDoctorScheduleRegister(DoctorScheduleRegisterForm doctorScheduleRegisterForm){
		DoctorScheduleForm doctorScheduleForm=doctorScheduleRegisterForm.getDoctorScheduleForm();
		if(doctorScheduleForm!=null){
			this.doctorScheduleRegister(doctorScheduleRegisterForm);
			doctorScheduleForm=null;
			doctorScheduleRegisterForm.setDoctorScheduleForm(doctorScheduleForm);
		  }
	String docId=doctorScheduleRegisterForm.getDoctorId();
		if(docId!=null){
			 Doctor doctor=this.doctorDao.getDoctorById(Integer.parseInt(docId));
		     doctorScheduleRegisterForm.setDoctor(doctor);
		Set<DoctorServic> doctorServics=doctor.getDoctorServics();
		for(DoctorServic ds:doctorServics){
			ServicType st=ds.getServicType();
			doctorScheduleRegisterForm.getMapServicTypes().put(""+st.getServicTypeId(),""+st.getServicTypeName());
		}
         
	 	 doctorScheduleRegisterForm.setDoctorSchedules(this.doctorScheduleDao.getDoctorSchedules());
		} 
		List<Doctor> doctors=this.doctorDao.getDoctors();
		doctorScheduleRegisterForm.setDoctors(doctors);     
		
		doctorScheduleRegisterForm.setTimes(PrjSubFunction.getDataTimeArr());
		String[]  arr=PrjSubFunction.getDataDayNamesArr();
		doctorScheduleRegisterForm.setDayNames(arr);
         }
	
	private void doctorScheduleRegister(DoctorScheduleRegisterForm doctorScheduleRegisterForm){
		DoctorScheduleForm doctorScheduleForm=doctorScheduleRegisterForm.getDoctorScheduleForm();
		DoctorSchedule doctorSchedule=new DoctorSchedule();
		doctorSchedule.setDayName(doctorScheduleForm.getDayName());
		doctorSchedule.setEndTime(DateFormat.stringToTime_aa(doctorScheduleForm.getEndTime()));
		doctorSchedule.setStartTime(DateFormat.stringToTime_aa(doctorScheduleForm.getStartTime()));
		Doctor doctor=this.doctorDao.getDoctorById(Integer.parseInt(doctorScheduleRegisterForm.getDoctorId()));
		doctorSchedule.setDoctor(doctor);
		
       int doctorSchduleId=this.doctorScheduleDao.saveDoctorSchedule(doctorSchedule);
       String[] servicTypeIds=doctorScheduleForm.getSelectServicTypes();
        	for(String id:servicTypeIds){
        	
        	ScheduleServic scheduleServic=new ScheduleServic();
        	ScheduleServicId scheduleServicId=new ScheduleServicId();
         	scheduleServicId.setScheduleId(doctorSchduleId);
        	scheduleServicId.setServicTypeId(Integer.parseInt(id));
        	scheduleServic.setId(scheduleServicId);
        	this.scheduleServicDao.saveScheduleServic(scheduleServic);
        }
	}
	
}
