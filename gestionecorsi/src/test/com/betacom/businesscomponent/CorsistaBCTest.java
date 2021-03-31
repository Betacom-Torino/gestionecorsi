package test.com.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
		corsista.setNomeCor("Nino");
		corsista.setCognomeCor("D'angelo");
		corsista.setPreFormativi(1);
	}

	@Test
	void testCreateOrUpdate() throws ClassNotFoundException, DAOException, IOException, SQLException {
		try {
			if (corsista.getCodiceCor() < CodGenerator.getIstance().getNextCod("corsista"))
				CorsistaDAO.getFactory().update(conn, corsista);
			else
				CorsistaDAO.getFactory().create(conn, corsista);
			conn.commit();
			System.out.println("Corsista inserito correttamente");
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Errore nel inserimento del corsista");
		}
	}

	/*
	 * @Test void testGetByCod() { Corsista corsista =null; try { long cod = 5;
	 * corsista = CorsistaDAO.getFactory().getByCod(conn,cod);
	 * System.out.println("il corsista è:" +corsista.toString());
	 * assertNotNull(corsista); }catch(DAOException exc) { exc.printStackTrace();
	 * System.out.println("corsista non trovato"); } }
	 * 
	 * @Test void testSearchCorsista() { try { String nome = "Nino"; Corsista[]
	 * corsisti = CorsistaDAO.getFactory().getAll(conn); assertNotNull(corsisti);
	 * for(Corsista c: corsisti)
	 * if(c.getNomeCor().toLowerCase().equals(nome.toLowerCase()) |
	 * c.getCognomeCor().toLowerCase().equals(nome.toLowerCase()))
	 * System.out.println(c.toString()); }catch(DAOException exc){
	 * exc.printStackTrace(); fail("Errore nella ricerca del Corsista"); } }
	 * 
	 * 
	 * 
	 * @Test void testGetAll() { try { Corsista[] corsisti =
	 * CorsistaDAO.getFactory().getAll(conn); assertNotNull(corsisti);
	 * System.out.println("trovati tutti"); }catch(DAOException dao) {
	 * dao.printStackTrace(); fail("Recupero dati fallito"); } }
	 * 
	 * @Test void getNumCorsistiTotali(){ try { int
	 * n=CorsistaDAO.getFactory().getNumCorsistiTotali(conn); assertNotNull(n);
	 * }catch(DAOException dao) { dao.printStackTrace();
	 * fail("Recupero dati fallito"); } }
	 * 
	 */

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			corsista = null;
			CorsistaDAO.getFactory().delete(conn, corsista.getCodiceCor());
			conn.commit();
			System.out.println("Pulita la tabella corsista");
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Errore nella pulizia del DB");
		}
	}

}
