package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.betacom.businesscomponent.model.Corsista;

public class CorsistaDAO implements GenericDAO<Corsista>, DAOConstants{
private CachedRowSet rowSet;
	
	public static CorsistaDAO getFactory() throws DAOException {
		return new CorsistaDAO();
	}

	private CorsistaDAO() throws DAOException{
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void create(Connection conn, Corsista entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSISTI);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodiceCor());
			rowSet.updateString(2, entity.getNomeCor());
			rowSet.updateString(3, entity.getCognomeCor());
			rowSet.updateInt(4, entity.getPreFormativi());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Corsista entity) throws DAOException {
		PreparedStatement ps;
		try{
			ps = conn.prepareStatement(UPDATE_CORSISTA);
			ps.setString(1, entity.getNomeCor());
			ps.setString(2, entity.getCognomeCor());
			ps.setLong(3, entity.getCodiceCor());
			ps.setInt(4, entity.getPreFormativi());
			ps.execute();
			conn.commit();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	@Override
	public void delete(Connection conn, long codiceCor) throws DAOException {
		PreparedStatement ps;
		try{
			ps = conn.prepareStatement(DELETE_CORSISTA);
			ps.setLong(1, codiceCor);
			ps.execute();
			conn.commit();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	@Override
	public Corsista getByCod(Connection conn, long codiceCor) throws DAOException {
		PreparedStatement ps;
		Corsista corsista = null;
		try {
			ps = conn.prepareStatement(SELECT_CORSISTA_BY_COD);
			ps.setLong(1, codiceCor);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				corsista = new Corsista();
				corsista.setNomeCor(rs.getString(1));
				corsista.setCognomeCor(rs.getString(2));
				corsista.setCodiceCor(rs.getLong(3));
				corsista.setPreFormativi(rs.getInt(4));
			}
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return corsista;
	}

	@Override
	public Corsista[] getAll(Connection conn) throws DAOException {
		Corsista[] corsista = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTI);
			rs.last();
			corsista = new Corsista[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Corsista c = new Corsista();
				c.setCodiceCor(rs.getLong(1));
				c.setNomeCor(rs.getString(2));
				c.setCognomeCor(rs.getString(3));
				c.setPreFormativi(rs.getInt(4));
				corsista[i] = c;
			}
			rs.close();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return corsista;
	}
	
	
	public int numCorsistiTotali(Connection conn) throws DAOException {
		int n;
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(NUM_CORSISTI_TOT);
			rs.next();
			n=rs.getInt(1);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return n;
	}
	
}
