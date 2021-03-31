package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.betacom.businesscomponent.model.Docente;

public class DocenteDAO implements GenericDAO<Docente>, DAOConstants {
	private CachedRowSet rowSet;

	public static DocenteDAO getFactory() throws DAOException {
		return new DocenteDAO();
	}

	private DocenteDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Docente getByCod(Connection conn, long cod) throws DAOException {
		PreparedStatement ps;
		Docente docente = null;
		try {
			ps = conn.prepareStatement(SELECT_DOCENTE_BY_COD);
			ps.setLong(1, cod);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				docente = new Docente();
				docente.setCodDocente(rs.getLong(1));
				docente.setNomeDocente(rs.getString(2));
				docente.setCognomeDocente(rs.getString(3));
				docente.setCvDocente(rs.getString(4));
			}

		} catch (SQLException sql) {
			// TODO: handle exception
			throw new DAOException(sql);
		}
		return docente;
	}

	@Override
	public Docente[] getAll(Connection conn) throws DAOException {
		Docente[] docente = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_DOCENTI);
			rs.last();
			docente = new Docente[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Docente a = new Docente();
				a.setCodDocente(rs.getLong(1));
				a.setNomeDocente(rs.getString(2));
				a.setCognomeDocente(rs.getString(3));
				a.setCvDocente(rs.getString(4));
				docente[i] = a;
			}
			rs.close();
		} catch (SQLException sql) {
			// TODO: handle exception
			throw new DAOException(sql);
		}
		return docente;
	}

	public void create(Connection conn, Docente entity) throws DAOException {

	}

	public void delete(Connection conn, long cod) throws DAOException {

	}

	public void update(Connection conn, Docente entity) throws DAOException {

	}

	public Docente[] DocenteStat(Connection conn) throws DAOException {
		Docente[] docente = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(DOC_PIU_CORSI);
			rs.last();
			docente = new Docente[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Docente a = new Docente();
				a.setCodDocente(rs.getLong(1));
				a.setNomeDocente(rs.getString(2));
				a.setCognomeDocente(rs.getString(3));
				a.setCvDocente(rs.getString(4));
				docente[i] = a;
			}
			rs.close();
		} catch (SQLException sql) {
			// TODO: handle exception
			throw new DAOException(sql);
		}
		return docente;
	}
}
