package packjokoa;
import java.util.*;

public class JokalariCPU extends Jokalaria {
	
	public JokalariCPU(short pErrenkadaZutKop) {
		super("CPU", pErrenkadaZutKop);
	}
	
	@Override 
	public void txandaBatJokatu(JokalariArrunta pJokalaria) {
		boolean posibleaDa = true;
		boolean aurrekoanUkituDu = false;
		short jarraianAurkituDitzakeenUkitutak = 4;
		short zenbatUkituDituJarraian = 0;
		Random rand = new Random();
		short pX = (short) ((short) rand.nextInt(10) + 1);
		short pY = (short) ((short) rand.nextInt(10) + 1);
		while(posibleaDa) { 
			//Ura ukitzen duen arte errepikatuko den buklea:
			if(this.lehenengoTiroaEgin(pX, pY)) {
				String emaitza = pJokalaria.bigarrenTiroaEgin(pX, pY);
				this.hirugarrenTiroaEgin(pX, pY, emaitza);
				if(emaitza != "U") {
					//Itsasontzia ez badu ukitzen:
					posibleaDa = false;
				}
				aurrekoanUkituDu = true;
			}
			else {
				//Tiroa ez bada posiblea:
				posibleaDa = false;
			}
		}
	}

	@Override
	public void lehenengoTiroaEgin(short pX, short pY) {
		return super.getNireTableroa().konprobatuTiroa(pX, pY);
	}

	@Override
	public String bigarrenTiroaEgin(short pX, short pY) {
		return super.getNireTableroa().bigarrenTiroaEgin(pX, pY);
		//itzuliko duen String-a hirugarren tiroan erabiliko da
	}

	@Override
	public void hirugarrenTiroaEgin(short pX, short pY, String pEma) {
		// primeros llamamos a super.nUkituaInkrementatu y luego a tableroa.eguneratu
		//bigarren tiroan itzuli duen String-a dagokion posizioan sartuko du
		if(pEma == "U") {
			//Itsasontzia "U"kitu badu:
			super.nUkituaInkrementatu();
		}
		this.getNireTableroa().eguneratuTableroa(pEma);

	}
	
	public void setIzena() {
		super("CPU");
	}
	
	public boolean itsasontzirikEz() {
		return super.itsasontzirikEz();
	}
	
	
}
