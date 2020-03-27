package packjokoa;

import salbuespenak.OrientazioExc;

public abstract class Jokalaria {
	//atributuak:
	private Tableroa nireTableroa;
	private String izena;
	private Tableroa printTableroa;
	private int nUkituta;
	
	//eraikitzailea:
	public Jokalaria(String pIzena, short pErrenkadaZutKop) {
		this.nireTableroa=new Tableroa(pErrenkadaZutKop);
		this.izena=pIzena;
		this.nUkituta=0;
		this.printTableroa=new Tableroa(pErrenkadaZutKop); 
	}
	
	protected Tableroa getNireTableroa() {
		return this.nireTableroa;
	}
	
	protected Tableroa getPrintTableroa() {
		return this.nireTableroa;
	}
	
	public void itsasontziakJarri(int pErrenkadaZutKop){
		//salbuespenak: konprobatu posibeak direla koordenatuak, orientazioa eta ez badira zuzenak berriro jartzeko eskatuko zaio erabiltzaileari
		short pItsas=1;
		String pOrientazioa="Ezezagun";
		String itsasMota="Ezezagun";//bapaezpada hasieratuko dugu
		boolean denaOndo=false;
		
		//itsasontziak beti orden berdinean jarriko dira
		while(pItsas<5) {
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
			do {
			String pMezua1="Orain "+itsasMota+ " jarriko duzu "+ pItsas +" laukiko itsasontzia da, mesedez sartu lehengo koordenatua ";
			Short pX=Teklatua.getNireTeklatua().irakurriShort(pMezua1, 0, 10);
			
			String pMezua2="Sartu bigarren koordenatua mesedez";
			Short pY=Teklatua.getNireTeklatua().irakurriShort(pMezua2, 0, 10);
			
			String pMezua3="Sartu barkuaren orientazioa: H edo B";
			do {
			 pOrientazioa=Teklatua.getNireTeklatua().irakurriString(pMezua3); //MALLL
				try{
					if(pOrientazioa!="B" && pOrientazioa!="b" && pOrientazioa!="H" && pOrientazioa!="h") {
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
				}
			    }
			}
			while(!denaOndo);
			pItsas++;
			
		}
	}
		/*try {
			//aqui va el codigo norrmal y si no puede seguir salta
			this
		}
		catch (Exception e) {
			System.out.println("Sartu diren koordenatuak ez dira egokiak, mesedez sartu berriro.");
			this.nireTableroa.itsasontziakJarri(pX, pY, pItsas, pOrientazio);
		}*/

	
	public abstract void txandaBatJokatu( Jokalaria pJokalaria);		
	
	/*protected void setIzena(String pIzena) {
		this.izena = pIzena;
	}*/
	
	protected void nUkituaInkrementatu() {
		this.nUkituta++;
	}
	
	protected boolean itsasontzirikEz() {
		//true ematen du itsasontzirik ez badago tableroan
		//Dentro de arrunta y dentro de CPU comprueba cuántos se han tocado. 
		//Si llega a 10 partidaBukatu = true. Y se acaba el juego.
		boolean badaudeItsas=false;
		if(this.nUkituta==10) {
			badaudeItsas=true;
		}
		return badaudeItsas;
		
	}

	protected String bigarrenTiroaEgin(short pX, short pY) {
		return this.nireTableroa.bigarrenTiroa(pX, pY);
		//itzuliko duen String-a hirugarren tiroan erabiliko da
	}

}
