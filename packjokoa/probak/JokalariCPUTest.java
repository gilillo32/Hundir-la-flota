package probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import klaseak.JokalariCPU;
import klaseak.Koordenatuak;

public class JokalariCPUTest {
	private JokalariCPU j1;

	@Before
	public void setUp() throws Exception {
		j1 = new JokalariCPU((short)10);
	}

	@After
	public void tearDown() throws Exception {
		j1.erreseteatu();
		j1 = null;
	}

	@Test
	public void testJokalariCPU() {
		assertNotNull(j1);
	}
	
	@Test
	public void testItsasontziakJarri01(){
		System.out.println(" ");
		System.out.println("Sartuko dugu ' 1'-eko itsasontsi bat (1, 1) koordenatuan [1-eko bi itsasontzi egngo dira] CPU kordenatu horretan itsasontsirik ez jartzen behartzeko eta alboko koordenatuetan");
		System.out.println("Kordenatu hauetan ezin izang du itsasotzirik jarri: (0,0), (0,1), (0,2), (1,0), (1,2), (2,0), (2,1), (2,2) ");
		j1.koordenatuanJarri(1, 1, " 1"); 
		j1.itsasontziakJarri(10);			
		
		System.out.println(" ");
		System.out.println("Randomly egiten duenez, berriro egingo dugu");
		j1 = new JokalariCPU((short)10);
		System.out.println("Kordenatu hauetan ezin izang du itsasotzirik jarri: (0,0), (0,1), (0,2), (1,0), (1,2), (2,0), (2,1), (2,2) ");
		j1.koordenatuanJarri(1, 1, " 1"); 
		j1.itsasontziakJarri(10);
	}

	@Test
	public void testItsasontziakJarri02(){
		System.out.println(" ");
		System.out.println("Sartuko dugu ' 2'-eko itsasontsi bat (3, 3) koordenatuan  horizontalean  [2-eko bi itsasontzi egngo dira] CPU kordenatu horretan itsasontsirik ez jartzen behartzeko eta alboko koordenatuetan");
		System.out.println("Kordenatu hauetan ezin izang du itsasotzirik jarri: (2,2), (2,3), (2,4), (3,2), (4,2), (3,4), (4,4), (5,2), (5,3), (5,4) ");
		j1.koordenatuanJarri(3, 3, " 2"); 
		j1.koordenatuanJarri(4, 3, " 2"); 
		j1.itsasontziakJarri(10);	
		
		System.out.println(" ");
		System.out.println("Randomly egiten duenez, berriro egingo dugu");
		j1 = new JokalariCPU((short)10);
		System.out.println("Kordenatu hauetan ezin izang du itsasotzirik jarri: (2,2), (2,3), (2,4), (3,2), (4,2), (3,4), (4,4), (5,2), (5,3), (5,4) ");
		j1.koordenatuanJarri(3, 3, " 2"); 
		j1.koordenatuanJarri(4, 3, " 2"); 
		j1.itsasontziakJarri(10);	
	}
	
	@Test
	public void testItsasontziakJarri03(){
		System.out.println(" ");
		System.out.println("Sartuko dugu ' 3'-eko itsasontsi bat (6, 3) koordenatuan  bertikalean  [3-eko bi itsasontzi egngo dira] CPU kordenatu horretan itsasontsirik ez jartzen behartzeko eta alboko koordenatuetan");
		System.out.println("Kordenatu hauetan ezin izang du itsasotzirik jarri: (5,2), (5,3), (5,4), (5,5), (5,6), (6,2), (6,6), (7,2), (7,3), (7,4), (7,5), (7,6) ");
		j1.koordenatuanJarri(6, 3, " 3"); 
		j1.koordenatuanJarri(6, 4, " 3");
		j1.koordenatuanJarri(6, 5, " 3"); 
		j1.itsasontziakJarri(10);		
		
		System.out.println(" ");
		System.out.println("Randomly egiten duenez, berriro egingo dugu");
		j1 = new JokalariCPU((short)10);
		System.out.println("Kordenatu hauetan ezin izang du itsasotzirik jarri: (5,2), (5,3), (5,4), (5,5), (5,6), (6,2), (6,6), (7,2), (7,3), (7,4), (7,5), (7,6) ");
		j1.koordenatuanJarri(6, 3, " 3"); 
		j1.koordenatuanJarri(6, 4, " 3");
		j1.koordenatuanJarri(6, 5, " 3"); 
		j1.itsasontziakJarri(10);
	}



