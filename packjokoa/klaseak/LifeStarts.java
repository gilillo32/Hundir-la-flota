package klaseak;

class LifeStarts {
	public static void laif()
	 throws java.lang.InterruptedException{
		Life earth = new Life(55);
		earth.drawWorld();
		while(true){
			Thread.sleep(1000);
			earth.nextGeneration();
			earth.drawWorld();
		}
	}
}
