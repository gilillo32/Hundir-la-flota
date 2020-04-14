package probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packjokoa.JokalariCPU;
import packjokoa.Jokalaria;
import salbuespenak.*;

public class JokalariCPUTest {
	private JokalariCPU j1;

	@Before
	public void setUp() throws Exception {
		j1 = new JokalariCPU((short)10);
	}

	@After
	public void tearDown() throws Exception {
		j1 = null;
	}

	@Test
	public void testItsasontziakJarri(){
		assertNotNull(j1);
		j1.itsasontziakJarri(10);			
	}

	@Test
	public void testJokalariCPU() {
		assertNotNull(j1);
	}

	@Test
	public void testKoordenatuaAukeratu() {
		fail("Not yet implemented");
	}

}
