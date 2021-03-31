package test.com.betacom.architecture.dbaccess;

import static org.junit.Assert.fail;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;

class DBAccessTest {

	@Test
	void test() {
		try {
			DBAccess.getConnection();
		}catch(DAOException | IOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			fail("Errore nel tentativo di connessione");
		}finally {
			try {
				DBAccess.closeConnection();
			}catch(DAOException exc) {
				exc.printStackTrace();
				fail("Errore nel tentativo di chiusura della connessione");
			}
		}
	}

}
