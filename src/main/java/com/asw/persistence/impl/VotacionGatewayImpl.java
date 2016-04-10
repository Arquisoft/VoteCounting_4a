package com.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.asw.model.VotacionDTO;
import com.asw.persistence.VotacionGateway;

public class VotacionGatewayImpl implements VotacionGateway {

	private Connection con;

	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public List<VotacionDTO> findAll() throws SQLException {

		PreparedStatement pst = null;
		ResultSet rs = null;
		List<VotacionDTO> data = new ArrayList<VotacionDTO>();

		try {
			// pst = con.prepareStatement(Conf.get("SQL_FIND_ALL"));
			pst = con.prepareStatement("SELECT * FROM TVOTACION WHERE ID=1");
			rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getLong(1)+", "+rs.getString(2));
				data.add(new VotacionDTO(rs.getLong(1), rs.getString(2)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pst.close();
				rs.close();
			} catch (SQLException e) {
				throw e;
			}
		}
		return data;
	}
}
