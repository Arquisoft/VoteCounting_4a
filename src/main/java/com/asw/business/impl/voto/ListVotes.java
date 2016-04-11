package com.asw.business.impl.voto;

import java.sql.SQLException;
import java.util.List;

import com.asw.business.util.Jdbc;
import com.asw.conf.PersistenceFactory;
import com.asw.model.Voto;
import com.asw.persistence.impl.VotoGatewayImpl;

public class ListVotes {

	public List<Voto> listPendingVotes() {
		List<Voto> allPendingVotes = null;
		VotoGatewayImpl votoUpd = PersistenceFactory.getVotoGateway();
		try {
			votoUpd.setConnection(Jdbc.getConnection());
			allPendingVotes = votoUpd.findAll();
			for(Voto voto:allPendingVotes){
				votoUpd.actualizarLeido(voto.getId());
			}
		} catch (SQLException e) {
			throw new RuntimeException ("Error inesperado con la base de datos.");
		}
		return allPendingVotes;
	}
}
