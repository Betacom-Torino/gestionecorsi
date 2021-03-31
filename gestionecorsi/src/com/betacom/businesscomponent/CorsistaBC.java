package com.betacom.businesscomponent;

import java.sql.Connection;

import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dao.GenericDAO;
import com.betacom.businesscomponent.model.Corsista;

public class CorsistaBC implements GenericDAO<Corsista>{

	@Override
	public void create(Connection conn, Corsista entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection conn, Corsista entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long cod) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getByCod(Connection conn, long cod) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
