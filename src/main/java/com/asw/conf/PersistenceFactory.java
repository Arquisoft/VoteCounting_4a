package com.asw.conf;

import com.asw.persistence.VotosGateway;
import com.asw.persistence.impl.VotosGatewayImpl;


public class PersistenceFactory {
	
	public static VotosGateway getVotosGateway() {
		return new VotosGatewayImpl();
	}

}
