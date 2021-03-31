package com.betacom.businesscomponent;

import java.io.IOException;
import java.sql.SQLException;
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

	public void createOrUpdateCorsista(Corsista corsista) throws DAOException, ClassNotFoundException, IOException {
		corsistaBC.createOrUpdate(corsista);

	}

	public void deleteCorso(long cod) throws DAOException {
		corsoBC.delete(cod);
	}

	public void deleteCorsista(long cod) throws DAOException {
		corsistaBC.delete(cod);

	}

	public Docente getDocenteByCod(long cod) throws DAOException {

		return docenteBC.getDocenteByCod(cod);
	}

	public Docente[] getDocenti() throws DAOException {

		return docenteBC.getDocenti();
	}

	public Amministratore getAmministratoreByCod(long cod) throws DAOException {

		return amministratoreBC.getByCod(cod);

	}

	public Corso[] getCorsi() throws DAOException {

		return corsoBC.getCorsi();

	}

	public Corso getCorsoByCod(long cod) throws DAOException {

		return corsoBC.getByCod(cod);
	}

	public Corsista getCorsistaByCod(long cod) {

		return corsistaBC.getByCod(cod);
	}

	public Corsista[] getCorsisti() throws DAOException {

		return corsistaBC.getCorsisti();
	}

	public Date getDataUltimoCorso() {
		return corsoBC.getDataUltimo();
	}

	public int getNumeroCommenti() {
		return corsoBC.getNumeroCommenti();
	}
	
	
	public int getNumCorsistiTotali() throws DAOException {
		return corsistaBC.getNumCorsistiTotali();
	}
	
}
