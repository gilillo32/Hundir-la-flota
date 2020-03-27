package packjokoa;
import java.util.*;
import salbuespenak.OrientazioExc;

public class BikoteJokalariak {
	//atributuak:
	private Jokalaria[] zerrenda;
/*	private JokalariArrunta j1;
	private JokalariCPU j2;    */
	private static BikoteJokalariak nireBikoteJokalariak = null;
	
	//eraikitzailea (Singleton):
	private BikoteJokalariak() {   //JokalariArrunta pJ1, JokalariCPU pJ2
		this.zerrenda = new Jokalaria [2];
	}
	
	public static synchronized BikoteJokalariak getNireBikoteJokalariak() {
		if(BikoteJokalariak.nireBikoteJokalariak==null) {
			BikoteJokalariak.nireBikoteJokalariak=new BikoteJokalariak();
		} 
		return BikoteJokalariak.nireBikoteJokalariak;
	}
	
	//gainontzeko metodoak:
	
	public void partidaBatJokatu() {
		while (!this.partidaBukatu()) {
			this.txandaBatJolastu();			
		}
	
			//inprimatu nork irabazi duen
		if (zerrenda[0].itsasontzirikEz() && zerrenda[1].itsasontzirikEz()) {
			System.out.println("BERDINKETA");
		}
		else if(zerrenda[0].itsasontzirikEz()) {
			System.out.println("ZORIONAK " + zerrenda[0].getIzena() + "IRABAZI DUZU!!!!   :)  <3 ");
		}
		else {
			System.out.println("GAME OVER " + zerrenda[0].getIzena() + "GALDU DUZU!!!!  :(    ");
		}
	}
	
	
	
	
	
	public void itsasontziakJarri() {
		
	}
	
	
	
	
	
	public boolean partidaBukatu() {
		// bi jokalarien tableroak begiratzen ditu eta 
		// ez badago itsasontzirik, partida amaitzen da.
		// itsasontzirikEz() erabiliko da jokalarien tableroak ikusteko.
		boolean ema=false;
		if(zerrenda[0].itsasontzirikEz()) {
			ema= true;
		}
		else if (zerrenda[1].itsasontzirikEz()) {
			ema= true;
		}
		
		return ema;
	}
	
	
	
	
	
	public void txandaBatJolastu() {
		
	}
	

	
	
	
	public static void main (String [ ] args) 	{	
		
		System.out.println("kAIXO LAGUN!");
		System.out.println("ONGI ETORRI!");
		System.out.println("Sartu zure izena: ");
		String izena = Teklatua.getNireTeklatua().irakurriString();
		short i=10;		
		BikoteJokalariak.getNireBikoteJokalariak().zerrenda[0] = new JokalariArrunta(izena, i );
		BikoteJokalariak.getNireBikoteJokalariak().zerrenda[1] = new JokalariCPU( i );
		
		System.out.println("Partida hasiko da!");
		BikoteJokalariak.getNireBikoteJokalariak().partidaBatJokatu();
		
	}
	
}
