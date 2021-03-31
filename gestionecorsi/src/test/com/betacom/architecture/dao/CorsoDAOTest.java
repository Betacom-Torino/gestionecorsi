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
	private static Corso corso2;
	private static Corso newCorso;
	private static Docente docente;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		docente = new Docente();
		docente = DocenteDAO.getFactory().getByCod(conn, 1);
		conn.close();
		
		corso = new Corso();
		corso.setCod(100);
		corso.setCodDocente(1);
		corso.setNome("Sistem Operativi");
		corso.setDataInizio(new GregorianCalendar(2000, 4, 15).getTime());
		corso.setDataFine(new GregorianCalendar(2000, 4, 20).getTime());
		corso.setCosto(30);
		corso.setCommenti("nessun commento");
		corso.setAula("Aula magna");
		
		corso2 = new Corso();
		corso2.setCod(101);
		corso2.setCodDocente(2);
		corso2.setNome("Sicurezza");
		corso2.setDataInizio(new GregorianCalendar(2020, 2, 15).getTime());
		corso2.setDataFine(new GregorianCalendar(2020, 2, 25).getTime());
		corso2.setCosto(30);
		corso2.setCommenti("Soma bin ciapà");
		corso2.setAula("Aula magna");
		
		newCorso = new Corso();
		newCorso.setCod(100);
		newCorso.setNome("Algoritmi");
		newCorso.setDataInizio(new GregorianCalendar(2000, 5, 15).getTime());
		newCorso.setDataFine(new GregorianCalendar(2000, 5, 25).getTime());
		newCorso.setCosto(50);
		newCorso.setCommenti("anche qui nessun commento");
		newCorso.setAula("Aula magna");
	}

	@BeforeEach
	void setUp() throws Exception {
		conn = DBAccess.getConnection();
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsoDAO.getFactory().create(conn, corso);
			System.out.println("Corso1 creato");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Creazione corso fallita");
		}
	}
	
	@Test
	@Order(2)
	void testGetByCod() {
		try {
			Corso c = CorsoDAO.getFactory().getByCod(conn, 100);
			assertNotNull(c);
			assertEquals("Sistem Operativi", c.getNome());
			assertEquals(30, c.getCosto());
			assertEquals("Aula magna", c.getAula());
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("GetByCod corso fallita");
		}
	}
	
	@Test
	@Order(3)
	void testGetAll() {
		try {
			CorsoDAO.getFactory().create(conn, corso2);
			System.out.println("Corso2 creato");
			Corso[] corsi = CorsoDAO.getFactory().getAll(conn);
			assertNotNull(corsi);
			assertEquals(2, corsi.length);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("GetAll corsi fallita");
		}
	}
	
	@Test
	@Order(4)
	void testUpdate() {
		try {
			CorsoDAO.getFactory().update(conn, newCorso);
			System.out.println("Corso modificato");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Modifica corso fallita");
		}
	}
	
	@Test
	@Order(5)
	void testDelete() {
		try {
			CorsoDAO.getFactory().delete(conn, 100);
			System.out.println("Corso1 eliminato");
			CorsoDAO.getFactory().delete(conn, 101);
			System.out.println("Corso2 eliminato");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Eliminazione corso fallita");
		}
	}
	
	@AfterEach
	void tearDown() throws Exception {
		if(conn!=null)
			conn.close();
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		docente=null;
		corso=null;
		corso2=null;
		newCorso=null;
	}
	
}
