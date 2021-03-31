package com.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.betacom.architecture.dao.CorsoDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.idgenerator.IdGenerator;
import com.betacom.businesscomponent.model.Corso;

public class CorsoBC {
	private Connection conn;
	private IdGenerator idGen;

	public CorsoBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public void createOrUpdate(Corso corso) throws ClassNotFoundException, IOException, DAOException {
		try {
			if (corso.getCod() > 0) {
				CorsoDAO.getFactory().update(conn, corso);
			} else {
				// settare l'id del corso con l'idGenerator prima di crearlo
				CorsoDAO.getFactory().create(conn, corso);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

}
