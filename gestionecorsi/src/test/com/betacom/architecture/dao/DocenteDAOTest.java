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
import com.betacom.architecture.dao.DocenteDAO;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.Corsista;
import com.betacom.businesscomponent.model.Docente;

class DocenteDAOTest {
	
	private static Connection conn;
	private static Docente docente;
	
	@BeforeAll
	static void setUp() throws Exception {
		conn = DBAccess.getConnection(); 
	}

	@AfterAll
	static void tearDown() throws Exception {

	}
	
	@Test
	void testGetAll() {
		try {
			Docente[] docenti = DocenteDAO.getFactory().getAll(conn);
			assertNotNull(docenti);
			assertEquals(10, docenti.length);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero docenti non funzionante");
		}
	}
	
	@Test
	void testGetByCod() {
		try {
			docente = DocenteDAO.getFactory().getByCod(conn, 1);
			assertNotNull(docente);
			assertEquals("Enrico", docente.getNomeDocente());
			assertEquals("Bini", docente.getCognomeDocente());
			assertEquals("cv/cv1.pdf", docente.getCvDocente());
		} catch (DAOException exc) {
			// TODO: handle exception
			exc.printStackTrace();
			fail("Test getByCod fallito");
		}
		
	}

	@Test
	void testDocenteStat() {
		try {
			Docente[] docente = DocenteDAO.getFactory().docenteStat(conn);
			assertNotNull(docente);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Statistica su docenti non funzionante");
		}
	}


}
