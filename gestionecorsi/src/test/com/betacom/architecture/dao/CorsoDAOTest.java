package test.com.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.betacom.architecture.dao.CorsoDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dao.DocenteDAO;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.Docente;

@TestMethodOrder(OrderAnnotation.class)
class CorsoDAOTest {
	private static Connection conn;
	private static Corso corso;
	private static Docente docente;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		
		docente = new Docente();
		docente = DocenteDAO.getFactory().getByCod(conn, 1);
		
		corso = new Corso();
		corso.setCod(100);
		corso.setCodDocente(1);
		corso.setNome("Lavaggi con ammorbidente");
		corso.setDataInizio(new GregorianCalendar(2020, 4, 15).getTime());
		corso.setDataFine(new GregorianCalendar(2000, 4, 20).getTime());
		corso.setCosto(30);
		corso.setCommenti("nessun commento");
		corso.setAula("Aula magna");
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsoDAO.getFactory().create(conn, corso);
			System.out.println("Corso creato");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Creazione corso fallita");
		}
	}
//	
//	@Test
//	@Order(2)
//	void testDelete() {
//		try {
//			CorsoDAO.getFactory().delete(conn, 100);
//			System.out.println("Corso eliminato");
//		}catch(DAOException exc) {
//			exc.printStackTrace();
//			fail("Eliminazione corso fallita");
//		}
//	}
	
	@AfterEach
	void tearDown() throws Exception {
		
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		docente=null;
		corso=null;
	}
	
}
