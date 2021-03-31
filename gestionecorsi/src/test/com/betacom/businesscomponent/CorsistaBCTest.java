package test.com.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.CorsistaBC;
import com.betacom.businesscomponent.model.Corsista;

class CorsistaBCTest {
	private static Connection conn;
	private static Corsista corsista;
	private static CorsistaBC corsistaBC;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setCodiceCor(5);
		corsista.setNomeCor("Nino");
		corsista.setCognomeCor("D'angelo");
		corsista.setPreFormativi(1);
	}

	
	@Test
	void testCreateOrUpdate() {
		fail("Not yet implemented");
	}
	
	@Test
	void testSearchCorsista() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetByCod() {
		fail("Not yet implemented");
	}
	
	@Test
	void tesGetAll() {
		fail("Not yet implemented");
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try{
			corsista = null;
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Delete from corsista");
			conn.commit();
			System.out.println("Pulita la tabella corsista");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia del DB");
		}
	}

}
