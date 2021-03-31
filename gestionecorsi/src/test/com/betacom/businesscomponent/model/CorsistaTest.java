package test.com.betacom.businesscomponent.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.betacom.businesscomponent.model.Corsista;

class CorsistaTest {
	private static Corsista corsista;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corsista = new Corsista();
		corsista.setNomeCor("Gianpaolo");
		corsista.setCognomeCor("Paoli");
		corsista.setCodiceCor(1);
		corsista.setPreFormativi(0);
	}


	@Test
	void testGet() {
		corsista.getNomeCor();
		corsista.getCognomeCor();
		corsista.getCodiceCor();
		corsista.getPreFormativi();
		System.out.println(corsista.toString());
	}

	@Test
	void testUpdate() {
		System.out.println(corsista.toString());
		corsista.setNomeCor("Gianni");
		corsista.setCognomeCor("Giangi");
		corsista.setCodiceCor(1);
		corsista.setPreFormativi(1);
		System.out.println(corsista.toString());
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		corsista = null;
		System.out.println("Corsista eliminato");
	}
	
}
