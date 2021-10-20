package com.coder.servic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.DoctorDao;
import com.coder.dao.DoctorScheduleDao;
import com.coder.dao.DoctorServicDao;
import com.coder.dao.RankDao;
import com.coder.dao.ServicDao;
import com.coder.dao.ServicTypeDao;
import com.coder.form.DoctorForm;
import com.coder.form.DoctorRegisterForm;
import com.coder.form.ServicForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.model.Doctor;
import com.coder.model.DoctorSchedule;
import com.coder.model.DoctorServicId;
import com.coder.model.Rank;
import com.coder.model.Servic;
import com.coder.model.ServicType;
import com.coder.util.PrjSubFunction;

@Service
@Repository("doctorServic")
public class DoctorServic {
	@Autowired
	private DoctorServicDao doctorServicDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private ServicTypeDao servicTypeDao;
	@Autowired
	private RankDao rankDao;
	@Autowired
	private DoctorScheduleDao doctorScheduleDao;
	public void preparDoctorRegister(DoctorRegisterForm doctorRegisterForm){
		DoctorForm doctorForm=doctorRegisterForm.getDoctorForm();
		if(doctorForm!=null){
			this.doctorRegister(doctorForm);
			
		  }
		doctorForm=new DoctorForm();
		doctorRegisterForm.setDoctorForm(doctorForm);
		List<ServicType> servicTypes=this.servicTypeDao.getServicTypes();
		for(ServicType st:servicTypes){
			doctorRegisterForm.getMapServicTypes().put(""+st.getServicTypeId(),""+st.getServicTypeName());
		}
	     List<Rank> ranks=this.rankDao.getRanks();
		for( Rank ra:ranks){
			doctorRegisterForm.getMapRanks().put(""+ra.getRankId(),""+ra.getRankName());
		}
		List<Doctor> doctors=this.doctorDao.getDoctors();
		if(doctors.size()==0){
		
			doctorForm.setDoctorId("did-1");
		}else{
			Doctor doctor=doctors.get(doctors.size()-1);
			doctorForm.setDoctorId("did-"+(doctor.getDoctorId()+1));
		}
	
		doctorRegisterForm.setDoctors(doctors);
         }
	
	private void doctorRegister(DoctorForm doctorForm){
		Doctor doctor=new Doctor();
		doctor.setDoctorName(doctorForm.getDoctorName());
		doctor.setDoctorGender(doctorForm.getDoctorGender());
		doctor.setDoctorGmail(doctorForm.getDoctorGmail());
		doctor.setDoctorAddress(doctorForm.getDoctorAddress());
		System.out.println("doctorForm.getDoctorAbout()="+doctorForm.getDoctorAbout());
		doctor.setDoctorAbout(doctorForm.getDoctorAbout());
		doctor.setDoctorPhone(doctorForm.getDoctorPhone());
		Rank rank=rankDao.getRankById(Integer.parseInt(doctorForm.getRankId()));
        doctor.setRank(rank);
       int doctorId=this.doctorDao.saveDoctor(doctor);
        for(String id:doctorForm.getSelectServicTypes()){
        	
        	ServicType servicType=this.servicTypeDao.getServicTypeById(Integer.parseInt(id));
        	DoctorServicId doctorServicId=new DoctorServicId();
        	doctorServicId.setDoctorId(doctorId);
        	doctorServicId.setServicTypeId(servicType.getServicTypeId());
        	com.coder.model.DoctorServic doctorServic=new com.coder.model.DoctorServic();
        	doctorServic.setId(doctorServicId);
        	this.doctorServicDao.saveDoctorServic(doctorServic);
        }
	    
	}
	public void showDoctorSchedules(DoctorRegisterForm doctorRegisterForm){
		String strDoctorId=doctorRegisterForm.getDoctorId();
		int doctorId=PrjSubFunction.convertId(strDoctorId,"did");
		Doctor doctor=this.doctorDao.getDoctorById(doctorId);
		List<DoctorSchedule> doctorSchedules=doctorScheduleDao.getDoctorScheduleByDoctor(doctor);
		doctorRegisterForm.setDoctorSchedules(doctorSchedules);
	
	}
}
