package klaseak;

import java.util.Scanner;
import salbuespenak.LimiteakGainditutaExc;

public class Proba{
	private static Proba nireTeklatua=null;
	private Scanner sc;
	private Tableroa nireTableroa;
	//eraikitzailea SINGLETON patroia
	private Proba(int pErrenkadaZutKop) {
		this.sc= new Scanner(System.in);
		this.nireTableroa=new Tableroa(pErrenkadaZutKop);
	} 
	
	public static synchronized Proba getNireTeklatua ( int pErrenkadaZutKop) {
		if(Proba.nireTeklatua==null) {
			Proba.nireTeklatua=new Proba(pErrenkadaZutKop);
		}
		return Proba.nireTeklatua;
	}

	public short irakurriShort(String pMezua, int i, int j) throws NumberFormatException{
		short emaitza = (short) (i -1);
        boolean denaOndo=false;
        do {
	        System.out.println(pMezua);
			String str = sc.nextLine();
		try{
			emaitza = Short.parseShort(str);
	        if(emaitza < i || emaitza >j){
	        	throw new LimiteakGainditutaExc("Limitetik kanpo");
            }
            denaOndo=true;
		} 
         catch (NumberFormatException e) { System.out.println("Balioa ez da numerikoa"); }
         catch (LimiteakGainditutaExc e) {
         e.getMessage();
         e.mezuaInprimatu();}
        }
        while(!denaOndo);
        return emaitza;
	}

	public void itsasontziakJarri(int pErrenkadaZutKop){
		//salbuespenak: konprobatu posibeak direla koordenatuak, orientazioa eta ez badira zuzenak berriro jartzeko eskatuko zaio erabiltzaileari
		short pItsas=0;
		String pOrientazioa="Ezezagun";
		String itsasMota="Ezezagun";//bapaezpada hasieratuko dugu
		boolean denaOndo=false;
		
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
			 }
			//koordenatuak pantailatik eskatu
			String pMezua1="Orain "+itsasMota+ " jarriko duzu "+ pItsas +" laukiko itsasontzia da, mesedez sartu lehengo koordenatua ";
			Short pX=Teklatua.getNireTeklatua().irakurriShort(pMezua1, 0, 10);
			
			String pMezua2="Sartu bigarren koordenatua mesedez";
			Short pY=Teklatua.getNireTeklatua().irakurriShort(pMezua2, 0, 10);
			
			String pMezua3="Sartu barkuaren orientazioa: H edo B";
			do {
			 pOrientazioa=Teklatua.getNireTeklatua().irakurriString(pMezua3); //MALLL
				try{
					if(pOrientazioa=="B" || pOrientazioa=="b" ) {
						System.out.println("B sartu duzu");
					}
					else if( pOrientazioa=="H" || pOrientazioa=="h") {
						System.out.println("H sartu duzu");
					}
					else {
						throw new  OrientazioExc("Sartu behar duzu H edo B");
					}
					denaOndo=true;
				}
				catch (OrientazioExc e){
					e.mezuaInprimatu();
				}
				}
			while(!denaOndo);
			
			
		   denaOndo=false;
		   if(pItsas!=1) {//1-eko itsasontzia ez du arazorik ematen
			   try {
				   if ((pX+pItsas-1>=pErrenkadaZutKop ) || (pY+pItsas-1>= pErrenkadaZutKop) ) {
					   throw new IndexOutOfBoundsException();
				   }
					this.nireTableroa.itsasontziakJarri(pX, pY, pItsas, pOrientazioa);
					denaOndo=true;
				}
				catch(IndexOutOfBoundsException e) {
					System.out.println("Sartu duzun itsasontzia ez da sartzen");
					this.itsasontziakJarri(pErrenkadaZutKop);
				}
		   }
		}
	}
/*public static void main (String [ ] args) throws OrientazioExc
{	String pMezua="Kaixo";
	Proba.getNireTeklatua(10).itsasontziakJarri(10);
}*/
	
}