package com.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.betacom.architecture.dao.AmministratoreDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.Amministratore;

public class AmministratoreBC {
	private Connection conn;
	
	public AmministratoreBC() throws DAOException, ClassNotFoundException, IOException {
		conn=DBAccess.getConnection();
	}
	
	public Amministratore getById(long cod) throws DAOException {
		try {
			return AmministratoreDAO.getFactory().getByCod(conn, cod);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}