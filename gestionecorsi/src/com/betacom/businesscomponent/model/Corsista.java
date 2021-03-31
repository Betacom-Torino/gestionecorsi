package com.betacom.businesscomponent.model;

public class Corsista {
	private String nomeCor;
	private String cognomeCor;
	private long codiceCor;
	private int preFormativi;
	
	public String getNomeCor() {
		return nomeCor;
	}
	
	public void setNomeCor(String nomeCor) {
		this.nomeCor = nomeCor;
	}
	
	public String getCognomeCor() {
		return cognomeCor;
	}
	
	public void setCognomeCor(String cognomeCor) {
		this.cognomeCor = cognomeCor;
	}
	
	public long getCodiceCor() {
		return codiceCor;
	}
	
	public void setCodiceCor(long codiceCor) {
		this.codiceCor = codiceCor;
	}
	
	public int getPreFormativi() {
		return preFormativi;
	}
	
	public void setPreFormativi(int preFormativi) {
		this.preFormativi = preFormativi;
	}

	@Override
	public String toString() {
		if(getPreFormativi() == 1)
			return "Nome corsista: " + nomeCor + "\tCognome corsista: " + cognomeCor + "\tId: " + codiceCor + "\tPrecedenti formativi: SI";
		return "Nome corsista: " + nomeCor + "\tCognome corsista: " + cognomeCor + "\tId: " + codiceCor + "\tPrecedenti formativi: NO";
	}
	
	
}