package com.betacom.businesscomponent.model;

public class CorsoCorsista {
	private int codCorsista;
	private int codCorso;
	
	public int getCodCorsista() {
		return codCorsista;
	}
	public void setCodCorsista(int codCorsista) {
		this.codCorsista = codCorsista;
	}
	public int getCodCorso() {
		return codCorso;
	}
	public void setCodCorso(int codCorso) {
		this.codCorso = codCorso;
	}
	
	@Override
	public String toString() {
		return "CorsoCorsista [codCorsista=" + codCorsista + ", codOrdine=" + codCorso + "]";
	}
}
