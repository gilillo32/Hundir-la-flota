package probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packjokoa.JokalariArrunta;

public class JokalariaTest {

	private JokalariArrunta j1; //, j2;
	@Before
	public void setUp() throws Exception {
		j1= new JokalariArrunta("lei",(short) 10);
		//j2= new JokalariArrunta("pau",(short) 10);
	}

	@After
	public void tearDown() throws Exception {
		j1=null;
		//j2=null;
	}

	@Test
	public void testJokalaria() {
		assertNotNull(j1);
		//assertNotNull(j2);
	}

	@Test
	public void testGetNireTableroa() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrintTableroa() {
		
	}

	@Test
	public void testNireTableroaBete() {
		//metodo hau konprobatzeko ez dago assert-erik, kontsolan konprbatzen dugu guk, metodo hau bera inprimatzen du tableroa ez dugu inprimatu metodoa deitu behar
		j1.nireTableroaBete();
	}

	@Test
	public void testItsasontziakJarri() {

	}

	@Test
	public void testItsasontzirikEz() {
		//false kasuak:
		int ukituta= j1.getNUkituta();//0 hasieratzen da
		assertEquals( 0, ukituta);
		//nUkituta atributua 10 baino txikiagoa denenean false bueltatuko du
		assertFalse(j1.itsasontzirikEz());
		
		j1.setNUkituta(8);
		ukituta= j1.getNUkituta();//0 hasieratzen da
		assertEquals( 8, ukituta);
		assertFalse(j1.itsasontzirikEz());
		
		//true kasua nUkituta==10 denean
		j1.setNUkituta(10);
		ukituta= j1.getNUkituta();//0 hasieratzen da
		assertEquals( 10, ukituta);
		assertTrue(j1.itsasontzirikEz());
	}

	@Test
	public void testKoordenatuanZerDagoen() {
		fail("Not yet implemented");
	}

	@Test
	public void testKoordenadaBaliogarriak() {
		fail("Not yet implemented");
	}

	@Test
	public void testEguneratuPrintTableroa() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIzena() {
		String izena = "lei";
		assertEquals(izena, j1.getIzena());
	}

	@Test
	public void testGetNUkituta() {
		int ukituta= j1.getNUkituta();//0 hasieratzen da
		assertEquals( 0, ukituta);
		
		//beste balio bat jarriko diogu		
		j1.setNUkituta(3);
		ukituta= j1.getNUkituta();//0 hasieratzen da
		assertEquals( 3, ukituta);
		
		//beste balio bat jarriko diogu		
		j1.setNUkituta(5);
		ukituta= j1.getNUkituta();//0 hasieratzen da
		assertEquals( 5, ukituta);
		
		
	}

	@Test
	public void testSetNUkituta() {
		int ukituta= j1.getNUkituta();//0 hasieratzen da
		assertEquals( 0, ukituta);
		
		//beste balio bat jarriko diogu		
		j1.setNUkituta(4);
		ukituta= j1.getNUkituta();//0 hasieratzen da
		assertEquals( 4, ukituta);
		
		//beste balio bat jarriko diogu		
		j1.setNUkituta(6);
		ukituta= j1.getNUkituta();//0 hasieratzen da
		assertEquals( 6, ukituta);
	}

}
