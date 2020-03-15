package packjokoa;

public abstract class Jokalaria {
	//atributuak:
	private Tableroa nireTableroa;
	private String izena;
	private Tableroa printTableroa;
	
	//eraikitzailea:
	public Jokalaria(String pIzena) {
		
	}
	
	public void itsasontziakJarri() {
		
	}
	
	public abstract void lehenengoTiroaEgin(short pX, short pY);		

	
	public abstract String bigarrenTiroaEgin(short pX, short pY);
	
	
	public abstract void hirugarrenTiroaEgin(short pX, short pY, String pEma);

}
