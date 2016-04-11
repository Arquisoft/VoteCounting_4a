package com.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.asw.conf.Conf;
import com.asw.model.Opcion;
import com.asw.persistence.OpcionGateway;

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
		List<Opcion> data = new ArrayList<Opcion>();

		try {
			pst = con.prepareStatement(Conf.get("FIND_ALL_OPTIONS"));
			rs = pst.executeQuery();
			while (rs.next()) {
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
		Opcion data = null;

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

	@Override
	public Opcion findById(Long id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Opcion data = null;

		try {
			pst = con.prepareStatement(Conf.get("FIND_OPTION_BY_ID"));
			pst.setLong(1, id);
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
