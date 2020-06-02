package probak;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import klaseak.JokalariArrunta;
import klaseak.Koordenatuak;

public class JokalariArruntaTest {

	private JokalariArrunta j1; 
	@Before
	public void setUp() throws Exception {
		j1= new JokalariArrunta("lei",(short) 10);
		
	}

	@After
	public void tearDown() throws Exception {
		j1=null;
	}

	//hay que imprimir la matriz vacia
	
	@Test
	public void testItsasontziakJarri01() {
		System.out.println("\nMetodoa testean: itsasontziakJarri1");
		System.out.println("\nMetodo hau konprobatzeko kontsolatik egin behar da, eta hainbat kasu frogatu behar dira, ikusteko exception egokiak botatzen duela etab egin behar duenean");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontsiak ordenean jartzen direla.");
		System.out.println("-Itsasontziak ondo jarri behar ditugu (jarriko ditugu errorerik emango ez dituen koordenatuetan)");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void testItsasontziakJarri02() {
		System.out.println("\nMetodoa testean: itsasontziakJarri2");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontsiak ordenean jartzen direla.");
		System.out.println("-Itsasontziren bat jada itsasontzi bat jarri dugun koordenatuan jartzen saituko gara eta exception bat botako du, KoordenatuEzEgokiak deitu duguna, eta koordenatu berriak sartzeko eskatuko du.");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void testItsasontziakJarri03() {
		System.out.println("\nMetodoa testean: itsasontziakJarri3");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontziak ordenean jartzen direla.");
		System.out.println("-Itsasontziren bat Tableroan ez dagoen koordenatu batean jartzen bada, Exception egokia saltatuko dela.\n Beraz, itsasontziren bat tablerotik at jartzen saiatuko gara.");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void testItsasontziakJarri04() {
		System.out.println("\nMetodoa testean: itsasontziakJarri4");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontziak ordenean jartzen direla.");
		System.out.println("-Orain, itsasontzi guztiak bertikalean jar ditzakegula frogatuko dugu, B letra LARRIZ. Ondo jarriko ditugu itsasontziak.");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void testItsasontziakJarri05() {
		System.out.println("\nMetodoa testean: itsasontziakJarri5");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontziak ordenean jartzen direla.");
		System.out.println("-Orain, itsasontzi guztiak bertikalean jar ditzakegula frogatuko dugu, b letra xehez. Ondo jarriko ditugu itsasontziak.");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void testItsasontziakJarri06() {
		System.out.println("\nMetodoa testean: itsasontziakJarri6");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontziak ordenean jartzen direla.");
		System.out.println("-Orain, itsasontzi guztiak horizontalean jar ditzakegula frogatuko dugu, H letra LARRIZ. Ondo jarriko ditugu itsasontziak.");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void testItsasontziakJarri07() {
		System.out.println("\nMetodoa testean: itsasontziakJarri7");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontziak ordenean jartzen direla.");
		System.out.println("-Orain, itsasontzi guztiak horizontalean jar ditzakegula frogatuko dugu, h letra xehez. Ondo jarriko ditugu itsasontziak.");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void testItsasontziakJarri08() {
		System.out.println("\nMetodoa testean: itsasontziakJarri8");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontziak ordenean jartzen direla.");
		System.out.println("-Orain, itsasontzi guztiak bertikalean jar ditzakegula frogatuko dugu, B letra LARRIZ. Koordenatu egoki bat sartuko dugu baina orientazioa jartzean tablerotik aterako da.");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void testItsasontziakJarri09() {
		System.out.println("\nMetodoa testean: itsasontziakJarri9");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontziak ordenean jartzen direla.");
		System.out.println("-Orain, itsasontzi guztiak bertikalean jar ditzakegula frogatuko dugu, b letra xehez. Koordenatu egoki bat sartuko dugu baina orientazioa jartzean tablerotik aterako da.");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void testItsasontziakJarri10() {
		System.out.println("\nMetodoa testean: itsasontziakJarri10");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontziak ordenean jartzen direla.");
		System.out.println("-Orain, itsasontzi guztiak horizontalean jar ditzakegula frogatuko dugu, H letra LARRIZ. Koordenatu egoki bat sartuko dugu baina orientazioa jartzean tablerotik aterako da.");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void testItsasontziakJarri11() {
		System.out.println("\nMetodoa testean: itsasontziakJarri11");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontziak ordenean jartzen direla.");
		System.out.println("-Orain, itsasontzi guztiak horizontalean jar ditzakegula frogatuko dugu, h letra xehez. Koordenatu egoki bat sartuko dugu baina orientazioa jartzean tablerotik aterako da.");
		j1.itsasontziakJarri(10);
	}
	
	 
	//koordenatuakAukeratu:
	
	@Test
	public void koordenatuakAukeratuTest() {
		System.out.println("\nMetodo hau konprobatzeko kontsolatik egin behar da, eta hainbat kasu frogatu behar dira, ikusteko exception egokiak botatzen duela etab egin behar duenean");
		System.out.println("koordenatuakAukeratuLehenengo testa" + "\nHau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Bi parametro eskatzen direla: Zutabea eta errenkada, orden horretan.");
		System.out.println("-0 eta 9 (biak barne) arteko zenbakiak aukeratu ahal ditugula errorerik gabe.");
		System.out.println("Guk sartutako koordenatuak era egokian bueltatzen direla.");
		Koordenatuak k = new Koordenatuak();
		k = j1.koordenatuaAukeratu();
		System.out.println("Esandako koordenatuak hurrengoak dira:\nZutabea: " + k.getKoordenatuakX() + "\nErrenkada: " + k.getKoordenatuakY());
	}

/*	@Test
	public void testJokalariArrunta() {
		assertNotNull(j1);
	}

	@Test
	public void testKoordenatuaAukeratu() {
		fail("Not yet implemented");
		//hemos puesto que lo comprobamos en la konsla, pero para eso tenemos que hacer un metodo que imprima las koordenadas, no? 
	}
*/
}
