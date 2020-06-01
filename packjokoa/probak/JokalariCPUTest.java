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
	
	@Test
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
	public void testKoordenatuaAukeratu() {
		Koordenatuak k = new Koordenatuak();
		Koordenatuak previousK = new Koordenatuak();
		//////////////////////////////////////////////////////////
		//Aurrean ez du asmatu, auzazko koordenatua bueltatezen du
		k = j1.koordenatuaAukeratu(k, false);
		previousK = k;
		assertNotNull(k);
		System.out.println("////////////////////////////////\nKoordenatuen probak:");
		System.out.println("Lehenengo aldiz randomly aukeratutako koordenatuak hauexek dira:\n" + k.getKoordenatuakX() + "\n" + k.getKoordenatuakY());
		//--------------------------------------------------
		//Aurrekoan asmatu du, aurreko txandan esan duen koordenatuaren alboko kordenatua esango du
			//hainbat kasu daude
		//Aurrekoan asmatu lehenengo aldiz:
		k = j1.koordenatuaAukeratu(k, true);
		System.out.println("Aurreko koordenatuak hauek ziren:\n" + previousK.getKoordenatuakX() + "\n" + previousK.getKoordenatuakY() + "\nEta koordenatu hori lehenengo aldiz asmatu ostean hauexek dira aukeratutakoak:\n" + k.getKoordenatuakX() + "\n" + k.getKoordenatuakY());
		previousK = k;
		//Aurrekoan asmatu bigarren aldiz baina oraingoan ez, beraz, zentzua aldatuko du:
		k = j1.koordenatuaAukeratu(k, true);
		System.out.println("Aurreko koordenatuak hauek ziren:\n" + previousK.getKoordenatuakX() + "\n" + previousK.getKoordenatuakY() + "\nEta koordenatu hori bigarren aldiz asmatu ostean hauexek dira aukeratutakoak:\n" + k.getKoordenatuakX() + "\n" + k.getKoordenatuakY());
		//Itsasontzi baten bi kasila asmatu baditu, itsasontsiaren zentzua asmatu du eta zentzu horretan bilatuko du
			//ura aurkitzen duenenen kontrako zentzuan begiratuko du lehenengo asmakizunetik(koordenatu horretatik)
		
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
