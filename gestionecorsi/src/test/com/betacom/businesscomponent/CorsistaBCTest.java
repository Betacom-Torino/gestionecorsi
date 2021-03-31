package test.com.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.CorsistaDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.idgenerator.CodGenerator;
import com.betacom.businesscomponent.model.Corsista;

class CorsistaBCTest {
	private static Connection conn;
	private static Corsista corsista;

	
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
	void testCreateOrUpdate() throws ClassNotFoundException, DAOException, IOException, SQLException {
		try {
			if(corsista.getCodiceCor() < CodGenerator.getIstance().getNextCod("corsista"))
				CorsistaDAO.getFactory().update(conn, corsista);
			else
				CorsistaDAO.getFactory().create(conn, corsista);
			conn.commit();
			System.out.println("Corsista inserito correttamente");
		}catch (DAOException exc) {
			exc.printStackTrace();
			fail("Errore nel inserimento del corsista");
		}
	}
	
	@Test
	void testSearchCorsista() {
		try {
			String nome = "Nino";
			Corsista[] corsisti = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsisti);
			for(Corsista c: corsisti)
				if(c.getNomeCor().toLowerCase().equals(nome.toLowerCase()) | c.getCognomeCor().toLowerCase().equals(nome.toLowerCase()))
					System.out.println(c.toString());
		}catch(DAOException exc){
			exc.printStackTrace();
			fail("Errore nella ricerca del Corsista");
		}
	}
	
	@Test
	void testGetByCod() {
		try {
			long id = 5;
			Corsista[] corsisti = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsisti);
			for(Corsista c : corsisti)
				if(c.getCodiceCor() == id)
					System.out.println("Corsista cercato:\n" + c.toString());
		}catch(DAOException exc) {
			exc.printStackTrace();
		}
	}
	
	@Test
	void tesGetAll() {
		try {
			Corsista[] corsisti = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsisti);
		}catch(DAOException dao) {
			dao.printStackTrace();
			fail("Recupero dati fallito");
		}
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
