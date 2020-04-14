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
		//nire tableroan begiratzen du
		Tableroa nireT = j1.getNireTableroa();
//	1		
		//hasieran uraz - beteta dago
		String ema = nireT.koordenatuanZerDagoen((short)1,(short) 1);
		assertEquals(" -" , ema);
		
		//koordenatu horretan " 1" jarriko dugu eta metodoa " U" buletatuko du
		nireT.KoordenatuanJarri(1, 1, " 1");
		ema = nireT.koordenatuanZerDagoen((short)1,(short) 1);
		assertEquals(" U" , ema);	
//	2
		//hasieran uraz - beteta dago
		ema = nireT.koordenatuanZerDagoen((short)5,(short) 1);
		assertEquals(" -" , ema);
				
		//koordenatu horretan " 2" jarriko dugu eta metodoa " U" buletatuko du
		nireT.KoordenatuanJarri(5, 1, " 2");
		ema = nireT.koordenatuanZerDagoen((short)5,(short) 1);
		assertEquals(" U" , ema);
//  3
		//hasieran uraz - beteta dago
		ema = nireT.koordenatuanZerDagoen((short)7,(short) 2);
		assertEquals(" -" , ema);
		
		//koordenatu horretan " 3" jarriko dugu eta metodoa " U" buletatuko du
		nireT.KoordenatuanJarri(7, 2, " 3");		
		ema = nireT.koordenatuanZerDagoen((short)7,(short) 2);
		assertEquals(" U" , ema);
//  4
		//hasieran uraz - beteta dago
		ema = nireT.koordenatuanZerDagoen((short)9,(short) 3);
		assertEquals(" -" , ema);
		
		//koordenatu horretan " 4" jarriko dugu eta metodoa " U" buletatuko du
		nireT.KoordenatuanJarri(9, 3, " 4");		
		ema = nireT.koordenatuanZerDagoen((short)9,(short) 3);
		assertEquals(" U" , ema);	
	
	}

	@Test
	public void test6KoordenadaBaliogarriak() {
		//nire tableroan begiratzen du
		Tableroa nireT = j1.getNireTableroa();
//	1	
		//hasieran uraz - beteta dago, beraz true bueltatuko du
		String ema = nireT.koordenatuanZerDagoen((short)1,(short) 1);
		assertEquals(" -" , ema);
		assertTrue(j1.koordenadaBaliogarriak((short)1,(short) 1) );
		
		//koordenatu horretan " 1" jarriko dugu eta koordenatuanZerDagoen metodoa " U" buletatuko du, beraz false bueltatuko du
		nireT.KoordenatuanJarri(1, 1, " 1");
		ema = nireT.koordenatuanZerDagoen((short)1,(short) 1);
		assertEquals(" U" , ema);		
		assertFalse(j1.koordenadaBaliogarriak((short)1,(short) 1) );		
//	2
		//hasieran uraz - beteta dago
		ema = nireT.koordenatuanZerDagoen((short)5,(short) 1);
		assertEquals(" -" , ema);
		assertTrue(j1.koordenadaBaliogarriak( (short)5,(short) 1) );
				
		//koordenatu horretan " 2" jarriko dugu eta koordenatuanZerDagoen metodoa " U" buletatuko du, beraz false bueltatuko du
		nireT.KoordenatuanJarri(5, 1, " 2");
		ema = nireT.koordenatuanZerDagoen((short)5,(short) 1);
		assertEquals(" U" , ema);
		assertFalse(j1.koordenadaBaliogarriak( (short)5,(short) 1)  );
//  3
		//hasieran uraz - beteta dago
		ema = nireT.koordenatuanZerDagoen((short)7,(short) 2);
		assertEquals(" -" , ema);
		assertTrue(j1.koordenadaBaliogarriak( (short)7,(short) 2) );
		
		//koordenatu horretan " 3" jarriko dugu koordenatuanZerDagoen metodoa " U" buletatuko du, beraz false bueltatuko du
		nireT.KoordenatuanJarri(7, 2, " 3");		
		ema = nireT.koordenatuanZerDagoen((short)7,(short) 2);
		assertEquals(" U" , ema);
		assertFalse(j1.koordenadaBaliogarriak(  (short)7,(short) 2) );
//  4
		//hasieran uraz - beteta dago
		ema = nireT.koordenatuanZerDagoen((short)9,(short) 3);
		assertEquals(" -" , ema);
		assertTrue(j1.koordenadaBaliogarriak( (short)9,(short) 3) );
		
		//koordenatu horretan " 4" jarriko dugu koordenatuanZerDagoen metodoa " U" buletatuko du, beraz false bueltatuko du
		nireT.KoordenatuanJarri(9, 3, " 4");		
		ema = nireT.koordenatuanZerDagoen((short)9,(short) 3);
		assertEquals(" U" , ema);	
		assertFalse(j1.koordenadaBaliogarriak( (short)9,(short) 3) );
		
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
