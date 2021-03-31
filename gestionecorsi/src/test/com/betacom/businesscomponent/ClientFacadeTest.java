package test.com.betacom.businesscomponent;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.ClientFacade;
import com.betacom.businesscomponent.model.Corsista;
import com.betacom.businesscomponent.model.Corso;

class ClientFacadeTest {

	private static Corsista corsista;
	private static Corso corso;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		corso = new Corso();
		corsista = new Corsista();

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		ClientFacade.getInstance().deleteCorso(10);
		ClientFacade.getInstance().deleteCorsista(10);

	}

	@Test
	void testCreate() {

		try {

			ClientFacade.getInstance().createOrUpdateCorso(corso);
			ClientFacade.getInstance().createCorsista(corsista);

		} catch (ClassNotFoundException | DAOException | IOException e) {
			fail();
			e.printStackTrace();
		}

	}

	@Test
	void testGetter() {

		try {

			assertNotNull(ClientFacade.getInstance().getAmministratoreById(10));
			assertNotNull(ClientFacade.getInstance().getCorsoById(10));
			assertNotNull(ClientFacade.getInstance().getCorsistaById(10));
			assertNotNull(ClientFacade.getInstance().getDocenteById(10));

			assertNotNull(ClientFacade.getInstance().getCorsi());
			assertNotNull(ClientFacade.getInstance().getCorsisti());
			assertNotNull(ClientFacade.getInstance().getDocenti());

		} catch (ClassNotFoundException | DAOException | IOException e) {
			fail();
			e.printStackTrace();
		}

	}

}
