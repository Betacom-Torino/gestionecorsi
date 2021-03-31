package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.betacom.businesscomponent.model.Amministratore;

public class AmministratoreDAO extends GenericDAOAdapter<Amministratore> implements DAOConstants{
	
	
	public static AmministratoreDAO getFactory() {
		return new AmministratoreDAO();
	}

	private AmministratoreDAO() {
		
	}

	@Override
	public Amministratore getByCod(Connection conn, long cod) throws DAOException {
		Amministratore admin = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_AMMINISTRATORE);
			ps.setLong(1, cod);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin = new Amministratore();
				admin.setCodAdmin(rs.getLong(1));
				admin.setNomeAdmin(rs.getString(2));
				admin.setCognomeAdmin(rs.getString(3));
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return admin;
	}
	
}
