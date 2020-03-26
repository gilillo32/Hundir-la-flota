package packjokoa;

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
	
	public void itsasontziakJarri() {
		//hay que meterle todos los parametros que se usaran en los metodos de dentro
		//salbuespenak: konprobatu posibeak direla koordenatuak, horientazioa eta ez badira zuzenak berriro jartzeko eskatuko saio erabiltzaileari
		
	}
	
	public abstract void txandaBatJokatu(short pX, short pY, Jokalaria pJokalaria);		
	
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
