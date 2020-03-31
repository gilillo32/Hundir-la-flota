package packjokoa;
import salbuespenak.*;

public class JokalariArrunta extends Jokalaria {
	
	public JokalariArrunta(String pIzena, Short pErrenkadaZutKop) {
		super(pIzena, pErrenkadaZutKop); 
	}
	
	@Override
	public Koordenatuak txandaBatJokatu() {	
		//koordenatuak eskatu
		
		String pMezua1="Sartu zure lehenengo koordenatua mesedez";
		Short pX=Teklatua.getNireTeklatua().irakurriShort(pMezua1, 1, 10);
		String pMezua2="Sartu zure lehenengo koordenatua mesedez";
		Short pY=Teklatua.getNireTeklatua().irakurriShort(pMezua2, 1, 10);
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
	
	
	
	
	public  void itsasontziakJarri(int pErrenkadaZutKop) {
		//salbuespenak: konprobatu posibeak direla koordenatuak, orientazioa eta ez badira zuzenak berriro jartzeko eskatuko zaio erabiltzaileari
		short pItsas=0;
		String pOrientazioa="Ezezagun";
		String itsasMota="Ezezagun";//bapaezpada hasieratuko dugu
		boolean denaOndo=false;
		boolean denaOndo2=false;
		
		//itsasontziak beti orden berdinean jarriko dira
		while(pItsas<5) {
			pItsas++;
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
			
			do {
			
			
			
			String pMezua1="Orain "+itsasMota+ " jarriko duzu "+ pItsas +" laukiko itsasontzia da, mesedez sartu lehengo koordenatua ";
			Short pX=Teklatua.getNireTeklatua().irakurriShort(pMezua1, 0, 10);
			
			String pMezua2="Sartu bigarren koordenatua mesedez";
			Short pY=Teklatua.getNireTeklatua().irakurriShort(pMezua2, 0, 10);
			
			String pMezua3="Sartu barkuaren orientazioa: H edo B";
			do {
			 pOrientazioa=Teklatua.getNireTeklatua().irakurriString(pMezua3); //MALLL
				try{
					if(pOrientazioa!="B" || pOrientazioa!="b" || pOrientazioa!="H" || pOrientazioa!="h") {
						throw new  OrientazioExc("Sartu behar duzu H edo B");
					}
					denaOndo=true;
				}
				catch (OrientazioExc e){
					e.mezuaInprimatu();
				}
				}while(!denaOndo);			
			
		   
		   if(pItsas!=1) {//1-eko itsasontzia ez du arazorik ematen
			   try {
				   if ((pX+pItsas-1>=pErrenkadaZutKop ) || (pY+pItsas-1>= pErrenkadaZutKop) ) {
					   throw new IndexOutOfBoundsException();
				   }
				   this.getNireTableroa().itsasontziakJarri(pX, pY, pItsas, pOrientazioa);
					denaOndo2=true;
				}
				catch(IndexOutOfBoundsException e) {
					System.out.println("Sartu duzun itsasontzia ez da sartzen");
					
				}
			   catch(KoordenatuEzEgokiak e) {
				   e.inprimatuMezua();
			   }
		   }
		}  while(!denaOndo2);  //do
		}//while(pItsas<5)
	}
	
	
	
}
