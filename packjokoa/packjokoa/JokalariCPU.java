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
		Koordenatuak koord = new Koordenatuak(pX, pY);
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
		return super.bigarrenTiroaEgin(pX, pY);
		//itzuliko duen String-a hirugarren tiroan erabiliko da
	}

	
	public void hirugarrenTiroaEgin(short pX, short pY, String pEma) {
		// primeros llamamos a super.nUkituaInkrementatu y luego a tableroa.eguneratu
		//bigarren tiroan itzuli duen String-a dagokion posizioan sartuko du
		if(pEma == "U") {
			//Itsasontzia "U"kitu badu:
			super.nUkituaInkrementatu();
		}
		this.getNireTableroa().eguneratuTableroa(pX, pY, pEma);
  
	}
	
	/*public void setIzena() {
		super("CPU");
	}*/
	
	public boolean itsasontzirikEz() {
		return super.itsasontzirikEz();
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
					 pX = (Short) null;
					 pY = (Short) null;
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
						 pX = (Short)null;
						 pY = (Short)null;
						 break;
					 case 1:
						 pX = (Short)null;
						 pY = (Short)null;
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
							 pX = (Short)null;
							 pY = (Short)null;
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
								 pX = (Short)null;
								 pY = (Short)null;
								 break;
							 case 2:
								 pX = (Short)null;
								 pY = (Short)null;
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
									 pX = (Short)null;
									 pY = (Short)null;
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
										 pX = (Short)null;
										 pY = (Short)null;
										 break;
									 case 3:
										 pX = (Short)null;
										 pY = (Short)null;
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
											 pX = (Short)null;
											 pY = (Short)null;
											 break;
										 }
									 }
									 else {
										 //Beheko eskumako izkina bada:
										 if(this.zeinIzkinaDa(pX, pY) == 4) {
											 switch(pZentzua) {
											 case 0:
												 pX = (Short)null;
												 pY = (Short)null;
												 break;
											 case 1:
												 pY = (short)(pY - 1);
												 break;
											 case 2:
												 pX = (short)(pX - 1);
												 break;
											 case 3:
												 pX = (Short)null;
												 pY = (Short)null;
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
		 }
		 Koordenatuak koord = new Koordenatuak(pX, pY);
		 return koord;	
	 }
	
	//Itsasontzia ukitu badu, metodo hau erabiliko da ausazko alboko koordenatuak generatzeko
	/*Cuando la CPU acierta una coordenada por primera vez, tiene cuatro opciones para decir la siguiente coordenada:
	 * la coordenada de arriba, la de abajo, la de la eskuma y la de la izda. Por lo tanto, este método crea un Random
	 * entre 1 y 4 (ambos incluídos), y si sale:
	 * 1- se dice la coordenada de la derecha
	 * 2- se dice la coordenada de arriba
	 * 3- se dice la coordenada de la izda
	 * 4- se dice la coordenada de abajo
	 */
	
	//Metodo honetako azken parametroak zenbat koordenatu eta non era ditzakeen ezaten du.
	private Koordenatuak albokoAusazkoKoordenatuakEratu(short pX, short pY) {
		//Arazorik ez badago, lau aukera ditu koordenatua eratzeko:
		if(this.zeinErtzaDa(pX, pY) == 0 && this.zeinIzkinaDa(pX, pY) == 0) {
			Random rand = new Random();
			byte zeinAukera = (byte)rand.nextInt(4);
			switch(zeinAukera) {
			case 0:
				pX = (short) (pX + 1);
				break;
			case 1:
				pY = (short) (pY - 1);
				break;
			case 2:
				pX = (short) (pX - 1);
				break;
			case 3:
				pY = (short) (pY + 1);
				break;
			}			
		}
		else {
			//Eskumako ertzan badago:
			if(this.zeinErtzaDa(pX, pY) == 1) {
				Random rand = new Random();
				byte zeinAukera = (byte) rand.nextInt(2);
				switch(zeinAukera) {
				case 0:
					pY = (short)(pY - 1);
					break;
				case 1:
					pX = (short)(pX - 1);
					break;
				case 2:
					pY = (short)(pY + 1);
					break;
				}
			}
			else {
				//Eskumako goiko izkinan badago:
				if(this.zeinIzkinaDa(pX, pY) == 1) {
					Random rand = new Random();
					byte zeinAukera = (byte)rand.nextInt(1);
					switch(zeinAukera) {
					case 0:
						pY = (short)(pY + 1);
						break;
					case 1:
						pX = (short)(pX - 1);
						break;
					}
				}
				else {
					//Goiko ertza bada:
					if(this.zeinErtzaDa(pX, pY) == 2) {
						Random rand = new Random();
						byte zeinAukera = (byte)rand.nextInt(3);
						switch(zeinAukera) {
						case 0:
							pX = (short)(pX + 1);
							break;
						case 1:
							pY = (short)(pY + 1);
							break;
						case 2:
							pX = (short)(pX - 1);
							break;
						}
					}
					else {
						//Goiko ezkerreko izkina bada:
						if(this.zeinIzkinaDa(pX, pY) == 2) {
							Random rand = new Random();
							byte zeinAukera = (byte)rand.nextInt(2);
							switch(zeinAukera) {
							case 0:
								pY = (short)(pY + 1);
								break;
							case 1:
								pX = (short)(pX + 1);
								break;
							}
						}
						else {
							//Ezkerreko ertza bada:
							if(this.zeinErtzaDa(pX, pY) == 3) {
								Random rand = new Random();
								byte zeinAukera = (byte)rand.nextInt(3);
								switch(zeinAukera) {
								case 0:
									pY = (short)(pY - 1);
									break;
								case 1:
									pX = (short)(pX + 1);
									break;
								case 2:
									pY = (short)(pY + 1);
									break;
								}
							}
							else {
								//Beheko ezkerreko izkina bada: 
								if(this.zeinIzkinaDa(pX, pY) == 3) {
									Random rand = new Random();
									byte zeinAukera = (byte)rand.nextInt(2);
									switch(zeinAukera) {
									case 0:
										pY = (short)(pY - 1);
										break;
									case 1:
										pX = (short)(pX + 1);
										break;
									}
								}
								else {
									//Beheko ertza bada:
									if(this.zeinErtzaDa(pX, pY) == 4) {
										Random rand = new Random();
										byte zeinAukera = (byte)rand.nextInt(3);
										switch(zeinAukera) {
										case 0:
											pX = (short)(pX - 1);
											break;
										case 1:
											pY = (short)(pY - 1);
											break;
										case 2:
											pX = (short)(pX + 1);
											break;
										}
									}
									else {
										//Beheko eskumako izkina bada:
										if(this.zeinIzkinaDa(pX, pY) == 4) {
											Random rand = new Random();
											byte zeinAukera = (byte)rand.nextInt(2);
											switch(zeinAukera) {
											case 0:
												pY = (short)(pY - 1);
												break;
											case 1:
												pX = (short)(pX - 1);
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
		}
		Koordenatuak koord = new Koordenatuak(pX, pY);
		return koord;
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
		int errenkadaZutKop = this.getNireTableroa().getErrenkadaZutKop();
		if(pX + 1 > errenkadaZutKop) {
			ertz1Da = true;
		}
		
		return true;
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
		int errenkadaZutKop = this.getNireTableroa().getErrenkadaZutKop();
		if(pY + 1 > errenkadaZutKop) {
			ertz4Da = true;
		}
		return ertz4Da;
	}
	
	//Metodo honek ertza ETA ez izkina den konprobatzen du
	private short zeinErtzaDa(short pX, short pY) {
		short ertzZenb = 0;
		if(this.zeinIzkinaDa(pX, pY) == 0) {
			//Izkina ez bada ertza bada konprobatuko du
			if(ertz1Da(pX, pY)) {
				ertzZenb = 1;
			}
			else {
				if(ertz2Da(pX, pY)) {
					ertzZenb = 2;
				}
				else{
					if(ertz3Da(pX, pY)) {
						ertzZenb = 3;
					}
					else {
						if(ertz4Da(pX, pY)) {
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
		int errenZutKop = this.getNireTableroa().getErrenkadaZutKop();
		if((pY - 1 == -1) && (pX + 1 > errenZutKop)) {
			izkina1Da = true;
		}
		return izkina1Da;
	}
	
	private boolean izkina2Da(short pX, short pY) {
		boolean izkina2Da = false;
		int errenZutKop =  this.getNireTableroa().getErrenkadaZutKop();
		if((pX - 1 == -1) && (pY - 1 == -1)) {
			izkina2Da = true;
		}
		return izkina2Da;
	}
	
	private boolean izkina3Da(short pX, short pY) {
		boolean izkina3Da = false;
		int errenZutKop = this.getNireTableroa().getErrenkadaZutKop();
		if((pY + 1 > errenZutKop) && (pX - 1 == 0)) {
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
	
	//Método general que devuelve el número de esquina:
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
