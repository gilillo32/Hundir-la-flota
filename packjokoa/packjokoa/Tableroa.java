package packjokoa;

public class Tableroa {
	//atributuak:
	private int errenZutKop;  //errenkada eta zutabe kopurua
	private String[][] matrizea;
	
	//eraikitzailea:
	public Tableroa() { /*BIGARREN MAILAKO ATAZA  int pTamaina*/
		this.errenZutKop = 10;
		this.matrizea = new String[this.errenZutKop][this.errenZutKop];
	}
	
	//gainontzeko metodoak:
	
	public void tableroaInprimatu() {
		//hasieratu indizeak
		int e= 0;
		int z= 0;
		System.out.print(" "); // lehennegoz hutsune bat inprimatu
		//Orain zutabeen indizeak imprimatuko ditu
		while (e<this.errenZutKop + 1) { 
			System.out.print(" "+e);	
			//deasberdin egingo dugu luzera hamar baino handiagoa denean, bain ahori bigarren mailako ataza da.
		}
		e=0; //berriro hasieratuko dugu
		while (e< this.errenZutKop + 1) { //erabili daiteke This.matrizea.length
			while (z<this.errenZutKop+1) { //erabili daiteke this.matrize[e].length
				System.out.print(e+ " " + this.matrizea[e][z]);				
			}			
		}
		
	}
	
	public void tableroaBete() { //uraz beteko dugu "-"
		//hasieratu indizeak
		int e= 0;
		int z= 0;

		while (e< this.errenZutKop + 1) { //erabili daiteke This.matrizea.length
			while (z<this.errenZutKop+1) { //erabili daiteke this.matrize[e].length
				this.matrizea[e][z] = "-";				
			}			
		}	
		
	}
	
	public void itsasontziakJarri() {
		
		
	}
	
	public boolean konprobatuTiroa(short pX, short pY) {
		//honako hauek salbuespenean jarriko ditugu(teklatuan)
		//konprobatuko dugu ez duela lehen erabili, ez badago U edo - (U itsasontzia ukituta dagoela esan nahi du, GOGORATU!!!
		//konprobaketa bere asmakuntzen tableroan begiratuko du
		boolean tiroa= false;
		if( this.matrizea[pX][pY] != "-" || this.matrizea[pX][pY] != "U") {
			tiroa= true;
		}
		return tiroa;
		
	}
	
	public String bigarrenTiroa(short pX, short pY) {
		//salbuespen del teklado SE MIRA AL PEDIR LA CORDENADA
		//honek etsaiaren tableroan begiratuko du zer dagoen kasilan
		return this.matrizea[pX][pY];
		
	}
	
	private boolean uraDago(short pX, short pY) {
		
	}
	
	private boolean hondoratutaDago(short pZenb) {
		
	}
	
	private boolean konprobatuHutsuneak() {
		
	}
	
	public void eguneratuTableroa(String pEmaitza) {
		
	}

}
