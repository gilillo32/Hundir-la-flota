package packjokoa;

public class BikoteJokalariak {
	//atributuak:
	private Jokalaria j1;
	private Jokalaria j2;
	private static BikoteJokalariak nireBikoteJokalariak = null;
	
	//eraikitzailea (Singleton):
	private BikoteJokalariak(Jokalaria pJ1, Jokalaria pJ2) {
		this.j1 = pJ1;
		this.j2 = pJ2;
	}
	
	public static synchronized BikoteJokalariak getNireBikoteJokalariak(Jokalaria pJ1, Jokalaria pJ2) {
		if(BikoteJokalariak.nireBikoteJokalariak==null) {
			BikoteJokalariak.nireBikoteJokalariak=new BikoteJokalariak(pJ1,pJ2);
		} 
		return BikoteJokalariak.nireBikoteJokalariak;
	}
	
	//gainontzeko metodoak:
	
	public void partidaBatJokatu() {
		
	}
	
	public void itsasontziakJarri() {
		
	}
	public boolean partidaBukatu() {
		// bi jokalarien tableroak begiratzen ditu eta 
		// ez badago itsasontzirik, partida amaitzen da.
		// itsasontzirikEz() erabiliko da jokalarien tableroak ikusteko.
	}
	public void txandaBatJolastu() {
		
	}
	
	
}
