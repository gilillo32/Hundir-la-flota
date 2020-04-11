package probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packjokoa.Tableroa;
import salbuespenak.KoordenatuEzEgokiak;

public class TableroaTest {
	private Tableroa  nireT, printT;
	@Before
	public void setUp() throws Exception {
		nireT = new Tableroa(10);
	}

	@After
	public void tearDown() throws Exception {
		nireT = null;
	}

	@Test
	public void testTableroa() {
		assertNotNull(nireT);
	}

	@Test
	public void testTableroaInprimatu() {
		System.out.println(" testTableroaInprimatu, tableroa hutsit inprimatuko da, indizeak inprimatuko dira soilik"); 
		nireT.tableroaInprimatu();
	}

	@Test
	public void testTableroaBete() {
		System.out.println(" testTableroaBete frogatzeko, inprimatuko dugu tableroa :"); 
		nireT.tableroaBete();
		
	}

	@Test(expected = KoordenatuEzEgokiak.class)
	public void testItsasontziakJarri() {
		
	}

	@Test
	public void testKonprobatuTiroa() {
		fail("Not yet implemented");
	}

	@Test
	public void testKoordenatuanZerDagoen() {
		fail("Not yet implemented");
	}

	@Test
	public void testEguneratuTableroa() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetErrenkadaZutKop() {
		fail("Not yet implemented");
	}
	
	@Test
	public void KoordenatuanJarri() {
		fail("Not yet implemented");
	}

}
