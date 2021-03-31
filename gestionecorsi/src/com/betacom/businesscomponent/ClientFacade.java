package com.betacom.businesscomponent;

import java.io.IOException;

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

	public Docente getDocenteByCod(long id) {

		Docente docente = null;

		return docente;
	}

	public Docente[] getDocenti() {

		Docente[] docenti = null;

		return docenti;
	}

	public Amministratore getAmministratoreByCod(long id) {

		Amministratore amministratore = null;

		return amministratore;

	}

	public Corso[] getCorsi() {

		Corso[] corsi = null;

		return corsi;

	}

	public Corso getCorsoByCod(long id) {

		Corso corso = null;

		return corso;
	}

	public Corsista getCorsistaByCod(long id) {

		Corsista corsista = null;

		return corsista;
	}

	public Corsista[] getCorsisti() {

		Corsista[] corsisti = null;

		return corsisti;
	}

}
