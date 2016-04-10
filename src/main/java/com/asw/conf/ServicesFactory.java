package com.asw.conf;

import com.asw.business.VoteService;
import com.asw.business.impl.VoteServiceImpl;


public class ServicesFactory {
	
	public static VoteService getVotesService () {
		return new VoteServiceImpl();
	}

}
