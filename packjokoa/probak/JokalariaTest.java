package probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import klaseak.*;

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
	public void test4NireTableroaBete() {
		//metodo hau konprobatzeko ez dago assert-erik, kontsolan konprobatzen dugu guk, metodo hau bera inprimatzen du tableroa ez dugu inprimatu metodoa deitu behar
		System.out.println(" Konprobatu tableroa bete dela uraz (' -')");
		j1.inprimatuNireTableroa();//metodo hau bikoteJokalariak klasean erabiltzen dugu eta nire tableroa inprimatzen du, kontslatik konprobatzen da
		System.out.println(" ");
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
		/*
		 *KoordenatuanZerDagoen nireTableroan begiratuko du kasilan zer dagoen, itsasontzia baldin badago " U" bueltatzen du, bestela, han dagoena, hau da, ura "-"
		 *Frogatu behar da lehenengoz tableroa urez " -" beteta dagoenenan " -" bueltatzen duela eta itsasontzi bat dagoenean ( " 1", " 2", " 3" edo " 4" ) " U" bueltatzen duela
		 */
//	1		
		//hasieran uraz - beteta dago
		String ema = j1.koordenatuanZerDagoen((short)1,(short) 1);
		assertEquals(" -" , ema);
		
		//koordenatu horretan " 1" jarriko dugu eta metodoa " U" buletatuko du
			//kordenatuanJarri metodoak +1 egiten dio sartutako kordenatuari, beraz -1 egingo diot nik nahi dudan koordenatuan egin dezan
		j1.koordenatuanJarri(1-1, 1-1, " 1"); 
		ema = j1.koordenatuanZerDagoen((short)1,(short) 1);
		assertEquals(" U" , ema);	
//	2
		//hasieran uraz - beteta dago
		ema = j1.koordenatuanZerDagoen((short)5,(short) 1);
		assertEquals(" -" , ema);
				
		//koordenatu horretan " 2" jarriko dugu eta metodoa " U" buletatuko du
		j1.koordenatuanJarri(5-1, 1-1, " 2");
		ema = j1.koordenatuanZerDagoen((short)5,(short) 1);
		assertEquals(" U" , ema);
//  3
		//hasieran uraz - beteta dago
		ema = j1.koordenatuanZerDagoen((short)7,(short) 2);
		assertEquals(" -" , ema);
		
		//koordenatu horretan " 3" jarriko dugu eta metodoa " U" buletatuko du
		j1.koordenatuanJarri(7-1, 2-1, " 3");		
		ema = j1.koordenatuanZerDagoen((short)7,(short) 2);
		assertEquals(" U" , ema);
//  4
		//hasieran uraz - beteta dago
		ema = j1.koordenatuanZerDagoen((short)9,(short) 3);
		assertEquals(" -" , ema);
		
		//koordenatu horretan " 4" jarriko dugu eta metodoa " U" buletatuko du
		j1.koordenatuanJarri(9-1, 3-1, " 4");		
		ema = j1.koordenatuanZerDagoen((short)9,(short) 3);
		assertEquals(" U" , ema);		
	}

	@Test
	public void test6KoordenadaBaliogarriak() {
		/*
		 *Ondo funtzionatzen duela frogatzeko, honakoa egin behar da:
		 *Print tableroan begiratzen du, hau da, tiroak egin ostean lortutakoa gordetzen den tableroan.
		 *Tablero hori hasieran tableroa " -" (uraz) betea egongo da, honek esan nahi du ez direla tiroak egin, eta koordenatu guztiak baliogarriak direla.
		 *Jolasan zehar uraz " -", ukitutako itsasontziz " U", eta hutz egindako tiroz " X", betea egongo da.
		 *Kordenatu batean " U" edo " X" egonda, koordenada hori ez da baliogarria izango
		 *
		*/
	
//	1	
			//hasieran uraz - beteta dago, beraz koordenatu horretan " -" dagoela dakigu, hau da koordenada baligarria dela, eta metodoa TRUE bueltatuko du	
		assertTrue(j1.koordenadaBaliogarriak( (short)1,(short) 1) );
			//koordenatu horretan " 1" jarriko dugu beraz koordenadaBaliogarriak FALSE bueltatuko du
		j1.koordenatuanJarriPrint(1-1, 1-1, " U");
		assertFalse(j1.koordenadaBaliogarriak(  (short)1,(short) 1) );		
		
//	2
			//hasieran uraz - beteta dago, BERAZ kordenatua baliogarria da TRUE		
		assertTrue(j1.koordenadaBaliogarriak( (short)5,(short) 1) );
				
			//koordenatu horretan " 2" jarriko dugu, beraz FALSE bueltatuko du
		j1.koordenatuanJarriPrint(5-1, 1-1, " U");
		assertFalse(j1.koordenadaBaliogarriak( (short)5,(short) 1)  );
		
//  3
		//hasieran uraz - beteta dago, BERAZ kordenatua baliogarria da TRUE		
		assertTrue(j1.koordenadaBaliogarriak( (short)7,(short) 2) );
		
		//koordenatu horretan " 3" jarriko dugu, beraz FALSE bueltatuko du
		j1.koordenatuanJarriPrint(7-1, 2-1, " X");
		assertFalse(j1.koordenadaBaliogarriak(  (short)7,(short) 2) );		


//  4
		//hasieran uraz - beteta dago, BERAZ kordenatua baliogarria da TRUE		
		assertTrue(j1.koordenadaBaliogarriak( (short)9,(short) 3) );
		
		//koordenatu horretan " 4" jarriko dugu, beraz FALSE bueltatuko du
		j1.koordenatuanJarriPrint(9-1, 3-1, " X");
		assertFalse(j1.koordenadaBaliogarriak( (short)9,(short) 3) );	
	}

	@Test
	public void test7EguneratuPrintTableroa() {		
		/*
		 *  String-a  " U" bada, ukituen zenbakia (nUkituta) unitate batean inkrementatuko du.
		 * " U" bada printTableroan dagokion posizioan sartuko du, beste kasuetan " X" sartuko du.
		 *Azkenik printTableroa inprimatuko du 
		 */
// " -" sartuko dut, nUkituta berdin mantenduko da eta koordenatu horretan " X" jarriko da		
		//nUkituta 0n hasieratzen dela dakigu
		int ukituta= j1.getNUkituta();
		assertEquals( 0, ukituta);	
		System.out.println( " Konprobatu (0,0) koordenatuan X bat dagoela"); //inprimatzen den indizea benetan sartutako indizea-1 da, matrizea 10*10 eko ez delako, 11*11 delako, indizeak matrizearen barruan daudelako.
		j1.eguneratuPrintTableroa( (short)1,(short) 1, " -" );	
		System.out.println(" ");
		ukituta= j1.getNUkituta();//0n hasieratzen da
		assertEquals( 0, ukituta);
// " U" sartuko dut, nUkituta inkrementatuko da eta koordenatu horretan " U" jarriko da	
		System.out.println( " Konprobatu (0,0) koordenatuan U bat dagoela");
		j1.eguneratuPrintTableroa( (short)1,(short) 1, " U" );	
		System.out.println(" ");
		ukituta= j1.getNUkituta();
		assertEquals( 1, ukituta);
		
// " -" sartuko dut, nUkituta berdin mantenduko da eta koordenatu horretan " X" jarriko da
		System.out.println( " Konprobatu (6,8) koordenatuan X bat dagoela");
		j1.eguneratuPrintTableroa( (short)7,(short) 9, " -" );
		System.out.println(" ");
		ukituta= j1.getNUkituta();
		assertEquals( 1, ukituta);
		
// " U" sartuko dut, nUkituta inkrementatuko da eta koordenatu horretan " U" jarriko da	
		System.out.println( " Konprobatu (4,2) koordenatuan U bat dagoela");
		j1.eguneratuPrintTableroa( (short)5,(short) 3, " U" );	
		System.out.println(" ");
		ukituta= j1.getNUkituta();
		assertEquals( 2, ukituta);
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
		ukituta= j1.getNUkituta();
		assertEquals( 3, ukituta);
		
		//beste balio bat jarriko diogu		
		j1.setNUkituta(5);
		ukituta= j1.getNUkituta();
		assertEquals( 5, ukituta);		
	}

	@Test
	public void test10SetNUkituta() {
		int ukituta= j1.getNUkituta();//0 hasieratzen da
		assertEquals( 0, ukituta);
		
		//beste balio bat jarriko diogu		
		j1.setNUkituta(4);
		ukituta= j1.getNUkituta();
		assertEquals( 4, ukituta);
		
		//beste balio bat jarriko diogu		
		j1.setNUkituta(6);
		ukituta= j1.getNUkituta();
		assertEquals( 6, ukituta);
	}
	
	@Test
	public void test11KoordenatuanJarri() {
		//koordenatuanJarri NireTablero matrizean aukeratutako koordenatu7an jartzen du nahi dugun karakterea, 
		//funtzinamendua frogatzeko koordenatuanZerDagoen metodoa erabiliko dut, metodo honek  NireTableroan begiratuko du kasilan zer dagoen, itsasontzia baldin badago " U" bueltatzen du, bestela, han dagoena, hau da, ura "-"		
			
		//hasieran uraz - beteta dago, beraz TRUE bueltatuko du
			String ema = j1.koordenatuanZerDagoen((short)2,(short) 2);
			assertEquals(" -" , ema);
			
			//koordenatu horretan " 1" jarriko dugu eta metodoa " U" buletatuko du
				//kordenatuanJarri metodoak +1 egiten dio sartutako kordenatuari, beraz -1 egingo diot nik nahi dudan koordenatuan egin dezan
			j1.koordenatuanJarri(2-1, 2-1, " 1"); 
			ema = j1.koordenatuanZerDagoen((short)2,(short) 2);
			assertEquals(" U" , ema);
	}
	@Test
	public void test12KoordenatuanJarriPrint() {
		//KoordenatuanJarriPrint printTableroan aukeratutako koordenatuan jartzen du nahi dugun karakterea, 
		//koordenadaBaliogarriak erabiliko dut frogak egiteko
		
			//hasieran uraz - beteta dago
		boolean ema = j1.koordenadaBaliogarriak((short)3,(short) 3);
		assertTrue( ema);
		
		//koordenatu horretan " U" jarriko dugu eta metodoa FALSE
		//kordenatuanJarri metodoak +1 egiten dio sartutako kordenatuari, beraz -1 egingo diot nik nahi dudan koordenatuan egin dezan
	j1.koordenatuanJarriPrint(3-1, 3-1, " U"); 
	ema = j1.koordenadaBaliogarriak((short)3,(short) 3);
	assertFalse( ema);
	
		//koordenatu horretan " X" jarriko dugu eta metodoa FALSE
		//kordenatuanJarri metodoak +1 egiten dio sartutako kordenatuari, beraz -1 egingo diot nik nahi dudan koordenatuan egin dezan
	j1.koordenatuanJarriPrint(3-1, 3-1, " X"); 
	ema = j1.koordenadaBaliogarriak((short)3,(short) 3);
	assertFalse( ema);
		
	}
		@Test
	public void test13eguneratuNireTableroa() {
			/*
			 * koordenatuanZerDagoen itzuli duen String-a  
			 * " U" (itsasontzia dago) bada nireTableroan dagokion posizioan sartuko du, beste kasuetan " X" sartuko du.
			 *inprimatuNireTableroaerabiliko dt frogatzeko kontsolaz
			*/
			System.out.println( " Konprobatu (3,3) koordenatuan U bat dagoela");
			j1.eguneratuNireTableroa( (short)4, (short) 4, " U"); //gogoratu matrizearen indizeak matrizearen barne daudela!
			j1.inprimatuNireTableroa();
			
			System.out.println( " Konprobatu (3,3) koordenatuan X bat dagoela");
			j1.eguneratuNireTableroa( (short)4, (short) 4, " -"); //gogoratu matrizearen indizeak matrizearen barne daudela!
			j1.inprimatuNireTableroa();
	}
}
