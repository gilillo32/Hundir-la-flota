package probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packjokoa.Tableroa;

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
	public void test4konprobatuItsasontziakJarri1() {
	//HORIZONTALEAN
		//sartuko dugu itsasontzi bat edozein koordenatuan, beraz ez dago arazorik
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(4), (short)(4), (short)(1), "H"));
		//Lehen sartu dugun koordenatu berdinetan saiatu gara itsasontzi bat jartzen.
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(4), (short)(2), "H"));
		
	//sartuko dugu itsasontzi bat ERDIAN
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
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(3), (short)(4), (short)(2), "h"));
		
		//saiatuko gara itsasontzi bat jartzen eskuinean
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(5), (short)(4), (short)(2), "h"));
		
		
	}
	
	@Test
	public void test4konprobatuItsasontziakJarri2() {
	//HORIZONTALEAN
										//GUZTIAK FALSE
		//sartuko dugu itsasontzi bat GOIKO ERTZAN
		nireT.KoordenatuanJarri((short)(4), (short)(1), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(0), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat BEHEKO ERTZAN
		nireT.KoordenatuanJarri((short)(4), (short)(8), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(9), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat ESKUINEKO ERTZAN(kontutan izan behar dugu itsasontziaren lehenenego koordenatua sartzen dugula)
		nireT.KoordenatuanJarri((short)(8), (short)(4), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(8), (short)(4), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat EZKERREKO ERTZAN
		nireT.KoordenatuanJarri((short)(0), (short)(3), " 1");
		//nireT.tableroaInprimatu();
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(0), (short)(4), (short)(2), "h"));
		
	}	
	
	@Test
	public void test4konprobatuItsasontziakJarri3() {
	//HORIZONTALEAN
										//GUZTIAK TRUE (itsasontziak ez daudelako inguruan)
		
		//sartuko dugu itsasontzi bat GOIKO ERTZAN
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(4), (short)(0), (short)(2), "h"));
		//nireT.tableroaInprimatu();
		
		//sartuko dugu itsasontzi bat BEHEKO ERTZAN
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(4), (short)(9), (short)(2), "h"));
		//nireT.tableroaInprimatu();
		
		//sartuko dugu itsasontzi bat ESKUINEKO ERTZAN (kontutan izan behar dugu itsasontziaren lehenenego koordenatua sartzen dugula)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(8), (short)(4), (short)(2), "h"));
		//nireT.tableroaInprimatu();	
		
		//sartuko dugu itsasontzi bat EZKERREKO ERTZAN
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(0), (short)(4), (short)(2), "h"));
		//nireT.tableroaInprimatu();
		
	}
	
	@Test
	public void test4konprobatuItsasontziakJarri4() {
	//HORIZONTALEAN
									//GUZTIAK FALSE
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN EZKERREAN)
		nireT.KoordenatuanJarri((short)(0), (short)(1), " 1");
		//nireT.tableroaInprimatu();
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(0), (short)(0), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN ESKUINEAN)
		nireT.KoordenatuanJarri((short)(9), (short)(1), " 1");
		//nireT.tableroaInprimatu();
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(8), (short)(0), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN ESKUINEAN)
		nireT.KoordenatuanJarri((short)(9), (short)(8), " 1");
		//nireT.tableroaInprimatu();
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(8), (short)(9), (short)(2), "h"));
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN EZKERREAN)
		nireT.KoordenatuanJarri((short)(0), (short)(8), " 1");
		//nireT.tableroaInprimatu();
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(0), (short)(9), (short)(2), "h"));
	}
	
	
	@Test
	public void test4konprobatuItsasontziakJarri5() {
	//HORIZONTALEAN
										//GUZTIAK TRUE
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN EZKERREAN)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(1), (short)(0), (short)(2), "h"));
		//nireT.tableroaInprimatu();
		
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN ESKUINEAN)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(0), (short)(9), (short)(2), "h"));
		//nireT.tableroaInprimatu();
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN ESKUINEAN)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(8), (short)(9), (short)(2), "h"));
		//nireT.tableroaInprimatu();
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN EZKERREAN)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(0), (short)(9), (short)(2), "h"));
		//nireT.tableroaInprimatu();
	}
	
	@Test
	public void test4konprobatuItsasontziakJarri6() {
	//BERTIKALEAN
		//sartuko dugu itsasontzi bat edozein koordenatuan, beraz ez dago arazorik
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(4), (short)(4), (short)(1), "B"));
		//Lehen sartu dugun koordenatu berdinetan saiatu gara itsasontzi bat jartzen.
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(4), (short)(2), "B"));
		
	//sartuko dugu itsasontzi bat ERDIAN
		//saiatuko gara itsasontzi bat jartzen behean
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(5), (short)(2), "b"));
		//behean diagonalean 
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(3), (short)(5), (short)(2), "b"));
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(5), (short)(5), (short)(2), "b"));
		
		//saiatuko gara itsasontzi bat jartzen goian
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(4), (short)(3), (short)(2), "b"));
		//goian diagonalean
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(3), (short)(3), (short)(2), "b"));
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(5), (short)(3), (short)(2), "b"));
		
		//saiatuko gara itsasontzi bat jartzen ezkerrean
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(3), (short)(4), (short)(2), "b"));
		
		//saiatuko gara itsasontzi bat jartzen eskuinean
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(5), (short)(4), (short)(2), "b"));
		
		
	}
	
	@Test
	public void test4konprobatuItsasontziakJarri7() {
	//BERTIKALEAN
										//GUZTIAK FALSE
		//sartuko dugu itsasontzi bat GOIKO ERTZAN
		nireT.KoordenatuanJarri((short)(4), (short)(1), " 1");
		nireT.tableroaInprimatu();
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(3), (short)(0), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat BEHEKO ERTZAN
		nireT.KoordenatuanJarri((short)(4), (short)(8), " 1");
		nireT.tableroaInprimatu();
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(3), (short)(9), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat ESKUINEKO ERTZAN
		nireT.KoordenatuanJarri((short)(8), (short)(4), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(9), (short)(4), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat EZKERREKO ERTZAN
		nireT.KoordenatuanJarri((short)(1), (short)(3), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(0), (short)(3), (short)(2), "b"));
		
	}	
	
	@Test
	public void test4konprobatuItsasontziakJarri8() {
	//BERTIKALEAN
										//GUZTIAK TRUE (itsasontziak ez daudelako inguruan)
		
		//sartuko dugu itsasontzi bat GOIKO ERTZAN
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(4), (short)(0), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat BEHEKO ERTZAN
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(4), (short)(9), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat ESKUINEKO ERTZAN (kontutan izan behar dugu itsasontziaren lehenenego koordenatua sartzen dugula)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(8), (short)(4), (short)(2), "b"));
				
		//sartuko dugu itsasontzi bat EZKERREKO ERTZAN
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(0), (short)(4), (short)(2), "b"));
		
		
	}
	
	@Test
	public void test4konprobatuItsasontziakJarri9() {
	//BERTIKALEAN
									//GUZTIAK FALSE
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN EZKERREAN)
		nireT.KoordenatuanJarri((short)(0), (short)(1), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(1), (short)(0), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN ESKUINEAN)
		nireT.KoordenatuanJarri((short)(9), (short)(1), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(0), (short)(9), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN ESKUINEAN)
		nireT.KoordenatuanJarri((short)(8), (short)(9), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(9), (short)(9), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN EZKERREAN)
		nireT.KoordenatuanJarri((short)(0), (short)(8), " 1");
		assertFalse(nireT.konprobatuItsasontziakJarri((short)(0), (short)(9), (short)(2), "b"));
	}
	
	
	@Test
	public void test4konprobatuItsasontziakJarri10() {
	//BERTIKALEAN
										//GUZTIAK TRUE
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN EZKERREAN)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(1), (short)(0), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat IZKINAN (GOIAN ESKUINEAN)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(0), (short)(9), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN ESKUINEAN)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(9), (short)(9), (short)(2), "b"));
		
		//sartuko dugu itsasontzi bat IZKINAN (BEHEAN EZKERREAN)
		assertTrue(nireT.konprobatuItsasontziakJarri((short)(0), (short)(9), (short)(2), "b"));
	}
	

	@Test
	public void test5KonprobatuTiroa() {
		//Koordenatu guztietan ura dago beraz edozein koordenatu aukeratzen badut TRUE bueltatu behar du
		assertTrue(printT.konprobatuTiroa((short)(6), (short)(8)));//edozein koordenatu 
	
		//guztietan +1 egin dugu, koordenatuanZerDagoen +1 egiten duelako
		
		//sartuko dugu koordenatu batean " X", hau da, koordenatu hori jadanik esanda dago eta ura zegoen eta berriro aukeratuko dugu koordenatu hori
		printT.KoordenatuanJarri(5, 5, " X");
		assertFalse(printT.konprobatuTiroa((short)(5+1),(short)(5+1)));
		
		//sartuko dugun koordenatu batean " U", hau da, koordenatu hori jadanik esanda dago eta itsasontzi bat ukituta zegoen eta berriro aukeratuko dugu koordenatu hori
		printT.KoordenatuanJarri(4, 7, " U");
		assertFalse(printT.konprobatuTiroa((short)(4+1),(short)(7+1)));
	}

	@Test
	public void test6KoordenatuanZerDagoen() {
		//guztietan +1 egin dugu, koordenatuanZerDagoen +1 egiten duelako
		
		//koordenatu guztietan ura dago, beraz " -" itzuliko du
		assertEquals(" -", printT.koordenatuanZerDagoen((short)(7), (short)(7)));
		assertNotEquals("-", printT.koordenatuanZerDagoen((short)(7), (short)(7)));
		
		//koordenatuan 1 laukiko itsasontzia dago, hau da, " 1" dago koordenatu horretan
		printT.KoordenatuanJarri(1, 1, " 1");
		assertEquals(" U", printT.koordenatuanZerDagoen((short)(1+1), (short)(1+1)));
		assertNotEquals("U", printT.koordenatuanZerDagoen((short)(1+1), (short)(1+1)));
	
		//koordenatuan 2 laukiko itsasontzia dago, hau da, " 2" dago koordenatu horretan
		printT.KoordenatuanJarri(8, 1, " 2");
		assertEquals(" U", printT.koordenatuanZerDagoen((short)(8+1), (short)(1+1)));
		assertNotEquals("U", printT.koordenatuanZerDagoen((short)(8+1), (short)(1+1)));
	
		//koordenatuan 3 laukiko itsasontzia dago, hau da, " 3" dago koordenatu horretan
		printT.KoordenatuanJarri(8, 3, " 3");
		assertEquals(" U", printT.koordenatuanZerDagoen((short)(8+1), (short)(3+1)));
		assertNotEquals("U", printT.koordenatuanZerDagoen((short)(8+1), (short)(3+1)));
		
		//koordenatuan 4 laukiko itsasontzia dago, hau da, " 4" dago koordenatu horretan
		printT.KoordenatuanJarri(8, 4, " 4");
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
		printT.KoordenatuanJarri(5, 6, " 1");
		assertEquals(" U",printT.koordenatuanZerDagoen((short)(5+1), (short)(6+1)));//koordenatuanZerDagoen " U" itzultzen du koordenatuan itsasotziren bat badago
		assertNotEquals("U",printT.koordenatuanZerDagoen((short)(5+1), (short)(6+1)));
		
		printT.KoordenatuanJarri(6, 6, " X");
		assertEquals(" X",printT.koordenatuanZerDagoen((short)(6+1), (short)(6+1)));
		assertNotEquals("X",printT.koordenatuanZerDagoen((short)(6+1), (short)(6+1)));

		
	}

}
