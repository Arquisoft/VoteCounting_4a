package com.asw.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.asw.model.Voto;

public interface VotoGateway {

	void setConnection(Connection con);

	List<Voto> findAll() throws SQLException;
	
	List<Voto> votosAContar() throws SQLException;
	
	void actualizarLeido(long id) throws SQLException;

}
