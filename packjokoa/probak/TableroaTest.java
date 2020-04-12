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
	public void testTableroa() {
		assertNotNull(nireT);
		assertNotNull(printT);
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
	public void testItsasontziakJarri() throws KoordenatuEzEgokiak {
		//sartuko dugu itsasontzi bat edozein koordenatuan, beraz ez dago arazorik
		nireT.itsasontziakJarri((short)(4), (short)(4), (short)(1), "h");
		assertFail(nireT.itsasontziakJarri((short)(4), (short)(4), (short)(2), "h"));//mal
	}

	@Test
	public void testKonprobatuTiroa() {
		//Koordenatu guztietan ura dago beraz edozein koordenatu aukeratzen badut TRUE bueltatu behar du
		assertTrue(printT.konprobatuTiroa((short)(6), (short)(8)));//edozein koordenatu 
	
		//sartuko dugu koordenatu batean " X", hau da, koordenatu hori jadanik esanda dago eta ura zegoen eta berriro aukeratuko dugu koordenatu hori
		printT.KoordenatuanJarri(5, 5, " X");
		assertFalse(printT.konprobatuTiroa((short)(5),(short)(5)));
		
		//sartuko dugun koordenatu batean " U", hau da, koordenatu hori jadanik esanda dago eta itsasontzi bat ukituta zegoen eta berriro aukeratuko dugu koordenatu hori
		printT.KoordenatuanJarri(4, 7, " U");
		assertFalse(printT.konprobatuTiroa((short)(4),(short)(7)));
	}

	@Test
	public void testKoordenatuanZerDagoen() {
		//koordenatu guztietan ura dago, beraz " -" itzuliko du
		assertEquals(" -", printT.koordenatuanZerDagoen((short)(7), (short)(7)));
		assertNotEquals("-", printT.koordenatuanZerDagoen((short)(7), (short)(7)));
		
		//koordenatuan 1 laukiko itsasontzia dago, hau da, " 1" dago koordenatu horretan
		printT.KoordenatuanJarri(1, 1, " 1");
		assertEquals(" U", printT.koordenatuanZerDagoen((short)(1), (short)(1)));
		assertNotEquals("U", printT.koordenatuanZerDagoen((short)(1), (short)(1)));
	
		//koordenatuan 2 laukiko itsasontzia dago, hau da, " 2" dago koordenatu horretan
		printT.KoordenatuanJarri(8, 1, " 2");
		assertEquals(" U", printT.koordenatuanZerDagoen((short)(8), (short)(1)));
		assertNotEquals("U", printT.koordenatuanZerDagoen((short)(8), (short)(1)));
	
		//koordenatuan 3 laukiko itsasontzia dago, hau da, " 3" dago koordenatu horretan
		printT.KoordenatuanJarri(8, 3, " 3");
		assertEquals(" U", printT.koordenatuanZerDagoen((short)(8), (short)(3)));
		assertNotEquals("U", printT.koordenatuanZerDagoen((short)(8), (short)(3)));
		
		//koordenatuan 4 laukiko itsasontzia dago, hau da, " 4" dago koordenatu horretan
		printT.KoordenatuanJarri(8, 4, " 4");
		assertEquals(" U", printT.koordenatuanZerDagoen((short)(8), (short)(4)));
		assertNotEquals("U", printT.koordenatuanZerDagoen((short)(8), (short)(4)));

	}

	@Test
	public void testEguneratuTableroa() {
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
	public void testGetErrenkadaZutKop() {
		//errenkadaZutKop finkatu dugu hasieran tableroa egiterakoan eta esan dugu 11 (10 sartu dugu baina gero eraikitzailean +1 egiten da) dela
		assertEquals(11, printT.getErrenkadaZutKop());
		assertNotEquals(2,printT.getErrenkadaZutKop());
		
		//aldatuko dugu ErrenkadaZutKop
		Tableroa auxT=new Tableroa(12);//13 da (12 sartu dugu baina gero eraikitzailean +1 egiten da)
		assertEquals(13, auxT.getErrenkadaZutKop());
		assertNotEquals(2,auxT.getErrenkadaZutKop());
	}
	
	@Test
	public void KoordenatuanJarri() {
		printT.KoordenatuanJarri(5, 6, " 1");
		assertEquals(" U",printT.koordenatuanZerDagoen((short)(5), (short)(6)));//koordenatuanZerDagoen " U" itzultzen du koordenatuan itsasotziren bat badago
		assertNotEquals("U",printT.koordenatuanZerDagoen((short)(5), (short)(6)));
		
		printT.KoordenatuanJarri(6, 6, " X");
		assertEquals(" X",printT.koordenatuanZerDagoen((short)(6), (short)(6)));
		assertNotEquals("X",printT.koordenatuanZerDagoen((short)(6), (short)(6)));

		
	}

}
