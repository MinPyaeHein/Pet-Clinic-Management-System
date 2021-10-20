package com.coder.servic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.DoctorDao;
import com.coder.dao.DoctorServicDao;
import com.coder.dao.OwnerDao;
import com.coder.dao.PetLoginDao;
import com.coder.dao.RankDao;
import com.coder.dao.ServicDao;
import com.coder.dao.ServicTypeDao;
import com.coder.form.DoctorForm;
import com.coder.form.DoctorRegisterForm;
import com.coder.form.OwnerForm;
import com.coder.form.OwnerRegisterForm;
import com.coder.form.PetLoginForm;
import com.coder.form.PetLoginRegisterForm;
import com.coder.form.ServicForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.model.Doctor;
import com.coder.model.DoctorServicId;
import com.coder.model.Owner;
import com.coder.model.PetLogin;
import com.coder.model.Rank;
import com.coder.model.Servic;
import com.coder.model.ServicType;

@Service
@Repository("petLoginServic")
public class PetLoginServic {
	@Autowired
	private PetLoginDao petLoginDao;
	
	    public void petLoginRegister(PetLoginForm petLoginForm){
	    	
		PetLogin petLogin=new PetLogin();
		petLogin.setLoginId(petLoginForm.getLoginId());
		petLogin.setUserName(petLoginForm.getUserName());
		petLogin.setPassword(petLoginForm.getPassword());
		this.petLoginDao.savePetLogin(petLogin);
 	}
	    public PetLogin petLoginUser(PetLoginForm petLoginForm){
	    	
			PetLogin petLogin=this.petLoginDao.getPetLoginByUserNameAndPassword(petLoginForm.getLoginId(),petLoginForm.getPassword());
			return petLogin;
	    	
	    }
	    
	
}
