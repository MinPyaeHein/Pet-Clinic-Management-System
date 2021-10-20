package com.coder.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coder.model.Doctor;
import com.coder.model.Owner;
import com.coder.model.Pet;
import com.coder.model.ServicType;
import com.coder.model.Species;
@Repository("speciesDao")
public class SpeciesDao extends AbstractDao<Integer,Species>{
	
	public Integer saveSpecies(Species species)
	{
	return (Integer)super.persist(species);
    }
	
	public Species getSpeciesById(int id){
		Species species=super.criteriaQuerryGetObjectById(id,"speciesId");
	return species;}
  
public void  updateSpecies(Species species)
{
super.update(species);

}
public void  deleteSpecies(Species species)
{
super.delete(species);

}

public List<Species> getSpecies() {
	List<Species> species=(List<Species>)super.getAllEntity();
		return species;
	}

}
