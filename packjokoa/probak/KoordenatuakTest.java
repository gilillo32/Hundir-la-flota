package probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packjokoa.Koordenatuak;

public class KoordenatuakTest {
	private Koordenatuak k, k1;

	@Before
	public void setUp() throws Exception {
		k = new Koordenatuak();
		k1 = new Koordenatuak((short)1, (short)1);
	}

	@After
	public void tearDown() throws Exception {
		k=null;
		k1=null;
	}

	@Test
	public void testKoordenatuak() {
		assertNotNull(k);
	}

	@Test
	public void testKoordenatuakShortShort() {
		assertNotNull(k1);
	}

	@Test
	public void testSetKoordenatuakX() {
		short x = k.getKoordenatuakX();		
		assertEquals((short)-1, x); //hasierako balioa		
		
		k.setKoordenatuakX((short) 2);
		x = k.getKoordenatuakX();	
		assertEquals((short)2, x);
	}

	@Test
	public void testGetKoordenatuakX() {
		short x = k1.getKoordenatuakX();		
		assertEquals((short)1, x); //hasierako balioa		
	}

	@Test
	public void testSetKoordenatuakY() {
		short y = k.getKoordenatuakY();
		assertEquals((short)-1, y);//hasierako balioa
		
		k.setKoordenatuakY((short) 2);
		y = k.getKoordenatuakY();
		assertEquals((short)2, y);
	}

	@Test
	public void testGetKoordenatuakY() {
		short y = k1.getKoordenatuakY();
		assertEquals((short)1, y);
	}

}
