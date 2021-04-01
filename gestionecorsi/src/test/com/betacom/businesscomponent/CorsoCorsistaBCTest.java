package test.com.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.CorsoCorsistaBC;
import com.betacom.businesscomponent.model.Corsista;
import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.CorsoCorsista;

class CorsoCorsistaBCTest {

	private static Corsista corsista;
	private static Corso corso;
	private static CorsoCorsista corsocorsista;
	private static CorsoCorsistaBC corsocorsistaBC;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn=DBAccess.getConnection();
		
		corsista = new Corsista();
		corsista.setCodiceCor(1);
		corsista.setNomeCor("Nino");
		corsista.setCognomeCor("D'angelo");
		corsista.setPreFormativi(1);
		
		corso = new Corso();
		corso.setCod(1);
		corso.setCodDocente(1);
		corso.setNome("Sicurezza");
		corso.setDataInizio(new GregorianCalendar(2020, 2, 15).getTime());
		corso.setDataFine(new GregorianCalendar(2020, 2, 25).getTime());
		corso.setCosto(30);
		corso.setCommenti("Soma bin ciapà");
		corso.setAula("Aula magna");
		
		corsocorsista.setCodCorsista(1);
		corsocorsista.setCodCorso(1);
		
		corsocorsistaBC= new CorsoCorsistaBC();
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		corsista=null;
		corso=null;
		try {
			corsocorsistaBC.delete(corsista.getCodiceCor());
			conn.commit();
			System.out.println("db pulito");
		}catch (DAOException e) {
			e.printStackTrace();
			System.out.println("testDelete fallito");
		}
		
	}
	
	@Test
	void testCreate() {
		try {
			corsocorsistaBC.create(corsocorsista);
			System.out.println("corso_corsista creato");
		}catch (DAOException e) {
			e.printStackTrace();
			System.out.println("testCreate fallito");
		}
	}

	@Test
	void testCorsiByCorsista() {
		Corso[] corsi=null;
		try {
			corsi=corsocorsistaBC.corsiByCorsista(corsista.getCodiceCor());
			assertNotNull(corsi);
		}catch (DAOException e) {
			e.printStackTrace();
			System.out.println("testCorsiByCorsista fallito");
		}
	}

}
