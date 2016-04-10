package com.asw.business.impl;

import java.sql.SQLException;
import java.util.List;

import com.asw.business.VoteService;
import com.asw.business.impl.votacion.ListVotacion;
import com.asw.model.Votacion;
import com.asw.model.Voto;
import com.asw.persistence.impl.VotoGatewayImpl;

public class VoteServiceImpl implements VoteService {

	@Override
	public List<Votacion> listAllVotaciones() {
		return new ListVotacion().listAll();
	}

	@Override
	public List<Voto> getPendingVotes() {
		List<Voto> allPendingVotes = null;
		VotoGatewayImpl votoUpd = new VotoGatewayImpl();
		try {
			allPendingVotes = new VotoGatewayImpl().findAll();
			for(Voto voto:allPendingVotes){
				votoUpd.actualizarLeido(voto.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allPendingVotes;
	}
}
