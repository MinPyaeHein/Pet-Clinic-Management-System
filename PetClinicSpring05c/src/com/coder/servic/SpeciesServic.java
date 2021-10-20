package com.coder.servic;

import java.util.List;

import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.DoctorDao;
import com.coder.dao.DoctorServicDao;
import com.coder.dao.OwnerDao;
import com.coder.dao.PetDao;
import com.coder.dao.RankDao;
import com.coder.dao.ServicDao;
import com.coder.dao.ServicTypeDao;
import com.coder.dao.SpeciesDao;
import com.coder.form.DoctorForm;
import com.coder.form.DoctorRegisterForm;
import com.coder.form.PetForm;
import com.coder.form.PetRegisterForm;
import com.coder.form.ServicForm;
import com.coder.form.ServicRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.form.SpeciesForm;
import com.coder.form.SpeciesRegisterForm;
import com.coder.model.Doctor;
import com.coder.model.DoctorServicId;
import com.coder.model.Owner;
import com.coder.model.Pet;
import com.coder.model.Rank;
import com.coder.model.Servic;
import com.coder.model.ServicType;
import com.coder.model.Species;
import com.coder.util.DateFormat;

@Service
@Repository("speciesServic")
public class SpeciesServic {
	
	@Autowired
	private SpeciesDao speciesDao;
	
	public void preparSpeciesRegister(SpeciesRegisterForm speciesRegisterForm){
		SpeciesForm speciesForm=speciesRegisterForm.getSpeciesForm();
		if(speciesForm!=null){
			this.speciesRegister(speciesRegisterForm);
			speciesForm=null;
		  }
		speciesRegisterForm.setSpeciesForm(speciesForm);
		List<Species> species=this.speciesDao.getSpecies();
		speciesRegisterForm.setSpecies(species);
         }
	
	private void speciesRegister(SpeciesRegisterForm speciesRegisterForm){
		Species species=new Species();
		SpeciesForm speciesForm=speciesRegisterForm.getSpeciesForm();
		species.setSpeciesName(speciesForm.getSpeciesName());
		this.speciesDao.saveSpecies(species);
		
		
        }
	    
	}

