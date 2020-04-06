package packjokoa;

public class Koordenatuak {
	
	private short x;
	private short y;
	

	public Koordenatuak() {
		this.x = -1;
		this.y = -1;
	}
	
	public Koordenatuak(short pX, short pY) {
		this.x = pX;
		this.y = pY;
	}
	
	public void setKoordenatuakX(short pX) {
		this.x = pX;
	}
	
	public short getKoordenatuakX() {
		return this.x;
	}
	
	public void setKoordenatuakY(short pY) {
		this.y = pY;
	}
	
	public short getKoordenatuakY() {
		return this.y;
	}

}