	@Test
	public void testKoordenatuaAukeratu0() {
		Koordenatuak k = new Koordenatuak();
		Koordenatuak previousK = new Koordenatuak();
		//////////////////////////////////////////////////////////
		//Aurrean ez du asmatu, auzazko koordenatua bueltatezen du
		k = j1.koordenatuaAukeratu(k, false);
		previousK = k;
		assertNotNull(k);
		System.out.println("////////////////////////////////\nKoordenatuen probak:\nLehenengo kasua: Zentzua lehenengoan asmatuko du");
		System.out.println("Lehenengo aldiz randomly aukeratutako koordenatuak hauexek dira:\n" + k.getKoordenatuakX() + "\n" + k.getKoordenatuakY());
		//--------------------------------------------------
		//Aurrekoan asmatu du, aurreko txandan esan duen koordenatuaren alboko kordenatua esango du
			//hainbat kasu daude
		//Aurrekoan asmatu lehenengo aldiz:
		k = j1.koordenatuaAukeratu(k, true);
		System.out.println("Koordenatu hori lehenengo aldiz asmatu ostean hauexek dira aukeratutakoak:\n" + k.getKoordenatuakX() + "\n" + k.getKoordenatuakY());
		previousK = k;
		//Aurrekoan asmatu bigarren aldiz baina oraingoan ez, beraz, zentzua aldatuko du:
		k = j1.koordenatuaAukeratu(k, true);
		System.out.println("Kordenatu hori bigarren aldiz asmatu ostean hauexek dira aukeratutakoak:\n" + k.getKoordenatuakX() + "\n" + k.getKoordenatuakY());
		//Itsasontzi baten bi kasila asmatu baditu, itsasontsiaren zentzua asmatu du eta zentzu horretan bilatuko du
			//ura aurkitzen duenenen kontrako zentzuan begiratuko du lehenengo asmakizunetik(koordenatu horretatik)
		//Orain, bi koordenatu asmatu ostean, esango diogu azkenetik esandako koordenatua ez duela asmatu, beraz, esan duen lehenengo koordenatura bueltatuko du eta kontrako zentzuan begiratuko du:
		k = j1.koordenatuaAukeratu(k, false);
		System.out.println("Koordenatu hori ez duenez asmatu, baina zentzua dakienez, hauek dira aukeratutakoak:\n" + k.getKoordenatuakX() + "\n" + k.getKoordenatuakY());
		
	}
	
