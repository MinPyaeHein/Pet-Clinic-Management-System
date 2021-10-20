package com.coder.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coder.model.Doctor;
import com.coder.model.Owner;
import com.coder.model.Pet;
import com.coder.model.ServicType;
@Repository("petDao")
public class PetDao extends AbstractDao<Integer,Pet>{
	
	public Integer savePet(Pet pet)
	{
	return (Integer)super.persist(pet);
    }
	
	public Pet getPetById(int id){
		Pet pet=super.criteriaQuerryGetObjectById(id,"petId");
	return pet;}
  
public void  updatePet(Pet pet)
{
super.update(pet);

}
public void  deletePet(Pet pet)
{
super.delete(pet);

}

public List<Pet> getPets() {
	List<Pet> pet=(List<Pet>)super.getAllEntity();
		return pet;
	}

}
