package klaseak;

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
			if(pOrientazio.equals("B") || pOrientazio.equals("b") ) {//pX ez da aldatzen   
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
	    if( pOrientazio.equals("B") || pOrientazio.equals("b") ) {//pX ez da aldatzen
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
		if(ema!=null){
			if( ema.equals(bat)  || ema.equals(bi)  || ema.equals(hiru)  || ema.equals(lau) ) { 
				ema = " U";
			}	
		}
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
		/* true bueltatzen du itsasontzien hartean hiutsuneak egongo badira itsasontzia koordenatu horretan jarrri ostean, bestela false, hau da, itsasontzia ezin da han jarri
		   pItsas esango digu zein motatak itsasontzia den, guk jakitek zein koordenatuan amaituko den itsasontzia
		   itsasontzien hartean gutxienez kasila bat tartean egon behar da
		*/
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
			/*if(pX != this.errenZutKop-1 && amZut==this.errenZutKop-1) {
				//System.out.println( " konprobatuHutsuneak  IF PX!=this.errenZutKop ESKUINEKO ");
				if(this.koordenatuanZerDagoen( amZut, amEr) == " U") { //ESKUINEKO KASILAN BEGIRATU
				hutsune = false;	
				//System.out.println( " konprobatuHutsuneak  ESK1");
				}
			}
			else*/ if (pX != this.errenZutKop-1 && amZut!=this.errenZutKop-1) {
				if(this.koordenatuanZerDagoen((short)(amZut+1), amEr) == " U") { //ESKUINEKO KASILAN BEGIRATU
					hutsune = false;	
					//System.out.println( " konprobatuHutsuneak  ESK1");
					}
			}
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
		 if(pY!=1 && amZut == this.errenZutKop-1 ) {
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
			if (pY != this.errenZutKop-1 && amZut == this.errenZutKop-1 ) {
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
		if (pOrientazio.equals("B") || pOrientazio.equals("b")) {
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
			
			if(pY != this.errenZutKop-1 && amEr != this.errenZutKop-1) {   
				//System.out.println( " konprobatuHutsuneak  pY != this.errenZutKop BEHEKO");
				if(this.koordenatuanZerDagoen( amZut, (short)(amEr+1)) == " U") { //BEHEKO KASILAN BEGIRATU
					hutsune = false;	
				}
			}
				aux=(short) (pY-1);
			if(pX!=1  && amEr != this.errenZutKop-1 ) { //pY != this.errenZutKop-1
				//System.out.println( " konprobatuHutsuneak pX!=1 EZKERREKO");
				if (pY!=1) {
					while(hutsune && aux<= (amEr+1)) {		//EZKERREKO ZUTABEKO KASILAK BEGIRATU	(ez da azkenengo errenkada)	
						if( this.koordenatuanZerDagoen((short) (pX-1), aux) == " U") {
							//System.out.println( " konprobatuHutsuneak EZK");
							hutsune = false;
						}
					aux++;
					}
				}
				else {
					aux=(short) (pY);
					while(hutsune && aux<= (amEr+1)) {		//EZKERREKO ZUTABEKO KASILAK BEGIRATU	(baina ez diagonala)
						if( this.koordenatuanZerDagoen((short) (pX-1), aux) == " U") {
							//System.out.println( " konprobatuHutsuneak EZK");
							hutsune = false;
						}
					aux++;
					}
				}
			}
			if(pX!=1  && amEr == this.errenZutKop-1) {
				//System.out.println( " else if konprobatuHutsuneak pX!=1 EZKERREKO bis");
				while(hutsune && aux<= amEr) {		//EZKERREKO ZUTABEKO KASILAK BEGIRATU	 (azkennego errenkada da)	
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
				if(pY!=1) {
					while(hutsune && aux<= (amEr+1)) {			//ESKUINEKO ZUTABEKOKASILAK BEGIRATU	
						if(this.koordenatuanZerDagoen((short) (pX+1), aux) == " U") {
							//System.out.println( " konprobatuHutsuneak ESK");
							hutsune = false;
						}
						aux++;
					}
				}
				else {
					aux=(short) (pY);
					while(hutsune && aux<= (amEr+1)) {			//ESKUINEKO ZUTABEKOKASILAK BEGIRATU	 (DIAGONALAK EZ)
						if(this.koordenatuanZerDagoen((short) (pX+1), aux) == " U") {
							//System.out.println( " konprobatuHutsuneak ESK");
							hutsune = false;
						}
						aux++;
					}
				}
			}
		   if(pX != this.errenZutKop-1 &&  amEr == this.errenZutKop-1 ) {
				//System.out.println( "else if konprobatuHutsuneak pY != this.errenZutKop ESKUINEKO bis");
				while(hutsune && aux<= amEr) {			//ESKUINEKO ZUTABEKOKASILAK BEGIRATU	(azkennego errenkada da)	
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
		//etsaiak koordenatu horretan duena zure PRINTtABLERO-AN jarriko du metodo honek
		if ( pEmaitza != " U") {
			pEmaitza= " X"; //jarriko du X bat gero konprobatuTiroa jakiteko ea koordenatu hori lehenik esan dugun ala ez
		}
		this.matrizea[pY][pX] = pEmaitza;
	}
	
	public void XBete(short pX, short pY, int pItsas, byte pZentzua ) {	
		//lortuko dugu orientazioa
		String pOrientazio;
		if(pZentzua==0 || pZentzua==2) {
			pOrientazio="h";
		}
		else {
			pOrientazio="b";
		}
		
		boolean lehena=false;
		boolean azkena=false;		
		short aux=0;
		short amZut=0;
		short amEr=0;
		
		//orientazioaren arabera prozedura desberdina izango da
		if ( pOrientazio.equals("h") ) { 
			//ikusiko dugu ea koordenatua ezkerreko (lehena) ala eskuinekoa (azkena) den
			//lehen zutabea bada
			if(pX==1) {//Lehenengo koordenatua da
				lehena=true;
			}
			//azken zutabea bada
			else if(pX==this.errenZutKop-1){//azken koordenatua da
				azkena=true;
			}
			else {
				if(pItsas!=1) {
					//koordenatuanZerDagoen metodoa erabiliko dugu, " U" itzultzen badu lehena dela dakigu, bestela azkena
					if(this.koordenatuanZerDagoen((short)(pX+1),pY).equals(" U")) {
						lehena=true;
					}
					else {
						azkena=true;
					}
				}
			}
						
			//horizontalean
			if(azkena) {
				amZut=pX;
				pX=(short)(pX-pItsas+1);//+1 egiten dugu jakiteko itsasontziaren lehenengo kasila
			}
			else {
				amZut= (short )(pX + pItsas-1);//-1 EGITEN DUGU, JAKITEKO ITSASONTZIAREN AZKENENGO KASILA
			}
			amEr= pY;
			
			if(pX!=1) {
				this.matrizea[pY][(short)(pX-1)]= " X";
			}
				
			if (pX != this.errenZutKop-1 && amZut!=this.errenZutKop-1) {
				this.matrizea[amEr][(short)(amZut+1)]= " X";
			}
			
			aux=(short)(pX-1);
			if(pY!=1 && amZut != this.errenZutKop-1 ) { 
				while(aux<= (amZut+1)) {		//GOIKO ERRENKETAKO KASILAK BEGIRATU		
					this.matrizea[(short)(pY-1)][aux]= " X";
					aux++;
				}
			}
			if(pY!=1 && amZut == this.errenZutKop-1 ) {
				while(aux<= amZut) {		//GOIKO ERRENKETAKO KASILAK BEGIRATU		
					this.matrizea[(short)(pY-1)][aux]= " X";
					aux++;
				}
			}

			aux=(short)(pX-1) ;
			if(pY != this.errenZutKop-1  && amZut != this.errenZutKop-1) {
				while(aux<= (amZut+1)) {				
					this.matrizea[(short)(pY+1)][aux]= " X";
					aux++;
				}
			}
			if (pY != this.errenZutKop-1 && amZut == this.errenZutKop-1 ) {
				while( aux<= amZut) {				
					this.matrizea[(short)(pY+1)][aux]= " X";				
					aux++;
				}
			}
		}	
		else {
			//ikusiko dugu ea koordenatua goikoa (lehena) ala behekoa (azkena) den
			//lehen errenkada bada
			if(pY==1) {//Lehenengo koordenatua da
				lehena=true;
			}
			//azken errenkada bada
			else if(pY==this.errenZutKop-1){//azken koordenatua da
				azkena=true;
			}
			else {
				if(pItsas!=1) {
					//koordenatuanZerDagoen metodoa erabiliko dugu, " U" itzultzen badu lehena dela dakigu, bestela azkena
					if(this.koordenatuanZerDagoen(pX,(short)(pY+1)).equals(" U")) {
						lehena=true;
					}
					else {
						azkena=true;
					}
				}
			}
			//Bertikalean
			if(azkena) {
				amEr=pY;
				pY=(short)(pY-pItsas+1);//+1 egiten dugu jakiteko itsasontziaren lehenengo kasila
			}
			else {
				amEr= (short )(pY + pItsas -1); //-1 EGITEN DUGU, JAKITEKO ITSASONTZIAREN AZKENENGO KASILA
			}
			amZut= pX;
			
			if(pY!=1 ) {
				this.matrizea[(short)(pY-1)][pX]= " X";	
			}			
			
			if(pY != this.errenZutKop-1 && amEr != this.errenZutKop-1) {   
				this.matrizea[(short)(amEr+1)][amZut]= " X";	
			}
			
			aux=(short) (pY-1);
			if(pX!=1  && amEr != this.errenZutKop-1 ) { 
				if (pY!=1) {
					while(aux<= (amEr+1)) {		//EZKERREKO ZUTABEKO KASILAK BEGIRATU	(ez da azkenengo errenkada)	
						this.matrizea[aux][(short) (pX-1)]= " X";
						aux++;
					}
				}
				else {
					aux=(short) (pY);
					while(aux<= (amEr+1)) {		//EZKERREKO ZUTABEKO KASILAK BEGIRATU	(baina ez diagonala)
						this.matrizea[aux][(short) (pX-1)]= " X";	
						aux++;
					}
				}
			}
			
			if(pX!=1  && amEr == this.errenZutKop-1) {
				while(aux<= amEr) {		//EZKERREKO ZUTABEKO KASILAK BEGIRATU	 (azkenengo errenkada da)	
					this.matrizea[aux][(short) (pX-1)]= " X";
					aux++;
				}
			}
			aux=(short) (pY-1);
			if(pX != this.errenZutKop-1 && amEr != this.errenZutKop-1  ) {  
				if(pY!=1) {
					while(aux<= (amEr+1)) {			//ESKUINEKO ZUTABEKOKASILAK BEGIRATU	
						this.matrizea[aux][(short) (pX+1)]= " X";
						aux++;
					}
				}
				else {
					aux=(short) (pY);
					while(aux<= (amEr+1)) {			//ESKUINEKO ZUTABEKOKASILAK BEGIRATU	 (DIAGONALAK EZ)
						this.matrizea[aux][(short) (pX+1)]= " X";
						aux++;
					}
				}
			}
		   if(pX != this.errenZutKop-1 &&  amEr == this.errenZutKop-1 ) {
				while(aux<= amEr) {			//ESKUINEKO ZUTABEKOKASILAK BEGIRATU	(azkenengo errenkada da)	
					this.matrizea[aux][(short) (pX+1)]= " X";
					aux++;
				}
			}
		}
}
		
	public boolean hondoratutaDago (int pItsas) {
		boolean emaitza=true;
		String itsas="";
		
		if(pItsas==2) {
			itsas=" 2";
		}
		else if(pItsas==3) {
			itsas=" 3";
		}
		else if(pItsas==4) {
			itsas=" 4";
		}
		else {
			itsas=" -";
		}
		
		if(pItsas!=1) {
			int i=1;
			int j=1;
			while(i<this.errenZutKop && emaitza) {
				j=1;
				while(j<this.errenZutKop && emaitza) {
					if( this.matrizea[j][i].equals(itsas) ) {
						emaitza=false;
					}
					j++;
				}
				i++;
			}
		}
		return emaitza;
	}
	
	public int zeItsasontziHondoratu(short pX, short pY) {
		int emaitza=0;
		String itsas=this.matrizea[pY][pX];
		if(itsas.equals(" 1")) {
			emaitza=1;
		}
		else if(itsas.equals(" 2")) {
			emaitza=2;
		}
		else if(itsas.equals(" 3")) {
			emaitza=3;
		}
		else if(itsas.equals(" 4")) {
			emaitza=4;
		}
		else if(itsas.equals(" X")) {
			emaitza=-1;
		}
		return emaitza;
	}
	
	//izkinen konprobaketak JokalariCPU-n beharrezkoa da metodo hau:
	public int getErrenkadaZutKop() {
		return this.errenZutKop;
	}
	
////////////////////////TESTAK EGITEKO BEHAR DITUGUN METODOAK ////////////////////////
	public void koordenatuanJarri ( int pX, int pY, String pJarri) {
	// 	NIK NAHI DUDAN KARAKTEREA JARTZEN DU NIK AUKERATUTAKO KOORDENATUAN
	// !!!!!KONTUZ!!!!!  LEHENENGO KOORDENATU HORRI +1 EGITEN DIO ETA!!!!!!!!!!
	this.matrizea[pY+1][pX+1] = pJarri;
	}	

	public boolean konprobatuItsasontziakJarri(short pX, short pY,short pItsas, String pOrientazio) {
		boolean emaitza= true;
		try {
			//gehi bat egin dugu JokalariArruntan bezala, matrizea 11x11 delako eta koordenatu horrek matrizean duen benetako posizioa +1 eginez da
			this.itsasontziakJarri((short)(pX+1), (short)(pY+1), pItsas, pOrientazio);
		}
		catch (KoordenatuEzEgokiak e){
			emaitza= false;
		}
		return emaitza;
	}
}
