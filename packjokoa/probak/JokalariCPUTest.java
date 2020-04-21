package probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import klaseak.JokalariCPU;
import klaseak.Jokalaria;
import klaseak.Koordenatuak;
import salbuespenak.*;

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
/*
	@Test
	public void testItsasontziakJarri1(){
		System.out.println("Sartuko dugu ' 1'-eko itsasontsi bat 1, 1 koordenatuan CPU kordenatu horretan itsasontsirik ez jartzen behartzeko eta alboko koordenatuetan");
		System.out.println("Kordenatu hauetan ezin izang du itsasotzirik jarri: (0,0), (0,1), (0,2), (1,0), (1,2), (2,0), (2,1), (2,2) ");
		j1.itsasontziakJarri(10);			
	}

	@Test
	public void testItsasontziakJarri2(){
		
		j1.itsasontziakJarri(10);			
	}
	
	@Test
	public void testItsasontziakJarri3(){
		
		j1.itsasontziakJarri(10);			
	}
*/
	@Test
	public void testJokalariCPU() {
		assertNotNull(j1);
	}

	@Test
	public void testKoordenatuaAukeratu() {
		boolean emaitza= false;
		Koordenatuak k= new Koordenatuak();
		//Aurrean ez du asmatu, auzazko koordenatua bueltatezen du
		k = j1.koordenatuaAukeratu(k, false);
		assertNotNull(k);
		if (k.getKoordenatuakX()<10 && k.getKoordenatuakX()>-1) {
			
			if (k.getKoordenatuakY() <10 && k.getKoordenatuakY()>-1 ) {
				emaitza=true;
			}
		}
		assertTrue(emaitza);
		
		//Aurrekoan asmatu du, aurreko txandan esan duen koordenatuaren alboko kordenatua esango du
			//hainbat kasu daude
		//Itsasontsi baten bi kasila asmatu baditu, itsasontsiaren zentzua asmatu du eta zentzu horretan bilatuko du
			//ura aurkitzen duenenen kontrako zentzuan begiratuko du lehenengo asmakizunetik(koordenatu horretatik)
		
	}

}
