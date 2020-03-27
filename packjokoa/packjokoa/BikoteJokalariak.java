package packjokoa;

import salbuespenak.OrientazioExc;

public class BikoteJokalariak {
	//atributuak:
	private JokalariArrunta j1;
	private JokalariCPU j2;
	private static BikoteJokalariak nireBikoteJokalariak = null;
	
	//eraikitzailea (Singleton):
	private BikoteJokalariak(JokalariArrunta pJ1, JokalariCPU pJ2) {
		this.j1 = pJ1;
		this.j2 = pJ2;
	}
	
	public static synchronized BikoteJokalariak getNireBikoteJokalariak(JokalariArrunta pJ1, JokalariCPU pJ2) {
		if(BikoteJokalariak.nireBikoteJokalariak==null) {
			BikoteJokalariak.nireBikoteJokalariak=new BikoteJokalariak(pJ1,pJ2);
		} 
		return BikoteJokalariak.nireBikoteJokalariak;
	}
	
	//gainontzeko metodoak:
	
	public void partidaBatJokatu() {
		
	}
	
	public void itsasontziakJarri() {
		
	}
	public boolean partidaBukatu() {
		// bi jokalarien tableroak begiratzen ditu eta 
		// ez badago itsasontzirik, partida amaitzen da.
		// itsasontzirikEz() erabiliko da jokalarien tableroak ikusteko.
	}
	public void txandaBatJolastu() {
		
	}
	
	public void jokalariakInskribatu() {
		//lehenengo jokalariaren izena jarri
		System.out.println("Sartu zure izena: ");
		String izena = Teklatua.getNireTeklatua().irakurriString();
		this.j1.setIzena(izena);
		
		/*//bigarren jokalariari izena jarri 								BIGARREN MAILAKO ATAZA
		 * System.out.println("Sartu zure izena: ");
		String izena = Teklatua.getNireTeklatua().irakurriString();
		this.j2.setIzena(izena);
		 */
	}
	
	public static void main (String [ ] args) 	{	
		System.out.println("kAIXO LAGUN!");
		
		BikoteJokalariak.getNireBikoteJokalariak(pJ1, pJ2)
	}
	
}
