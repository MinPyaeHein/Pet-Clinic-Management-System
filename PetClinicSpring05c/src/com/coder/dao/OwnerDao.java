package com.coder.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coder.model.Doctor;
import com.coder.model.Owner;
import com.coder.model.ServicType;
@Repository("ownerDao")
public class OwnerDao extends AbstractDao<Integer,Owner>{
	
	public Integer saveOwner(Owner owner)
	{
	return (Integer)super.persist(owner);
    }
	
	public Owner getOwnerById(int id){
    Owner owner=super.criteriaQuerryGetObjectById(id,"ownerId");
	return owner;}
  
public void  updateOwner(Owner owner)
{
super.update(owner);

}
public void  deleteOwner(Owner owner)
{
super.delete(owner);

}

public List<Owner> getOwners() {
	List<Owner> doctor=(List<Owner>)super.getAllEntity();
		return doctor;
	}

}
