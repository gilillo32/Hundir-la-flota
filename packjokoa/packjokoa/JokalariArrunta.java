package packjokoa;

public class JokalariArrunta extends Jokalaria {
	
	public JokalariArrunta(String pIzena, Short pErrenkadaZutKop) {
		super(pIzena, pErrenkadaZutKop); 
	}
	
	@Override
	public void txandaBatJokatu(Jokalaria pJokalaria) {	
		//koordenatuak eskatu
		String pMezua1="Sartu zure lehenengo koordenatua mesedez";
		Short pX=Teklatua.getNireTeklatua().irakurriShort(pMezua1, 1, 10);
		String pMezua2="Sartu zure lehenengo koordenatua mesedez";
		Short pY=Teklatua.getNireTeklatua().irakurriShort(pMezua2, 1, 10);
		
		boolean posibleaDa=true;
		while(posibleaDa) {
			if(this.koordenadaBaliogarriak(pX, pY)) {
				String emaitza = pJokalaria.koordenatuanZerDagoen(pX, pY);
				this.eguneratuPrintTableroa(pX, pY, emaitza);
				if(emaitza!="U") {
					//Itsasontzia ez badu ukitzen:
					posibleaDa=false; 
				}
				else {
					//koordenatuak eskatu berriro, itsasontzia ukitu duelako
					String pMezua11="Sartu zure lehenengo koordenatua mesedez";
					pX=Teklatua.getNireTeklatua().irakurriShort(pMezua11, 1, 10);
					String pMezua21="Sartu zure lehenengo koordenatua mesedez";
				    pY=Teklatua.getNireTeklatua().irakurriShort(pMezua21, 1, 10);
				}
			}
			else {
				posibleaDa=false;
			}
		}
	}

	private boolean koordenadaBaliogarriak(short pX, short pY) {
		 return super.getNireTableroa().konprobatuTiroa(pX, pY);
	}


	public String koordenatuanZerDagoen(short pX, short pY) {
		return super.koordenatuanZerDagoen(pX, pY);
		//itzuliko duen String-a hirugarren tiroan erabiliko da
	}

	private void eguneratuPrintTableroa(short pX, short pY, String pEma) {
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
