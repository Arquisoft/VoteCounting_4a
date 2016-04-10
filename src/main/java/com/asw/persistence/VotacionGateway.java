package com.asw.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.asw.model.VotacionDTO;

public interface VotacionGateway {

	void setConnection(Connection con);

	List<VotacionDTO> findAll() throws SQLException;

}
