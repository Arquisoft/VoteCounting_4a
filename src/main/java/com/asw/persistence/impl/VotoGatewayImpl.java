package com.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.asw.conf.Conf;
import com.asw.model.Voto;
import com.asw.persistence.VotoGateway;

public class VotoGatewayImpl implements VotoGateway {

	private Connection con;

	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public List<Voto> votosAContar() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Voto> data = new ArrayList<Voto>();

		try {
			pst = con.prepareStatement(Conf.get("FIND_ALL_VOTES_NO_READ"));
			rs = pst.executeQuery();
			while (rs.next()) {
				data.add(new Voto(rs.getLong(1), rs.getDate(2), rs.getLong(3),
						rs.getLong(4)));
			}

		} finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				throw e;
			}
		}
		return data;
	}

	@Override
	public void actualizarLeido(long id) throws SQLException {
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(Conf.get("UPDATE_LEIDO"));
			pst.setLong(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
}