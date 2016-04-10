package com.asw.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.asw.model.VotacionDTO;

public interface VotanteGateway {

	void setConnection(Connection con);

	List<Votante> findAll() throws SQLException;
	
	Votante findByNif(String nif) throws SQLException;

}
