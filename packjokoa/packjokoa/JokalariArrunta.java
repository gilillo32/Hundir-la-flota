package packjokoa;

public class JokalariArrunta extends Jokalaria {
	
	public JokalariArrunta() {
		super(pIzena,pNUkitua);
	}

	@Override
	public void lehenengoTiroaEgin(short pX, short pY) {
		super.getNireTableroa().konprobatuTiroa(pX, pY);
	}

	@Override
	public String bigarrenTiroaEgin(short pX, short pY) {
		return super.getNireTableroa().bigarrenTiroa(pX, pY);
		//itzuliko duen String-a hirugarren tiroan erabiliko da
	}

	@Override
	public void hirugarrenTiroaEgin(short pX, short pY, String pEma) {
		// primeros llamamos a super.nUkituaInkrementatu y luego a tableroa.eguneratu
		//bigarren tiroan itzuli duen String-a dagokion posizioan sartuko du
		super.nUkituaInkrementatu();
		this.getNireTableroa().eguneratuTableroa(pEma);
	}

	public void setIzena(String pIzena) {
		super.setIzena(pIzena);
	}
	
	public boolean itsasontzirikEz() {
		return super.itsasontzirikEz();
	}
	
	
}
