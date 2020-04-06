package packjokoa;
import salbuespenak.*;

public class JokalariArrunta extends Jokalaria {
	
	public JokalariArrunta(String pIzena, short pErrenkadaZutKop) {
		super(pIzena, pErrenkadaZutKop); 
	}
	

	public Koordenatuak koordenatuaAukeratu() {	
		//koordenatuak eskatu
		
		String pMezua1="Sartu zure lehenengo koordenatua mesedez";
		short pX=Teklatua.getNireTeklatua().irakurriShort(pMezua1, 1, 10);
		String pMezua2="Sartu zure lehenengo koordenatua mesedez";
		short pY=Teklatua.getNireTeklatua().irakurriShort(pMezua2, 1, 10);
		Koordenatuak k = new Koordenatuak(pX, pY);
		
		return k;
		/*
		boolean posibleaDa=true;
		while(posibleaDa) {
			if(this.koordenadaBaliogarriak(pX, pY)) {
				String emaitza = pJokalaria.koordenatuanZerDagoen(pX, pY);
				this.eguneratuPrintTableroa(pX, pY, emaitza);
				if(emaitza!="U") {
					//Itsasontzia ez badu ukitzen:
					posibleaDa=false; 
				}
				else {
					//koordenatuak eskatu berriro, itsasontzia ukitu duelako
					String pMezua11="Sartu zure lehenengo koordenatua mesedez";
					pX=Teklatua.getNireTeklatua().irakurriShort(pMezua11, 1, 10);
					String pMezua21="Sartu zure lehenengo koordenatua mesedez";
				    pY=Teklatua.getNireTeklatua().irakurriShort(pMezua21, 1, 10);
				}
			}
			else {
				posibleaDa=false;
			}
		}*/
		
	}

	public boolean koordenadaBaliogarriak(short pX, short pY) {
		 return super.getNireTableroa().konprobatuTiroa(pX, pY);
	}


	public String koordenatuanZerDagoen(short pX, short pY) {
		return super.koordenatuanZerDagoen(pX, pY);
		//itzuliko duen String-a hirugarren tiroan erabiliko da
	}

	public  void eguneratuPrintTableroa(short pX, short pY, String pEma) {
		// primeros llamamos a super.nUkituaInkrementatu y luego a tableroa.eguneratu
		//bigarren tiroan itzuli duen String-a dagokion posizioan sartuko du
		if(pEma=="U") {
			super.nUkituaInkrementatu();
		}
		this.getNireTableroa().eguneratuTableroa(pX,pY,pEma);
	}
	
	/*public void setIzena(String pIzena) {
		super.setIzena(pIzena);
	}*/
	
	public boolean itsasontzirikEz() {
		return super.itsasontzirikEz();
	}   
	
	
	
	
	public void itsasontziakJarri(int pErrenkadaZutKop) {
		//salbuespenak: konprobatu posibeak direla koordenatuak, orientazioa eta ez badira zuzenak berriro jartzeko eskatuko zaio erabiltzaileari
		short pItsas=1;
		String pOrientazioa="H";
		String itsasMota="Ezezagun";//bapaezpada hasieratuko dugu
		boolean denaOndo2=false;
		
		//itsasontziak beti orden berdinean jarriko dira
		while(pItsas<5) {
			do {
			
			//hiztegi txiki bat sortuko dugu itsasontzentzako			
			switch(pItsas) {
			 case 1:
				 itsasMota="txalupa";
				 break;
			 case 2:
				 itsasMota="itsaspeko"; 
				 break;
			 case 3:
				 itsasMota="suntsitzailea";
				 break;
			 case 4:
				 itsasMota="portahegazkinak";
				 break;
			 } //switch
			//koordenatuak pantailatik eskatu
			
			System.out.println(" ");
			String pMezua1="Orain "+itsasMota+ " jarriko duzu "+ pItsas +" laukiko itsasontzia da, mesedez sartu zutabea ";
			short pX= (short) (Teklatua.getNireTeklatua().irakurriShort(pMezua1, 0, 9)+1);
			
			String pMezua2="Sartu errenkada mesedez";
			short pY= (short) (Teklatua.getNireTeklatua().irakurriShort(pMezua2, 0, 9)+1);
			
		
			 if(pItsas!=1) {//1-eko itsasontzia ez du arazorik ematen			
			String pMezua3="Sartu barkuaren orientazioa: H edo B";			
			String pH="h";
			String pB="b";
			pOrientazioa=Teklatua.getNireTeklatua().irakurriOrientazioa(pMezua3, pH, pB); 		
			 }
		   
		 
			   try {
				   if( pOrientazioa.equals("B") || pOrientazioa.equals("b")) {
					   if ((pY+pItsas-1>= ( pErrenkadaZutKop) +1)) {
						  // System.out.println("A VER SI ENTRAAA     IndexOutOfBoundsException");
						   throw new IndexOutOfBoundsException();
					   }
				   }
				   else if(pOrientazioa.equals("H") || pOrientazioa.equals("h")) {
					   if ((pX+pItsas-1>= (pErrenkadaZutKop+1))) {
						  //System.out.println("A VER SI ENTRAAA     IndexOutOfBoundsException");
						   throw new IndexOutOfBoundsException();
					   }
				   }
				   //System.out.println("A VER SI ENTRAAA     IndexOutOfBoundsException  DESPUES DE THROW");
				   this.getNireTableroa().itsasontziakJarri(pX, pY, pItsas, pOrientazioa);
				   denaOndo2=true;
				   
				}
				catch(IndexOutOfBoundsException e) {
					System.out.println("Sartu duzun itsasontzia ez da sartzen");
					denaOndo2=false;
					
				}
			   catch(KoordenatuEzEgokiak e) {
				   denaOndo2=false;
				   e.inprimatuMezua();
				   System.out.println(" ");
			   }
		   //}
		}  while(!denaOndo2);  //do
			denaOndo2=false;
			pItsas++;
		}//while(pItsas<5)
	}
	
	
	
}
