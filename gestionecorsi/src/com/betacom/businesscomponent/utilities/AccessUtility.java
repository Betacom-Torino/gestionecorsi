package com.betacom.businesscomponent.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.betacom.architecture.dao.DAOConstants;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;

public class AccessUtility implements DAOConstants {
	private Connection conn;

	public AccessUtility() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public String getUserPass(String username) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ADMINCOD);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			return null;
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}