package com.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.betacom.architecture.dao.CorsoDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.idgenerator.CodGenerator;
import com.betacom.businesscomponent.model.Corso;

public class CorsoBC {
	private Connection conn;
	private CodGenerator codGen;

	public CorsoBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public void createOrUpdate(Corso corso) throws ClassNotFoundException, IOException, DAOException {
		try {
			if (corso.getCod() > 0) {
				CorsoDAO.getFactory().update(conn, corso);
			} else {
				codGen = CodGenerator.getIstance();
				long cod = codGen.getNextCod("Corso");
				corso.setCod(cod);
				CorsoDAO.getFactory().create(conn, corso);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void delete(long cod) throws DAOException {
		try {
			CorsoDAO.getFactory().delete(conn, cod);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Corso getByCod(long cod) throws DAOException {
		try {
			return CorsoDAO.getFactory().getByCod(conn, cod);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Corso[] getCorsi() throws DAOException {
		Corso[] corsi = null;
		try {
			corsi = CorsoDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}

	public Corso[] getDisponibili() throws DAOException {
		Corso[] corsi = null;
		try {
			corsi = CorsoDAO.getFactory().getDisponibli(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;

	}

	public Date getDataUltimo() throws DAOException {
		return CorsoDAO.getFactory().getDataUltimo(conn);
	}

	public int getNumeroCommenti() throws DAOException {
		int n = 0;
		try {
			n = CorsoDAO.getFactory().getNumeroCommenti(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return n;
	}

	public Corso[] getCorsoPiuFreq() throws DAOException {
		Corso[] corsi;
		try {
			corsi = CorsoDAO.getFactory().getCorsoPiuFreq(conn);
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}
		return corsi;
	}

	public int mediaCorso() throws DAOException {

		int n = 0;
		try {
			n = CorsoDAO.getFactory().mediaCorsi(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return n;
	}

	
	public Corso[] getCorsiNonIniziati() throws DAOException {
		Corso[] corsi = null;
		try {
			corsi = CorsoDAO.getFactory().getCorsiNonIniziati(conn);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}

	
	
	
	
}
