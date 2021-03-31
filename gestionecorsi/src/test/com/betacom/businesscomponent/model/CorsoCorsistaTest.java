package test.com.betacom.businesscomponent.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.betacom.businesscomponent.model.CorsoCorsista;

class CorsoCorsistaTest {
	private static CorsoCorsista corsoCorsista;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corsoCorsista = new CorsoCorsista();
		corsoCorsista.setCodCorsista(1);;
		corsoCorsista.setCodCorso(2);
	}

	@Test
	static void testGet() throws Exception {
		corsoCorsista.getCodCorsista();
		corsoCorsista.getCodCorso();
		System.out.println(corsoCorsista.toString());
	}
	
	@Test
	void testUpdate() {
		System.out.println(corsoCorsista.toString());
		corsoCorsista.setCodCorsista(2);
		corsoCorsista.setCodCorso(3);
		System.out.println(corsoCorsista.toString());
	}
	
	@AfterAll
	static void delete() throws Exception{
		corsoCorsista = null;
		System.out.println("Eliminato");
	}

}
