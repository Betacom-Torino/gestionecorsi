package com.betacom.businesscomponent;

import java.io.IOException;
import java.util.Date;

import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.model.Amministratore;
import com.betacom.businesscomponent.model.Corsista;
import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.Docente;

public class ClientFacade {

	private static ClientFacade cF;

	private CorsoBC corsoBC;
	private CorsistaBC corsistaBC;
	private AmministratoreBC amministratoreBC;
	private CorsoCorsistaBC corsoCorsistaBC;
	private DocenteBC docenteBC;

	private ClientFacade() throws ClassNotFoundException, DAOException, IOException {

		corsoBC = new CorsoBC();
		corsistaBC = new CorsistaBC();
		amministratoreBC = new AmministratoreBC();
		corsoCorsistaBC = new CorsoCorsistaBC();
		docenteBC = new DocenteBC();
	}

	public static ClientFacade getInstance() throws ClassNotFoundException, DAOException, IOException {

		if (cF == null)
			cF = new ClientFacade();

		return cF;
	}

	public void createOrUpdateCorso(Corso corso) throws ClassNotFoundException, DAOException, IOException {
		corsoBC.createOrUpdate(corso);
	}

	public void updateCorsista(Corsista corsista) {
		corsistaBC.update(corsista);

	}

	public void createCorsista(Corsista corsista) {
		corsistaBC.create(corsista);

	}

	public void deleteCorso(long id) {
		corsoBC.delete(corso);
	}

	public void deleteCorsista(long id) {
		corsistaBC.delete(corsista);

	}

	public Docente getDocenteByCod(long cod) {

		return docenteBC.getByCod(cod);
	}

	public Docente[] getDocenti() {

		return docentiBC.getAll();
	}

	public Amministratore getAmministratoreByCod(long cod) {

		return amministratoreBC.getByCod(cod);

	}

	public Corso[] getCorsi() {

		return corsoBC.getAll();

	}

	public Corso getCorsoByCod(long cod) {

		return corsoBC.getByCod(cod);
	}

	public Corsista getCorsistaByCod(long cod) {

		return corsistaBC.getByCod(cod);
	}

	public Corsista[] getCorsisti() {

		return corsistaBC.getAll();
	}

	public int getNumeroCorsi() {
		return corsoBC.getNumero();
	}

	public Date getDataUltimoCorso() {
		return corsoBC.getDataUltimo();
	}

	public int getNumeroCommenti() {
		return corsoBC.getNumeroCommenti();
	}

}
