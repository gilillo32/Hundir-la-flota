package klaseak;
import java.io.*;
import java.util.*;

public class BikoteJokalariak {
	//atributuak:
	private Jokalaria[] zerrenda;
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
		System.out.println(" ");
		System.out.println(" PARTIDA AMAITU DA!! ");
		System.out.println(" ");
		if (this.getZerrenda()[0].itsasontzirikEz() && this.getZerrenda()[1].itsasontzirikEz()) {
			System.out.println("BERDINKETA IZAN DA...");
		}
		else if(this.getZerrenda()[0].itsasontzirikEz()) {
			System.out.println("ZORIONAK " + this.getZerrenda()[0].getIzena() + ", IRABAZI DUZU!!!!   :)  <3 ");
		}
		else {
			System.out.println("GAME OVER " + this.getZerrenda()[0].getIzena() + ", GALDU DUZU!!!!  :(    ");
		}
	}
	
	
	
	public void getItsasontziak(){
		this.itsasontziakJarri();
	}
	

	private void itsasontziakJarri() {
	//JokalariArrunta-k itsasontziak jarriko ditu bere nireTableroa atributuan
		System.out.println(this.getZerrenda()[0].getIzena() + " itsasontziak jartzeko unea heldu da!");
		System.out.println(" ");
		this.getZerrenda()[0].inprimatuNireTableroa();
		System.out.println(" ");
		System.out.println(" ");
		this.getZerrenda()[0].itsasontziakJarri(10);
		System.out.println(" ");
		System.out.println(" ");
	//JokalariCPU-k itsasontziak jarriko ditu bere nireTableroa atributuan
		System.out.println(this.getZerrenda()[1].getIzena() + " itsasontziak jartzeko unea heldu da!");
		System.out.println(" ");
		this.getZerrenda()[1].inprimatuNireTableroa();
		System.out.println(" ");
		System.out.println(" ");
		this.getZerrenda()[1].itsasontziakJarri(10);
		System.out.println(" ");
	}
	
	
	
	public boolean getPartidaBukatu(){
		return this.partidaBukatu();
	}
	
	private boolean partidaBukatu() {
		/*
		 bi jokalarien tableroak begiratzen ditu eta 
		 ez badago itsasontzirik, partida amaitzen da.
		 itsasontzirikEz() erabiliko da jokalarien tableroak ikusteko.
		*/
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
			System.out.println(" ");
			System.out.println(this.getZerrenda()[0].getIzena() + " zure txanda da!");
		do {
			Koordenatuak k= ((JokalariArrunta)this.getZerrenda()[0]).koordenatuaAukeratu();
			short pX= (short) (k.getKoordenatuakX() + 1);
			short pY = (short) ( k.getKoordenatuakY()+1);
		
			if(this.getZerrenda()[0].koordenadaBaliogarriak(pX, pY)  ) {
				String emaitza = this.getZerrenda()[1].koordenatuanZerDagoen(pX, pY);
				this.getZerrenda()[0].eguneratuPrintTableroa(pX, pY, emaitza);
			//AZTERTUKO NAHI  DUGU EA ITSASONTZIA HONDORATU DUEN, HORRETARAKO ETSAIAREN NIREtABLEROA ALDATUKO DUGU UKITZEN DUENEAN GEROAGO getNireTableroa().hondoratutaDago(itsas) ETSAIAREN TABLEROAN METODOA ERABILI AHAL IZATEKO
				//ikusiko dugu ze itsasontzi dagoen koordenatuan				
				int itsas=this.getZerrenda()[1].getNireTableroa().zeItsasontziHondoratu(pX, pY);
				this.getZerrenda()[1].eguneratuNireTableroa(pX, pY, emaitza);
			
				if(this.getZerrenda()[1].getNireTableroa().hondoratutaDago(itsas)) {
					System.out.println("ZORIONAK " + this.getZerrenda()[0].getIzena() +", hondoratu duzu itsasontzia!!");
				}
			//
				if(emaitza!=" U") {
					//Itsasontzia ez badu ukitzen:
					posibleaDa=false;
					System.out.println(" ");
					System.out.println("OOH!!!" + this.getZerrenda()[0].getIzena() +", ez duzu itsasontzirik ukitu");
				}
				else {
					System.out.println(" ");
					System.out.println("Oso ondo!" + this.getZerrenda()[0].getIzena() +", itsasontsi bat ukitu duzu!");
				}
			}
			else {
				posibleaDa=false;
				System.out.println(" ");
				System.out.println(this.getZerrenda()[0].getIzena() + ", sartu dituzun koordenatuak jada sartu dituzu. Txanda galdu duzu");				
			}
			if( this.getZerrenda()[0].itsasontzirikEz() ) {
				//ITSASONTZII GUZTIAK HONDORATU DITUENENEAN SARTZEN DA HEMEN, IF HONEK EGITEN DUENA HONAKOA DA:
				//AZKENENGO TIROA EGITEAN UKITU DUENEZ BESTE TIRO BAT EGITEN UTZIKO  LIGUKE, BAINA EZ DUGU TIRORIK EGIN BEHAR, JADA ITSASONTSI GUZTIAK HONDORATU DITUGULAKO
				//IF HAU HORI EKIDITZEN DU, LOOP-A EZ DUELAKO BESTE BEGIZTA BAT EGINGO.
				posibleaDa=false;
			}
			
		}while(posibleaDa) ;
		
	//JokalariCPU 
			System.out.println(" ");
			System.out.println(this.getZerrenda()[1].getIzena() + "-ren txanda da!");
			System.out.println(" ");
		posibleaDa=true;
		do {			
			k1= ((JokalariCPU)this.getZerrenda()[1]).koordenatuaAukeratu(k1,   aurrekoanAsmatu);
			short pX= (short) (k1.getKoordenatuakX() +1);
			short pY = (short) (k1.getKoordenatuakY()+1);
			
				if(this.getZerrenda()[1].koordenadaBaliogarriak(pX, pY)) {
					String emaitza = this.getZerrenda()[0].koordenatuanZerDagoen(pX, pY);
					this.getZerrenda()[1].eguneratuPrintTableroa(pX, pY, emaitza);
					
				//AZTERTUKO NAHI  DUGU EA ITSASONTZIA HONDORATU DUEN, HORRETARAKO ETSAIAREN NIREtABLEROA ALDATUKO DUGU UKITZEN DUENEAN GEROAGO getNireTableroa().hondoratutaDago(itsas) ETSAIAREN TABLEROAN METODOA ERABILI AHAL IZATEKO
					//ikusiko dugu ze itsasontzi dagoen koordenatuan
					//ura badago 0 itzultzen du
					int itsas=this.getZerrenda()[0].getNireTableroa().zeItsasontziHondoratu(pX, pY);
					this.getZerrenda()[0].eguneratuNireTableroa(pX, pY, emaitza);
				//	
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
					
				//ITSASONTSI BAT HONDORATZEAN SARTZEN DA
					if(this.getZerrenda()[0].getNireTableroa().hondoratutaDago(itsas)) {
						System.out.println(" ");
						System.out.println("ZORIONAK " + this.getZerrenda()[1].getIzena() +", hondoratu duzu itsasontzia!!");
						if (this.getZerrenda()[1] instanceof JokalariCPU) {
							byte zentzua=((JokalariCPU)this.getZerrenda()[1]).getZentzua();
							this.getZerrenda()[1].getPrintTableroa().XBete(pX, pY, itsas, zentzua);
							((JokalariCPU)this.getZerrenda()[1]).erreseteatu();
							aurrekoanAsmatu=false;
						}
					}					
				}

				if( this.getZerrenda()[1].itsasontzirikEz() ) {
					//ITSASONTZII GUZTIAK HONDORATU DITUENENEAN SARTZEN DA HEMEN, IF HONEK EGITEN DUENA HONAKOA DA:
					//AZKENENGO TIROA EGITEAN UKITU DUENEZ BESTE TIRO BAT EGITEN UTZIKO  LIGUKE, BAINA EZ DUGU TIRORIK EGIN BEHAR, JADA ITSASONTSI GUZTIAK HONDORATU DITUGULAKO
					//IF HAU HORI EKIDITZEN DU, LOOP-A EZ DUELAKO BESTE BEGIZTA BAT EGINGO.
					posibleaDa=false;
				}
		}while(posibleaDa);			
	}
	
	
	 
	
	
/////////////////////////////////////////////////////////////////////////////////////	  		 MAIN 	    	//////////////////////////////////////////////////////////////////////////////////////////	
	
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
		System.out.println("Sartu zure izena: ");
		String izena = Teklatua.getNireTeklatua().irakurriString();
		short i=10;	//erenkada kopurua	
		BikoteJokalariak.getNireBikoteJokalariak().getZerrenda()[0] = new JokalariArrunta(izena, i );
		BikoteJokalariak.getNireBikoteJokalariak().getZerrenda()[1] = new JokalariCPU( i );
		System.out.println(" ");
		System.out.println(" PARTIDA HASIKO DA!");
		System.out.println(" ");
		System.out.println(" ZORTE ON! ");
		System.out.println(" ");
		BikoteJokalariak.getNireBikoteJokalariak().partidaBatJokatu();	
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Eskerrik asko jolasteagatik! <3 ");
		System.out.println(" ");
		System.out.println(" 				Egileak:");
		System.out.println(" 							- Paula Ontalvilla");
		System.out.println(" 							- Leire Garcia");
		System.out.println(" 							- Gaizka Zuazo");
		System.out.println(" 							- Iñigo Gil");
	}
	
}

