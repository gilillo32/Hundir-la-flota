package probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packjokoa.JokalariArrunta;

public class JokalariArruntaTest {

	private JokalariArrunta j1; //, j2;
	@Before
	public void setUp() throws Exception {
		j1= new JokalariArrunta("lei",(short) 10);
		//j2= new JokalariArrunta("pau",(short) 10);
	}

	@After
	public void tearDown() throws Exception {
		j1=null;
		//j2=null;
	}

	@Test
	public void test1ItsasontziakJarri() {
		System.out.println("Metodo hau konprobatzeko kontsolatik egin behar da, eta hainbat kasu ffrgatu behar dira, ikusteko exception egokiak botatzen duela etab egin behar duenean");
		System.out.println("Leheneng testa");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontsiak ordenean jartzen direla.");
		System.out.println("-Itsasontsiak ondo jarri behar ditugu (jarriko ditugu errorerik emango ez dituen koordenatuetan)");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void test2ItsasontziakJarri() {
		System.out.println("Metodo hau konprobatzeko kontsolatik egin behar da, eta hainbat kasu ffrgatu behar dira, ikusteko exception egokiak botatzen duela etab egin behar duenean");
		System.out.println("Bigarren testa");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontsiak ordenean jartzen direla.");
		System.out.println("-Itsasontsiren bat jada itsasontsi bat jarri dugun koordenatuan jartzen saituko gara eta exception bat botako du, KoordenatuEzEgokiak deitu duguna, eta koordenatu berriak sartzeko eskatuko du.");
		j1.itsasontziakJarri(10);
	}
	
	@Test
	public void test3ItsasontziakJarri() {
		System.out.println("Metodo hau konprobatzeko kontsolatik egin behar da, eta hainbat kasu ffrgatu behar dira, ikusteko exception egokiak botatzen duela etab egin behar duenean");
		System.out.println("Hirugarren testa");
		System.out.println("Hau da frogatu beharrekoa test honetan:");
		System.out.println("-Proba guztietan: Itsasontsiak ordenean jartzen direla.");
		System.out.println("-Itsasontsiren bat Tableroan ez dagoen koordenatu batTableroan ez dagoen koordenatu bat");
		j1.itsasontziakJarri(10);
	}

	@Test
	public void testJokalariArrunta() {
		assertNotNull(j1);
	}

	@Test
	public void testKoordenatuaAukeratu() {
		fail("Not yet implemented");
		//hemos puesto que lo comprobamos en la konsla, pero para eso tenemos que hacer un metodo que imprima las koordenadas, no? 
	}

}
