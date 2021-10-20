package com.coder.servic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.RankDao;
import com.coder.dao.ServicTypeDao;
import com.coder.form.RankForm;
import com.coder.form.RankRegisterForm;
import com.coder.form.ServicTypeForm;
import com.coder.form.ServicTypeRegisterForm;
import com.coder.model.Rank;
import com.coder.model.ServicType;

@Service
@Repository("rankServic")
public class RankServic {
	@Autowired
	private RankDao rankDao;
	
	
	public void preparRankRegister(RankRegisterForm rankRegisterForm){
		RankForm rankForm=rankRegisterForm.getRankForm();
		if(rankForm!=null){
			this.rankRegister(rankForm);
			rankForm=null;
		  }
		rankRegisterForm.setRankForm(rankForm);
		List<Rank> ranks=this.rankDao.getRanks();
		rankRegisterForm.setRanks(ranks);
         }
	
	private int rankRegister(RankForm rankForm){
		Rank rank=new Rank();
		rank.setRankName(rankForm.getRankName());
		rank.setShortTerm(rankForm.getShortTerm());
		int id=this.rankDao.saveRank(rank);
		return id; 
	}
	
	public void preparRankUpdate(RankRegisterForm rankRegisterForm){
		RankForm rankForm=rankRegisterForm.getRankForm();
	int rankId=Integer.parseInt(rankForm.getRankId());
	Rank rank=this.rankDao.getRankById(rankId);
	rankForm.setRankId(rank.getRankId()+"");
	rankForm.setRankName(rank.getRankName());
	rankForm.setShortTerm(rank.getShortTerm());
	rankRegisterForm.setRankForm(rankForm);
	}
	
	public void rankUpdate(RankRegisterForm rankRegisterForm){
		RankForm rankForm=rankRegisterForm.getRankForm();
		Rank rank=new Rank();
		rank.setRankId(Integer.parseInt(rankForm.getRankId()));
		rank.setRankName(rankForm.getRankName());
		rank.setShortTerm(rankForm.getShortTerm());
		this.rankDao.updateRank(rank);
		rankForm=null;
		rankRegisterForm.setRankForm(rankForm);
	}
	public void rankDelete(RankRegisterForm rankRegisterForm){
		RankForm rankForm=rankRegisterForm.getRankForm();
		int id=Integer.parseInt(rankForm.getRankId());
		Rank rank=this.rankDao.getRankById(id);
        this.rankDao.deleteRank(rank);
		rankForm=null;
		rankRegisterForm.setRankForm(rankForm);
		
	}

}
