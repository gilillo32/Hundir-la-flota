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
	
	public void tableroaInprimatu() {
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
				this.matrizea[e][z] = " -";				
				z++;
			}	
			e++;
		}	
		//this.tableroaInprimatu();		
	} 
	

	public void itsasontziakJarri (short pX, short pY,short pItsas, String pOrientazio) throws KoordenatuEzEgokiak{
		int aux=0;
		//System.out.println( " ANTESSSSSSSSSSSSSSSSSSSS itsasontziakJarri primer if ");
		//itsasontzia jarriko dugu:
		if(	 this.konprobatuItsasontzirikEzKoordenatuan(pX, pY, pItsas, pOrientazio) && this.konprobatuHutsuneak(pX, pY, pItsas, pOrientazio)) {
			//orientazioaren arabera bi modu:	
			//System.out.println( " itsasontziakJarri primer if ");
			if (pOrientazio.equals("H")  || pOrientazio.equals("h") ) {//pY ez da aldatzen  
				//System.out.println( " itsasontziakJarri primer if hhhhhhhhhhhhhhhhhh ");
				aux= pX+pItsas;
				
				while(pX<aux) {
					//System.out.println( " itsasontziakJarri primer  H WHILEEEEEE ");
					 this.matrizea[pY][pX]=  (" " + String.valueOf(pItsas));
					pX++;
				}
			}
			else if(pOrientazio.equals("B") || pOrientazio.equals("b") ) {//pX ez da aldatzen   
				//System.out.println( " itsasontziakJarri primer if BBBBBBBBBBBBBBBBBBBBBBBBBBBB ");
				aux	=pY+ pItsas;
				while(pY<aux) {
					//System.out.println( " itsasontziakJarri primer B WHILEEEEEEEE ");
					 this.matrizea[pY][pX]= (" " + String.valueOf(pItsas));
					pY++;
				}				
			}
		}
		else {
			//System.out.println( " EXCEPTION KoordenatuEzEgokiak          GGGGGGGGGG ");
			throw new KoordenatuEzEgokiak();
		}
		
		}
	
	
	private boolean konprobatuItsasontzirikEzKoordenatuan(short pX, short pY,short pItsas, String pOrientazio) {
		//begiratzen du guk itsasontzia jarri nahi dugun koordenatuan ez dagoela jada itsasontsirik
		//false itsasontzia badago
		//true itsasontsirik ez badago eta gure itsasontzia jarri ahal bada
		boolean emaitza=true;
		int aux=0;
		if ( pOrientazio.equals("H")  || pOrientazio.equals("h") ) {//pY ez da aldatzen
			aux= pX+pItsas;
			//System.out.println( " konprobatuItsasontsirikEzKoordenatuan PRIMER IF ");
			while(pX<aux && emaitza) {
				//System.out.println( " konprobatuItsasontsirikEzKoordenatuan WHILE ");
				//System.out.println( this.koordenatuanZerDagoen(pX, pY));
				if (  this.koordenatuanZerDagoen(pX, pY).equals(" U")) { //U bat bueltazen badu esan nahi du itsasontsi bat dagoela han
					emaitza=false;
					//System.out.println( " konprobatuItsasontsirikEzKoordenatuan SEGUNDO IF ");
				}				 
				pX++;
			}			
		}
		else if( pOrientazio.equals("B") || pOrientazio.equals("b") ) {//pX ez da aldatzen
			//System.out.println( " konprobatuItsasontsirikEzKoordenatuan ELSE IF ");
			aux	=pY+ pItsas;
			while(pY<aux && emaitza) {
				//System.out.println( " konprobatuItsasontsirikEzKoordenatuan SEGUNDO WHILE ");
				if (  this.koordenatuanZerDagoen(pX, pY).equals(" U")) {
					//System.out.println( " konprobatuItsasontsirikEzKoordenatuan TERCER IF ");
					emaitza=false;
				}
				pY++;
			}			
		}		
		return emaitza;
	}
	
	
	
	
	public boolean konprobatuTiroa(short pX, short pY) {
		//honako hauek salbuespenean jarriko ditugu(teklatuan)
		//konprobatuko dugu ez duela lehen erabili, ez badago U edo  (U itsasontzia ukituta dagoela esan nahi du, GOGORATU!!!
		//konprobaketa bere asmakuntzen tableroan begiratuko du
		boolean tiroa= false;
		if(this.uraDago(pX, pY)) {
			tiroa= true;
		}		
		return tiroa;
		}
	
	public String koordenatuanZerDagoen(short pX, short pY) {
		//salbuespen del teklado SE MIRA AL PEDIR LA CORDENADA
		//honek etsaiaren tableroan begiratuko du zer dagoen kasilan, itsasontzia baldin badago " U" bueltatzen du, bestela, han dagoena, hau da, ura "-"
		String ema= this.matrizea[pY][pX];
		String bat=" 1";
		String bi = " 2";
		String hiru = " 3";
		String lau =" 4";
		//System.out.println( "matrizean dagoenaaaaaaaa   !m" + this.matrizea[pY][pX] );
		//System.out.println("EMA hasierako balioa .... " + ema);
		if( ema.equals(bat)  || ema.equals(bi)  || ema.equals(hiru)  || ema.equals(lau) ) { //   ||this.matrizea[pY][pX].equals(bi)  || this.matrizea[pY][pX].equals(hiru)  || this.matrizea[pY][pX].equals(lau)
			ema = " U";
			//System.out.println("EMA LO QUE se supne que hay si entra en el if " + ema);
		}	
		//System.out.println("EMA LO QUE devuelve " + ema);
		return ema ;		
	}
	
	private boolean uraDago(short pX, short pY) {
		boolean dago=false;
		if( this.matrizea[pY][pX] == " -") {
			dago=true;
		}		
		return dago;		
	}
	

	
	private boolean konprobatuHutsuneak(short pX, short pY, short pItsas, String pOrientazio ) {		
	
		//true bueltatzen du itsasontzien hartean hiutsuneak egongo badira itsasontzia koordenatu horretan jarrri ostean, bestela false, hau da, itsasontzia ezin da han jarri
		//pItsas esango digu zein motatak itsasontzia den, guk jakitek zein koordenatuan amaituko den itsasontzia
		//itsasontzien hartean gutxienez kasila bat tartean egon behar da
		boolean hutsune = true;
		short aux=0;
		short amZut=0;
		short amEr=0;
		//orientazioaren arabera prozedura desberdina izango da
		if ( pOrientazio.equals("H")  || pOrientazio.equals("h") ) { 
			//System.out.println( " konprobatuHutsuneak PRIMER IF  H ");
			//horizontalean
			amZut= (short )(pX + pItsas-1);//-1 EGITEN DUGU, JAKITEKO ITSASONTZIAREN AZKENENGO KASILA
			amEr= pY;
			if(pX!=1) {
				//System.out.println( " konprobatuHutsuneak  IF PX!=1 EZKERREKO");
				if( this.koordenatuanZerDagoen((short)(pX-1), pY).equals(" U") ) { //EZKERREKO KASILAN BEGIRATU
					//System.out.println( " konprobatuHutsuneak  EZK1 jjdsjdjdjj");
					hutsune = false;
				}}
			if(pX != this.errenZutKop-1) {
				//System.out.println( " konprobatuHutsuneak  IF PX!=this.errenZutKop ESKUINEKO ");
				if(this.koordenatuanZerDagoen( amZut, amEr) == " U") { //ESKUINEKO KASILAN BEGIRATU
				hutsune = false;	
				//System.out.println( " konprobatuHutsuneak  ESK1");
				}}
			aux=(short)(pX-1);
			if(pY!=1 && amZut != this.errenZutKop-1 ) { 
				//System.out.println( " konprobatuHutsuneak  pY!=1  GOIKO");
				while(hutsune && aux<= (amZut+1)) {		//GOIKO ERRENKETAKO KASILAK BEGIRATU		
					if(this.koordenatuanZerDagoen(aux, (short)(pY-1)) == " U") {
							hutsune = false;
							//System.out.println( " konprobatuHutsuneak  GOI");
						}
						aux++;
					}
			}
			else if(pY!=1 && amZut == this.errenZutKop-1 ) {
				//System.out.println( " konprobatuHutsuneak  pY!=1  GOIKO bisssss");
				while(hutsune && aux<= amZut) {		//GOIKO ERRENKETAKO KASILAK BEGIRATU		
					if(this.koordenatuanZerDagoen(aux, (short)(pY-1)) == " U") {
							hutsune = false;
							//System.out.println( " konprobatuHutsuneak  GOI");
						}
						aux++;
					}
			}

			aux=(short)(pX-1) ;
			if(pY != this.errenZutKop-1  && amZut != this.errenZutKop-1) {
				//System.out.println( " konprobatuHutsuneak  (pY != this.errenZutKop   BEHEKO");
				while(hutsune && aux<= (amZut+1)) {				
					if(this.koordenatuanZerDagoen(aux, (short)(pY+1)) == " U") { //BEHEKO ERRENKADAKO KASILETAN BEGIRATU
						hutsune = false;
						//System.out.println( " konprobatuHutsuneak  BEHE");
					}
					aux++;
				}
			}
			else if (pY != this.errenZutKop-1 && amZut == this.errenZutKop-1 ) {
				//System.out.println( " konprobatuHutsuneak  (pY != this.errenZutKop   BEHEKO bisssss");
				while(hutsune && aux<= amZut) {				
					if(this.koordenatuanZerDagoen(aux, (short)(pY+1)) == " U") { //BEHEKO ERRENKADAKO KASILETAN BEGIRATU
						hutsune = false;
						//System.out.println( " konprobatuHutsuneak  BEHE");
					}
					aux++;
				}
			}

		}
		else if (pOrientazio.equals("B") || pOrientazio.equals("b")) {
			//System.out.println( " konprobatuHutsuneak PRIMER IF  B ");
			//Bertikalean
			amEr= (short )(pY + pItsas -1); //-1 EGITEN DUGU, JAKITEKO ITSASONTZIAREN AZKENENGO KASILA
			amZut= pX;
			if(pY!=1 ) {
				//System.out.println( " konprobatuHutsuneak  pY!=1 gOIKO");
				if(this.koordenatuanZerDagoen(pX, (short)(pY-1)) == " U") { //gOIKO KASILAN BEGIRATU
					//System.out.println( " konprobatuHutsuneak  GOI");
					hutsune = false;
				}
			}			
			
			if(pY != this.errenZutKop-1 ) {   
				//System.out.println( " konprobatuHutsuneak  pY != this.errenZutKop BEHEKO");
				if(this.koordenatuanZerDagoen( amZut, amEr) == " U") { //BEHEKO KASILAN BEGIRATU
					hutsune = false;	
				}
			}
				aux=(short) (pY-1);
			if(pX!=1  && amEr != this.errenZutKop-1 ) { //pY != this.errenZutKop-1
				//System.out.println( " konprobatuHutsuneak pX!=1 EZKERREKO");
				while(hutsune && aux<= (amEr+1)) {		//EZKERREKO ZUTABEKOKASILAK BEGIRATU		
					if( this.koordenatuanZerDagoen((short) (pX-1), aux) == " U") {
						//System.out.println( " konprobatuHutsuneak EZK");
						hutsune = false;
					}
					aux++;
				}
			}
			else if(pX!=1  && amEr == this.errenZutKop-1) {
				//System.out.println( " else if konprobatuHutsuneak pX!=1 EZKERREKO bis");
				while(hutsune && aux<= amEr) {		//EZKERREKO ZUTABEKOKASILAK BEGIRATU		
					if( this.koordenatuanZerDagoen((short) (pX-1), aux) == " U") {
						//System.out.println( " konprobatuHutsuneak EZK");
						hutsune = false;
					}
					aux++;
				}
			}
				aux=(short) (pY-1);
			if(pX != this.errenZutKop-1 && amEr != this.errenZutKop-1  ) {  //&& pY != this.errenZutKop-1 
				//System.out.println( " konprobatuHutsuneak pX != this.errenZutKop ESKUINEKO");
				while(hutsune && aux<= (amEr+1)) {			//ESKUINEKO ZUTABEKOKASILAK BEGIRATU	
					if(this.koordenatuanZerDagoen((short) (pX+1), aux) == " U") {
						//System.out.println( " konprobatuHutsuneak ESK");
						hutsune = false;
					}
					aux++;
				}
			}
			else if(pX != this.errenZutKop-1 &&  amEr == this.errenZutKop-1 ) {
				//System.out.println( "else if konprobatuHutsuneak pY != this.errenZutKop ESKUINEKO bis");
				while(hutsune && aux<= amEr) {			//ESKUINEKO ZUTABEKOKASILAK BEGIRATU	
					if(this.koordenatuanZerDagoen((short) (pX+1), aux) == " U") {
						//System.out.println( " konprobatuHutsuneak ESK");
						hutsune = false;
					}
					aux++;
				}
			}
		}
		return hutsune;
	}
	
	
	public void eguneratuTableroa( short pX, short pY, String pEmaitza) {
		//etsaiak koordenatu horretan duena zure tableroan jarriko du metodo honek
		if ( pEmaitza != " U") {
			pEmaitza= " X"; //jarriko du X bat gero konprobatuTiroa jakiteko ea koordenatu hori lehenik esan dugun ala ez
		}
		this.matrizea[pY][pX] = pEmaitza;
		this.tableroaInprimatu();
	}
	

	
	//izkinen konprobaketak JokalariCPU-n beharrezkoa da metodo hau:
	public int getErrenkadaZutKop() {
		return this.errenZutKop;
	}
	
	//Testak egiteko behar dugun metodoa:
	public void KoordenatuanJarri ( int pX, int pY, String pJarri) {
	this.matrizea[pY][pX] = pJarri;
	}
}
