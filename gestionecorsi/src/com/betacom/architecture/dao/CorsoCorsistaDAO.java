package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO implements GenericDAO<CorsoCorsista>, DAOConstants{
	public static CorsoCorsistaDAO getFactory() throws DAOException {
		return new CorsoCorsistaDAO();
	}
	private CachedRowSet rowSet;
	
	private CorsoCorsistaDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	@Override
	public void create(Connection conn, CorsoCorsista entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodCorsista());
			rowSet.updateLong(2, entity.getCodCorso());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, CorsoCorsista entity) throws DAOException {
	}

	@Override
	public void delete(Connection conn, long cod) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO_CORSISTA);
			ps.setLong(1, cod);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public CorsoCorsista getByCod(Connection conn, long cod) throws DAOException {
		return null;
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) throws DAOException {
		return null;
	}
	
	
	public Corso[] corsiByCorsista(Connection conn,Long cod) throws DAOException{
		Corso[] corsi=null;
		PreparedStatement ps;
		try{
			ps=conn.prepareStatement(SELECT_CORSI_BY_CORSISTA,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ps.setLong(1,cod);
			ResultSet rs=ps.executeQuery();
			rs.last();
			corsi=new Corso[rs.getRow()];
			rs.beforeFirst();
			for(int i=0; rs.next(); i++){
				Corso c=new Corso();
				c.setCod(rs.getLong(1));
				c.setCodDocente(rs.getLong(2));
				c.setNome(rs.getString(3));
				c.setDataInizio(new java.util.Date(rs.getDate(4).getTime()));
				c.setDataFine(new java.util.Date(rs.getDate(5).getTime()));
				c.setCosto(rs.getDouble(6));
				c.setCommenti(rs.getString(7));
				c.setAula(rs.getString(8));
				corsi[i]=c;
			}
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
		return corsi;
	}
	
	
	public void deleteByCorso(Connection conn, long cod) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO_CORSISTA_BY_CORSO);
			ps.setLong(1, cod);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	

}
