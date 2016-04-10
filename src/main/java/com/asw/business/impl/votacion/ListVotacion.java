package com.asw.business.impl.votacion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.asw.business.util.Jdbc;
import com.asw.conf.PersistenceFactory;
import com.asw.model.VotacionDTO;
import com.asw.persistence.VotacionGateway;

public class ListVotacion {

	public List<VotacionDTO> listAll() {
		Connection con = null;
		List<VotacionDTO> result = null;
		try {
			con = Jdbc.getConnection();	
			VotacionGateway tg = PersistenceFactory.getVotosGateway();
			tg.setConnection(con);
			//Saco todos los tipos de vehiculo
			result = tg.findAll();			
		} catch (SQLException e) {
			throw new RuntimeException ("Error inesperado con la base de datos.");
		} finally {
			Jdbc.close(con);
		}
		return result;
	}
}
