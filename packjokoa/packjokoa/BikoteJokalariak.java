package packjokoa;
import java.io.*;
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
		
		this.itsasontziakJarri();
		
		
		
		while (!this.partidaBukatu()) {
			this.koordenatuaAukeratu();			
		}
	
			//inprimatu nork irabazi duen
		if (this.zerrenda[0].itsasontzirikEz() && this.zerrenda[1].itsasontzirikEz()) {
			System.out.println("BERDINKETA");
		}
		else if(this.zerrenda[0].itsasontzirikEz()) {
			System.out.println("ZORIONAK " + this.zerrenda[0].getIzena() + "IRABAZI DUZU!!!!   :)  <3 ");
		}
		else {
			System.out.println("GAME OVER " + this.zerrenda[0].getIzena() + "GALDU DUZU!!!!  :(    ");
		}
	}
	
	
	
	private void itsasontziakJarri() {
		this.zerrenda[0].getNireTableroa().tableroaBete();
		this.zerrenda[0].itsasontziakJarri(10);
		this.zerrenda[1].getNireTableroa().tableroaBete();
		this.zerrenda[1].itsasontziakJarri(10);
		
	}
	
	
	
	
	
	private boolean partidaBukatu() {
		// bi jokalarien tableroak begiratzen ditu eta 
		// ez badago itsasontzirik, partida amaitzen da.
		// itsasontzirikEz() erabiliko da jokalarien tableroak ikusteko.
		boolean ema=false;
		if(this.zerrenda[0].itsasontzirikEz()) {
			ema= true;
		}
		else if (this.zerrenda[1].itsasontzirikEz()) {
			ema= true;
		}		
		return ema;
	}
	
	
	
	
	
	private void koordenatuaAukeratu() {
		boolean posibleaDa=true;
		boolean aurrekoanAsmatu =false;
		Koordenatuak k1= new Koordenatuak();
		
		//JokalariArrunta:
		do {
		System.out.println(this.zerrenda[0].getIzena() + " zure txanda da!");
		Koordenatuak k= ((JokalariArrunta)this.zerrenda[0]).koordenatuaAukeratu();
		short pX= (short) (k.getKoordenatuakX() + 1);
		short pY = (short) ( k.getKoordenatuakY()+1);
		
			if(this.zerrenda[0].koordenadaBaliogarriak(pX, pY)  ) {
				String emaitza = this.zerrenda[1].koordenatuanZerDagoen(pX, pY);
				this.zerrenda[0].eguneratuPrintTableroa(pX, pY, emaitza);
				if(emaitza!=" U") {
					//Itsasontzia ez badu ukitzen:
					posibleaDa=false;
					System.out.println("OOH!!! Ez duzu itsasontzirik ukitu");
				}				
			}
			else {
				posibleaDa=false;
				System.out.println("Sartu dituzun koordenatuak jada sartu dituzu. Txanda galdu duzu");
			}
			
		}while(posibleaDa) ;
		//JokalariCPU
		posibleaDa=true;
		do {
			System.out.println(this.zerrenda[1].getIzena() + "-ren txanda da!");
			
			k1= ((JokalariCPU)this.zerrenda[1]).koordenatuaAukeratu(k1,   aurrekoanAsmatu);
			short pX= (short) (k1.getKoordenatuakX()+ 1 );
			short pY = (short) (k1.getKoordenatuakY()+1);
			
				if(this.zerrenda[1].koordenadaBaliogarriak(pX, pY)  ) {
					String emaitza = this.zerrenda[0].koordenatuanZerDagoen(pX, pY);
					this.zerrenda[1].eguneratuPrintTableroa(pX, pY, emaitza);
					if(emaitza!=" U") {
						//Itsasontzia ez badu ukitzen:
						posibleaDa=false; 
						aurrekoanAsmatu=false;
						
					}
					else {
						aurrekoanAsmatu=true;
						
					}
				}
				else {
					posibleaDa=false;
				}
		}while(posibleaDa);			
	}
	
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static void main (String [ ] args) 	{	
		Scanner input = null;
		//Hasierako pantaila inprimatzeko:
		File f = new File("HASIERA_TESTUA.txt");
		try {
			input = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("Ez da aurkitu fitxategia");
		}

		while (input.hasNextLine())
		{ 
		   System.out.println(input.nextLine());
		}
		System.out.println("kAIXO LAGUN!");
		System.out.println("ONGI ETORRI!");
		System.out.println("Sartu zure izena: ");
		String izena = Teklatua.getNireTeklatua().irakurriString();
		short i=10;	//erenkada kopurua	
		BikoteJokalariak.getNireBikoteJokalariak().zerrenda[0] = new JokalariArrunta(izena, i );
		BikoteJokalariak.getNireBikoteJokalariak().zerrenda[1] = new JokalariCPU( i );
		
		System.out.println("Partida hasiko da!");
		BikoteJokalariak.getNireBikoteJokalariak().partidaBatJokatu();
		
	}
	
}
