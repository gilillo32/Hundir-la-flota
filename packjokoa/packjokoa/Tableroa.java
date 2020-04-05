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
				this.matrizea[e][z] = " -";				
				z++;
			}	
			e++;
		}	
		this.tableroaInprimatu();		
	} 
	

	public void itsasontziakJarri (short pX, short pY,short pItsas, String pOrientazio) throws KoordenatuEzEgokiak{
		int aux=0;

		//itsasontzia jarriko dugu:
		if(	 this.konprobatuItsasontsirikEzKoordenatuan(pX, pY, pItsas, pOrientazio) && this.konprobatuHutsuneak(pX, pY, pItsas, pOrientazio)) {
			//orentazioaren arabera bi modu:	
			System.out.println( " itsasontziakJarri primer if ");
			if (pOrientazio.equals("H")  || pOrientazio.equals("h") ) {//pY ez da aldatzen  
				
				aux= pX+pItsas;
				
				while(pX<aux) {
					
					 this.matrizea[pY][pX]=  (" " + String.valueOf(pItsas));
					pX++;
				}
			}
			else if(pOrientazio.equals("B") || pOrientazio.equals("b") ) {//pX ez da aldatzen   
				
				aux	=pY+ pItsas;
				while(pY<aux) {
					
					 this.matrizea[pY][pX]= (" " + String.valueOf(pItsas));
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
		if ( pOrientazio.equals("H")  || pOrientazio.equals("h") ) {//pY ez da aldatzen
			aux= pX+pItsas;
			System.out.println( " konprobatuItsasontsirikEzKoordenatuan PRIMER IF ");
			while(pX<aux && emaitza) {
				System.out.println( " konprobatuItsasontsirikEzKoordenatuan WHILE ");
				System.out.println( this.koordenatuanZerDagoen(pX, pY));
				if (  this.koordenatuanZerDagoen(pX, pY).equals("U")) { //U bat bueltazen badu esan nahi du itsasontsi bat dagoela han
					emaitza=false;
					System.out.println( " konprobatuItsasontsirikEzKoordenatuan SEGUNDO IF ");
				}				 
				pX++;
			}			
		}
		else if( pOrientazio.equals("B") || pOrientazio.equals("b") ) {//pX ez da aldatzen
			System.out.println( " konprobatuItsasontsirikEzKoordenatuan ELSE IF ");
			aux	=pY+ pItsas;
			while(pY<aux) {
				System.out.println( " konprobatuItsasontsirikEzKoordenatuan SEGUNDO WHILE ");
				if (  this.koordenatuanZerDagoen(pX, pY).equals("U")) {
					System.out.println( " konprobatuItsasontsirikEzKoordenatuan TERCER IF ");
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
		String ema= this.matrizea[pY][pX];
		String bat=" 1";
		String bi = " 2";
		String hiru = " 3";
		String lau =" 4";
		//System.out.println( "matrizean dagoenaaaaaaaa   !m" + this.matrizea[pY][pX] );
		//System.out.println("EMA hasierako balioa .... " + ema);
		if( ema.equals(bat)  || ema.equals(bi)  || ema.equals(hiru)  || ema.equals(lau) ) { //   ||this.matrizea[pY][pX].equals(bi)  || this.matrizea[pY][pX].equals(hiru)  || this.matrizea[pY][pX].equals(lau)
			ema = "U";
			//System.out.println("EMA LO QUE se supne que hay si entra en el if " + ema);
		}	
		//System.out.println("EMA LO QUE devuelve " + ema);
		return ema ;		
	}
	
	private boolean uraDago(short pX, short pY) {
		boolean dago=false;
		if( this.matrizea[pY][pX] == "-") {
			dago=true;
		}		
		return dago;		
	}
	

	
	private boolean konprobatuHutsuneak(short pX, short pY, short pItsas, String pOrientazio ) {		
	
		//true bueltatzen du itsasontzien hartean hiutsuneak egongo badira itsasontsia koordenatu horretan jarrri ostean, bestela false, hau da, itsasontzia ezin da han jarri
		//pItsas esango digu zein motatak itsasontsia den, guk jakitek zein koordenatuan amaituko den itsasontzia
		//itsasontsien hartean gutxienez kasila bat tartean egon behar da
		boolean hutsune = true;
		short aux=0;
		short amaierakoEr=0;
		short amaierakoZut=0;
		//orientazioaren arabera prozedura desberdina izango da
		if ( pOrientazio.equals("H")  || pOrientazio.equals("h") ) { 
			System.out.println( " konprobatuHutsuneak PRIMER IF  H ");
			//horizontalean
			amaierakoEr= (short )(pX + pItsas);
			amaierakoZut= pY;
			if(pX!=1) {
				System.out.println( " konprobatuHutsuneak  IF PX!=1 ");
				if( this.koordenatuanZerDagoen((short)(pX-1), pY).equals("U") ) { //EZKERREKO KASILAN BEGIRATU
					System.out.println( " konprobatuHutsuneak  EZK1 jjdsjdjdjj");
					hutsune = false;
				}}
			if(pX != this.errenZutKop-1) {
				System.out.println( " konprobatuHutsuneak  IF PX!=this.errenZutKop ");
				if(this.koordenatuanZerDagoen( amaierakoEr, amaierakoZut) == "U") { //ESKUINEKO KASILAN BEGIRATU
				hutsune = false;	
				System.out.println( " konprobatuHutsuneak  ESK1");
				}}
			aux=(short)(pX-1);
			if(pY!=1) {
				System.out.println( " konprobatuHutsuneak  pY!=1");
			while(hutsune && aux< (amaierakoEr+1)) {		//GOIKO ERRENKETAKO KASILAK BEGIRATU		
				if(this.koordenatuanZerDagoen(aux, (short)(pY-1)) == "U") {
						hutsune = false;
						System.out.println( " konprobatuHutsuneak  GOI");
					}
					aux++;
				}
			}
			aux=(short)(pX-1) ;
			if(pY != this.errenZutKop-1) {
				System.out.println( " konprobatuHutsuneak  (pY != this.errenZutKop");
				while(hutsune && aux< (amaierakoEr+1)) {				
					if(this.koordenatuanZerDagoen(aux, (short)(pY+1)) == "U") { //BEHEKO ERRENKADAKO KASILETAN BEGIRATU
						hutsune = false;
						System.out.println( " konprobatuHutsuneak  BEHE");
					}
					aux++;
				}
			}			
		}
		else if (pOrientazio.equals("B") || pOrientazio.equals("b")) {
			System.out.println( " konprobatuHutsuneak PRIMER IF  B ");
			//Bertikalean
			amaierakoEr=  pX;
			amaierakoZut= (short )(pY + pItsas);
			if(pY!=1) {
				System.out.println( " konprobatuHutsuneak  pY!=1");
				if(this.koordenatuanZerDagoen(pX, (short)(pY-1)) == "U") { //gOIKO KASILAN BEGIRATU
					System.out.println( " konprobatuHutsuneak  GOI");
					hutsune = false;
				}
			}
			if(pY != this.errenZutKop-1) {
				System.out.println( " konprobatuHutsuneak  pY != this.errenZutKop");
				if(this.koordenatuanZerDagoen( amaierakoEr, amaierakoZut) == "U") { //BEHEKO KASILAN BEGIRATU
					hutsune = false;	
				}
			}
				aux=(short) (pY-1);
			if(pX!=1) {
				System.out.println( " konprobatuHutsuneak pX!=1");
				while(hutsune && aux< (amaierakoZut+1)) {		//EZKERREKO ZUTABEKOKASILAK BEGIRATU		
					if( this.koordenatuanZerDagoen((short) (pX-1), aux) == "U") {
						System.out.println( " konprobatuHutsuneak EZK");
						hutsune = false;
					}
					aux++;
				}
			}
				aux=(short) (pY-1);
			if(pX != this.errenZutKop-1) {
				System.out.println( " konprobatuHutsuneak pX != this.errenZutKop");
				while(hutsune && aux< (amaierakoZut+1)) {			//ESKUINEKO ZUTABEKOKASILAK BEGIRATU	
					if(this.koordenatuanZerDagoen((short) (pX+1), aux) == "U") {
						System.out.println( " konprobatuHutsuneak ESK");
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
		if ( pEmaitza != "U") {
			pEmaitza= "X"; //jarriko du X bat gero konprobatuTiroa jakiteko ea koordenatu hori lehenik esan dugun ala ez
		}
		this.matrizea[pY][pX] = pEmaitza;
	}
	

	
	//izkinen konprobaketak JokalariCPU-n beharrezkoa da metodo hau:
	public int getErrenkadaZutKop() {
		return this.errenZutKop;
	}

}
