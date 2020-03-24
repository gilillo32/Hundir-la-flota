package packjokoa;
import java.util.*;

public class JokalariCPU extends Jokalaria {
	
	public JokalariCPU(short pErrenkadaZutKop) {
		super("CPU", pErrenkadaZutKop);
	}
	
	 
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
				else {
				aurrekoanUkituDu = true;
				zenbatUkituDituJarraian++;
				}
			}
			else {
				//Tiroa ez bada posiblea:
				posibleaDa = false;
				zenbatUkituDituJarraian = 0;
			}
		}
	}

	public boolean lehenengoTiroaEgin(short pX, short pY) {
		return super.getNireTableroa().konprobatuTiroa(pX, pY);
	}

	
	public String bigarrenTiroaEgin(short pX, short pY) {
		return super.getNireTableroa().bigarrenTiroaEgin(pX, pY);
		//itzuliko duen String-a hirugarren tiroan erabiliko da
	}

	
	public void hirugarrenTiroaEgin(short pX, short pY, String pEma) {
		// primeros llamamos a super.nUkituaInkrementatu y luego a tableroa.eguneratu
		//bigarren tiroan itzuli duen String-a dagokion posizioan sartuko du
		if(pEma == "U") {
			//Itsasontzia "U"kitu badu:
			super.nUkituaInkrementatu();
		}
		this.getNireTableroa().eguneratuTableroa(pEma);

	}
	
	/*public void setIzena() {
		super("CPU");
	}*/
	
	public boolean itsasontzirikEz() {
		return super.itsasontzirikEz();
	}
	
	/*Koordenada bat izkina den ala ez konprobatzeko metodoak:
	 * izkinen zenbakiak koadrante kartesiarrak bezala banatuko dira.
	 * 1 izkina eskumako goiko izkina izango da.
	 * 2 izkina ezkerraldeko goiko izkina izango da.
	 * 3 izkina ezkerraldeko beheko izkina izango da.
	 * 4 izkina eskumako beheko izkina izango da.
	 */
	private boolean izkina1Da(short pX, short pY) {
		boolean izkina1Da = false;
		int errenZutKop = this.getNireTableroa().getErrenkadaZutKop();
		if((pX - 1 == 0) && (pY + 1 > errenZutKop)) {
			izkina1Da = true;
		}
		return izkina1Da;
	}
	
	private boolean izkina2Da(short pX, short pY) {
		boolean izkina2Da = false;
		int errenZutKop =  this.getNireTableroa().getErrenkadaZutKop();
		if((pX - 1 == 0) && (pY - 1 == 0)) {
			izkina2Da = true;
		}
		return izkina2Da;
	}
	
	private boolean izkina3Da(short pX, short pY) {
		boolean izkina3Da = false;
		int errenZutKop = this.getNireTableroa().getErrenkadaZutKop();
		if((pX + 1 > errenZutKop) && (pY - 1 == 0)) {
			izkina3Da = true;
		}
		return izkina3Da;
	}
	
	private boolean izkina4Da(short pX, short pY) {
		boolean izkina4Da = false;
		int errenZutKop = this.getNireTableroa().getErrenkadaZutKop();
		if((pX + 1 > errenZutKop) && (pY + 1 > errenZutKop)) {
			izkina4Da = true;
		}
		return izkina4Da;
	}
	
	//Método general que comprueba qué esquina de todas es:
	private short zeinIzkinaDa(short pX, short pY) {
		short izkinaZenb = 0;
		if(izkina1Da(pX, pY)) {
			izkinaZenb = 1;
		}
		else {
			if(izkina2Da(pX, pY)) {
				izkinaZenb = 2;
			}
			else {
				if(izkina3Da(pX, pY)) {
					izkinaZenb = 3;
				}
				else {
					if(izkina4Da(pX, pY)) {
						izkinaZenb = 4;
					}
				}
			}
		}
		return izkinaZenb;
	}
	
}
