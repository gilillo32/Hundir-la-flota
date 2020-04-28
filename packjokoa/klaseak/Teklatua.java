package klaseak;

import java.util.Scanner;

import salbuespenak.LimiteakGainditutaExc;

public class Teklatua {
	private static Teklatua nireTeklatua=null;
	private Scanner sc;
	
	//eraikitzailea SINGLETON patroia
	private Teklatua() {
		this.sc= new Scanner(System.in);
	}
	
	public static synchronized Teklatua getNireTeklatua() {
		if(Teklatua.nireTeklatua==null) {
			Teklatua.nireTeklatua=new Teklatua();
		} 
		return Teklatua.nireTeklatua;
	}

	//String bat irakurtzeko

	public String irakurriString(String pMezua){
		//ailegatuko saio, inprimatu nahi dugun mezua NUMEROS!!!!!
		System.out.println(pMezua);
		String emaitza = sc.nextLine();//irakurri teklatutik enter bat sartu arte
		return emaitza;
	}

	
	
	
	public String irakurriOrientazioa(String pMezua, String pH, String pB) { 
		String emaitza; 
		do { System.out.println(pMezua); 
		emaitza = sc.nextLine(); 
		}while(!emaitza.equalsIgnoreCase(pH) && !emaitza.equalsIgnoreCase(pB)); 
		return emaitza; 
		} 
	
	
	
	
	
	public String irakurriString(){
		String mezua=this.sc.nextLine();
		//faltaria salbuespena de si no mete una H o B
		
		return mezua;

	}
	
	/*public String irakurriOrientazioa(String pMezua) throws OrientazioExc{
		System.out.println(pMezua);
		String emaitza = sc.nextLine();//irakurri teklatutik enter bat sartu arte	
		boolean denaOndo=false;
		do {
		try{
			if(emaitza!="B"|| emaitza!="b"||emaitza!="H"||emaitza!="h") {
			throw new  OrientazioExc("Sartu behar duzu H edo B");
			}
			denaOndo=true;
		}
		catch (OrientazioExc e){
			e.mezuaInprimatu();
			this.irakurriOrientazioa(pMezua);
		}
		}
		while(!denaOndo);
		return emaitza;
	}*/


	
	//short bat irakurtzeko

	public short irakurriShort(String pMezua, int pNundik, int pNora){
		short emaitza = (short) (pNundik -1);
        boolean denaOndo=false;
        do {
	        System.out.println(pMezua);
			String str = sc.nextLine();
		try{
			emaitza = Short.parseShort(str);
	        if(emaitza < pNundik || emaitza >pNora){
	        	throw new LimiteakGainditutaExc("Limitetik kanpo");//sartzen duen koordenatuaren balio bat negatiboa edo tablerotik kanpo badago
            }
            denaOndo=true;
		} 
         catch (NumberFormatException e) { System.out.println("Balioa ez da numerikoa"); }
         catch (LimiteakGainditutaExc e) { e.mezuaInprimatu(); }
        }
        while(!denaOndo);
        return emaitza;
      } 
	
	public short irakurriAukera(String pMezua, int pNundik, int pNora){
		short emaitza = (short) (pNundik -1);
        boolean denaOndo=false;
        do {
	        System.out.println(pMezua);
			String str = sc.nextLine();
		try{
			emaitza = Short.parseShort(str);
	        if(emaitza < pNundik || emaitza >pNora){
	        	throw new LimiteakGainditutaExc("Limitetik kanpo");//sartzen duen koordenatuaren balio bat negatiboa edo tablerotik kanpo badago
            }
            denaOndo=true;
		} 
         catch (NumberFormatException e) { System.out.println("Zenbaki bat sartu behar duzu"); }
         catch (LimiteakGainditutaExc e) { System.out.println("Ez da aukera baliogarria"); }
        }
        while(!denaOndo);
        return emaitza;
      } 
}
