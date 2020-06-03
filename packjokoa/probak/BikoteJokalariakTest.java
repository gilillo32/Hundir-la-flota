package probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import klaseak.BikoteJokalariak;
import klaseak.JokalariArrunta;
import klaseak.JokalariCPU;
public class BikoteJokalariakTest {
	private static BikoteJokalariak bikoteJokalariak;

	@Before
	public void setUp() throws Exception {
		bikoteJokalariak=BikoteJokalariak.getNireBikoteJokalariak();
		bikoteJokalariak.getZerrenda()[0]= new JokalariArrunta("gaizka" , (short) 10 );
		bikoteJokalariak.getZerrenda()[1]= new JokalariCPU((short)10);
		
	}

	@After
	public void tearDown() throws Exception {
		bikoteJokalariak=null;

	}

	@Test
	public void testGetNireBikoteJokalariak() {
		assertEquals(bikoteJokalariak,BikoteJokalariak.getNireBikoteJokalariak());
	}
	
	@Test
	public void getPartidaBukatu(){
		//aztertutako kasua da, jokalaria arrunta itsasontzi guztiak hondoratu dituela, hau da nUkituta=10.
		bikoteJokalariak.getZerrenda()[0].setNUkituta(9);
		bikoteJokalariak.getZerrenda()[0].eguneratuPrintTableroa((short)2, (short)2, " U");
		//konprobatu egingo dugu getNUKituta
		assertEquals(10, bikoteJokalariak.getZerrenda()[0].getNUkituta());
		bikoteJokalariak.getZerrenda()[1].setNUkituta(2);
		assertTrue(bikoteJokalariak.getPartidaBukatu());
		
		//aztertuko dugun kasua alderantzizkoa izango da kasu honetan cpu nUkituta=10
		bikoteJokalariak.getZerrenda()[0].setNUkituta(7);
		bikoteJokalariak.getZerrenda()[0].eguneratuPrintTableroa((short)2, (short)2, " U");
		bikoteJokalariak.getZerrenda()[1].setNUkituta(9);
		bikoteJokalariak.getZerrenda()[1].eguneratuPrintTableroa((short)2, (short)2, " U");
		assertTrue(bikoteJokalariak.getPartidaBukatu());
		//biak nUkituta != 10, hau da jokoa ez da amaitu.
		bikoteJokalariak.getZerrenda()[0].setNUkituta(7);
		bikoteJokalariak.getZerrenda()[0].eguneratuPrintTableroa((short)2, (short)2, " U");
		bikoteJokalariak.getZerrenda()[1].setNUkituta(6);
		bikoteJokalariak.getZerrenda()[1].eguneratuPrintTableroa((short)2, (short)2, " U");
		assertFalse(bikoteJokalariak.getPartidaBukatu());
		//kasu honetan emaitza ez da izango =" U"
		bikoteJokalariak.getZerrenda()[0].setNUkituta(7);
		bikoteJokalariak.getZerrenda()[0].eguneratuPrintTableroa((short)2, (short)2, " X");
		bikoteJokalariak.getZerrenda()[1].setNUkituta(9);
		bikoteJokalariak.getZerrenda()[1].eguneratuPrintTableroa((short)2, (short)2, " U");
		assertTrue(bikoteJokalariak.getPartidaBukatu());
		
	}
	
	@Test
	public void konprobatuItsasontziak(){
		bikoteJokalariak.getItsasontziak();
	}
	
	@Test
	public void konprobatuKoord(){
		bikoteJokalariak.getKoordenatuaaukeratu();
	}
	
	@Test
	public void testPartidaBatJokatu() {
		bikoteJokalariak.partidaBatJokatu();
	}
	
	



}
