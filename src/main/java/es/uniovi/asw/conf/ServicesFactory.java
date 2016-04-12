package es.uniovi.asw.conf;


import es.uniovi.asw.business.VoteService;
import es.uniovi.asw.business.impl.VoteServiceImpl;

public class ServicesFactory {
	
	public static VoteService getVotesService () {
		return new VoteServiceImpl();
	}

}
