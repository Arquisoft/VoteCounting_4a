package com.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.asw.conf.Conf;
import com.asw.model.Votacion;
import com.asw.persistence.VotacionGateway;

public class VotacionGatewayImpl implements VotacionGateway {

	private Connection con;

	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public List<Votacion> findAll() throws SQLException {

		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Votacion> data = new ArrayList<Votacion>();

		try {
			pst = con.prepareStatement(Conf.get("SQL_CARGAR_VOTACIONES"));
			rs = pst.executeQuery();
			while (rs.next()) {
				data.add(new Votacion(rs.getLong(1), rs.getString(2)));
			}
		}
		catch (SQLException e) {
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
