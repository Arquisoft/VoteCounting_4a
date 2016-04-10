package com.asw.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.asw.model.VotacionDTO;

public interface OpcionGateway {

	void setConnection(Connection con);

	List<Opcion> findAll() throws SQLException;
	
	Opcion findByName(String name) throws SQLException;

}
