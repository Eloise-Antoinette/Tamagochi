package Tamagochi;

public class TamagochiCat extends Tamagochi {
	
	private double high = 0.5;
	

	public TamagochiCat(String name, String color, String hairColor) {
		super(name, color, hairColor);
		
		this.health = 120;
		this.hunger = 10;
		this.lifeTime = 40;
		
		this.type = "cat";
		this.high = 2;
		
	}
	

	/**
	 * @return the high
	 */
	public double getHigh() {
		return high;
	}

}
