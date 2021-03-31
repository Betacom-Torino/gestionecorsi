package test.com.betacom.businesscomponent;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.ClientFacade;

class ClientFacadeTest {

	@Test
	void testGetter() {

		try {

			assertNotNull(ClientFacade.getInstance().getAmministratoreByCod(1));
			assertNotNull(ClientFacade.getInstance().getDocenteByCod(21));

			assertNotNull(ClientFacade.getInstance().getCorsi());
			assertNotNull(ClientFacade.getInstance().getCorsisti());
			assertNotNull(ClientFacade.getInstance().getDocenti());

			assertNotNull(ClientFacade.getInstance().getStatisticaDocenti());

			// X LORENZO: inserisce codice di un corsista e un corso che hai nel DB
			assertNotNull(ClientFacade.getInstance().getCorsistaByCod(1));
			assertNotNull(ClientFacade.getInstance().getCorsoByCod(2)); 
			assertNotNull(ClientFacade.getInstance().getDurataMediaCorsi());
			System.out.println(ClientFacade.getInstance().getDurataMediaCorsi());

		} catch (ClassNotFoundException | DAOException | IOException e) {
			fail();
			e.printStackTrace();
		}

	}

}
