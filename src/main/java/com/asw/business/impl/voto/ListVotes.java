package com.asw.business.impl.voto;

import java.sql.SQLException;
import java.util.List;

import com.asw.model.Voto;
import com.asw.persistence.impl.VotoGatewayImpl;

public class ListVotes {

	public List<Voto> listPendingVotes() {
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
