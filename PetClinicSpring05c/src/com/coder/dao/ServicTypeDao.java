package com.coder.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.coder.model.ServicType;
@Repository("servicTypeDao")
public class ServicTypeDao extends AbstractDao<Integer,ServicType>{
	
	public Integer saveServicType(ServicType servicType)
	{
	return (Integer)super.persist(servicType);

		}
	public ServicType getServicTypeById(int id){
		ServicType servicType=super.criteriaQuerryGetObjectById(id,"servicTypeId");
		return servicType;
		}
	public ServicType getServicTypeByName(String name){
		ServicType servicType=super.criteriaQuerryGetObjectByName(name,"servicTypeName");
		return servicType;
		}
  
public void  updateServicType(ServicType servicType)
{
super.update(servicType);

}
public void  deleteServicType(ServicType servicType)
{
super.delete(servicType);

}

public List<ServicType> getServicTypes() {
	List<ServicType> servicType=(List<ServicType>)super.getAllEntity();
		return servicType;
	}

}
