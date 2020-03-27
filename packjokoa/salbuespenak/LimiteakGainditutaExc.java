package salbuespenak;

public class LimiteakGainditutaExc extends Exception {
	//eraikitzaaileak
			//parametrorik gabe
		public LimiteakGainditutaExc() {
			super();
		}
			//parametroekin
		public LimiteakGainditutaExc(String pMezua) {
			//"Sartu dituzun kordenatuak ez dira egkiak, mesedez sartu koordenatuak berriro."
			//cuando agamos trow exception tenemos que poner esto entre parentesis
			super(pMezua);
		}
		public void mezuaInprimatu(){
			System.out.println("Balio hori ez dago tableroan");
		}
}
