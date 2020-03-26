package packjokoa;

import java.util.Scanner;

public class Teklatua {
	private static Teklatua nireTeklatua=null;
	private Scanner sc;
	
	//eraikitzailea SINGLETON patroia
	private Teklatua() {
		
	}
	
	public static synchronized Teklatua getNireTeklatua() {
		if(Teklatua.nireTeklatua==null) {
			Teklatua.nireTeklatua=new Teklatua();
		}
		return Teklatua.nireTeklatua;
	}
	
	public void mezuaIrakurri() {
		
	}
	//String bat irakurtzeko
	public String irakurriString(){
		String mezua=this.sc.nextLine();
		//faltaria salbuespena de si no mete una H o B
		
		return mezua;
	}
	
	
	
	//short bat irakurtzeko
	public short irakurriShort(){
		String zenb=this.irakurriString();
		short zenbShort=0;
		//salbuespenak egin barik
		
		if(zenb.isEmpty()){ //true bueltatuko du String tamaina 0 bada
			System.out.println("Zenbaki bat idatzi, mesedez");
			zenb=this.irakurriString();
		}
		else {
			
			try {
				zenbShort=Short.parseShort(zenb);
				//if(zenbShort<1 || zenbShort>)
			}
			catch(NumberFormatException e){
				System.out.println("Bakarrik zenbaki osoak onartzen dira.");
				zenbShort=this.irakurriShort();
				}
			}
		return zenbShort;
	}
	
}
