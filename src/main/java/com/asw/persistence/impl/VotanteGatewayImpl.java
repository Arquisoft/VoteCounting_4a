package com.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.asw.conf.Conf;
import com.asw.model.VotacionDTO;
import com.asw.persistence.VotacionGateway;
import com.asw.persistence.Votante;
import com.asw.persistence.VotanteGateway;
import com.asw.persistence.Voto;
import com.asw.persistence.VotoGateway;

public class VotanteGatewayImpl implements VotanteGateway {

	private Connection con;

	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public List<Votante> findAll() throws SQLException {

		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Votante> data = new ArrayList<VotacionDTO>();

		try {
			pst = con.prepareStatement(Conf.get("FIND_ALL_VOTERS"));
			rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getLong(1) + ", " + rs.getString(2));
				data.add(new Votante(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getBoolean(4), rs.getLong(5)));
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

	@Override
	public Votante findByNif(String nif) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Votante data;

		try {
			pst = con.prepareStatement(Conf.get("FIND_VOTER_BY_NIF"));
			pst.setString(1, nif);
			rs = pst.executeQuery();
			rs.next();
			data = new Votante(rs.getString(1), rs.getString(2), rs
					.getString(3), rs.getBoolean(4), rs.getLong(5));
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
