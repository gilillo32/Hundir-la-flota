package packjokoa;

public class Tableroa {
	//atributuak:
	private int errenZutKop;  //errenkada eta zutabe kopurua
	private String[][] matrizea;
	
	//eraikitzailea:
	public Tableroa(int pTamaina) { /*BIGARREN MAILAKO ATAZA*/
		this.errenZutKop = pTamaina;
		
		this.matrizea = new String[this.errenZutKop][this.errenZutKop];
	}
	
	//gainontzeko metodoak:
	
	public void tableroaInprimatu() {
		//hasieratu indizeak
		int e= 0;
		int z= 0;
		System.out.print(" "); // lehennegoz hutsune bat inprimatu
		//Orain zutabeen indizeak imprimatuko ditu
		while (e<this.errenZutKop + 1) { 
			System.out.print(" "+e);	//linea berean inprimatzen du
			//deasberdin egingo dugu luzera hamar baino handiagoa denean, bain ahori bigarren mailako ataza da.
			e++;
		}
		e=0; //berriro hasieratuko dugu
		while (e< this.errenZutKop + 1) { //erabili daiteke This.matrizea.length
			while (z<this.errenZutKop+1) { //erabili daiteke this.matrize[e].length
				System.out.println(e+ " " + this.matrizea[e][z]);		//aldi bakoitzean hurrengo lerroan inprimatzen du		
			}			
		}
		
	}
	
	public void tableroaBete() { //uraz beteko dugu "-"
		//hasieratu indizeak
		int e= 0;
		int z= 0;
		while (e< this.errenZutKop + 1) { //erabili daiteke This.matrizea.length
			while (z<this.errenZutKop+1) { //erabili daiteke this.matrize[e].length
				this.matrizea[e][z] = "-";				
			}			
		}	
		
		
	} 
	
	public void itsasontziakJarri (short pX, short pY,short pItsas, String pOrientazio)  {
		try { if ((pX+pItsas>= this.errenZutKop) || pX<0 || pY<0 || (pY+pItsas>= this.errenZutKop) ){
			throw (new IndexOutOfBoundsException());//esta salbuespen es de C+, la nuestra seria IndexOutOfBoundsException()
			}
		//salbuespena:
		//konprobatu itsasontsia sar daitekeela koordenatu horretan, hau da 4eko itsasontsia ez gara saiatuko sartzen 9,9 kooedenatuan ez baita sartzen
		int aux=0;
		this.tableroaBete();// tableroa uraz beteko dugu
		//itsasontsia jarriko dugu:
		if(	this.konprobatuHutsuneak(pX, pY, pItsas, pOrientazio)) {
			//orentazioaren arabera bi modu:
			if (pOrientazio=="H") {//pY ez da aldatzen
				aux= pX+pItsas;
				
				while(pX<aux) {
					 this.matrizea[pY][pX]= String.valueOf(pItsas);
					pX++;
				}
			}
			else if(pOrientazio=="B") {//pX ez da aldatzen
				aux	=pY+ pItsas;
				while(pY<aux) {
					 this.matrizea[pY][pX]= String.valueOf(pItsas);
					pY++;
				}				
			}
		}
		else { 
			//ez bada posible sartzea itsasontsia leku honetan, SALBUESPENA. BERAZ BERRIRO ESKATU BEHAR DIO KOORDENATUA HORIENTAZIOA ETA ABAR
			System.out.print("Sartu dituzun koordenatuak ez dira egokiak, itsasontsia beste baten parean jarriko zenukeelako. Mesedez sartu koordenatu berriak:");
		}
		this.tableroaInprimatu();
		}//try
		catch(IndexOutOfBoundsException e) {
			System.out.print("Sartu dituzun koordenatuak ez dira egokiak, ez baitaude tableroaren barruan. Mesedez sartu koordenatu berriak:");
			//pedir koordenadas
			//pX
			pX=Teklatua.getNireTeklatua().irakurriShort();
			//pY
			pY=Teklatua.getNireTeklatua().irakurriShort();
			//pOrientazio
			pOrientazio=Teklatua.getNireTeklatua().irakurriString();
			this.itsasontziakJarri(pX, pY, pItsas, pOrientazio);
			
		}
	}
	
	public boolean konprobatuTiroa(short pX, short pY) {
		//honako hauek salbuespenean jarriko ditugu(teklatuan)
		//konprobatuko dugu ez duela lehen erabili, ez badago U edo - (U itsasontzia ukituta dagoela esan nahi du, GOGORATU!!!
		//konprobaketa bere asmakuntzen tableroan begiratuko du
		boolean tiroa= false;
		if( !this.uraDago(pX, pY) || this.matrizea[pY][pX] != "U") {
			tiroa= true;
		}
		
		return tiroa;
		}
	
