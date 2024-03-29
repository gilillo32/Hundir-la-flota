package klaseak;
import java.util.*;

import salbuespenak.KoordenatuEzEgokiak;

public class JokalariCPU extends Jokalaria {
	
	private ArrayList<Koordenatuak> albokoKoordenatuak;
	private Koordenatuak koordenatuOriginalak;
	private boolean zentzuAukeratuta=false;
	private byte zentzua=0;
	
	public JokalariCPU(short pErrenkadaZutKop) {		
		super("CPU", pErrenkadaZutKop);
		this.albokoKoordenatuak = new ArrayList<Koordenatuak>();
		this.koordenatuOriginalak = new Koordenatuak();		
	}
	
	public byte getZentzua() {
		return this.zentzua;
	}
	
	public void erreseteatu() {
		this.zentzuAukeratuta=false;
		this.erreseteatuAlbokoKoordenatuak();
		this.zentzua=0;
	}

	 public Koordenatuak koordenatuaAukeratu( Koordenatuak pK1,  boolean pAurrekoanAsmatu) {
		Koordenatuak k= new Koordenatuak();	
		if (pAurrekoanAsmatu && this.albokoKoordenatuak.size()!=0) {
			this.zentzuAukeratuta=true;
		}
		
		if(!pAurrekoanAsmatu && this.albokoKoordenatuak.size()==0 ) { //ez dago arazorik, lehen saiakera da
			k= this.koordenatuRandom();	
		}
		else if(!this.zentzuAukeratuta) { //sartuko da zentzua aurkitu arte
			if (this.albokoKoordenatuak.size()==0) {
				this.koordenatuOriginalak=pK1;
				this.albokoKordenatuakSortu(this.koordenatuOriginalak);
			}
			int konti=0;
			do {
				k=this.albokoKoordenatuak.get(this.zentzua); 
				konti++;
				
				if ((k.getKoordenatuakY()== -1 || k.getKoordenatuakX()== -1)){
						this.zentzua++;
					
				}
				
				//-1 bueltatuko du X egotekotan 
				else if(this.getPrintTableroa().zeItsasontziHondoratu((short)(k.getKoordenatuakX()+1), (short)(k.getKoordenatuakY()+1))==-1 ) {
						this.zentzua++;
					
				}
				
			}while((k.getKoordenatuakY()== -1 || k.getKoordenatuakX()== -1) || this.getPrintTableroa().zeItsasontziHondoratu((short)(k.getKoordenatuakX()+1), (short)(k.getKoordenatuakY()+1))==-1 && konti<=4);
			
	 	} 
		else if(pAurrekoanAsmatu && this.albokoKoordenatuak.size()!=0) { //zentzua asmatu du eta koordenatuak zentzu horretan aukeratu
			k= this.zentzuBateanKoordenatuBerriak(pK1.getKoordenatuakX(), pK1.getKoordenatuakY(), this.zentzua);
			if (k.getKoordenatuakY()== -1 && k.getKoordenatuakX()== -1 || this.getPrintTableroa().zeItsasontziHondoratu((short)(k.getKoordenatuakX()+1), (short)(k.getKoordenatuakY()+1))==-1 ) {
				this.kontrakoZentzua();	
				k= this.zentzuBateanKoordenatuBerriak(this.koordenatuOriginalak.getKoordenatuakX(), this.koordenatuOriginalak.getKoordenatuakY(), this.zentzua);
			}
			
		}
		else if(!pAurrekoanAsmatu && this.albokoKoordenatuak.size()!=0) {//lehen ez du asmatu baina zentzua bazekien, beraz kontrako zentzuan begiratu behar du
				this.kontrakoZentzua();
				k= this.zentzuBateanKoordenatuBerriak(this.koordenatuOriginalak.getKoordenatuakX(), this.koordenatuOriginalak.getKoordenatuakY(), this.zentzua);
		}
		return  k ;
	}
	 
