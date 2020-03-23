package packjokoa;

public abstract class Jokalaria {
	//atributuak:
	private Tableroa nireTableroa;
	private String izena;
	private Tableroa printTableroa;
	private int nUkituta;
	
	//eraikitzailea:
	public Jokalaria(String pIzena, int pNUkitua) {
		this.nireTableroa=new Tableroa(pErrenkadaZutKop);
		this.izena=pIzena;
		this.nUkituta=pNUkitua;
		this.printTableroa=new Tableroa(pErrenkadaZutKop); 
	}
	
	protected Tableroa getNireTableroa() {
		return this.nireTableroa;
	}
	
	protected Tableroa getPrintTableroa() {
		return this.nireTableroa;
	}
	
	public void itsasontziakJarri() {
		
	}
	
	public abstract void lehenengoTiroaEgin(short pX, short pY);		

	
	public abstract String bigarrenTiroaEgin(short pX, short pY);
	
	
	public abstract void hirugarrenTiroaEgin(short pX, short pY, String pEma);
	//hemen tableroaEguneratu() deituko da eta this.nUkituta++
	//10 ukituta egonda, itsasontzi guztiak hondoratuta daudela esan nahi du,
	//beraz, irabazi duzu.
	
	
	protected void setIzena(String pIzena) {
		this.izena = pIzena;
	}
	
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

}
