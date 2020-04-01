package packjokoa;

import salbuespenak.KoordenatuEzEgokiak;
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
	
	public abstract void itsasontziakJarri(int pErrenkadaZutKop);

	
	public abstract Koordenatuak txandaBatJokatu( );		
	
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

	public String koordenatuanZerDagoen(short pX, short pY) {
		return this.nireTableroa.koordenatuanZerDagoen(pX, pY);
		//itzuliko duen String-a hirugarren tiroan erabiliko da
	}
	
	public boolean koordenadaBaliogarriak(short pX, short pY) {
		return this.getNireTableroa().konprobatuTiroa(pX, pY);
	}

	public void eguneratuPrintTableroa(short pX, short pY, String pEma) {
		// primeros llamamos a super.nUkituaInkrementatu y luego a tableroa.eguneratu
		//bigarren tiroan itzuli duen String-a dagokion posizioan sartuko du
		if(pEma == "U") {
			//Itsasontzia "U"kitu badu:
			this.nUkituaInkrementatu();
		}
		this.getNireTableroa().eguneratuTableroa(pX, pY, pEma);
  
	}
	
	
	
	public String getIzena() {
		return this.izena;
	}
	
	
	
	

}
