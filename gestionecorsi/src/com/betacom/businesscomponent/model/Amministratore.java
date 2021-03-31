package com.betacom.businesscomponent.model;

public class Amministratore {
	private String nomeAdmin;
	private String cognomeAdmin;
	private long codAdmin;

	public String getNomeAdmin() {
		return nomeAdmin;
	}

	public void setNomeAdmin(String nomeAdmin) {
		this.nomeAdmin = nomeAdmin;
	}

	public String getCognomeAdmin() {
		return cognomeAdmin;
	}

	public void setCognomeAdmin(String cognomeAdmin) {
		this.cognomeAdmin = cognomeAdmin;
	}

	public long getCodAdmin() {
		return codAdmin;
	}

	public void setCodAdmin(long codAdmin) {
		this.codAdmin = codAdmin;
	}

	@Override
	public String toString() {
		return "Amministratore [nomeAdmin=" + nomeAdmin + ", cognomeAdmin=" + cognomeAdmin + ", codAdmin=" + codAdmin
				+ "]";
	}

}