	 private Koordenatuak koordenatuRandom() {
		 Koordenatuak k = null;
		 k = new Koordenatuak(); 
		 Random rand = new Random();
		 short pX = (short) ((short) rand.nextInt(10) );//0-etik 9 zenbaki bat bueltatzeko					
		 short pY = (short) ((short) rand.nextInt(10));
		 k.setKoordenatuakX(pX);
		 k.setKoordenatuakY(pY);		
		 return k;
	 }														
	 
	 public void itsasontziakJarri(int pErrenkadaZutKop) {
		 short pItsas = 1;
		 short limitX = -1;
		 short limitY = -1;
		 short pX, pY;
		 String pOrientazioa = "";
		 boolean denaOndo2 = false;
		 
		 
		 //itsasontziak ordenean jarri:
		 while(pItsas<5) {
			 
				do {
					//Lehenengo orientazioa aukeratuko du:
					Random rand = new Random();
					byte orientazioZenb = -1;             //ORIENTAZIOA AUKERATU
					if(pItsas == 1) {
						orientazioZenb = (byte)0;
					}
					else {
						orientazioZenb = (byte) rand.nextInt(2);
					}
					switch(orientazioZenb) {
					case 0:
						pOrientazioa = "h";
						limitX = (short) (11 - pItsas);
						limitY = 10;
						break;
					case 1:
						pOrientazioa = "b";
						limitX = 10;
						limitY = (short)(11 - pItsas);
						break;
					}
						
					
					//Koordenatuak aukeratu
					pX = (short) (rand.nextInt(limitX) + 1); //From 1 to x limit incluído
					pY = (short) (rand.nextInt(limitY) + 1); //From 1 to y limit incluído
				    try {
				    	if ((pX+pItsas-1>= (pErrenkadaZutKop+1) ) || (pY+pItsas-1>= ( pErrenkadaZutKop) +1)) {
						   throw new IndexOutOfBoundsException();
				    	}
				    	this.getNireTableroa().itsasontziakJarri(pX, pY, pItsas, pOrientazioa);
						denaOndo2=true;
					}
				    catch(IndexOutOfBoundsException e) {
						denaOndo2=false;						
					}
				    catch(KoordenatuEzEgokiak e) {
					    denaOndo2=false;
				   }
			}  while(!denaOndo2);  
				denaOndo2=false;
				pItsas++;
			}
		this.getNireTableroa().tableroaInprimatu();
	 }
	 
	 
	 
	 private void albokoKordenatuakSortu(Koordenatuak pK) {
		short auxPX = pK.getKoordenatuakX() ;
		short auxPY = pK.getKoordenatuakY();
		byte kont=0;
		while (kont<4) {
			this.gehituAlbokoKoordenatuak(this.zentzuBateanKoordenatuBerriak(auxPX, auxPY, kont));
			kont++;
		}
	 }
	    
	
	private void gehituAlbokoKoordenatuak (Koordenatuak pK) {
		this.albokoKoordenatuak.add(pK);
	}
	
