package test.com.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.AmministratoreDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.AmministratoreBC;
import com.betacom.businesscomponent.ClientFacade;
import com.betacom.businesscomponent.model.Amministratore;

class AmministratoreBCTest {
	private Connection conn;
	@Test
	void test() {
		try {
			conn = DBAccess.getConnection();
			long cod = 1;
			Amministratore admin = ClientFacade.getInstance().getAmministratoreByCod(cod);
			System.out.println(admin);
		} catch (DAOException |  ClassNotFoundException | IOException e) {
			e.printStackTrace();
			fail("Ricerca non funzionante");
		} 
	}

}
