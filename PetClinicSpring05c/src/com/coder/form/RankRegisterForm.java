package com.coder.form;

import java.util.List;

import com.coder.model.Rank;

public class RankRegisterForm {
private RankForm rankForm;
private List<Rank> ranks;
public RankForm getRankForm() {
	return rankForm;
}

public void setRankForm(RankForm rankForm) {
	this.rankForm = rankForm;
}

public List<Rank> getRanks() {
	return ranks;
}

public void setRanks(List<Rank> ranks) {
	this.ranks = ranks;
}
}
