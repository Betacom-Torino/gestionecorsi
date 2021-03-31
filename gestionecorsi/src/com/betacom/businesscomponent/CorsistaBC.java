package com.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.betacom.architecture.dao.CorsistaDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.idgenerator.CodGenerator;
import com.betacom.businesscomponent.model.Corsista;


public class CorsistaBC {
	private Connection conn;
	private CodGenerator idGen;
	
	public CorsistaBC() throws DAOException, ClassNotFoundException, IOException{
		conn = DBAccess.getConnection();
	}
	
	public void createOrUpdate(Corsista corsista) throws DAOException, ClassNotFoundException, IOException{
		idGen = CodGenerator.getIstance();
		try {
			if(corsista.getCodiceCor() > 0) {
				CorsistaDAO.getFactory().update(conn, corsista);
			}else {
				corsista.setCodiceCor(idGen.getNextCod("corsista"));
				CorsistaDAO.getFactory().create(conn, corsista);
			}
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Corsista[] searchCorsista(int query) throws DAOException {
		List<Corsista> lista = new ArrayList<Corsista>(50);
		int criterioRicerca = query;
		
		for(Corsista c : getCorsisti())
			if(c.getCodiceCor() == criterioRicerca)
				lista.add(c);
		Corsista[] corsisti = (Corsista[]) lista.toArray();
		return corsisti;
	} 
	
	public Corsista getByCod(long id) {
		try {
			return CorsistaDAO.getFactory().getByCod(conn, id);
		}catch(SQLException sql) {
			sql.printStackTrace();
			return null;
		}
	}
	
	
	public Corsista[] getCorsisti() throws DAOException{
		Corsista[] corsisti = null;
		try {
			corsisti = CorsistaDAO.getFactory().getAll(conn);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return corsisti;
	}
	
	public void delete(long id) throws DAOException{
		try {
			CorsistaDAO.getFactory().delete(conn, id);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
