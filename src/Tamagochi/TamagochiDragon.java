package Tamagochi;

public class TamagochiDragon extends Tamagochi {

	


	/**
	 * 
	 * Constructor 
	 * @param name
	 * @param color
	 * @param hairColor
	 */
	public TamagochiDragon(String name, String color, String hairColor) {
		super(name, color, hairColor);
		
		this.health = 120;
		this.hunger = 10;
		this.lifeTime = 60;
		
		this.type = "dragon";
		this.high = 200;
	}
	




	/**
	 * @return the high
	 */
	public double getHigh() {
		return high;
	}

	
	
	

}
