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
	
	
}
