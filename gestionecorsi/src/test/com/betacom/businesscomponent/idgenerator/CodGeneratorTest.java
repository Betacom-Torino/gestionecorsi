package test.com.betacom.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;


import org.junit.jupiter.api.Test;

import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.idgenerator.CodGenerator;


class CodGeneratorTest {


	@Test
	void testCodGen() {
		try {
			CodGenerator codGen= CodGenerator.getIstance();
			assertNotNull(codGen);
			long valore= codGen.getNextCod("corso");
			assertEquals(valore,codGen.getNextCod("corso")-1);
			System.out.println(valore);
		}catch (ClassNotFoundException |IOException |DAOException exc) {
			exc.printStackTrace();
			fail("test su sequenza fallito");
			
		}
	}

}