	@Test
	public void testKoordenatuaAukeratu01() {
	//konprobatuko dugu lehenik eta behin eskuinean begiratzen duela
		Koordenatuak k = new Koordenatuak((short)(4),(short)(3)); 
		Koordenatuak k1=j1.koordenatuaAukeratu(k, true);//6,4 itzuli
		j1.eguneratuPrintTableroa((short)(6),(short)(4), " X");
		//konprobatuko dugu koordenatua 5,3 dela
		Koordenatuak k2 = new Koordenatuak((short)(5),(short)(3)); 
		assertEquals(k2.getKoordenatuakX(),k1.getKoordenatuakX());
		assertEquals(k2.getKoordenatuakY(),k1.getKoordenatuakY());
		
	//konprobatuko dugu orain goian begiratzen duela
		k1=j1.koordenatuaAukeratu(k1, false);//5,3 itzuli
		j1.eguneratuPrintTableroa((short)(5),(short)(3), " X");
		//konprobatuko dugu koordenatua 4,2 dela
		k2 = new Koordenatuak((short)(4),(short)(2)); 
		assertEquals(k2.getKoordenatuakX(),k1.getKoordenatuakX());
		assertEquals(k2.getKoordenatuakY(),k1.getKoordenatuakY());
	
	//konprobatuko dugu orain ezkerrean begiratzen duela
		k1=j1.koordenatuaAukeratu(k1, false);//4,4 itzuli
		j1.eguneratuPrintTableroa((short)(4),(short)(4), " X");
		//konprobatuko dugu koordenatua 3,3 dela
		k2 = new Koordenatuak((short)(3),(short)(3)); 
		assertEquals(k2.getKoordenatuakX(),k1.getKoordenatuakX());
		assertEquals(k2.getKoordenatuakY(),k1.getKoordenatuakY());
		
	//konprobatuko dugu azkenik behean begiratzen duela
		k1=j1.koordenatuaAukeratu(k1, false);//5,5 itzuli
		j1.eguneratuPrintTableroa((short)(6),(short)(6), " X");
		//konprobatuko dugu koordenatua 4,4 dela
		k2 = new Koordenatuak((short)(4),(short)(4)); 
		assertEquals(k2.getKoordenatuakX(),k1.getKoordenatuakX());
		assertEquals(k2.getKoordenatuakY(),k1.getKoordenatuakY());
		
	//berriro false da zentzua=0
		k1=j1.koordenatuaAukeratu(k1, false);//6,4 itzuli
		j1.eguneratuPrintTableroa((short)(6),(short)(4), " X");
		System.out.println("zentzua"+ j1.getZentzua());
		//konprobatuko dugu koordenatua 5,3 dela
		k2 = new Koordenatuak((short)(4),(short)(4)); 
		assertEquals(k2.getKoordenatuakX(),k1.getKoordenatuakX());
		assertEquals(k2.getKoordenatuakY(),k1.getKoordenatuakY());
	} 
	
	@Test
	public void testKoordenatuaAukeratu02() {
		//asmatu du eta izkina batean dago
			//GOIAN EZKERREAN, aukeratuko du 1,0
		Koordenatuak k = new Koordenatuak((short)(0),(short)(0));
		Koordenatuak k2 = new Koordenatuak();
		Koordenatuak k3=new Koordenatuak((short)(1),(short)(0));
		k2=j1.koordenatuaAukeratu(k, true);
		assertEquals(k3.getKoordenatuakX(),k2.getKoordenatuakX());
		assertEquals(k3.getKoordenatuakY(),k2.getKoordenatuakY());
		
		j1.erreseteatu();
		
			//GOIAN ESKUINEAN, aukeratuko du 8,0
		k = new Koordenatuak((short)(9),(short)(0));
		k2 = new Koordenatuak();
		k3=new Koordenatuak((short)(8),(short)(0));
		k2=j1.koordenatuaAukeratu(k, true);
		assertEquals(k3.getKoordenatuakX(),k2.getKoordenatuakX());
		assertEquals(k3.getKoordenatuakY(),k2.getKoordenatuakY());
		
		j1.erreseteatu();

			//BEHEAN EZKERREAN, aukeratuko du 1,9
		k = new Koordenatuak((short)(0),(short)(9));
		k2 = new Koordenatuak();
		k3=new Koordenatuak((short)(1),(short)(9));
		k2=j1.koordenatuaAukeratu(k, true);
		assertEquals(k3.getKoordenatuakX(),k2.getKoordenatuakX());
		assertEquals(k3.getKoordenatuakY(),k2.getKoordenatuakY());
		
		j1.erreseteatu();
		
			//BEHEAN ESKUINEAN, aukeratuko du 9,8
		k = new Koordenatuak((short)(9),(short)(9));
		k2 = new Koordenatuak();
		k3=new Koordenatuak((short)(9),(short)(8));
		k2=j1.koordenatuaAukeratu(k, true);
		assertEquals(k3.getKoordenatuakX(),k2.getKoordenatuakX());
		assertEquals(k3.getKoordenatuakY(),k2.getKoordenatuakY());

	}
	
