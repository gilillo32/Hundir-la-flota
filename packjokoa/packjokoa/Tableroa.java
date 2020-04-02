package packjokoa;

import salbuespenak.KoordenatuEzEgokiak;

public class Tableroa {
	//atributuak:
	private int errenZutKop;  //errenkada eta zutabe kopurua
	private String[][] matrizea;
	
	//eraikitzailea:
	public Tableroa(int pTamaina) { /*BIGARREN MAILAKO ATAZA*/
		this.errenZutKop = pTamaina + 1;
		
		this.matrizea = new String[this.errenZutKop][this.errenZutKop];
	}
	
	//gainontzeko metodoak:
	
	private void tableroaInprimatu() {
		//hasieratu indizeak
		int akum=0;
		int e= 0;
		int z= 1;
		while(z<this.matrizea[e].length) {
			this.matrizea[0][0]="  ";
			this.matrizea[e][z]= String.valueOf(" "+akum);
			this.matrizea[z][e]= String.valueOf(akum+" ");
			z++;
			akum++;
		}
		
		while (e< this.errenZutKop ) { //erabili daiteke This.matrizea.length
			z=0;
			while (z<this.errenZutKop) { //erabili daiteke this.matrize[e].length
				
				System.out.print(  this.matrizea[e][z]); //aldi bakoitzean hurrengo lerroan inprimatzen du
				z++;
			}
			e++;
			System.out.print("\n");
			
		}
	}
	
	public void tableroaBete() { //uraz beteko dugu "-"
		//hasieratu indizeak
		int e= 1;
		int z= 1;
		while (e< this.errenZutKop) { //erabili daiteke This.matrizea.length
			z= 1;
			while (z<this.errenZutKop) { //erabili daiteke this.matrize[e].length
				/*if(e==10) {
					this.matrizea[e][z] = "- ";
				}
				else if(z==10) {
					this.matrizea[e][z] = "  - ";
				}
				else {*/
					this.matrizea[e][z] = " -";
				//}
				
				z++;
			}	
			e++;
		}	
		this.tableroaInprimatu();		
	} 
	

	public void itsasontziakJarri (short pX, short pY,short pItsas, String pOrientazio) throws KoordenatuEzEgokiak{
		int aux=0;

		//itsasontzia jarriko dugu:
		if(	this.konprobatuHutsuneak(pX, pY, pItsas, pOrientazio) && this.konprobatuItsasontsirikEzKoordenatuan(pX, pY, pItsas, pOrientazio)) {
			//orentazioaren arabera bi modu:
			if (pOrientazio=="H" || pOrientazio=="h" ) {//pY ez da aldatzen
				aux= pX+pItsas;
				
				while(pX<aux) {
					 this.matrizea[pY][pX]= String.valueOf(pItsas);
					pX++;
				}
			}
			else if(pOrientazio=="B" || pOrientazio=="b") {//pX ez da aldatzen
				aux	=pY+ pItsas;
				while(pY<aux) {
					 this.matrizea[pY][pX]= String.valueOf(pItsas);
					pY++;
				}				
			}
		}
		else {
			throw new KoordenatuEzEgokiak();
		}
		
		this.tableroaInprimatu();
		}
	
	
	private boolean konprobatuItsasontsirikEzKoordenatuan(short pX, short pY,short pItsas, String pOrientazio) {
		//begiratzen du guk itsasontsia jarri nahi dugun koordenatuan ez dagoela jada itsasontsirik
		//false itsasontsia badago
		//true itsasontsirik ez badago eta gure itsasontsia jarri ahal bada
		boolean emaitza=true;
		int aux=0;
		if (pOrientazio=="H" || pOrientazio=="h" ) {//pY ez da aldatzen
			aux= pX+pItsas;
			while(pX<aux && emaitza) {
				if (  this.koordenatuanZerDagoen(pX, pY) == "U") {
					emaitza=false;
				}				 
				pX++;
			}			
		}
		else if(pOrientazio=="B" || pOrientazio=="b") {//pX ez da aldatzen
			aux	=pY+ pItsas;
			while(pY<aux) {
				if (  this.koordenatuanZerDagoen(pX, pY) == "U") {
					emaitza=false;
				}
				pY++;
			}			
		}		
		return emaitza;
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
	
	public String koordenatuanZerDagoen(short pX, short pY) {
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
