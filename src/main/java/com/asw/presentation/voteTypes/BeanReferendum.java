package com.asw.presentation.voteTypes;

import javax.faces.bean.ManagedBean;

import com.asw.instanciator.VotesShow;

@ManagedBean
public class BeanReferendum {
	
	private VotesShow votesShow;

	public VotesShow getVotesShow() {
		return votesShow;
	}

	public void setVotesShow(VotesShow votesShow) {
		this.votesShow = votesShow;
	}

}
