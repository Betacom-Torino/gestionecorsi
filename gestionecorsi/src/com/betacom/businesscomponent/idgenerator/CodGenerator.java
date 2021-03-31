package com.betacom.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.betacom.architecture.dao.DAOConstants;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;

import java.sql.PreparedStatement;

public class CodGenerator implements DAOConstants {

	
//Id corsista and id corso generator 

		private static CodGenerator istanza;
		private Connection conn;
		private Statement stmt;
		private ResultSet rs;

		private CodGenerator() throws ClassNotFoundException, DAOException, IOException {
			conn = DBAccess.getConnection();
		}

		public static CodGenerator getIstance() throws ClassNotFoundException, DAOException, IOException {
			if (istanza == null) {
				istanza = new CodGenerator();
			}
			return istanza;

		}

		public long getNextCod(String tipo) throws ClassNotFoundException, DAOException, IOException {
			long cod = 0;
			String query = null;
			tipo= tipo.toLowerCase();
			if(tipo.equals("corso"))
				query= SELECT_CORSOSEQ;
			else if(tipo.equals("corsista"))
				query=SELECT_CORSISTASEQ;
	    try {
	    	rs = stmt.executeQuery(query);
			rs.next();
			cod = rs.getLong(1);
			} catch (SQLException sql) {
				throw new DAOException(sql);
			}
			return cod;
		}

	}

