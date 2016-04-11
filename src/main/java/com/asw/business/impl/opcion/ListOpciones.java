package com.asw.business.impl.opcion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.asw.business.util.Jdbc;
import com.asw.conf.PersistenceFactory;
import com.asw.model.Opcion;
import com.asw.persistence.OpcionGateway;

public class ListOpciones {

	public List<Opcion> listOptions() {
		Connection con = null;
		List<Opcion> result = null;
		try {
			con = Jdbc.getConnection();	
			OpcionGateway tg = PersistenceFactory.getOpcionGateway();
			tg.setConnection(con);
			result = tg.findAll();			
		} catch (SQLException e) {
			throw new RuntimeException ("Error inesperado con la base de datos.");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
