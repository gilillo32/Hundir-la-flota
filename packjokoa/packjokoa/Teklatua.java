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
		return mezua;
	}
	
	//short bat irakurtzeko
	public short irakurriOsoa(){
		String zenb=this.irakurriString();
		short zenbInt=0;
		//salbuespenak egin barik
		if(zenb.isEmpty()){
			System.out.println("Zenbaki bat idatzi, mesedez");
			zenb=this.irakurriString();
		}
		else {
			zenbInt=Short.parseShort(zenb);
		}
		return zenbInt;
	}
	
}