	@Test
	public void testKoordenatuaAukeratu03() {
		//asmatu du eta ertza batean dago
			//GOIKO ERTZA, aukeratuko dugu 6,0
		Koordenatuak k = new Koordenatuak((short)(5),(short)(0));
		Koordenatuak k2 = new Koordenatuak();
		Koordenatuak k3=new Koordenatuak((short)(6),(short)(0));
		k2=j1.koordenatuaAukeratu(k, true);
		assertEquals(k3.getKoordenatuakX(),k2.getKoordenatuakX());
		assertEquals(k3.getKoordenatuakY(),k2.getKoordenatuakY());
		
		j1.erreseteatu();

			//BEHEKO ERTZA, aukeratuko du 6,9
		k = new Koordenatuak((short)(5),(short)(9));
		k2 = new Koordenatuak();
		k3=new Koordenatuak((short)(6),(short)(9));
		k2=j1.koordenatuaAukeratu(k, true);
		assertEquals(k3.getKoordenatuakX(),k2.getKoordenatuakX());
		assertEquals(k3.getKoordenatuakY(),k2.getKoordenatuakY());
		
		j1.erreseteatu();

			//ESKUINEKO ERTZA, aukeratuko du 9,4
		k = new Koordenatuak((short)(9),(short)(5));
		k2 = new Koordenatuak();
		k3=new Koordenatuak((short)(9),(short)(4));
		k2=j1.koordenatuaAukeratu(k, true);
		assertEquals(k3.getKoordenatuakX(),k2.getKoordenatuakX());
		assertEquals(k3.getKoordenatuakY(),k2.getKoordenatuakY());
		
		j1.erreseteatu();

			//EZKERREKO ERTZA, aukeratuko du 1,5
		k = new Koordenatuak((short)(0),(short)(5));
		k2 = new Koordenatuak();
		k3=new Koordenatuak((short)(1),(short)(5));
		k2=j1.koordenatuaAukeratu(k, true);
		assertEquals(k3.getKoordenatuakX(),k2.getKoordenatuakX());
		assertEquals(k3.getKoordenatuakY(),k2.getKoordenatuakY());
	}
	
	@Test
	public void testKoordenatuaAukeratu04() {
		//erdian dago
		Koordenatuak k = new Koordenatuak((short)(5),(short)(5)); 
		Koordenatuak k1=j1.koordenatuaAukeratu(k, true);
		j1.eguneratuPrintTableroa((short)(5),(short)(5), " X");

		
		//konprobatuko dugu koordenatua 0,1 dela
		Koordenatuak k2 = new Koordenatuak((short)(6),(short)(5)); 
		assertEquals(k2.getKoordenatuakX(),k1.getKoordenatuakX());
		assertEquals(k2.getKoordenatuakY(),k1.getKoordenatuakY());
	}
	
	@Test
	public void testKoordenatuaAukeratu05() {
		//Bi asmatu ditu baina hurrengo koordenatua jadanik esanda dago, beraz, kontrako zentzura jo beharko du.
		j1.eguneratuPrintTableroa((short)(6),(short)(4), " X");
		Koordenatuak k = new Koordenatuak((short)(3),(short)(3)); 
		Koordenatuak k1 = j1.koordenatuaAukeratu(k, true);//4,3 itzuli
		j1.eguneratuPrintTableroa((short)(5),(short)(4), " U");
		Koordenatuak k2 = j1.koordenatuaAukeratu(k1, true);
		assertEquals(j1.getZentzua(), 2);
	}

	@Test
	public void testKoordenatuaAukeratu06() {
		//Bi asmatu ditu baina ertz batekin edo izkina batekin joko du, beraz, kontrako zentzura jo beharko du.
		//ESKUINEKO ERTZAREKIN TOPO:
		System.out.println("\n...........................\n");
		System.out.println("\nZentzua 0-tik 2-ra aldatuko du.");
		Koordenatuak k = new Koordenatuak((short)(8),(short)(3)); 
		Koordenatuak k1 = j1.koordenatuaAukeratu(k, true);//10,4 itzuli
		j1.eguneratuPrintTableroa((short)(10),(short)(4), " U");
		System.out.println("Zentzua: " + j1.getZentzua());
		Koordenatuak k2 = j1.koordenatuaAukeratu(k1, true);
		System.out.println("Zentzua: " + j1.getZentzua());
		assertEquals(j1.getZentzua(), 2);
	}
	
