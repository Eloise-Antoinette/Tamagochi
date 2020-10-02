package Tamagochi;

public class TamagochiFish extends Tamagochi {

	private double high = 0.2;
	
	public TamagochiFish(String name, String color, String hairColor) {
		super(name, color, hairColor);
		
		this.health = 80;
		this.hunger = 0;
		this.lifeTime = 60;
		
		this.type = "fish";
		this.high = 0.5;
	}




	/**
	 * @return the high
	 */
	public double getHigh() {
		return high;
	}
}
