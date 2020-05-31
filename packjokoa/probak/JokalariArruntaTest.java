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
	public void testItsasontziakJarri1() {
		System.out.println("Metodo hau konprobatzeko kontsolatik egin behar da, eta hainbat kasu frogatu behar dira, ikusteko exception egokiak botatzen duela etab egin behar duenean");
		System.out.println("Lehenengo testa");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontsiak ordenean jartzen direla.");
		System.out.println("-Itsasontziak ondo jarri behar ditugu (jarriko ditugu errorerik emango ez dituen koordenatuetan)");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void testItsasontziakJarri2() {
		System.out.println("Metodo hau konprobatzeko kontsolatik egin behar da, eta hainbat kasu frogatu behar dira, ikusteko exception egokiak botatzen duela etab egin behar duenean");
		System.out.println("Bigarren testa");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontsiak ordenean jartzen direla.");
		System.out.println("-Itsasontziren bat jada itsasontsi bat jarri dugun koordenatuan jartzen saituko gara eta exception bat botako du, KoordenatuEzEgokiak deitu duguna, eta koordenatu berriak sartzeko eskatuko du.");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void testItsasontziakJarri3() {
		System.out.println("Metodo hau konprobatzeko kontsolatik egin behar da, eta hainbat kasu frogatu behar dira, ikusteko exception egokiak botatzen duela etab egin behar duenean");
		System.out.println("Hirugarren testa");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontziak ordenean jartzen direla.");
		System.out.println("-Itsasontziren bat Tableroan ez dagoen koordenatu batean jartzen bada, Exception egokia saltatuko dela.\n Beraz, itsasontziren bat tablerotik at jartzen saiatuko gara.");
		j1.itsasontziakJarri(10);
	}
	
	 
	//koordenatuakAukeratu:
	
	@Test
	public void koordenatuakAukeratuTest() {
		System.out.println("Metodo hau konprobatzeko kontsolatik egin behar da, eta hainbat kasu frogatu behar dira, ikusteko exception egokiak botatzen duela etab egin behar duenean");
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
