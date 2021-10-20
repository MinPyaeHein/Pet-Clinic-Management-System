package com.coder.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coder.model.Rank;
import com.coder.model.ServicType;
@Repository("rankDao")
public class RankDao extends AbstractDao<Integer,Rank>{
	
	public Integer saveRank(Rank rank)
	{
	return (Integer)super.persist(rank);

		}
	public Rank getRankById(int id){
		Rank rank=super.criteriaQuerryGetObjectById(id,"rankId");
		return rank;
		}
  
public void  updateRank(Rank rank)
{
super.update(rank);

}
public void  deleteRank(Rank rank)
{
super.delete(rank);

}

public List<Rank> getRanks() {
	List<Rank> ranks=(List<Rank>)super.getAllEntity();
		return ranks;
	}

}
