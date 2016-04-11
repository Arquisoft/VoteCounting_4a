package com.asw.conf;

import com.asw.persistence.VotacionGateway;
import com.asw.persistence.impl.OpcionGatewayImpl;
import com.asw.persistence.impl.VotacionGatewayImpl;
import com.asw.persistence.impl.VotoGatewayImpl;


public class PersistenceFactory {
	
	public static VotacionGateway getVotacionGateway() {
		return new VotacionGatewayImpl();
	}

	public static VotoGatewayImpl getVotoGateway() {
		return new VotoGatewayImpl();
	}
	
	public static OpcionGatewayImpl getOpcionGateway() {
		return new OpcionGatewayImpl();
	}

}
