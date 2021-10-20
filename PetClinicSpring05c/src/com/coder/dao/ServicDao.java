package com.coder.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coder.model.Servic;
import com.coder.model.ServicType;
@Repository("servicDao")
public class ServicDao extends AbstractDao<Integer,Servic>{
	
	public Integer saveServic(Servic servic)
	{
	return (Integer)super.persist(servic);

		}
	public Servic getServicById(int id){
		Servic servic=super.criteriaQuerryGetObjectById(id,"servicId");
		return servic;
		}
  
public void  updateServic(Servic servic)
{
super.update(servic);

}
public void  deleteServic(Servic servic)
{
super.delete(servic);

}

public List<Servic> getServics() {
	List<Servic> servic=(List<Servic>)super.getAllEntity();
		return servic;
	}

}
