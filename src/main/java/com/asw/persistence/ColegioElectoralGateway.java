package com.asw.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.asw.model.ColegioElectoral;

public interface ColegioElectoralGateway {

	void setConnection(Connection con);

	List<ColegioElectoral> findAll() throws SQLException;
	ColegioElectoral findByIdent(long id) throws SQLException;

}
