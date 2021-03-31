package test.com.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.CorsistaDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.Corsista;

class CorsistaDAOTest {
	private static Connection conn;
	private static Corsista corsista;
	
	@BeforeAll
	static void setUp() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setNomeCor("Gianfranco");
		corsista.setCognomeCor("Franco");
		corsista.setCodiceCor(1);
		corsista.setPreFormativi(1);
	}

	@AfterAll
	static void tearDown() throws Exception {
		try {
			corsista = null;
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Delete from corsista");
			conn.commit();
			System.out.println("Pulita la tabella corsista");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia DB");
		}
	}

	@Test
	void testCreate() {
		try {
			CorsistaDAO.getFactory().create(DBAccess.getConnection(), corsista);
			System.out.println("Corsista creato");
		}catch(ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			fail("Creazione ordine fallita");
		}
	}
	
	@Test
	void testGetAll() {
		try {
			Corsista[] corsisti = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsisti);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero corsisti fallito");
		}
	}

}
