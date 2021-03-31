package com.betacom.architecture.dao;

import java.sql.Connection;

public interface GenericDAO<T> {

	
	void create(Connection conn,T entity) throws DAOException;      //Create
	void update(Connection conn, T entity) throws DAOException;     //Update
	void delete(Connection conn, long cod) throws DAOException;      //delete

	T getByCod(Connection conn, long cod) throws DAOException;        //read
	T[] getAll(Connection conn) throws DAOException;				//read
	
}

