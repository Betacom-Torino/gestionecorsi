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

import com.betacom.architecture.dao.CorsistaDAO;
import com.betacom.architecture.dao.CorsoCorsistaDAO;
import com.betacom.architecture.dao.CorsoDAO;
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
	private static Corsista corsista2;
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
		
		corsista2 = new Corsista();
		corsista2.setCodiceCor(2);
		corsista2.setNomeCor("Gianfranco");
		corsista2.setCognomeCor("Franco");
		corsista2.setPreFormativi(1);
		
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
			CorsoDAO.getFactory().create(conn , corso);
			CorsoDAO.getFactory().create(conn , corso2);
			CorsistaDAO.getFactory().create(conn, corsista);
			CorsistaDAO.getFactory().create(conn, corsista2);
			
			CorsoCorsistaDAO.getFactory().create(conn, corsocorsista);
			System.out.println("Corso_corsista 1 creato");
			CorsoCorsistaDAO.getFactory().create(conn, corsocorsista2);
			System.out.println("Corso_corsista 2 creato");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("test create fallita");
		}
	}
	
	@Test
	@Order(2)
	void testCorsiByCorsista() {
		Corso[] corsi=null;
		try {
		corsi=CorsoCorsistaDAO.getFactory().corsiByCorsista(conn, corsista.getCodiceCor());
			assertNotNull(corsi);
			assertEquals(1, corsi.length);
		}catch (DAOException e) {
			e.printStackTrace();
			System.out.println("testCorsiByCorsista fallito");
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		try {
			//eliminiamo dal db corsi, corsisti e corsi corsisti creati

			CorsoCorsistaDAO.getFactory().delete(conn, corsocorsista.getCodCorsista());
			CorsoCorsistaDAO.getFactory().delete(conn, corsocorsista2.getCodCorsista());
			CorsoDAO.getFactory().delete(conn , corso.getCod());
			CorsistaDAO.getFactory().delete(conn, corsista.getCodiceCor());
			CorsoDAO.getFactory().delete(conn , corso2.getCod());
			CorsistaDAO.getFactory().delete(conn, corsista2.getCodiceCor());
		
			
			System.out.println("db pulito");
			conn.close();
			
			corso=null;
			corso2=null;
			corsista=null;
			corsista2=null;
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("pulizia db fallita");
		}
	}

}
