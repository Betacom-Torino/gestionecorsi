package test.com.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.betacom.architecture.dao.CorsoCorsistaDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.Corsista;
import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.CorsoCorsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsoCorsistaDAOTest {

	private static Connection conn;
	private static Corso corso;
	private static Corso corso2;
	private static Corsista corsista;
	private static CorsoCorsista corsocorsista;
	private static CorsoCorsista corsocorsista2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		
		corso = new Corso();
		corso.setCod(100);
		corso.setCodDocente(1);
		corso.setNome("Sistemi Operativi");
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
		
		corsista = new Corsista();
		corsista.setCodiceCor(1);
		corsista.setNomeCor("Gianfranco");
		corsista.setCognomeCor("Franco");
		corsista.setPreFormativi(1);
		
		corsista = new Corsista();
		corsista.setCodiceCor(2);
		corsista.setNomeCor("Gianfranco");
		corsista.setCognomeCor("Franco");
		corsista.setPreFormativi(1);
		
		corsocorsista= new CorsoCorsista();
		corsocorsista.setCodCorsista(1);
		corsocorsista.setCodCorso(100);
		
		corsocorsista2= new CorsoCorsista();
		corsocorsista2.setCodCorsista(2);
		corsocorsista2.setCodCorso(101);
	}
	
	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsoCorsistaDAO.getFactory().create(conn, corsocorsista);
			System.out.println("Corso_corsista 1 creato");
			CorsoCorsistaDAO.getFactory().create(conn, corsocorsista2);
			System.out.println("Corso_corsista 2 creato");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Creazione corso fallita");
		}
	}
	
	@Test
	@Order(2)
	void testCorsiByCorsista() {
		Corso[] corsi=null;
		try {
			CorsoCorsistaDAO.getFactory().corsiByCorsista(conn, corsista.getCodiceCor());
			assertNotNull(corsi);
			assertEquals(2, corsi.length);
		}catch (DAOException e) {
			e.printStackTrace();
			System.out.println("testCorsiByCorsista fallito");
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		corso=null;
		corso2=null;
		corsista=null;
		try {
			CorsoCorsistaDAO.getFactory().delete(conn, 1);
			conn.commit();
			System.out.println("db pulito");
			conn.close();
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("pulizia fallita");
		}
	}

}