	public String bigarrenTiroa(short pX, short pY) {
		//salbuespen del teklado SE MIRA AL PEDIR LA CORDENADA
		//honek etsaiaren tableroan begiratuko du zer dagoen kasilan, itsasontsia baldin badago "U" bueltatzen du, bestela, han dagoena, hau da, ura "-"
		String ema = this.matrizea[pY][pX];
		if(ema== "1" || ema=="2" || ema=="3" || ema=="4" ) {
			ema = "U";
		}
			
		return ema ;
		
	}
	
	private boolean uraDago(short pX, short pY) {
		boolean dago=false;
		if( this.matrizea[pY][pX] == "-") {
			dago=true;
		}		
		return dago;		
	}
	
	/*private boolean hondoratutaDago(short pZenb) {
		
	}*/
	
	private boolean konprobatuHutsuneak(short pX, short pY, short pItsas, String pOrientazio ) {
		
		
		//////////
		//HAY QUE MIRARR QUE NO SEAN ESQUINAS NI PUNTOS CRITICOS!!! AHORA SOLO ESTA LO GENERICO
		//////////
		
		//true bueltatzen du itsasontzien hartean hiutsuneak egongo badira itsasontsia koordenatu horretan jarrri ostean, bestela false, hau da, itsasontzia ezin da han jarri
		//pItsas esango digu zein motatak itsasontsia den, guk jakitek zein koordenatuan amaituko den itsasontzia
		//itsasontsien hartean gutxienez kasila bat tartean egon behar da
		boolean hutsune = false;
		int aux=0;
		int amaierakoEr=0;
		int amaierakoZut=0;
		//orientazioaren arabera prozedura desberdina izango da
		if (pOrientazio=="H") { 
			//horizontalean
			amaierakoEr=  pX + pItsas;
			amaierakoZut= pY;
			if(this.matrizea[pY][pX-1]=="-") { //EZKERREKO KASILAN BEGIRATU
				hutsune = true;
			}
			else if(this.matrizea[amaierakoEr][amaierakoZut]=="-") { //ESKUINEKO KASILAN BEGIRATU
				hutsune = true;	
			}
			aux=pX;
			while(!hutsune && aux< amaierakoEr) {		//GOIKO ERRENKETAKO KASILAK BEGIRATU		
				if(this.matrizea[pY-1][aux]=="-") {
					hutsune = true;
				}
				aux++;
			}
			aux=pX;
			while(!hutsune && aux< amaierakoEr) {				
				if(this.matrizea[pY+1][aux]=="-") { //BEHEKO ERRENKADAKO KASILETAN BEGIRATU
					hutsune = true;
				}
				aux++;
			}
			
			///QUE NO SSE OLVIDEN LAS SALBUESPENAS, ESQUINAS ETC....			
			
		}
		else if (pOrientazio=="B") {
			//Bertikalean
			amaierakoEr=  pX;
			amaierakoZut= pY + pItsas;
	
			if(this.matrizea[pY-1][pX]=="-") { //gOIKO KASILAN BEGIRATU
				hutsune = true;
			}
			else if(this.matrizea[amaierakoEr][amaierakoZut]=="-") { //BEHEKO KASILAN BEGIRATU
				hutsune = true;	
			}
			aux=pY;
			while(!hutsune && aux< amaierakoZut) {		//EZKERREKO ZUTABEKOKASILAK BEGIRATU		
				if(this.matrizea[aux][pX-1]=="-") {
					hutsune = true;
				}
				aux++;
			}
			aux=pY;
			while(!hutsune && aux< amaierakoZut) {			//ESKUINEKO ZUTABEKOKASILAK BEGIRATU	
				if(this.matrizea[aux][pX+1]=="-") {
					hutsune = true;
				}
				aux++;
			}
			///QUE NO SSE OLVIDEN LAS SALBUESPENAS, ESQUINAS ETC....
			
		
			
		}
		return hutsune;
	}
	
	public void eguneratuTableroa( short pX, short pY, String pEmaitza) {
		//etsaiak koordenatu horretan duena zure tableroan jarriko du metodo honek
		if ( pEmaitza != "U") {
			pEmaitza= "X"; //jarriko du X bat gero konprobatuTiroa jakiteko ea koordenatu hori lehenik esan dugun ala ez
		}
		this.matrizea[pY][pX] = pEmaitza;
	}
	
	//setter getter:
	
	//izkinen konprobaketak JokalariCPU-n beharrezkoa da metodo hau:
	public int getErrenkadaZutKop() {
		return this.errenZutKop;
	}

}
