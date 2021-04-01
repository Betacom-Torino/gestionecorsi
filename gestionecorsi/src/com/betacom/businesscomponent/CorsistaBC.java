package com.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.betacom.architecture.dao.CorsistaDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.idgenerator.CodGenerator;
import com.betacom.businesscomponent.model.Corsista;

public class CorsistaBC {
	private Connection conn;
	private CodGenerator idGen;

	public CorsistaBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public void createOrUpdate(Corsista corsista) throws DAOException, ClassNotFoundException, IOException {
		idGen = CodGenerator.getIstance();
		try {
			if(corsista.getCodiceCor() > 0) {
				CorsistaDAO.getFactory().update(conn, corsista);
			}else {
				System.out.println("creazione");
				corsista.setCodiceCor(idGen.getNextCod("corsista"));
				CorsistaDAO.getFactory().create(conn, corsista);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Corsista[] searchCorsista(String query) throws DAOException {
		Corsista[] corsisti = null;
		try {
			corsisti = CorsistaDAO.getFactory().searchCorsista(query, conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsisti;
	}

	public Corsista getByCod(long cod) throws DAOException {
		Corsista corsista = null;
		try {
			corsista = CorsistaDAO.getFactory().getByCod(conn, cod);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsista;
	}

	public Corsista[] getCorsisti() throws DAOException {
		Corsista[] corsisti = null;
		try {
			corsisti = CorsistaDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsisti;
	}

	public void delete(long id) throws DAOException {
		try {
			CorsistaDAO.getFactory().delete(conn, id);
			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public int getNumCorsistiTotali() throws DAOException {
		int n;
		try {
			n = CorsistaDAO.getFactory().getNumCorsistiTotali(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return n;
	}

}