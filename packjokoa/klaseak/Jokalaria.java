package klaseak;

import salbuespenak.KoordenatuEzEgokiak;

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
		this.printTableroa.tableroaBete();
		this.nireTableroa.tableroaBete();
	}
	
	
	protected Tableroa getNireTableroa() {
		return this.nireTableroa;
	}
	
	protected Tableroa getPrintTableroa() {
		return this.printTableroa;
	}
	
	public void nireTableroaBete() {
		this.nireTableroa.tableroaInprimatu();
	}
	
	public abstract void itsasontziakJarri(int pErrenkadaZutKop);
	
	private void nUkituaInkrementatu() {
		this.nUkituta++;
	}
	
	public boolean itsasontzirikEz() {
		/*
		 * true ematen du etsaiaren itsasontzi guztiak hondoratu ostean, hau da, this.nUkituta==10 izatra heltzen denean.		
		*/
		boolean badaudeItsas=false;
		if(this.nUkituta==10) {
			badaudeItsas=true;
		}
		return badaudeItsas;		
	}
	
	public boolean koordenadaBaliogarriak(short pX, short pY) {
	/*
		*printTableroan begiratzen du, hau da, tiroak egin ostean lortutakoa gordetzen den tableroan.
		*Jolasan zehar uraz " -", ukitutako itsasontziz " U", eta hutz egindako tiroz " X", betea egongo da.
		*Kordenatu batean " U" edo " X" egonda, koordenada hori ez da baliogarria izango, FALSE bueltatuko du
		*Kordenatu batean " -" egonda, koordenada hori baliogarria da, TRUE bueltautko du
	*/
		return this.printTableroa.konprobatuTiroa(pX, pY);
	}
	
	public String koordenatuanZerDagoen(short pX, short pY) {
		/*
		 * NireTableroan begiratuko du kasilan zer dagoen, itsasontzia baldin badago " U" bueltatzen du, bestela, han dagoena, hau da, ura "-"
		 * Itzuliko duen String-a hirugarren tiroan erabiliko da
	    */
		return this.nireTableroa.koordenatuanZerDagoen(pX, pY);		
	}
	
	public void eguneratuPrintTableroa(short pX, short pY, String pEma) {
		/*
		 * koordenatuanZerDagoen itzuli duen String-a  " U" bada, ukituen zenbakia (nUkituta) unitate batean inkrementatuko du.
		 * " U" bada printTableroan dagokion posizioan sartuko du, beste kasuetan " X" sartuko du.
		 *Azkenik printTableroa inprimatuko du 
		 */
		if(pEma == " U") {
			this.nUkituaInkrementatu();
		}
		this.printTableroa.eguneratuTableroa(pX, pY, pEma);  
		this.printTableroa.tableroaInprimatu();
	}
	
	public void eguneratuNireTableroa(short pX, short pY, String pEma) {
		/*
		 * koordenatuanZerDagoen itzuli duen String-a  " U" bada, ukituen zenbakia (nUkituta) unitate batean inkrementatuko du.
		 * " U" bada printTableroan dagokion posizioan sartuko du, beste kasuetan " X" sartuko du.
		 *Azkenik printTableroa inprimatuko du 
		 */
		this.nireTableroa.eguneratuTableroa(pX, pY, pEma);  
	}
	
	
	public String getIzena() {
		return this.izena;
	}
	public int  getNUkituta() {
		return this.nUkituta;
	}
	public void  setNUkituta(int pUkituta) {
		 this.nUkituta = pUkituta;
	}
	
//	Testak egiteko behar ditugun metodoak:
	
	public void koordenatuanJarri ( int pX, int pY, String pJarri) {		
		this.nireTableroa.koordenatuanJarri(pX, pY, pJarri);
	}
	
	public void koordenatuanJarriPrint ( int pX, int pY, String pJarri) {
		this.printTableroa.koordenatuanJarri(pX, pY, pJarri);
	}
	

}
