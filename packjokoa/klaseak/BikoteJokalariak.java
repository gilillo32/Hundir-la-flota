package klaseak;
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
		System.out.println(this.getZerrenda()[0].getIzena() + " itsasontziak jartzeko unea heldu da!");
		System.out.println(" ");
		this.getZerrenda()[0].nireTableroaBete();
		System.out.println(" ");
		System.out.println(" ");
		this.getZerrenda()[0].itsasontziakJarri(10);
		System.out.println(" ");
		System.out.println(" ");
		
		System.out.println(this.getZerrenda()[1].getIzena() + " itsasontziak jartzeko unea heldu da!");
		System.out.println(" ");
		this.getZerrenda()[1].nireTableroaBete();
		System.out.println(" ");
		System.out.println(" ");
		this.getZerrenda()[1].itsasontziakJarri(10);
		System.out.println(" ");
		
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
		System.out.println(" ");
		System.out.println(this.getZerrenda()[0].getIzena() + " zure txanda da!");
		System.out.println(" ");
		Koordenatuak k= ((JokalariArrunta)this.getZerrenda()[0]).koordenatuaAukeratu();
		short pX= (short) (k.getKoordenatuakX() + 1);
		short pY = (short) ( k.getKoordenatuakY()+1);
		
			if(this.getZerrenda()[0].koordenadaBaliogarriak(pX, pY)  ) {
				String emaitza = this.getZerrenda()[1].koordenatuanZerDagoen(pX, pY);
				this.getZerrenda()[0].eguneratuPrintTableroa(pX, pY, emaitza);
				int itsas=this.getZerrenda()[1].getNireTableroa().zeItsasontziHondoratu(pX, pY);
				this.getZerrenda()[1].eguneratuNireTableroa(pX, pY, emaitza);
				if(this.getZerrenda()[1].getNireTableroa().hondoratutaDago(itsas)) {
					System.out.println("ZORIONAK " + this.getZerrenda()[0].getIzena() +", hondoratu duzu itsasontzia!!");
				}
				if(emaitza!=" U") {
					//Itsasontzia ez badu ukitzen:
					posibleaDa=false;
					System.out.println(" ");
					System.out.println("OOH!!!" + this.getZerrenda()[0].getIzena() +", ez duzu itsasontzirik ukitu");
				}				
			}
			else {
				posibleaDa=false;
				System.out.println(" ");
				System.out.println(this.getZerrenda()[0].getIzena() + ", sartu dituzun koordenatuak jada sartu dituzu. Txanda galdu duzu");
				
			}
			
		}while(posibleaDa) ;
		//JokalariCPU 
		posibleaDa=true;
		do {
			System.out.println(" ");
			System.out.println(this.getZerrenda()[1].getIzena() + "-ren txanda da!");
			System.out.println(" ");
			
			k1= ((JokalariCPU)this.getZerrenda()[1]).koordenatuaAukeratu(k1,   aurrekoanAsmatu);
			short pX= (short) (k1.getKoordenatuakX() +1);
			short pY = (short) (k1.getKoordenatuakY()+1);
			
				if(this.getZerrenda()[1].koordenadaBaliogarriak(pX, pY)  ) {
					String emaitza = this.getZerrenda()[0].koordenatuanZerDagoen(pX, pY);
					this.getZerrenda()[1].eguneratuPrintTableroa(pX, pY, emaitza);
					//ikusiko dugu ze itsasontzi dagoen koordenatuan
					int itsas=this.getZerrenda()[0].getNireTableroa().zeItsasontziHondoratu(pX, pY);
					this.getZerrenda()[0].eguneratuNireTableroa(pX, pY, emaitza);
					if(emaitza!=" U") {
						//Itsasontzia ez badu ukitzen:
						posibleaDa=false; 
						aurrekoanAsmatu=false;
						System.out.println(" ");
						System.out.println("OOH!!!" + this.getZerrenda()[1].getIzena() +", ez duzu itsasontzirik ukitu");
						
					}
					else {
						aurrekoanAsmatu=true;
						
					}
					
					if(this.getZerrenda()[0].getNireTableroa().hondoratutaDago(itsas)) {
						System.out.println("ZORIONAK " + this.getZerrenda()[1].getIzena() +", hondoratu duzu itsasontzia!!");
						if (this.getZerrenda()[1] instanceof JokalariCPU) {
							((JokalariCPU)this.getZerrenda()[1]).erreseteatu();
							aurrekoanAsmatu=false;
						}
					}
					
				}
				else {
					posibleaDa=false;
					System.out.println(" ");
					System.out.println(this.getZerrenda()[1].getIzena() + ", sartu dituzun koordenatuak jada sartu dituzu. Txanda galdu duzu");
					System.out.println(k1.getKoordenatuakX());
					System.out.println(k1.getKoordenatuakY());
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
		System.out.println("ONGI ETORRI!");
		System.out.println(" ");
		System.out.println("ARAUAK: ");
		System.out.println("- Ezin dira bi itsasontzi ondoz ondo jarri, kasila bateko distantzia egon behar da.");
		System.out.println("- Koordenatuak hautatzeko, errenkada eta zutabeen zenbakia idatzi behar da, baita orientazioa B edo H ere.");
		System.out.println("- Jokalari bakoitzak aukera bakarra dauka tiroa egiteko, koordenatua errepikatzen badu txanda galduko du.  ");
		System.out.println("- Jokalari bat itsaontzia ukitzen baldin badu, beste tiro bat egiteko aukera izango du, hutz egiten duen arte. ");
		System.out.println("- Irabazlea beste jokalariaren itsasontzi guztiak hondoratzen dituen jokalaria da. ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("ZORTE ON! ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Sartu zure izena: ");
		String izena = Teklatua.getNireTeklatua().irakurriString();
		short i=10;	//erenkada kopurua	
		BikoteJokalariak.getNireBikoteJokalariak().getZerrenda()[0] = new JokalariArrunta(izena, i );
		BikoteJokalariak.getNireBikoteJokalariak().getZerrenda()[1] = new JokalariCPU( i );
		System.out.println(" ");
		System.out.println("				PARTIDA HASIKO DA!");
		System.out.println(" ");
		BikoteJokalariak.getNireBikoteJokalariak().partidaBatJokatu();		
	}
	
}

