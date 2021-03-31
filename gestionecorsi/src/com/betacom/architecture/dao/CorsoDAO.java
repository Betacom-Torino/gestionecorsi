package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.betacom.businesscomponent.model.Corso;

public class CorsoDAO implements GenericDAO<Corso>, DAOConstants{
	private CachedRowSet rowSet;
	
	public static CorsoDAO getFactory() throws DAOException {
		return new CorsoDAO();
	}

	private CorsoDAO() throws DAOException{
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void create(Connection conn, Corso entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSI);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCod());
			rowSet.updateString(2, entity.getNome());
			rowSet.updateDate(3, new java.sql.Date(entity.getDataInizio().getTime()));
			rowSet.updateDate(4, new java.sql.Date(entity.getDataFine().getTime()));
			rowSet.updateDouble(5, entity.getCosto());
			rowSet.updateString(6, entity.getCommenti());
			rowSet.updateString(7, entity.getAula());

			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	
	public void update(Connection conn, Corso entity) throws DAOException {
		PreparedStatement ps;
		try{
			ps = conn.prepareStatement(UPDATE_CORSO);
			ps.setString(1, entity.getNome());
			ps.setDate(2, new java.sql.Date(entity.getDataInizio().getTime()));
			ps.setDate(3, new java.sql.Date(entity.getDataFine().getTime()));
			ps.setDouble(4, entity.getCosto());
			ps.setString(5, entity.getCommenti());
			ps.setString(6, entity.getAula());
			ps.setLong(7, entity.getCod());

			ps.execute();
			conn.commit();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void delete(Connection conn, long idCorso) throws DAOException {
		PreparedStatement ps;
		try{
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, idCorso);
			ps.execute();
			conn.commit();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Corso getByCod(Connection conn, long cod) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corso[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
