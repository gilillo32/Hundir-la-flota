package klaseak;
import java.io.*;
import java.util.*;

public class BikoteJokalariak {
	//atributuak:
	private Jokalaria[] zerrenda;
	private static BikoteJokalariak nireBikoteJokalariak = null;
	private String norenKontra = null;
	
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
			System.out.println(" ");
			if(this.norenKontra.equals("CPU")) {
				Scanner input_zuretxanda = null;
				File zuretxandaFile = new File("ZURETXANDA.txt");
				try {
					input_zuretxanda = new Scanner(zuretxandaFile);
					
				} catch (FileNotFoundException e) {
					System.out.println("Ez da aurkitu fitxategia");
				}
				while(input_zuretxanda.hasNextLine())
				{ 
				   System.out.println(input_zuretxanda.nextLine());
				}input_zuretxanda.close();
			}
			else {
				Scanner input_lehenengo = null;
				File lehenengoFile = new File("LEHENENGO.txt");
				try {
					input_lehenengo = new Scanner(lehenengoFile);
					
				} catch (FileNotFoundException e) {
					System.out.println("Ez da aurkitu fitxategia");
				}
				while(input_lehenengo.hasNextLine())
				{ 
				   System.out.println(input_lehenengo.nextLine());
				}input_lehenengo.close();
			}
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
			
		}while(posibleaDa);
		
	switch(this.norenKontra) {
	case "CPU":
		//JokalariCPU 
				System.out.println(" ");
				System.out.println(" ");
				//System.out.println(this.getZerrenda()[1].getIzena() + "-ren txanda da!");
				Scanner input_cpu = null;
				File cpuFile = new File("CPU.txt");
				try {
					input_cpu = new Scanner(cpuFile);
					
				} catch (FileNotFoundException e) {
					System.out.println("Ez da aurkitu fitxategia");
				}
				while(input_cpu.hasNextLine())
				{ 
				   System.out.println(input_cpu.nextLine());
				}input_cpu.close();
				System.out.println(" ");
			posibleaDa=true;
			do {			
				k1= ((JokalariCPU)this.getZerrenda()[1]).koordenatuaAukeratu(k1, aurrekoanAsmatu);
				short pX= (short) (k1.getKoordenatuakX() +1);
				short pY = (short) (k1.getKoordenatuakY()+1);
				
					if(this.getZerrenda()[1].koordenadaBaliogarriak(pX, pY)) {
						String emaitza = this.getZerrenda()[0].koordenatuanZerDagoen(pX, pY);
						this.getZerrenda()[1].eguneratuPrintTableroa(pX, pY, emaitza);
						System.out.println(" ");
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
							System.out.println("OOH!!!" + this.getZerrenda()[1].getIzena() +", ez duzu itsasontzirik ukitu");
							
						}
						else {
							aurrekoanAsmatu=true;							
						}
						
					//ITSASONTSI BAT HONDORATZEAN SARTZEN DA
						if(this.getZerrenda()[0].getNireTableroa().hondoratutaDago(itsas)) {
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
			break;
	case "Arrunta":
			System.out.println(" ");
			System.out.println(" ");
			Scanner input_bigarren = null;
			File bigarrenFile = new File("BIGARREN.txt");
			try {
				input_cpu = new Scanner(bigarrenFile);
				
			} catch (FileNotFoundException e) {
				System.out.println("Ez da aurkitu fitxategia");
			}
			while(input_bigarren.hasNextLine())
			{ 
			   System.out.println(input_bigarren.nextLine());
			}input_bigarren.close();
		do {
			Koordenatuak k= ((JokalariArrunta)this.getZerrenda()[1]).koordenatuaAukeratu();
			short pX= (short) (k.getKoordenatuakX() + 1);
			short pY = (short) ( k.getKoordenatuakY()+1);
		
			if(this.getZerrenda()[1].koordenadaBaliogarriak(pX, pY)  ) {
				String emaitza = this.getZerrenda()[0].koordenatuanZerDagoen(pX, pY);
				this.getZerrenda()[1].eguneratuPrintTableroa(pX, pY, emaitza);
			//AZTERTUKO NAHI  DUGU EA ITSASONTZIA HONDORATU DUEN, HORRETARAKO ETSAIAREN NIREtABLEROA ALDATUKO DUGU UKITZEN DUENEAN GEROAGO getNireTableroa().hondoratutaDago(itsas) ETSAIAREN TABLEROAN METODOA ERABILI AHAL IZATEKO
				//ikusiko dugu ze itsasontzi dagoen koordenatuan				
				int itsas=this.getZerrenda()[0].getNireTableroa().zeItsasontziHondoratu(pX, pY);
				this.getZerrenda()[0].eguneratuNireTableroa(pX, pY, emaitza);
			
				if(this.getZerrenda()[0].getNireTableroa().hondoratutaDago(itsas)) {
					System.out.println("ZORIONAK " + this.getZerrenda()[1].getIzena() +", hondoratu duzu itsasontzia!!");
				}
			//
				if(emaitza!=" U") {
					//Itsasontzia ez badu ukitzen:
					posibleaDa=false;
					System.out.println(" ");
					System.out.println("OOH!!!" + this.getZerrenda()[1].getIzena() +", ez duzu itsasontzirik ukitu");
				}
				else {
					System.out.println(" ");
					System.out.println("Oso ondo!" + this.getZerrenda()[1].getIzena() +", itsasontsi bat ukitu duzu!");
				}
			}
			else {
				posibleaDa=false;
				System.out.println(" ");
				System.out.println(this.getZerrenda()[1].getIzena() + ", sartu dituzun koordenatuak jada sartu dituzu. Txanda galdu duzu");				
			}
			if( this.getZerrenda()[1].itsasontzirikEz() ) {
				//ITSASONTZII GUZTIAK HONDORATU DITUENENEAN SARTZEN DA HEMEN, IF HONEK EGITEN DUENA HONAKOA DA:
				//AZKENENGO TIROA EGITEAN UKITU DUENEZ BESTE TIRO BAT EGITEN UTZIKO  LIGUKE, BAINA EZ DUGU TIRORIK EGIN BEHAR, JADA ITSASONTSI GUZTIAK HONDORATU DITUGULAKO
				//IF HAU HORI EKIDITZEN DU, LOOP-A EZ DUELAKO BESTE BEGIZTA BAT EGINGO.
				posibleaDa=false;
			}
			
		}while(posibleaDa);
		break;
		}
	}
	
	public void setNorenKontra(String pNorenKontra) {
		this.norenKontra = pNorenKontra;
	}

	
	
	 
	
	
/////////////////////////////////////////////////////////////////////////////////////	  		 MAIN 	    	//////////////////////////////////////////////////////////////////////////////////////////	
	
	public static void main (String [ ] args) throws InterruptedException 	{	
		Scanner input_HASIERA = null;
		Scanner input_ARAUAK = null;
		Scanner input_AUKERAK = null;
		//Hasierako pantaila inprimatzeko:
		File hasieraTestuaFile = new File("HASIERA_TESTUA.txt");
		File arauakFile = new File("ARAUAK.txt");
		File aukerakFile = new File("AUKERAK.txt");
		try {
			input_HASIERA = new Scanner(hasieraTestuaFile);
			
		} catch (FileNotFoundException e) {
			System.out.println("Ez da aurkitu fitxategia");
		}

		while(input_HASIERA.hasNextLine())
		{ 
		   System.out.println(input_HASIERA.nextLine());
		}input_HASIERA.close();
		System.out.println("ONGI ETORRI! Esperientzia osoaz gozatzeko, pantaila osoan jokatzea gomendatzen dugu!\n");
		do {
			
			try {
				input_AUKERAK = new Scanner(aukerakFile);
			}
			catch(FileNotFoundException e){
				System.out.println("Ez da aurkitu fitxategia");
			}
			while(input_AUKERAK.hasNextLine()) {
				System.out.println(input_AUKERAK.nextLine());
			}input_AUKERAK.close();
			int aukera = Teklatua.getNireTeklatua().irakurriAukera("\nZer egin nahi duzu?", 0, 4);
			switch(aukera) {
			case 1:
				BikoteJokalariak.getNireBikoteJokalariak().setNorenKontra("CPU");
				System.out.println("Sartu zure izena:");
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
				break;
			case 2:
				BikoteJokalariak.getNireBikoteJokalariak().setNorenKontra("Arrunta");
				System.out.println("Sartu lehenengo jokalariaren izena:");
				String izena1 = Teklatua.getNireTeklatua().irakurriString();
				System.out.println("Sartu bigarren jokalariaren izena:");
				String izena2 = Teklatua.getNireTeklatua().irakurriString();
				short j=10;	//erenkada kopurua	
				BikoteJokalariak.getNireBikoteJokalariak().getZerrenda()[0] = new JokalariArrunta(izena1, j );
				BikoteJokalariak.getNireBikoteJokalariak().getZerrenda()[1] = new JokalariArrunta(izena2, j );
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
				break;
			case 3:
				try {
					input_ARAUAK = new Scanner(arauakFile);
				}
				catch(FileNotFoundException e) {
					System.out.println("Ez da aurkitu fitxategia");
				}
				while(input_ARAUAK.hasNextLine())
				{ 
				   System.out.println(input_ARAUAK.nextLine());
				}input_ARAUAK.close();
				System.out.println("\n");
				break;
			case 4:
				System.exit(0);
				break;
			case 0:
				klaseak.LifeStarts.laif();
			}
				
		}while(true);
		
	}
	
}

