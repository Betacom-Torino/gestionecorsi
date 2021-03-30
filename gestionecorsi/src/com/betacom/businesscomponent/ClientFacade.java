package com.betacom.businesscomponent;

import java.io.IOException;

import com.betacom.architecture.dao.DAOException;

public class ClientFacade {

	private static ClientFacade cF;

	private CorsoBC corsoBC;
	private CorsistaBC corsistaBC;
	private AmministratoreBC amministratoreBC;
	private CorsoCorsistaBC corsoCorsistaBC;
	private DocenteBC docenteBC;

	private ClientFacade() throws ClassNotFoundException, DAOException, IOException {

	}

	public static ClientFacade getInstance() throws ClassNotFoundException, DAOException, IOException {

		if (cF == null)
			cF = new ClientFacade();

		return cF;
	}

}
