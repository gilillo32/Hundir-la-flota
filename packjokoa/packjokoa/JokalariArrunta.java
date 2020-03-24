package packjokoa;

public class JokalariArrunta extends Jokalaria {
	
	public JokalariArrunta(String pIzena, Short pErrenkadaZutKop) {
		super(pIzena, pErrenkadaZutKop); 
	}
	
	@Override
	public void txandaBatJokatu(short pX, short pY, Jokalaria pJokalaria) {	
		boolean posibleaDa=true;
		while(posibleaDa) {
			if(this.lehenengoTiroaEgin(pX, pY)) {
				String emaitza = pJokalaria.bigarrenTiroaEgin(pX, pY);
				this.hirugarrenTiroaEgin(pX, pY, emaitza);
				if(emaitza!="U") {
					posibleaDa=false; 
				}
				else {
					//Teklatua.getNireTeklatua()
					//pedirle las coordenadas y cambiar 
				}
			}
			else {
				posibleaDa=false;
			}
		}
	}

	private boolean lehenengoTiroaEgin(short pX, short pY) {
		 return super.getNireTableroa().konprobatuTiroa(pX, pY);
	}


	public String bigarrenTiroaEgin(short pX, short pY) {
		return super.bigarrenTiroaEgin(pX, pY);
		//itzuliko duen String-a hirugarren tiroan erabiliko da
	}

	private void hirugarrenTiroaEgin(short pX, short pY, String pEma) {
		// primeros llamamos a super.nUkituaInkrementatu y luego a tableroa.eguneratu
		//bigarren tiroan itzuli duen String-a dagokion posizioan sartuko du
		if(pEma=="U") {
			super.nUkituaInkrementatu();
		}
		this.getNireTableroa().eguneratuTableroa(pX,pY,pEma);
	}
	
	/*public void setIzena(String pIzena) {
		super.setIzena(pIzena);
	}*/
	
	public boolean itsasontzirikEz() {
		return super.itsasontzirikEz();
	}   
	
}
