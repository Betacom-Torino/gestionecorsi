package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

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
			rowSet.updateInt(1, entity.getCodCorsista());
			rowSet.updateInt(2, entity.getCodCorso());
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
	}

	@Override
	public CorsoCorsista getByCod(Connection conn, long cod) throws DAOException {
		return null;
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) throws DAOException {
		return null;
	}

}
