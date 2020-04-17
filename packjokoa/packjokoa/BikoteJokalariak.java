package packjokoa;
import java.io.*;
import java.util.*;

public class BikoteJokalariak {
	//atributuak:
	private Jokalaria[] zerrenda;
/*	private JokalariArrunta j1;
	private JokalariCPU j2;    */
	private static BikoteJokalariak nireBikoteJokalariak = null;
	
	//eraikitzailea (Singleton):
	private BikoteJokalariak() {   //JokalariArrunta pJ1, JokalariCPU pJ2
		this.zerrenda=new Jokalaria [2];
		
	}
	
	public static synchronized BikoteJokalariak getNireBikoteJokalariak() {
		if(BikoteJokalariak.nireBikoteJokalariak==null) {
			BikoteJokalariak.nireBikoteJokalariak=new BikoteJokalariak();
		} 
		return BikoteJokalariak.nireBikoteJokalariak;
	}
	
	//gainontzeko metodoak:
	
	
	public Jokalaria[] getZerrenda() {
		return zerrenda;
	}

	

	public void partidaBatJokatu() {
		
		this.itsasontziakJarri();
		
		
		
		while (!this.partidaBukatu()) {
			this.koordenatuaAukeratu();			
		}
	
			//inprimatu nork irabazi duen
		if (this.getZerrenda()[0].itsasontzirikEz() && this.getZerrenda()[1].itsasontzirikEz()) {
			System.out.println("BERDINKETA");
		}
		else if(this.getZerrenda()[0].itsasontzirikEz()) {
			System.out.println("ZORIONAK " + this.getZerrenda()[0].getIzena() + "IRABAZI DUZU!!!!   :)  <3 ");
		}
		else {
			System.out.println("GAME OVER " + this.getZerrenda()[0].getIzena() + "GALDU DUZU!!!!  :(    ");
		}
	}
	
	
	
	public void getItsasontziak(){
		this.itsasontziakJarri();
	}
	

	private void itsasontziakJarri() {
		this.getZerrenda()[0].nireTableroaBete();
		System.out.println(" ");
		System.out.println(" ");
		this.getZerrenda()[0].itsasontziakJarri(10);
		System.out.println(" ");
		System.out.println(" ");
		this.getZerrenda()[1].nireTableroaBete();
		System.out.println(" ");
		System.out.println(" ");
		this.getZerrenda()[1].itsasontziakJarri(10);
		
	}
	
	
	
	public boolean getPartidaBukatu(){
		return this.partidaBukatu();
	}
	
	private boolean partidaBukatu() {
		// bi jokalarien tableroak begiratzen ditu eta 
		// ez badago itsasontzirik, partida amaitzen da.
		// itsasontzirikEz() erabiliko da jokalarien tableroak ikusteko.
		boolean ema=false;
		if(this.getZerrenda()[0].itsasontzirikEz()) {
			ema= true;
		}
		else if (this.getZerrenda()[1].itsasontzirikEz()) {
			ema= true;
		}		
		return ema;
	}
	
	
	
	public void getKoordenatuaaukeratu(){
		this.koordenatuaAukeratu();
	}
	
	private void koordenatuaAukeratu() {
		boolean posibleaDa=true;
		boolean aurrekoanAsmatu =false;
		Koordenatuak k1= new Koordenatuak();
		
		//JokalariArrunta:
		do {
		System.out.println(this.getZerrenda()[0].getIzena() + " zure txanda da!");
		System.out.println(" ");
		Koordenatuak k= ((JokalariArrunta)this.getZerrenda()[0]).koordenatuaAukeratu();
		short pX= (short) (k.getKoordenatuakX() + 1);
		short pY = (short) ( k.getKoordenatuakY()+1);
		
			if(this.getZerrenda()[0].koordenadaBaliogarriak(pX, pY)  ) {
				String emaitza = this.getZerrenda()[1].koordenatuanZerDagoen(pX, pY);
				this.getZerrenda()[0].eguneratuPrintTableroa(pX, pY, emaitza);
				if(emaitza!=" U") {
					//Itsasontzia ez badu ukitzen:
					posibleaDa=false;
					System.out.println("OOH!!!" + this.getZerrenda()[0].getIzena() +", ez duzu itsasontzirik ukitu");
					System.out.println(" ");
				}				
			}
			else {
				posibleaDa=false;
				System.out.println(this.getZerrenda()[0].getIzena() + ", sartu dituzun koordenatuak jada sartu dituzu. Txanda galdu duzu");
				System.out.println(" ");
			}
			
		}while(posibleaDa) ;
		//JokalariCPU
		posibleaDa=true;
		do {
			System.out.println(this.getZerrenda()[1].getIzena() + "-ren txanda da!");
			System.out.println(" ");
			
			k1= ((JokalariCPU)this.getZerrenda()[1]).koordenatuaAukeratu(k1,   aurrekoanAsmatu);
			short pX= (short) (k1.getKoordenatuakX()+ 1 );
			short pY = (short) (k1.getKoordenatuakY()+1);
			
				if(this.getZerrenda()[1].koordenadaBaliogarriak(pX, pY)  ) {
					String emaitza = this.getZerrenda()[0].koordenatuanZerDagoen(pX, pY);
					this.getZerrenda()[1].eguneratuPrintTableroa(pX, pY, emaitza);
					if(emaitza!=" U") {
						//Itsasontzia ez badu ukitzen:
						posibleaDa=false; 
						aurrekoanAsmatu=false;
						System.out.println("OOH!!!" + this.getZerrenda()[1].getIzena() +", ez duzu itsasontzirik ukitu");
						System.out.println(" ");
						
					}
					else {
						aurrekoanAsmatu=true;
						
					}
				}
				else {
					posibleaDa=false;
					System.out.println(this.getZerrenda()[1].getIzena() + ", sartu dituzun koordenatuak jada sartu dituzu. Txanda galdu duzu");
					System.out.println(" ");
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
		System.out.println(" ");
		System.out.println("Sartu zure izena: ");
		String izena = Teklatua.getNireTeklatua().irakurriString();
		short i=10;	//erenkada kopurua	
		BikoteJokalariak.getNireBikoteJokalariak().getZerrenda()[0] = new JokalariArrunta(izena, i );
		BikoteJokalariak.getNireBikoteJokalariak().getZerrenda()[1] = new JokalariCPU( i );
		System.out.println(" ");
		System.out.println("Partida hasiko da!");
		System.out.println(" ");
		BikoteJokalariak.getNireBikoteJokalariak().partidaBatJokatu();		
	}
	
}

