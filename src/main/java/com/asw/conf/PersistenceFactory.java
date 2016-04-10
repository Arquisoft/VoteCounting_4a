package com.asw.conf;

import com.asw.persistence.VotacionGateway;
import com.asw.persistence.impl.VotacionGatewayImpl;


public class PersistenceFactory {
	
	public static VotacionGateway getVotosGateway() {
		return new VotacionGatewayImpl();
	}

}
