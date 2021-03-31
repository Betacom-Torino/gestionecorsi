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
		docente = new Docente();
		docente.setNomeDocente("Mario");
		docente.setCognomeDocente("Rossi");
		docente.setCodDocente(1);
		docente.setCvDocente("cv.pdf");
	}

	@AfterAll
	static void tearDown() throws Exception {
		try {
			docente = null;
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Delete from docente");
			conn.commit();
			System.out.println("Tabella docente pulita");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia DB");
		}
	}

	@Test
	void testCreate() {
		try {
			DocenteDAO.getFactory().create(DBAccess.getConnection(), docente);
			System.out.println("Docente creato correttamente");
		}catch(ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			fail("Creazione docente fallita");
		}
	}
	
	@Test
	void testGetAll() {
		try {
			Docente[] docente = DocenteDAO.getFactory().getAll(conn);
			assertNotNull(docente);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero docenti non funzionante");
		}
	}
	
	/*
	@Test
	void testDocenteStat() {
		try {
			Docente[] docente = DocenteDAO.getFactory().getAll(conn);
			assertNotNull(docente);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Statistica su docenti non funzionante");
		}
	}
	*/

}
