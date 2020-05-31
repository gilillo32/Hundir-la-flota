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
	//KONTUTAN IZATEKO!!
	//konprobatuItsasontziakJarri() bi koordenatu jasotzen ditu, baina +1 egingo du
	
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
	public void test9KoordenatuanJarri() {
		//guztietan +1 egin dugu, koordenatuanZerDagoen +1 egiten duelako
		printT.koordenatuanJarri(5, 6, " 1");
		assertEquals(" U",printT.koordenatuanZerDagoen((short)(5+1), (short)(6+1)));//koordenatuanZerDagoen " U" itzultzen du koordenatuan itsasotziren bat badago
		assertNotEquals("U",printT.koordenatuanZerDagoen((short)(5+1), (short)(6+1)));
		
		printT.koordenatuanJarri(6, 6, " X");
		assertEquals(" X",printT.koordenatuanZerDagoen((short)(6+1), (short)(6+1)));
		assertNotEquals("X",printT.koordenatuanZerDagoen((short)(6+1), (short)(6+1)));

		
	}

	@Test
	public void test10zeItsasontziHondoratu() {
	//guztietan +1 egin dugu, koordenatuanZerDagoen +1 egiten duelako
		//sartuko dugu 1-ko itsasontzi bat
		printT.koordenatuanJarri(6, 6, " 1");
		//"1"-eko izatekotan 1 itzuli behar du
		assertEquals(1,printT.zeItsasontziHondoratu((short)(6+1), (short)(6+1)));
		
		//sartuko dugu 2-ko itsasontzi bat
		printT.koordenatuanJarri(6, 6, " 2");
		//"2"-eko izatekotan 2 itzuli behar du
		assertEquals(2,printT.zeItsasontziHondoratu((short)(6+1), (short)(6+1)));
		
		//sartuko dugu 3-ko itsasontzi bat
		printT.koordenatuanJarri(6, 6, " 3");
		//"3"-eko izatekotan 3 itzuli behar du
		assertEquals(3,printT.zeItsasontziHondoratu((short)(6+1), (short)(6+1)));
		
		//sartuko dugu 4-ko itsasontzi bat
		printT.koordenatuanJarri(6, 6, " 4");
		//"4"-eko izatekotan 4 itzuli behar du
		assertEquals(4,printT.zeItsasontziHondoratu((short)(6+1), (short)(6+1)));	
		
		//sartuko dugu X (ura dagoela esan nahi du)
		printT.koordenatuanJarri(6, 6, " X");
		//X egotekotan -1 itzuliko du
		assertEquals(-1,printT.zeItsasontziHondoratu((short)(6+1), (short)(6+1)));
		
		//sartuko dugu U (ukituta dagoela esan nahi du)
		printT.koordenatuanJarri(6, 6, " U");
		//bestela 0 itzuliko du
		assertEquals(0,printT.zeItsasontziHondoratu((short)(6+1), (short)(6+1)));
	}
	
	//KONTUTAN IZATEKO!!
	//erabili dugun kodea hutsuneakKonprobatu() metodoaren antzekoa da, beraz kasu berdinak erabiliko ditugu
	//konprobatzeko ea ondo dagoen metodoa erabiliko dugu kontsola
	//XBete() metodoari sartzen zaizkion koordenatuak +1 eginda daude
	@Test
	public void test11XBete1() {
	//HORIZONTALEAN (zentzua=0 edo zentzua=2)
	//sartuko dugu itsasontzi bat ERDIAN
		nireT.koordenatuanJarri((short)(4), (short)(4), " 1");//benetan (5,5) koordenatuan jarri duzu
		nireT.XBete((short)(5), (short)(5), 1, (byte)(0));
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		nireT.koordenatuanJarri((short)(4), (short)(4), " 3");//benetan (5,5) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(3), (short)(4), " 3");//benetan (4,5) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(2), (short)(4), " 3");//benetan (3,5) koordenatuan jarri duzu
		nireT.XBete((short)(5), (short)(5), 3, (byte)(2));//esandako azkenengo koodenatua (5,5) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		nireT.koordenatuanJarri((short)(4), (short)(4), " 3");//benetan (5,5) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(3), (short)(4), " 3");//benetan (4,5) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(2), (short)(4), " 3");//benetan (3,5) koordenatuan jarri duzu
		nireT.XBete((short)(3), (short)(5), 3, (byte)(2));//esandako azkenengo koodenatua (3,5) da
		nireT.tableroaInprimatu();
	}
	
	@Test
	public void test11XBete2() {
	//HORIZONTALEAN (zentzua=0 edo zentzua=2)
		//sartuko dugu itsasontzi bat GOIKO ERTZAN
		nireT.koordenatuanJarri((short)(4), (short)(0), " 2");//benetan (5,1) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(3), (short)(0), " 2");//benetan (4,1) koordenatuan jarri duzu
		nireT.XBete((short)(4), (short)(1), 2, (byte)(2));//esandako azkenenengo koodenatua (4,1) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		nireT.koordenatuanJarri((short)(4), (short)(0), " 2");//benetan (5,1) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(3), (short)(0), " 2");//benetan (4,1) koordenatuan jarri duzu
		nireT.XBete((short)(5), (short)(1), 2, (byte)(2));//esandako azkenenengo koodenatua (5,1) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		//sartuko dugu itsasontzi bat BEHEKO ERTZAN
		nireT.koordenatuanJarri((short)(4), (short)(9), " 2");//benetan (5,10) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(3), (short)(9), " 2");//benetan (4,10) koordenatuan jarri duzu
		nireT.XBete((short)(5), (short)(10), 2, (byte)(0));//esandako azkenenengo koodenatua (5,10) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		nireT.koordenatuanJarri((short)(4), (short)(9), " 2");//benetan (5,10) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(3), (short)(9), " 2");//benetan (4,10) koordenatuan jarri duzu
		nireT.XBete((short)(4), (short)(10), 2, (byte)(0));//esandako azkenenengo koodenatua (4,10) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		//sartuko dugu itsasontzi bat ESKUINEKO ERTZAN (kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula)
		nireT.koordenatuanJarri((short)(9), (short)(4), " 2");//benetan (10,5) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(8), (short)(4), " 2");//benetan (9,5) koordenatuan jarri duzu
		nireT.XBete((short)(9), (short)(5), 2, (byte)(0));//esandako azkenenengo koodenatua (9,5) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		nireT.koordenatuanJarri((short)(9), (short)(4), " 2");//benetan (10,5) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(8), (short)(4), " 2");//benetan (9,5) koordenatuan jarri duzu
		nireT.XBete((short)(10), (short)(5), 2, (byte)(0));//esandako azkenenengo koodenatua (10,5) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
					
		//sartuko dugu itsasontzi bat EZKERREKO ERTZAN
		nireT.koordenatuanJarri((short)(0), (short)(3), " 2");//benetan (1,4) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(1), (short)(3), " 2");//benetan (2,4) koordenatuan jarri duzu
		nireT.XBete((short)(2), (short)(4), 2, (byte)(0));//esandako azkenenengo koodenatua (2,4) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		
	}	
	
	@Test
	public void test11XBete3() {
	//HORIZONTALEAN(zentzua=0 edo zentzua=2)
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN EZKERREAN)
		nireT.XBete((short)(1), (short)(1), 1, (byte)(2));
		nireT.tableroaInprimatu();
		
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN ESKUINEAN) 
		nireT.XBete((short)(10), (short)(1), 1, (byte)(2));
		nireT.tableroaInprimatu();		
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN ESKUINEAN) 
		nireT.XBete((short)(10), (short)(10), 1, (byte)(2));
		nireT.tableroaInprimatu();		
				
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN EZKERREAN)
		nireT.XBete((short)(1), (short)(10), 1, (byte)(2));
		nireT.tableroaInprimatu();	
	}
	
	
	@Test
	public void test11XBete4() {
	//BERTIKALEAN(zentzua=1 edo zentzua=3)
		//sartuko dugu itsasontzi bat ERDIAN
		nireT.koordenatuanJarri((short)(4), (short)(4), " 1");//benetan (5,5) koordenatuan jarri duzu
		nireT.XBete((short)(5), (short)(5), 1, (byte)(1));
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		nireT.koordenatuanJarri((short)(4), (short)(4), " 3");//benetan (5,5) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(4), (short)(5), " 3");//benetan (5,6) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(4), (short)(6), " 3");//benetan (5,7) koordenatuan jarri duzu
		nireT.XBete((short)(5), (short)(5), 3, (byte)(1));//esandako azkenengo koodenatua (5,5) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		nireT.koordenatuanJarri((short)(4), (short)(4), " 3");//benetan (5,5) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(4), (short)(5), " 3");//benetan (5,6) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(4), (short)(6), " 3");//benetan (5,7) koordenatuan jarri duzu
		nireT.XBete((short)(5), (short)(7), 3, (byte)(3));//esandako azkenengo koodenatua (5,7) da
		nireT.tableroaInprimatu();
	
	}	
	
	@Test
	public void test11XBete5() {
	//BERTIKALEAN(zentzua=1 edo zentzua=3)		
		//sartuko dugu itsasontzi bat GOIKO ERTZAN
		nireT.koordenatuanJarri((short)(4), (short)(0), " 2");//benetan (5,1) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(4), (short)(1), " 2");//benetan (5,2) koordenatuan jarri duzu
		nireT.XBete((short)(5), (short)(2), 2, (byte)(1));//esandako azkenenengo koodenatua (5,2) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		nireT.koordenatuanJarri((short)(4), (short)(0), " 2");//benetan (5,1) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(4), (short)(1), " 2");//benetan (5,2) koordenatuan jarri duzu
		nireT.XBete((short)(5), (short)(2), 2, (byte)(1));//esandako azkenenengo koodenatua (5,2) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		//sartuko dugu itsasontzi bat BEHEKO ERTZAN
		nireT.koordenatuanJarri((short)(4), (short)(8), " 2");//benetan (5,9) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(4), (short)(9), " 2");//benetan (5,10) koordenatuan jarri duzu
		nireT.XBete((short)(5), (short)(10), 2, (byte)(3));//esandako azkenenengo koodenatua (5,10) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		nireT.koordenatuanJarri((short)(4), (short)(8), " 2");//benetan (5,9) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(4), (short)(9), " 2");//benetan (5,10) koordenatuan jarri duzu
		nireT.XBete((short)(5), (short)(9), 2, (byte)(3));//esandako azkenenengo koodenatua (5,10) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		//sartuko dugu itsasontzi bat ESKUINEKO ERTZAN (kontutan izan behar dugu itsasontziaren lehenengo koordenatua sartzen dugula)
		nireT.koordenatuanJarri((short)(9), (short)(4), " 2");//benetan (10,5) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(9), (short)(5), " 2");//benetan (10,6) koordenatuan jarri duzu
		nireT.XBete((short)(10), (short)(5), 2, (byte)(3));//esandako azkenenengo koodenatua (10,5) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
		
		nireT.koordenatuanJarri((short)(9), (short)(4), " 2");//benetan (10,5) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(9), (short)(5), " 2");//benetan (10,6) koordenatuan jarri duzu
		nireT.XBete((short)(10), (short)(6), 2, (byte)(3));//esandako azkenenengo koodenatua (10,6) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();
					
		//sartuko dugu itsasontzi bat EZKERREKO ERTZAN
		nireT.koordenatuanJarri((short)(0), (short)(3), " 2");//benetan (1,4) koordenatuan jarri duzu
		nireT.koordenatuanJarri((short)(0), (short)(4), " 2");//benetan (1,5) koordenatuan jarri duzu
		nireT.XBete((short)(1), (short)(5), 2, (byte)(3));//esandako azkenenengo koodenatua (1,5) da
		nireT.tableroaInprimatu();
		
		nireT.tableroaBete();

		
	}
	
	@Test
	public void test11XBete6() {
	//BERTIKALEAN(zentzua=1 edo zentzua=3)	
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN EZKERREAN)
		nireT.XBete((short)(1), (short)(1), 1, (byte)(1));
		nireT.tableroaInprimatu();
		
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN ESKUINEAN) 
		nireT.XBete((short)(10), (short)(1), 1, (byte)(3));
		nireT.tableroaInprimatu();		
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN ESKUINEAN) 
		nireT.XBete((short)(10), (short)(10), 1, (byte)(1));
		nireT.tableroaInprimatu();		
				
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN EZKERREAN)
		nireT.XBete((short)(1), (short)(10), 1, (byte)(32));
		nireT.tableroaInprimatu();	
	}
	
}
