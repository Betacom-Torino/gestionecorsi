package com.betacom.businesscomponent.model;

public class CorsoCorsista {
	private long codCorsista;
	private long codCorso;
	

	
	public long getCodCorsista() {
		return codCorsista;
	}



	public void setCodCorsista(long codCorsista) {
		this.codCorsista = codCorsista;
	}



	public long getCodCorso() {
		return codCorso;
	}



	public void setCodCorso(long codCorso) {
		this.codCorso = codCorso;
	}



	@Override
	public String toString() {
		return "CorsoCorsista [codCorsista=" + codCorsista + ", codCorso=" + codCorso + "]";
	}
	
}
