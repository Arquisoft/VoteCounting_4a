package com.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.asw.conf.Conf;
import com.asw.model.ColegioElectoral;
import com.asw.persistence.ColegioElectoralGateway;

public class ColegioElectoralGatewayImpl implements ColegioElectoralGateway {

	private Connection con;

	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public List<ColegioElectoral> findAll() throws SQLException {

		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ColegioElectoral> data = new ArrayList<ColegioElectoral>();

		try {
			pst = con.prepareStatement(Conf.get("FIND_ALL_CE"));
			rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getLong(1) + ", " + rs.getString(2));
				data.add(new ColegioElectoral(rs.getLong(1), rs.getLong(2), rs
						.getString(3)));
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
	public ColegioElectoral findByIdent(long id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ColegioElectoral data = null;

		try {
			pst = con.prepareStatement(Conf.get("FIND_CE_BY_ID"));
			pst.setLong(1, id);
			rs = pst.executeQuery();
			rs.next();
			data = new ColegioElectoral(rs.getLong(1),
					rs.getLong(2), rs.getString(3));
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
