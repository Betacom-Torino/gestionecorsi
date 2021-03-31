package com.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dao.DocenteDAO;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.Docente;

public class DocenteBC {
	private Connection conn;
	
	public DocenteBC() throws DAOException, ClassNotFoundException, IOException{
		conn = DBAccess.getConnection();
	}
	
	public Docente getDocenteByCod(long cod) throws DAOException{
		try {
			return DocenteDAO.getFactory().getByCod(conn, cod);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Docente[] getDocenti() throws DAOException {
		Docente[] docente = null;
		try {
			docente = DocenteDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return docente;
	}
	
	public Docente[] statDocenti() throws DAOException{
		Docente[] docente = null;
		try {
			docente = DocenteDAO.getFactory().docenteStat(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return docente;
	}

}