	private void erreseteatuAlbokoKoordenatuak() {
		this.albokoKoordenatuak.clear();
	}

	
	/*
	 * Metodo honek zentzu bat jarraitzen duen hurrengo koordenatua emango du
	 * 0 eskumarantz
	 * 1 gora
	 * 2 ezkerrerantz
	 * 3 beherantz
	 * null bueltatuko du ezin bada hurrengo koordenatua eman (izkina edo ertza bada)
	 */
	private Koordenatuak zentzuBateanKoordenatuBerriak(short pX, short pY, byte pZentzua) {
		 //Arazorik ez badago:
		 if(this.zeinErtzaDa(pX, pY) == 0 && this.zeinIzkinaDa(pX, pY) == 0) {
			 switch(pZentzua) {
			 case 0:
				 pX = (short)(pX + 1);
				 break;
			 case 1:
				 pY = (short)(pY - 1);
				 break;
			 case 2:
				 pX = (short)(pX - 1);
				 break;
			 case 3:
				 pY = (short)(pY + 1);
				 break;
			 }
		 }
		 else {
			 //Eskumako ertza bada:
			 if(this.zeinErtzaDa(pX, pY) == 1) {
				 switch(pZentzua) {
				 case 0:
					 pX = -1;
					 pY = -1;
					 break;
				 case 1:
					 pY = (short)(pY - 1);
					 break;
				 case 2:
					 pX = (short)(pX - 1);
					 break;
				 case 3:
					 pY = (short)(pY + 1);
					 break;
				 }
			 }
			 else {
				 //Eskumako goiko izkina bada:
				 if(this.zeinIzkinaDa(pX, pY) == 1) {
					 switch(pZentzua) {
					 case 0:
						 pX = -1;
						 pY = -1;
						 break;
					 case 1:
						 pX = -1;
						 pY = -1;
						 break;
					 case 2:
						 pX =(short)(pX - 1);
						 break;
					 case 3: 
						 pY = (short)(pY + 1);
						 break;
					 }
				 }
				 else {
					 //Goiko(grill) ertza bada:
					 if(this.zeinErtzaDa(pX, pY) == 2) {
						 switch(pZentzua) {
						 case 0:
							 pX = (short)(pX + 1);
							 break;
						 case 1:
							 pX = -1;
							 pY = -1;
							 break;
						 case 2:
							 pX = (short)(pX - 1);
							 break;
						 case 3:
							 pY = (short)(pY + 1);
							 break;
						 }
						 
					 }
					 else {
						 //Goiko ezkerreko izkina bada:
						 if(this.zeinIzkinaDa(pX, pY) == 2) {
							 switch(pZentzua) {
							 case 0:
								 pX = (short)(pX + 1);
								 break;
							 case 1:
								 pX = -1;
								 pY = -1;
								 break;
							 case 2:
								 pX = -1;
								 pY = -1;
								 break;
							 case 3:
								 pY = (short)(pY + 1);
								 break;
							 }
						 }
						 else {
							 //Ezkerreko ertza bada:
							 if(this.zeinErtzaDa(pX, pY) == 3) {
								 switch(pZentzua) {
								 case 0:
									 pX = (short)(pX + 1);
									 break;
								 case 1:
									 pY = (short)(pY - 1);
									 break;
								 case 2:
									 pX = -1;
									 pY = -1;
									 break;
								 case 3:
									 pY = (short)(pY + 1);
									 break;
								 }
							 }
							 else {
								 //Beheko ezkerreko izkina bada:
								 if(this.zeinIzkinaDa(pX, pY) == 3) {
									 switch(pZentzua) {
									 case 0:
										 pX = (short)(pX + 1);
										 break;
									 case 1:
										 pY = (short)(pY - 1);
										 break;
									 case 2:
										 pX = -1;
										 pY = -1;
										 break;
									 case 3:
										 pX = -1;
										 pY = -1;
										 break;
									 }
								 }
								 else {
									 //Beheko ertza bada:
									 if(this.zeinErtzaDa(pX, pY) == 4) {
										 switch(pZentzua) {
										 case 0:
											 pX = (short)(pX + 1);
											 break;
										 case 1:
											 pY = (short)(pY - 1);
											 break;
										 case 2:
											 pX = (short)(pX - 1);
											 break;
										 case 3:
											 pX = -1;
											 pY = -1;
											 break;
										 }
									 }
									 else {
										 //Beheko eskumako izkina bada:
											 switch(pZentzua) {
											 case 0:
												 pX = -1;
												 pY = -1;
												 break;
											 case 1:
												 pY = (short)(pY - 1);
												 break;
											 case 2:
												 pX = (short)(pX - 1);
												 break;
											 case 3:
												 pX = -1;
												 pY = -1;
												 break;
											 }
										 
									 }
								 }
							 }
						 }
					 }
				 }
			 }
		 }
		 Koordenatuak koord = new Koordenatuak(pX, pY);
		 return koord;	
	
	 }
	
	
	
	private void kontrakoZentzua() {
		switch(this.zentzua) {
		case 0:
			this.zentzua = 2;
			break;
		case 1:
			this.zentzua = 3;
			break;
		case 2: 
			this.zentzua = 0;
			break;
		case 3:
			this.zentzua = 1;
			break;
		}
		
	}
		
