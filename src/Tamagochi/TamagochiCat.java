package Tamagochi;

public class TamagochiCat extends Tamagochi {
	

	public TamagochiCat(String name, String color, String hairColor) {
		super(name, color, hairColor);
		
		//Cat's parameters initialisation
		this.health = 120;
		this.hunger = 10;
		this.lifeTime = 40;
		
		this.type = "cat";
		this.high = 2;
		
	}

}
