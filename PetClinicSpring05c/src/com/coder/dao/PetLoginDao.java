package com.coder.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coder.model.Doctor;
import com.coder.model.Owner;
import com.coder.model.Pet;
import com.coder.model.PetLogin;
import com.coder.model.ServicType;
@Repository("petLoginDao")
public class PetLoginDao extends AbstractDao<Integer,PetLogin>{
	
	public void savePetLogin(PetLogin petLogin)
	{
	super.persistVoid(petLogin);
    }
	
	public PetLogin getPetLoginById(int id){
		PetLogin petLogin=super.criteriaQuerryGetObjectById(id,"petLoginId");
	return petLogin;
	}
	public PetLogin getPetLoginByUserNameAndPassword(String loginId,String password) {
		
		PetLogin petLogin=super.getObjectTwoParam(loginId.trim(),"loginId",password.trim(),"password");
		
		return petLogin;
		
	}
  
public void  updatePetLogin(PetLogin petLogin)
{
super.update(petLogin);

}
public void  deletePetLogin(PetLogin petLogin)
{
super.delete(petLogin);

}

public List<PetLogin> getPetLogins() {
	List<PetLogin> petLogin=(List<PetLogin>)super.getAllEntity();
		return petLogin;
	}

}
