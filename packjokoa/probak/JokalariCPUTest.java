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
	public void testItsasontziakJarri1(){
		//amaituta ETA ONDO, LEIRE
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
	public void testItsasontziakJarri2(){
		//amaituta ETA ONDO, LEIRE
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
	
	/*@Test
	public void testItsasontziakJarri3(){
		//amaituta ETA ONDO, LEIRE
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
		
		///////////////////////////////////////////////////////////
		System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-\n");
		System.out.println("Bigarren kasua: zentzua ez du lehenengoan aurkituko, bigarrenean baizik");
		j1.erreseteatu();
		//Orain, zentzua aldatzera behartuko dugu, lehenengo aldiz ukituko du eta itsasontzia bertikalean egongo da:
		Koordenatuak k1 = new Koordenatuak();
		k1 = j1.koordenatuaAukeratu(k1, false);
		previousK = k1;
		System.out.println("Lehenengo aldiz randomly aukeratutako koordenatuak hauexek dira:\n" + k1.getKoordenatuakX() + "\n" + k1.getKoordenatuakY());
		k1 = j1.koordenatuaAukeratu(k1, true);
		System.out.println("Lehenengo koordenatua asmatu duenez, eskuinerantz saiakera egin duela konprobatuko dugu:\n" + k1.getKoordenatuakX() + "\n" + k1.getKoordenatuakY());
		k1 = j1.koordenatuaAukeratu(k1, false);
		System.out.println("Eskuinerantz saiatzen ura aurkitu duenez, orain gorantz saiatuko da:\n" + k1.getKoordenatuakX() + "\n" + k1.getKoordenatuakY());
	}*/
	
	@Test
	public void testKoordenatuaAukeratu1() {
		//badaki zentzua	
		j1.erreseteatu();
		Koordenatuak k = new Koordenatuak((short)(4),(short)(3)); 
		Koordenatuak k1=j1.koordenatuaAukeratu(k, true);//6,3 ITZULI
		j1.eguneratuPrintTableroa((short)(6),(short)(4), " X");
		System.out.println("Eskuinerantz saiatzen ura aurkitu duenez, orain gorantz saiatuko da:\n" + k1.getKoordenatuakX() + "\n" + k1.getKoordenatuakY());
		Koordenatuak k2=j1.koordenatuaAukeratu(k1, false);
		System.out.println(j1.getZentzua());
		System.out.println("Eskuinerantz saiatzen ura aurkitu duenez, orain gorantz saiatuko da:\n" + k2.getKoordenatuakX() + "\n" + k2.getKoordenatuakY());
		Koordenatuak k3=j1.koordenatuaAukeratu(k2, false);
		System.out.println(j1.getZentzua());
		Koordenatuak k4=j1.koordenatuaAukeratu(k3, true);///zentzua asmatuta 2 da
		System.out.println(j1.getZentzua());

		//konprobatuko dugu ea koordenatua 4,1 den
		Koordenatuak k5 = new Koordenatuak((short)(3),(short)(3)); 
		assertEquals(k5.getKoordenatuakX(),k4.getKoordenatuakX());
		assertEquals(k5.getKoordenatuakY(),k4.getKoordenatuakY());
	} 
	/*
	@Test
	public void testKoordenatuaAukeratu2() {
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
	public void testKoordenatuaAukeratu3() {
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
	public void testGetZentzua() {
		//zentzua 0 hasieratzen dela dakigunez, horrekin frogatuko dugu funtzionamendua
		assertEquals(0, j1.getZentzua() );
		
	}
	
	@Test
	public void testErreseteatu() {
		//zentzua 0 hasieratzen dela dakigunez, horrekin frogatuko dugu funtzionamendua
		assertEquals(0, j1.getZentzua() );
		
	}*/

}
