package test.com.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.betacom.architecture.dao.CorsistaDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.ClientFacade;
import com.betacom.businesscomponent.model.Corsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaBCTest {
	private static Connection conn;
	private static Corsista corsista;
	
	@BeforeAll
	static void setUp() throws Exception{
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setCodiceCor(5);
		corsista.setNomeCor("Gianni");
		corsista.setCognomeCor("Franco");
		corsista.setPreFormativi(1);
	}
	
	@Test
	@Order(1)
	void testCreateOrUpdate() throws ClassNotFoundException, IOException, SQLException {
		try {
			ClientFacade.getInstance().createOrUpdateCorsista(corsista);
			CorsistaDAO.getFactory().create(conn, corsista);
			System.out.println("Corsista inserito correttamente. " + corsista.toString());
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nel inserimento del corsista");
		}
	}
	
	@Test
	@Order(4)
	void testGetByCod() throws ClassNotFoundException, IOException {
		try {
			long id = 5;
			Corsista[] corsisti = ClientFacade.getInstance().getCorsisti();
			for(Corsista c : corsisti)
				if(c.getCodiceCor() == id)
					System.out.println("Corsista ricercato: " + c.toString());
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errorre nella ricerca per codice");
		}
	}
	
	@Test
	@Order(3)
	void testSearchCorsista() throws ClassNotFoundException, IOException{
		try {
			String nome = "Gianni";
			Corsista[] corsisti = ClientFacade.getInstance().searchCorsista(nome);
			assertNotNull(corsisti);
			System.out.println("Corsista trovato");
			Corsista[] lista = CorsistaDAO.getFactory().getAll(conn);
			for(Corsista c : lista) {
				System.out.println(c.toString());
			}
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nella ricerca del corsista");
		}
	}
	
	
	@Test
	@Order(5)
	void testGetAll() throws ClassNotFoundException, IOException {
		try {
			Corsista[] corsisti = ClientFacade.getInstance().getCorsisti();
			assertNotNull(corsisti);
			System.out.println("Trovati tutti");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nel trovarli tutti");
		}
	}
	
	@Test
	@Order(2)
	void getNumCorsistiTotali() throws ClassNotFoundException, IOException {
		try {
			int n = ClientFacade.getInstance().getNumCorsistiTotali();
			assertNotNull(n);
			System.out.println("Totale Corsisti: " + n);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nel recupero del totale dei corsisti");
		}
	}
	
	@AfterAll
	static void tearDown() throws ClassNotFoundException, IOException {
		try {
			corsista = null;
			ClientFacade.getInstance().deleteCorsista(5);
			CorsistaDAO.getFactory().delete(conn, 5);
			System.out.println("Pulito il DB");
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia del DB");
		}
	}

}