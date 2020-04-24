package probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import klaseak.*;

public class TableroaTest {
	private Tableroa  nireT, printT;
	@Before
	public void setUp() throws Exception {
		nireT = new Tableroa(10);
		printT = new Tableroa(10);
		nireT.tableroaBete();
		printT.tableroaBete();
	}

	@After
	public void tearDown() throws Exception {
		nireT = null;
		printT=null;
	}

	
	@Test
	public void test1Tableroa() {
		assertNotNull(nireT);
		assertNotNull(printT);
	}

	@Test
	public void test2TableroaInprimatu() {
		System.out.println(" testTableroaInprimatu"); 
		nireT.tableroaInprimatu();
	}

	@Test
	public void test3TableroaBete() {
		System.out.println(" testTableroaBete frogatzeko, inprimatuko dugu tableroa :"); 
		nireT.tableroaBete();
		
	}
	
	@Test
	public void testHondoratutaDago() {
		//EZ daude itsasontzirik TRUE bueltatu behar du
		assertTrue(nireT.hondoratutaDago(1));
		assertTrue(nireT.hondoratutaDago(2));
		assertTrue(nireT.hondoratutaDago(3));
		assertTrue(nireT.hondoratutaDago(4));
		
		//sartuko dugu bakoitzeko kasilla bat, bateko izan ezik bakarrik bat egon ahal delako 
		nireT.koordenatuanJarri(4, 4, " 2");
		nireT.koordenatuanJarri(6, 6, " 3");
		nireT.koordenatuanJarri(5, 8, " 4");
		
		assertFalse(nireT.hondoratutaDago(2));
		assertFalse(nireT.hondoratutaDago(2));
		assertFalse(nireT.hondoratutaDago(3));
		assertFalse(nireT.hondoratutaDago(4));
		
		//sartuko diot 0, hau da, ez du itsasontzirik aurkitu
		assertFalse(nireT.hondoratutaDago(0));//mal
		
	}
	
