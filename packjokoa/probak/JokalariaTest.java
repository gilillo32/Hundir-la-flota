package probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packjokoa.JokalariArrunta;
import packjokoa.Tableroa;

public class JokalariaTest {

	private JokalariArrunta j1; 
	@Before
	public void setUp() throws Exception {
		j1= new JokalariArrunta("lei",(short) 10);
		
	}

	@After
	public void tearDown() throws Exception {
		j1=null;
	}

	@Test
	public void test1Jokalaria() {
		assertNotNull(j1);
	}

	@Test
	public void test2GetNireTableroa() {
		Tableroa nireT = null;
		nireT = j1.getNireTableroa();
		//tablero abueltatzen duela ziurtatu
		assertNotNull(nireT);
		nireT.tableroaInprimatu();
	}

	@Test
	public void test3GetPrintTableroa() {
		Tableroa printT = null;
		printT = j1.getPrintTableroa();
		//tablero abueltatzen duela ziurtatu
		assertNotNull(printT);
		printT.tableroaInprimatu();
	}

	@Test
	public void test4NireTableroaBete() {
		//metodo hau konprobatzeko ez dago assert-erik, kontsolan konprbatzen dugu guk, metodo hau bera inprimatzen du tableroa ez dugu inprimatu metodoa deitu behar
		j1.nireTableroaBete();//metodo hau bikoteJokalariak klasean erabiltzen dugu eta nire tableroa inprimatzen du, kontslatik konprobatzen da
	}



	@Test
	public void test4ItsasontzirikEz() {
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
	public void test5KoordenatuanZerDagoen() {
		//ezi nda konprobaru tableroa ezin bada atzitu
	}

	@Test
	public void test6KoordenadaBaliogarriak() {
		//ezin da konprobaru tableroa ezin bada atzitu
	}

	@Test
	public void test7EguneratuPrintTableroa() {
		//ezin da konprobaru tableroa ezin bada atzitu
	}

	@Test
	public void test8GetIzena() {
		String izena = "lei";
		assertEquals(izena, j1.getIzena());
	}

	@Test
	public void test9GetNUkituta() {
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
	public void test10SetNUkituta() {
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
