package test.com.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.CorsistaDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dao.DocenteDAO;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.DocenteBC;
import com.betacom.businesscomponent.model.Corsista;
import com.betacom.businesscomponent.model.Docente;

class DocenteBCTest {
	private static Connection conn;
	private static DocenteBC docenteBc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		docenteBc = new DocenteBC();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@Test
	void testGetByCod() {
		try {
			Docente docente = docenteBc.getDocenteByCod(1);
			assertNotNull(docente);
			assertEquals("Enrico", docente.getNomeDocente());
			assertEquals("Bini", docente.getCognomeDocente());
			assertEquals("cv/cv1.pdf", docente.getCvDocente());
			System.out.println("chiamata funzionante");
		} catch (DAOException exc) {
			// TODO: handle exception
			exc.printStackTrace();
			fail("Test getByCodBC fallito");
		}
	}

	@Test
	void testGetAll() {
		try {
			Docente[] docenti = docenteBc.getDocenti();
			assertNotNull(docenti);
			assertEquals(10, docenti.length);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Recupero docenti non funzionante");
		}
	}

	@Test
	void testDocenteStat() {
		try {
			Docente[] docente = docenteBc.statDocenti();
			assertNotNull(docente);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Statistica su docenti non funzionante");
		}
	}

}