	@Test
	public void test4konprobatuItsasontziakJarri1() {
	//HORIZONTALEAN 
		//sartuko dugu itsasontzi bat edozein koordenatuan, beraz ez dago arazorik
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(4), (short)(4), (short)(1), "H"));
		//Lehen sartu dugun koordenatu berdinetan saiatu gara itsasontzi bat jartzen.
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(4), (short)(2), "H"));
		
	//sartuko dugu itsasontzi bat ERDIAN
		nireT.koordenatuanJarri((short)(4), (short)(4), " 1");
		//saiatuko gara itsasontzi bat jartzen behean
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(5), (short)(2), "h"));
		//behean diagonalean 
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(3), (short)(5), (short)(2), "h"));
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(5), (short)(5), (short)(2), "h"));
		
		//saiatuko gara itsasontzi bat jartzen goian
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(3), (short)(2), "h"));
		//goian diagonalean
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(3), (short)(3), (short)(2), "h"));
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(5), (short)(3), (short)(2), "h"));
		
		//saiatuko gara itsasontzi bat jartzen ezkerrean
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(2), (short)(4), (short)(2), "h"));
		
		//saiatuko gara itsasontzi bat jartzen eskuinean
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(5), (short)(4), (short)(2), "h"));
		
		
	}
	
	@Test
	public void test4konprobatuItsasontziakJarri2() {
	//HORIZONTALEAN
										//GUZTIAK FALSE
		//sartuko dugu itsasontzi bat GOIKO ERTZAN
		nireT.koordenatuanJarri((short)(4), (short)(1), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(0), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat BEHEKO ERTZAN
		nireT.koordenatuanJarri((short)(4), (short)(8), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(9), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat ESKUINEKO ERTZAN (kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula)
		nireT.koordenatuanJarri((short)(9), (short)(4), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(8), (short)(3), (short)(2), "h"));
			//baita saiatuko gara sartzen 1-ko itsasontzia
			nireT.koordenatuanJarri((short)(9), (short)(6), " 1");
			assertFalse(nireT.konprobatuItsasontziakJarri((short)(9), (short)(7), (short)(1), "h"));
					
		//sartuko dugu itsasontzi bat EZKERREKO ERTZAN
		nireT.koordenatuanJarri((short)(0), (short)(3), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(0), (short)(4), (short)(2), "h"));
		
	}	
	
	@Test
	public void test4konprobatuItsasontziakJarri3() {
	//HORIZONTALEAN
										//GUZTIAK TRUE (itsasontziak ez daudelako inguruan)
		
		//sartuko dugu itsasontzi bat GOIKO ERTZAN
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(4), (short)(0), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat BEHEKO ERTZAN
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(4), (short)(9), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat ESKUINEKO ERTZAN (kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula, beraz itsasontzi 2-koa bada ezin dugu ertzan sartu)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(8), (short)(4), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat EZKERREKO ERTZAN
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(0), (short)(4), (short)(2), "h"));
		
		
	}
	
	@Test
	public void test4konprobatuItsasontziakJarri4() {
	//HORIZONTALEAN
									//GUZTIAK FALSE
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN EZKERREAN)
		nireT.koordenatuanJarri((short)(0), (short)(1), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(0), (short)(0), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN ESKUINEAN) (kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula, beraz itsasontzi 2-koa bada ezin dugu ertzan sartu)
		nireT.koordenatuanJarri((short)(9), (short)(1), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(8), (short)(0), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN ESKUINEAN) (kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula, beraz itsasontzi 2-koa bada ezin dugu ertzan sartu)
		nireT.koordenatuanJarri((short)(9), (short)(8), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(8), (short)(9), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN EZKERREAN)
		nireT.koordenatuanJarri((short)(0), (short)(8), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(0), (short)(9), (short)(2), "h"));
	}
	
	
	@Test
	public void test4konprobatuItsasontziakJarri5() {
	//HORIZONTALEAN
										//GUZTIAK TRUE
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN EZKERREAN)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(1), (short)(0), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN ESKUINEAN) (kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula, beraz itsasontzi 2-koa bada ezin dugu ertzan sartu)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(8), (short)(0), (short)(2), "h"));	
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN ESKUINEAN) (kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula, beraz itsasontzi 2-koa bada ezin dugu ertzan sartu)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(8), (short)(9), (short)(2), "h"));

		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN EZKERREAN)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(0), (short)(9), (short)(2), "h"));
	}
	
	@Test
	public void test4konprobatuItsasontziakJarri6() {
	//BERTIKALEAN
		//sartuko dugu itsasontzi bat edozein koordenatuan, beraz ez dago arazorik
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(4), (short)(4), (short)(1), "B"));
		//Lehen sartu dugun koordenatu berdinetan saiatu gara itsasontzi bat jartzen.
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(4), (short)(2), "B"));
		
	//sartuko dugu itsasontzi bat ERDIAN
		nireT.koordenatuanJarri((short)(4), (short)(4), " 1");
		//saiatuko gara itsasontzi bat jartzen behean
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(5), (short)(2), "b"));
		//behean diagonalean 
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(3), (short)(5), (short)(2), "b"));
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(5), (short)(5), (short)(2), "b"));
		
		//saiatuko gara itsasontzi bat jartzen goian
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(2), (short)(2), "b"));
		//goian diagonalean
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(3), (short)(2), (short)(2), "b"));
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(5), (short)(2), (short)(2), "b"));
		
		//saiatuko gara itsasontzi bat jartzen ezkerrean
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(3), (short)(5), (short)(2), "b"));
		
		//saiatuko gara itsasontzi bat jartzen eskuinean
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(5), (short)(4), (short)(2), "b"));
		
		
	}
	
	@Test
	public void test4konprobatuItsasontziakJarri7() {
	//BERTIKALEAN
										//GUZTIAK FALSE
		//sartuko dugu itsasontzi bat GOIKO ERTZAN
		nireT.koordenatuanJarri((short)(4), (short)(0), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(3), (short)(0), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat BEHEKO ERTZAN (kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula, beraz itsasontzi 2-koa bada sartu ezin dugu sartu beheko ertzean zuzenean)
		nireT.koordenatuanJarri((short)(4), (short)(9), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(3), (short)(8), (short)(2), "b"));
			//baita saiatuko gara 1-ko itsasontzia sartzen
			nireT.koordenatuanJarri((short)(6), (short)(9), " 1");
			assertFalse(nireT.konprobatuItsasontziakJarri((short)(7), (short)(9), (short)(1), "b"));
			
		//sartuko dugu itsasontzi bat ESKUINEKO ERTZAN
		nireT.koordenatuanJarri((short)(8), (short)(4), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(9), (short)(4), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat EZKERREKO ERTZAN
		nireT.koordenatuanJarri((short)(1), (short)(3), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(0), (short)(3), (short)(2), "b"));
		
	}	
	
	@Test
	public void test4konprobatuItsasontziakJarri8() {
	//BERTIKALEAN
										//GUZTIAK TRUE (itsasontziak ez daudelako inguruan)
		
		//sartuko dugu itsasontzi bat GOIKO ERTZAN
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(4), (short)(0), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat BEHEKO ERTZAN (kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula, beraz itsasontzi 2-koa bada sartu ezin dugu sartu beheko ertzean zuzenean)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(4), (short)(8), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat ESKUINEKO ERTZAN (kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula, beraz itsasontzi 2-koa bada sartu ezin dugu sartu beheko ertzean zuzenean)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(8), (short)(4), (short)(2), "b"));
				
		//sartuko dugu itsasontzi bat EZKERREKO ERTZAN
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(0), (short)(4), (short)(2), "b"));
		
		
	}
	
	@Test
	public void test4konprobatuItsasontziakJarri9() {
	//BERTIKALEAN
									//GUZTIAK FALSE
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN EZKERREAN)
		nireT.koordenatuanJarri((short)(0), (short)(1), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(1), (short)(0), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN ESKUINEAN)
		nireT.koordenatuanJarri((short)(8), (short)(0), " 1"); 
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(9), (short)(0), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN ESKUINEAN) (kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula, beraz itsasontzi 2-koa bada sartu ezin dugu sartu beheko ertzean zuzenean)
		nireT.koordenatuanJarri((short)(8), (short)(9), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(9), (short)(8), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN EZKERREAN) (kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula, beraz itsasontzi 2-koa bada sartu ezin dugu sartu beheko ertzean zuzenean)
		nireT.koordenatuanJarri((short)(1), (short)(8), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(0), (short)(8), (short)(2), "b"));
	}
	
	
	@Test
	public void test4konprobatuItsasontziakJarri10() {
	//BERTIKALEAN
										//GUZTIAK TRUE
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN EZKERREAN)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(0), (short)(1), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN ESKUINEAN)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(9), (short)(0), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN ESKUINEAN )(kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula, beraz itsasontzi 2-koa bada sartu ezin dugu sartu beheko ertzean zuzenean)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(9), (short)(8), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN EZKERREAN)(kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula, beraz itsasontzi 2-koa bada sartu ezin dugu sartu beheko ertzean zuzenean)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(0), (short)(8), (short)(2), "b"));
	}
	

	@Test
	public void test5KonprobatuTiroa() {
		//Koordenatu guztietan ura dago beraz edozein koordenatu aukeratzen badut TRUE bueltatu behar du
		assertTrue(printT.konprobatuTiroa((short)(6), (short)(8)));//edozein koordenatu 
	
		//guztietan +1 egin dugu, koordenatuanZerDagoen +1 egiten duelako
		
		//sartuko dugu koordenatu batean " X", hau da, koordenatu hori jadanik esanda dago eta ura zegoen eta berriro aukeratuko dugu koordenatu hori
		printT.koordenatuanJarri(5, 5, " X");
		assertFalse(printT.konprobatuTiroa((short)(5+1),(short)(5+1)));
		
		//sartuko dugun koordenatu batean " U", hau da, koordenatu hori jadanik esanda dago eta itsasontzi bat ukituta zegoen eta berriro aukeratuko dugu koordenatu hori
		printT.koordenatuanJarri(4, 7, " U");
		assertFalse(printT.konprobatuTiroa((short)(4+1),(short)(7+1)));
	}

	@Test
	public void test6KoordenatuanZerDagoen() {
		//guztietan +1 egin dugu, koordenatuanZerDagoen +1 egiten duelako
		
		//koordenatu guztietan ura dago, beraz " -" itzuliko du
		assertEquals(" -", printT.koordenatuanZerDagoen((short)(7), (short)(7)));
		assertNotEquals("-", printT.koordenatuanZerDagoen((short)(7), (short)(7)));
		
		//koordenatuan 1 laukiko itsasontzia dago, hau da, " 1" dago koordenatu horretan
		printT.koordenatuanJarri(1, 1, " 1");
		assertEquals(" U", printT.koordenatuanZerDagoen((short)(1+1), (short)(1+1)));
		assertNotEquals("U", printT.koordenatuanZerDagoen((short)(1+1), (short)(1+1)));
	
		//koordenatuan 2 laukiko itsasontzia dago, hau da, " 2" dago koordenatu horretan
		printT.koordenatuanJarri(8, 1, " 2");
		assertEquals(" U", printT.koordenatuanZerDagoen((short)(8+1), (short)(1+1)));
		assertNotEquals("U", printT.koordenatuanZerDagoen((short)(8+1), (short)(1+1)));
	
		//koordenatuan 3 laukiko itsasontzia dago, hau da, " 3" dago koordenatu horretan
		printT.koordenatuanJarri(8, 3, " 3");
		assertEquals(" U", printT.koordenatuanZerDagoen((short)(8+1), (short)(3+1)));
		assertNotEquals("U", printT.koordenatuanZerDagoen((short)(8+1), (short)(3+1)));
		
		//koordenatuan 4 laukiko itsasontzia dago, hau da, " 4" dago koordenatu horretan
		printT.koordenatuanJarri(8, 4, " 4");
		assertEquals(" U", printT.koordenatuanZerDagoen((short)(8+1), (short)(4+1)));
		assertNotEquals("U", printT.koordenatuanZerDagoen((short)(8+1), (short)(4+1)));

	}

	@Test
	public void test7EguneratuTableroa() {
		//" U" sartuko dugu, hau da, itsasotzi bat ukitu du
		printT.eguneratuTableroa((short)(2), (short)(7), " U");
		assertEquals(" U",printT.koordenatuanZerDagoen((short)(2), (short)(7)));
		assertNotEquals("U",printT.koordenatuanZerDagoen((short)(2), (short)(7)));
		
		//" X" sartuko dugu, hau da, ez du itsasontzi ukitu ura aurkitu du
		printT.eguneratuTableroa((short)(7), (short)(7), " X");
		assertEquals(" X",printT.koordenatuanZerDagoen((short)(7), (short)(7)));
		assertNotEquals("X",printT.koordenatuanZerDagoen((short)(7), (short)(7)));
	}

	@Test
	public void test8GetErrenkadaZutKop() {
		//errenkadaZutKop finkatu dugu hasieran tableroa egiterakoan eta esan dugu 11 (10 sartu dugu baina gero eraikitzailean +1 egiten da) dela
		assertEquals(11, printT.getErrenkadaZutKop());
		assertNotEquals(2,printT.getErrenkadaZutKop());
		
		//aldatuko dugu ErrenkadaZutKop
		Tableroa auxT=new Tableroa(12);//13 da (12 sartu dugu baina gero eraikitzailean +1 egiten da)
		assertEquals(13, auxT.getErrenkadaZutKop());
		assertNotEquals(2,auxT.getErrenkadaZutKop());
	}
	
	@Test
	public void test8KoordenatuanJarri() {
		//guztietan +1 egin dugu, koordenatuanZerDagoen +1 egiten duelako
		printT.koordenatuanJarri(5, 6, " 1");
		assertEquals(" U",printT.koordenatuanZerDagoen((short)(5+1), (short)(6+1)));//koordenatuanZerDagoen " U" itzultzen du koordenatuan itsasotziren bat badago
		assertNotEquals("U",printT.koordenatuanZerDagoen((short)(5+1), (short)(6+1)));
		
		printT.koordenatuanJarri(6, 6, " X");
		assertEquals(" X",printT.koordenatuanZerDagoen((short)(6+1), (short)(6+1)));
		assertNotEquals("X",printT.koordenatuanZerDagoen((short)(6+1), (short)(6+1)));

		
	}

}