	@Test
	public void testKoordenatuaAukeratu07() {
		//Bi asmatu ditu baina ertz batekin edo izkina batekin joko du, beraz, kontrako zentzura jo beharko du.
		//GOIKO ERTZAREKIN TOPO:
		System.out.println("\n...........................\n");
		System.out.println("\nZentzua 1-tik 3-ra aldatuko du.");
		Koordenatuak k = new Koordenatuak((short)(6),(short)(1)); 
		Koordenatuak k1 = j1.koordenatuaAukeratu(k, true);
		j1.eguneratuPrintTableroa((short)(8),(short)(2), " X");
		System.out.println("Zentzua: " + j1.getZentzua());
		Koordenatuak k2 = j1.koordenatuaAukeratu(k1, false);
		j1.eguneratuPrintTableroa((short)7, (short)1, " U");
		System.out.println("Zentzua: " + j1.getZentzua());
		j1.koordenatuaAukeratu(k2, true);
		System.out.println("Zentzua: " + j1.getZentzua());
		assertEquals(j1.getZentzua(), 3);
	}
	
	@Test
	public void testKoordenatuaAukeratu08() {
		//Bi asmatu ditu baina ertz batekin edo izkina batekin joko du, beraz, kontrako zentzura jo beharko du.
		//EZKERREKO ERTZAREKIN TOPO:
		System.out.println("\n...........................\n");
		System.out.println("\nZentzua 2-tik 0-ra aldatuko du.");
		Koordenatuak k = new Koordenatuak((short)(1),(short)(6)); 
		Koordenatuak k1 = j1.koordenatuaAukeratu(k, true);
		j1.eguneratuPrintTableroa((short)(3),(short)(7), " X");
		System.out.println("Zentzua: " + j1.getZentzua());
		Koordenatuak k2 = j1.koordenatuaAukeratu(k1, false);
		j1.eguneratuPrintTableroa((short)2, (short)6, " X");
		System.out.println("Zentzua: " + j1.getZentzua());
		Koordenatuak k3 = j1.koordenatuaAukeratu(k2, false);
		j1.eguneratuPrintTableroa((short)1, (short)7, " U");
		System.out.println("Zentzua: " + j1.getZentzua());
		j1.koordenatuaAukeratu(k3, true);
		System.out.println("Zentzua: " + j1.getZentzua());
		assertEquals(j1.getZentzua(), 0);
	}
	
	@Test
	public void testKoordenatuaAukeratu09() {
		//Bi asmatu ditu baina ertz batekin edo izkina batekin joko du, beraz, kontrako zentzura jo beharko du.
		//BEHEKO ERTZAREKIN TOPO:
		System.out.println("\n...........................\n");
		System.out.println("\nZentzua 3-tik 1-ra aldatuko du.");
		Koordenatuak k = new Koordenatuak((short)(1),(short)(8)); 
		Koordenatuak k1 = j1.koordenatuaAukeratu(k, true);
		j1.eguneratuPrintTableroa((short)(3),(short)(9), " X");
		System.out.println("Zentzua: " + j1.getZentzua());
		Koordenatuak k2 = j1.koordenatuaAukeratu(k1, false);
		j1.eguneratuPrintTableroa((short)2, (short)8, " X");
		System.out.println("Zentzua: " + j1.getZentzua());
		Koordenatuak k3 = j1.koordenatuaAukeratu(k2, false);
		j1.eguneratuPrintTableroa((short)1, (short)9, " X");
		System.out.println("Zentzua: " + j1.getZentzua());
		Koordenatuak k4 = j1.koordenatuaAukeratu(k3, false);
		System.out.println("Zentzua: " + j1.getZentzua());
		j1.eguneratuPrintTableroa((short)2, (short)10, " U");
		System.out.println("Zentzua: " + j1.getZentzua());
		j1.koordenatuaAukeratu(k4, true);
		System.out.println("Zentzua: " + j1.getZentzua());
		assertEquals(j1.getZentzua(), 1);
	}
	
	
	@Test
	public void testGetZentzua() {
		//zentzua 0 hasieratzen dela dakigunez, horrekin frogatuko dugu funtzionamendua
		assertEquals(0, j1.getZentzua() );
		
	}
	
	@Test
	public void testErreseteatu() {
		//zentzua 0 hasieratzen dela dakigunez, horrekin frogatuko dugu funtzionamendua
		assertEquals(0, j1.getZentzua() );
		
	}

}
