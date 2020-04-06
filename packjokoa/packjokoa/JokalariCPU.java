package packjokoa;
import java.util.*;

import salbuespenak.KoordenatuEzEgokiak;

public class JokalariCPU extends Jokalaria {
	
	private ArrayList<Koordenatuak> esandakoKoordenatuak;//esan dituen koorenatu guztiak gordetzen dira, ez errepikatzeko
	private ArrayList<Koordenatuak> albokoKoordenatuak;
	private ArrayList<Koordenatuak> nireItsasontziakEtaAlbokoKoordenatuak;
	private Koordenatuak koordenatuOriginalak;
	//private boolean zentzuaAldatuBeharDu = false;
	//private boolean zentzuaBadaki = false;
	//private short jarraianAurkituDitzakeenUkitutak = 4;
//private short zenbatUkituDituJarraian = 0;
	private byte zentzua=0;
	
	public JokalariCPU(short pErrenkadaZutKop) {		
		super("CPU", pErrenkadaZutKop);
		this.esandakoKoordenatuak= new ArrayList<Koordenatuak>();
		this.albokoKoordenatuak = new ArrayList<Koordenatuak>();
		this.koordenatuOriginalak = new Koordenatuak();
	}
	

	 public Koordenatuak koordenatuaAukeratu( Koordenatuak pK1,  boolean pAurrekoanAsmatu) {
		Koordenatuak k= new Koordenatuak();	
		boolean errepikatuta=false;
		if(!pAurrekoanAsmatu && this.albokoKoordenatuak.size()==0 ) { //ez dago arazorik, lehen saiakera da
			do {
				k= this.koordenatuRandom();
				if(!this.esandakoKoordenatuak.contains(k)) {
					this.esandakoKoordenatuak.add(k);
					errepikatuta=false;
				}
				else {
					errepikatuta=true;
				}					
			} while(errepikatuta);		
		}
		else if(pAurrekoanAsmatu &&  this.albokoKoordenatuak.size()==0) { //lehen aldiz ikutu du
			this.albokoKordenatuakSortu(pK1);
			this.koordenatuOriginalak=pK1;
			int kont=0;
			do {
				k=this.albokoKoordenatuak.get(this.zentzua);
				kont++;
				if (this.zentzua==3) {
					this.zentzua=0;
				}
				else {
					this.zentzua++;
				}
			}while(k.getKoordenatuakY()== -1 && k.getKoordenatuakX()== -1 && this.esandakoKoordenatuak.contains(k) && kont<=4);
			if( kont==4) {
				errepikatuta= false;
				do {
					k= this.koordenatuRandom();
					if(!this.esandakoKoordenatuak.contains(k)) {
						this.esandakoKoordenatuak.add(k);
						errepikatuta=false;
					}
					else {
						errepikatuta=true;
					}					
				} while(errepikatuta);	
			}
		}
		else if(pAurrekoanAsmatu && this.albokoKoordenatuak.size()!=0) { //ez da ukitzen duen lehenengo aldia, hau da zentzua asmatu du.
			//zentzua jakiteko:s
			if (this.zentzua==0) {
				this.zentzua=3;
			}
			else{
				this.zentzua--;
			}
			k= this.zentzuBateanKoordenatuBerriak(pK1.getKoordenatuakX(), pK1.getKoordenatuakY(), this.zentzua);
			if (k.getKoordenatuakY()== -1 && k.getKoordenatuakX()== -1) {
				this.kontrakoZentzua();
				this.erreseteatuAlbokoKoordenatuak();
				k= this.zentzuBateanKoordenatuBerriak(this.koordenatuOriginalak.getKoordenatuakX(), this.koordenatuOriginalak.getKoordenatuakY(), this.zentzua);
				this.albokoKordenatuakSortu(k);
			}
			if(this.esandakoKoordenatuak.contains(k) ) {
				errepikatuta= false;
				do {
					k= this.koordenatuRandom();
					if(!this.esandakoKoordenatuak.contains(k)) {
						this.esandakoKoordenatuak.add(k);
						errepikatuta=false;
					}
					else {
						errepikatuta=true;
					}					
				} while(errepikatuta);	
			}	
		}
		else if(!pAurrekoanAsmatu && this.albokoKoordenatuak.size()!=0) {//lehen ukitu du baina ez du zentzua asmatu
			int aux=0;
			int zentzua= this.zentzua;
			do {
				aux++;
				k=this.albokoKoordenatuak.get(this.zentzua);
				if (this.zentzua==3) {
					this.zentzua=0;
				}
				else {
					this.zentzua++;
				}
				
			}while(k.getKoordenatuakY()== -1 && k.getKoordenatuakX()==-1 && this.esandakoKoordenatuak.contains(k) && aux< 4-zentzua);
			if( aux== 4-zentzua) {
				errepikatuta= false;
				do {
					k= this.koordenatuRandom();
					if(!this.esandakoKoordenatuak.contains(k)) {
						this.esandakoKoordenatuak.add(k);
						errepikatuta=false;
					}
					else {
						errepikatuta=true;
					}					
				} while(errepikatuta);	
			}
			if (this.zentzua==0) {
				this.erreseteatuAlbokoKoordenatuak();//alboko koordenatuak erreseteatu
			}
		}		
		return  k ;
	}
	 
	 
	 private Koordenatuak koordenatuRandom() {
		 Koordenatuak k = new Koordenatuak();
		 Random rand = new Random();
		 short pX = (short) ((short) rand.nextInt(10) + 1);//1-etik 10 zenbaki bat bueltatzeko
		 short pY = (short) ((short) rand.nextInt(10) + 1);
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
					byte orientazioZenb = -1;               //ORIENTAZIOA AUKERATU
					orientazioZenb = (byte) rand.nextInt(2);
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
					pX = (short) (rand.nextInt(limitX) + 1); //From 1 to x limit
					pY = (short) (rand.nextInt(limitY) + 1); //From 1 to y limit
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
			   //}
			}  while(!denaOndo2);  //do
				denaOndo2=false;
				pItsas++;
			}//while(pItsas<5)
		}
	 
	 
	 private void albokoKordenatuakSortu(Koordenatuak pK) {
		short auxPX = pK.getKoordenatuakX() ;
		short auxPY = pK.getKoordenatuakY();
		
		//eskuina		
		this.gehituAlbokoKoordenatuak(this.zentzuBateanKoordenatuBerriak(auxPX, auxPY, (byte)0));
		 		 
		//gora
		this.gehituAlbokoKoordenatuak(this.zentzuBateanKoordenatuBerriak(auxPX, auxPY, (byte)1));
		 
		//ezkerra
		this.gehituAlbokoKoordenatuak(this.zentzuBateanKoordenatuBerriak(auxPX, auxPY, (byte)2));
		 
		//behera
		this.gehituAlbokoKoordenatuak(this.zentzuBateanKoordenatuBerriak(auxPX, auxPY, (byte)3));
	 }
	 
	 /* Ez da erabiltzen metodo hau
	private void gehituEsandakoKoordenatuak (Koordenatuak pK) {
		this.esandakoKoordenatuak.add(pK);
	}
	*/
	
	
	private void gehituAlbokoKoordenatuak (Koordenatuak pK) {
		this.albokoKoordenatuak.add(pK);
	}
	
	private void erreseteatuAlbokoKoordenatuak() {
		this.albokoKoordenatuak.clear();
	}
	 
	public boolean koordenadaBaliogarriak(short pX, short pY) {
		return super.koordenadaBaliogarriak(pX, pY);
	}

	
	public String koordenatuanZerDagoen(short pX, short pY) {
		return super.koordenatuanZerDagoen(pX, pY);
		//itzuliko duen String-a hirugarren tiroan erabiliko da
	}

	
	public void eguneratuPrintTableroa(short pX, short pY, String pEma) {
		super.eguneratuPrintTableroa(pX, pY, pEma);
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
										 if(this.zeinIzkinaDa(pX, pY) == 4) {
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
										 else {
											 pX = -1;
											 pY = -1;
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
	
	/*
	private boolean koordenatuHauEsanDu(Koordenatuak pKoord) {
		boolean esanDu = false;
		if(this.ListaKoordenatuak.contains(pKoord)) {
			esanDu = true;
		}
		return esanDu;
	}
	*/
	
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
	
	//Itsasontzia ukitu badu, metodo hau erabiliko da ausazko alboko koordenatuak generatzeko
	/*Cuando la CPU acierta una coordenada por primera vez, tiene cuatro opciones para decir la siguiente coordenada:
	 * la coordenada de arriba, la de abajo, la de la eskuma y la de la izda. Por lo tanto, este método crea un Random
	 * entre 1 y 4 (ambos incluídos), y si sale:
	 * 0- se dice la coordenada de la derecha
	 * 1- se dice la coordenada de arriba
	 * 2- se dice la coordenada de la izda
	 * 3- se dice la coordenada de abajo
	 */
	
	/*
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
