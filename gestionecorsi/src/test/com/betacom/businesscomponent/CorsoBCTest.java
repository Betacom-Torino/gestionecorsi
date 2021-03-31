package test.com.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dao.DocenteDAO;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.CorsoBC;
import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.Docente;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class CorsoBCTest {

	private static Connection conn;
	private static Corso corso, corso2;
	private static CorsoBC corsoBC;
	private static Docente docente;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		docente = DocenteDAO.getFactory().getByCod(conn, 1);
		conn.close();
		
		corso = new Corso();
		corso.setCod(0);
		corso.setCodDocente(1);
		corso.setNome("Sistemi Operativi");
		corso.setDataInizio(new GregorianCalendar(2020, 4, 15).getTime());
		corso.setDataFine(new GregorianCalendar(2020, 4, 20).getTime());
		corso.setCosto(300);
		corso.setCommenti("nessun commento");
		corso.setAula("Aula magna");
		
		corso2 = new Corso();
		corso2.setCod(1);
		corso2.setCodDocente(1);
		corso2.setNome("Sicurezza");
		corso2.setDataInizio(new GregorianCalendar(2020, 2, 15).getTime());
		corso2.setDataFine(new GregorianCalendar(2020, 2, 25).getTime());
		corso2.setCosto(30);
		corso2.setCommenti("Soma bin ciapà");
		corso2.setAula("Aula magna");
		
		corsoBC = new CorsoBC();
	}

	@BeforeEach
	void setUp() throws Exception {
		conn = DBAccess.getConnection();
	}

	@Test
	@Order(1)
	void testCreateOrUpdate1() {
		try {
			corsoBC.createOrUpdate(corso);
			System.out.println("Corso creato");
		} catch (ClassNotFoundException | DAOException | IOException e) {
			e.printStackTrace();
			System.out.println("testCreateOrUpdate1 fallita");
		}
	}

	@Test
	@Order(2)
	void testGetByCod() {
		try {
			Corso corso = corsoBC.getByCod(1);
			assertNotNull(corso);
			assertEquals("Sistemi Operativi", corso.getNome());
			assertEquals(300, corso.getCosto());
			assertEquals("nessun commento", corso.getCommenti());

		} catch (DAOException e) {
			e.printStackTrace();
			System.out.println("testGetByCod fallita");
		}
	}
	
	
	@Test
	@Order(3)
	void testCreateOrUpdate2() {
		try {
			corsoBC.createOrUpdate(corso2);
			System.out.println("Corso modificato");
		} catch (ClassNotFoundException | DAOException | IOException e) {
			e.printStackTrace();
			System.out.println("testCreateOrUpdate2 fallita");
		}
	}

	@Test
	@Order(3)
	void testGetCorsi() {
		try {
			Corso[] corsi = corsoBC.getCorsi();
			assertNotNull(corsi);
			assertEquals(1, corsi.length);
		} catch (DAOException e) {
			e.printStackTrace();
			System.out.println("TestGetCorsi ");
		}		
	}
	
	@Test
	@Order(4)
	void testDelete() {
		try {
			corsoBC.delete(1);
			System.out.println("Corso eliminato");
		} catch (DAOException e) {
			e.printStackTrace();
			System.out.println("TestDelete fallito ");
		}		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		if(conn!=null) {
			conn.close();
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		docente = null;
		corso = null;
		corsoBC = null;
	}
	
}
