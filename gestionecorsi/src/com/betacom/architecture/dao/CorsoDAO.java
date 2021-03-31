package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.betacom.businesscomponent.model.Corso;

public class CorsoDAO implements GenericDAO<Corso>, DAOConstants {
	private CachedRowSet rowSet;

	public static CorsoDAO getFactory() throws DAOException {
		return new CorsoDAO();
	}

	private CorsoDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void create(Connection conn, Corso entity) throws DAOException {

		try {
			rowSet.setCommand(SELECT_CORSI);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCod());
			rowSet.updateLong(2, entity.getCodDocente());
			rowSet.updateString(3, entity.getNome());
			rowSet.updateDate(4, new java.sql.Date(entity.getDataInizio().getTime()));
			rowSet.updateDate(5, new java.sql.Date(entity.getDataFine().getTime()));
			rowSet.updateDouble(6, entity.getCosto());
			rowSet.updateString(7, entity.getCommenti());
			rowSet.updateString(8, entity.getAula());

			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Corso entity) throws DAOException {
		PreparedStatement ps;
		try {
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
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void delete(Connection conn, long idCorso) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, idCorso);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Corso getByCod(Connection conn, long cod) throws DAOException {
		PreparedStatement ps;
		Corso corso = null;
		try {
			ps = conn.prepareStatement(SELECT_CORSI_BY_COD);
			ps.setLong(1, cod);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				corso = new Corso();
				corso.setCod(cod);
				corso.setCodDocente(rs.getLong(2));
				corso.setNome(rs.getString(3));
				corso.setDataInizio(new java.util.Date(rs.getDate(4).getTime()));
				corso.setDataFine(new java.util.Date(rs.getDate(5).getTime()));
				corso.setCosto(rs.getDouble(6));
				corso.setCommenti(rs.getString(7));
				corso.setAula(rs.getString(8));

			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corso;
	}

	@Override
	public Corso[] getAll(Connection conn) throws DAOException {
		Corso[] corsi = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSI);
			rs.last();
			corsi = new Corso[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Corso corso = new Corso();
				corso = new Corso();
				corso.setCod(rs.getLong(1));
				corso.setCodDocente(rs.getLong(2));
				corso.setNome(rs.getString(3));
				corso.setDataInizio(new java.util.Date(rs.getDate(4).getTime()));
				corso.setDataFine(new java.util.Date(rs.getDate(5).getTime()));
				corso.setCosto(rs.getDouble(6));
				corso.setCommenti(rs.getString(7));
				corso.setAula(rs.getString(8));
				corsi[i] = corso;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}

	public Corso[] getDisponibli(Connection conn) throws DAOException {
		Corso[] corsi = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(CORSI_ISCRITTI);
			rs.last();
			corsi = new Corso[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Corso corso = new Corso();
				corso = new Corso();
				corso.setCod(rs.getLong(1));
				corso.setCodDocente(rs.getLong(2));
				corso.setNome(rs.getString(3));
				corso.setDataInizio(new java.util.Date(rs.getDate(4).getTime()));
				corso.setDataFine(new java.util.Date(rs.getDate(5).getTime()));
				corso.setCosto(rs.getDouble(6));
				corso.setCommenti(rs.getString(7));
				corso.setAula(rs.getString(8));
				corsi[i] = corso;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}

	public int getNumeroCommenti(Connection conn) throws DAOException {
		PreparedStatement ps;
		int n = 0;
		try {
			ps = conn.prepareStatement(NUM_COMMENTI);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return n;
	}

	public Date getDataUltimo(Connection conn) throws DAOException {
		Date data = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(DATA_INIZIO_ULTIMO_CORSO);
			if (rs.next()) {
				data = new java.util.Date(rs.getDate(1).getTime());
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return data;
	}
	
	public String getCorsoPiuFreq(Connection conn) throws DAOException, SQLException{
		PreparedStatement ps;
				String nome = null;
				int max = 0;
				try {
					ps = conn.prepareStatement(NOME_CORSO_PIU_FREQ);
					ResultSet rs = ps.executeQuery();
					rs.first();
					nome = rs.getString(1);
					max = rs.getInt(2);
					if(rs.next()) 
						if(max < rs.getInt(2)) {
							nome = rs.getString(1);
							max = rs.getInt(2);
						}
				}catch(SQLException exc) {
					throw new DAOException(exc);
				}
				return nome;
	}

}
