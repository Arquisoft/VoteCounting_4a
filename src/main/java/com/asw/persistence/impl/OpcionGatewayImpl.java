package com.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.asw.conf.Conf;
import com.asw.model.VotacionDTO;
import com.asw.persistence.Opcion;
import com.asw.persistence.OpcionGateway;
import com.asw.persistence.VotacionGateway;
import com.asw.persistence.Voto;
import com.asw.persistence.VotoGateway;

public class OpcionGatewayImpl implements OpcionGateway {

	private Connection con;

	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public List<Opcion> findAll() throws SQLException {

		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Opcion> data = new ArrayList<VotacionDTO>();

		try {
			pst = con.prepareStatement(Conf.get("FIND_ALL_OPTIONS"));
			rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getLong(1) + ", " + rs.getString(2));
				data.add(new Opcion(rs.getLong(1), rs.getString(2), rs
						.getLong(3)));
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
	public Opcion findByName(String name) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Opcion data;

		try {
			pst = con.prepareStatement(Conf.get("FIND_OPTION_BY_NAME"));
			pst.setString(1, name);
			rs = pst.executeQuery();
			rs.next();
			data = new Opcion(rs.getLong(1), rs.getString(2), rs.getLong(3));
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