	/*Koordenada bat ertza bada konprobatzen duen duen metodoa:
	 * Lehenengo, izkina bat bada konprobatzen du, eta ez bada, zein ertza den konprobatzen du
	 * 1 bueltatuko du eskumako ertza bada
	 * 2 bueltatuko du goiko ertza bada
	 * 3 bueltatko du ezkerreko ertza bada
	 * 4 bueltatko du beheko ertza bada
	 * 0 bueltatuko du ertza ez bada.
	 */
	
	private boolean ertz1Da(short pX, short pY) {
		boolean ertz1Da = false;
		int errenkadaZutKop = this.getNireTableroa().getErrenkadaZutKop()-1;
		if(pX + 1 == errenkadaZutKop) {
			ertz1Da = true;
		}
		
		return ertz1Da;
	}
	
	private boolean ertz2Da(short pX, short pY) {
		boolean ertz2Da = false;
		if(pY - 1 == -1) {
			ertz2Da = true;
		}
		return ertz2Da;
	}
	
	private boolean ertz3Da(short pX, short pY) {
		boolean ertz3Da = false;
		if(pX - 1 == -1) {
			ertz3Da = true;
		}
		return ertz3Da;
	}
	
	private boolean ertz4Da(short pX, short pY) {
		boolean ertz4Da = false;
		int errenkadaZutKop = this.getNireTableroa().getErrenkadaZutKop()-1;
		if(pY + 1 == errenkadaZutKop) {
			ertz4Da = true;
		}
		return ertz4Da;
	}
	
	//Metodo honek ertza ETA ez izkina den konprobatzen du
	private short zeinErtzaDa(short pX, short pY) {
		short ertzZenb = 0;
		if(this.zeinIzkinaDa(pX, pY) == 0) {
			//Izkina ez bada ertza bada konprobatuko du
			if(this.ertz1Da(pX, pY)) {
				ertzZenb = 1;
			}
			else {
				if(this.ertz2Da(pX, pY)) {
					ertzZenb = 2;
				}
				else{
					if(this.ertz3Da(pX, pY)) {
						ertzZenb = 3;
					}
					else {
						if(this.ertz4Da(pX, pY)) {
							ertzZenb = 4;
						}
					}
				}
				
			}
		}
		return ertzZenb;
	}
	
	/*Koordenada bat izkina den ala ez konprobatzeko metodoak:
	 * izkinen zenbakiak koadrante kartesiarrak bezala banatuko dira.
	 * 1 izkina eskumako goiko izkina izango da.
	 * 2 izkina ezkerraldeko goiko izkina izango da.
	 * 3 izkina ezkerraldeko beheko izkina izango da.
	 * 4 izkina eskumako beheko izkina izango da.
	 * 0 izkina ez bada
	 */
	private boolean izkina1Da(short pX, short pY) {
		boolean izkina1Da = false;
		int errenZutKop = this.getNireTableroa().getErrenkadaZutKop()-1;
		if((pY - 1 == -1) && (pX + 1 == errenZutKop)) {
			izkina1Da = true;
		}
		return izkina1Da;
	}
	
	private boolean izkina2Da(short pX, short pY) {
		boolean izkina2Da = false;
		if((pX - 1 == -1) && (pY - 1 == -1)) {
			izkina2Da = true;
		}
		return izkina2Da;
	}
	
	private boolean izkina3Da(short pX, short pY) {
		boolean izkina3Da = false;
		int errenZutKop = this.getNireTableroa().getErrenkadaZutKop()-1;
		if((pY + 1 == errenZutKop) && (pX - 1 == -1)) {
			izkina3Da = true;
		}
		return izkina3Da;
	}
	
	private boolean izkina4Da(short pX, short pY) {
		boolean izkina4Da = false;
		int errenZutKop = this.getNireTableroa().getErrenkadaZutKop()-1;
		if((pX + 1 == errenZutKop) && (pY + 1 == errenZutKop)) {
			izkina4Da = true;
		}
		return izkina4Da;
	}
	
	//metodo orokorra izkinako zenbakia bueltatzen duena:
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
