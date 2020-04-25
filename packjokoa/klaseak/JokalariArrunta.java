package klaseak;
import salbuespenak.*;

public class JokalariArrunta extends Jokalaria {
	
	public JokalariArrunta(String pIzena, short pErrenkadaZutKop) {
		super(pIzena, pErrenkadaZutKop); 
	}
	

	public Koordenatuak koordenatuaAukeratu() {	
		//koordenatuak eskatu
		System.out.println(" ");
		String pMezua1="Sartu zure lehenengo koordenatua mesedez";
		short pX=(short) (Teklatua.getNireTeklatua().irakurriShort(pMezua1, 0, 9));
		String pMezua2="Sartu zure bigarren koordenatua mesedez";
		short pY=(short) (Teklatua.getNireTeklatua().irakurriShort(pMezua2, 0, 9));
		System.out.println(" ");
		Koordenatuak k = new Koordenatuak(pX, pY);		
		return k;
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
			
			//hiztegi txiki bat sortuko dugu itsasontzientzako			
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
			this.getNireTableroa().tableroaInprimatu();
		}//while(pItsas<5)
	}
	
	
	
}
