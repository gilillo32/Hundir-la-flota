package salbuespenak;

public class OrientazioExc extends Exception {
	//eraikitzaaileak
	//parametrorik gabe
		public OrientazioExc() {
			super();
		}
			//parametroekin
		public OrientazioExc(String pMezua) {
			//"Sartu dituzun kordenatuak ez dira egkiak, mesedez sartu koordenatuak berriro."
			//cuando agamos trow exception tenemos que poner esto entre parentesis
			super(pMezua);
		}
		public void mezuaInprimatu(){
			System.out.println("Sartu duzun orientazioa txarto dago");
		}
}
