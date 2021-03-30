package com.lupo.architecture.dao;

import java.sql.SQLException;

public class DAOException extends SQLException {
	private static final long serialVersionUID = -980352319191541863L;
	private final static int ORA1017 = 1017;
	private final static int ORA17002 = 17002;
	private final static int ORA00001 = 0;

	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	public DAOException(SQLException sql) {
		String chiave = "";
		if (sql != null) {
			switch (sql.getErrorCode()) {
			case ORA1017:
				chiave = "Nome utente o password errati";
				log(sql);
				break;
			case ORA17002:
				chiave = "IO exception di Oracle DB. Impossibile stailire la connessione";
				log(sql);
				break;
			case ORA00001:
				chiave = "Vincolo della tabelòla violato";
				log(sql);
				break;
			default:
				chiave = "Eccezione SQL non prevista";
				log(sql);
			}
		}
		message = chiave;
	}

	private void log(SQLException sql) {
		sql.printStackTrace();
		System.err.println("Motivo: " + sql.getMessage());
		System.err.println("Codice errore: " + sql.getErrorCode());
		System.err.println("Stato app: " + sql.getSQLState());
		System.err.println("Causa: " + sql.getCause());
	}

}
