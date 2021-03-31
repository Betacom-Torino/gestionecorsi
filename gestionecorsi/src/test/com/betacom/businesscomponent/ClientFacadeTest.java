package test.com.betacom.businesscomponent;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@Test
	void testGetter() {

		try {

			assertNotNull(ClientFacade.getInstance().getAmministratoreByCod(1));
			assertNull(ClientFacade.getInstance().getCorsoByCod(10));
			assertNull(ClientFacade.getInstance().getCorsistaByCod(10));
			assertNotNull(ClientFacade.getInstance().getDocenteByCod(10));

			assertNotNull(ClientFacade.getInstance().getCorsi());
			assertNotNull(ClientFacade.getInstance().getCorsisti());
			assertNotNull(ClientFacade.getInstance().getDocenti());

			assertNotNull(ClientFacade.getInstance().getDocenti());
			assertNotNull(ClientFacade.getInstance().getStatisticaDocenti());

		} catch (ClassNotFoundException | DAOException | IOException e) {
			fail();
			e.printStackTrace();
		}

	}

}
