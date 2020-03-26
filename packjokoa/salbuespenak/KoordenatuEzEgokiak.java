package salbuespenak;

public class KoordenatuEzEgokiak extends Exception {
	//eraikitzaaileak
		//parametrorik gabe
	public KoordenatuEzEgokiak() {
		super();
	}
		//parametroekin
	public KoordenatuEzEgokiak(String pMezua) {
		//"Sartu dituzun kordenatuak ez dira egkiak, mesedez sartu koordenatuak berriro."
		//cuando agamos trow exception tenemos que poner esto entre parentesis
		super(pMezua);
		
		//Sartu dituzun kordenatuak ez dira egkiak, mesedez sartu koordenatuak berriro.
	}

}
