package com.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;

public class CorsoBC {
	private Connection conn;
	private static long currval;
	
	public CorsoBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
}
