package com.coder.servic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
@Repository("petServic")
public class PetServic {
	@Autowired
	private PetDao petDao;
	@Autowired
	private SpeciesDao speciesDao;
	@Autowired
	private OwnerDao ownerDao;
	public void preparPetRegister(PetRegisterForm petRegisterForm){
		String strId=petRegisterForm.getOwnerId();
		//System.out.println("ownerId-="+strId);
		String id=strId.substring(4,strId.length());
		//System.out.println("ownerId2="+id);
		PetForm petForm=petRegisterForm.getPetForm();
		if(petForm!=null){
			this.petRegister(petRegisterForm);
			petForm=null;
		  }
		
		Owner owner=ownerDao.getOwnerById(Integer.parseInt(id));
		petRegisterForm.setPetForm(petForm);
		List<Species> species=this.speciesDao.getSpecies();
		for(Species sp:species)
		{petRegisterForm.getMapSpecies().put(""+sp.getSpeciesId(),""+sp.getSpeciesName());}
		
		Set<Pet> petSet=owner.getPets();
		List<Pet> pets=new ArrayList<Pet>();
		for(Pet p:petSet){
			pets.add(p);}
		
		petRegisterForm.setPets(pets);
        }	
	private void petRegister(PetRegisterForm petRegisterForm){
		Pet pet=new Pet();
		PetForm petForm=petRegisterForm.getPetForm();
		pet.setPetName(petForm.getPetName());
		pet.setPetSex(petForm.getPetSex());
		pet.setPetBirth(DateFormat.stringToDateFormat_dd_mm_yyyy(petForm.getPetBirth()));
		pet.setPetDeath(null);
		String strId=petRegisterForm.getOwnerId();
		String id=strId.substring(4,strId.length());
		Owner owner=ownerDao.getOwnerById(Integer.parseInt(id));
		Species species=this.speciesDao.getSpeciesById(Integer.parseInt(petForm.getSpeciesId()));
		pet.setOwner(owner);
		pet.setSpecies(species);
		this.petDao.savePet(pet);
       }
	    
	}

