package Tamagochi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Tamagochi {

	protected String name;
	protected String color;
	protected String hairColor;
	protected double high;
	protected int health;
	protected int hunger;
	protected int lifeTime;
	protected int bathroom;
	protected boolean isMask;
	protected boolean isAlive;
	protected String type;

	List<Tamagochi> allMyBabies = new ArrayList<Tamagochi>();

	public Tamagochi(String name, String color, String hairColor) {
		
		this.bathroom = 0;
		this.isMask = false;
		this.isAlive = true;
		
		
		this.name = name;
		this.color = color;
		this.hairColor = hairColor;
	}

	// ----------------------METHODS----------------------

	/**
	 * 
	 */
	public void getStatus() {
		System.out.println("Lifetime Level : " + this.lifeTime);
		System.out.println("Health Level : " + this.health);
		System.out.println("Hunger Level : " + this.hunger);
		System.out.println("Bathroom Level : " + this.bathroom);
		System.out.println("");
	}

	/**
	 * 
	 */
	public void isWashingItself() {
		System.out.println(this.name + " : Whaouh ! I'm all CLEAN Now !");
		System.out.println("");
		changeBathroom(2);
		changeHealth(+5);
		changeHunger(2);
		decreaseLifeTime(4);
	}

	/**
	 * 
	 */
	public void isPractising() {
		System.out.println(this.name + " : Whaouh ! Practising makes me feel so STRONG !");
		System.out.println("");
		changeBathroom(3);
		changeHealth(+5);
		changeHunger(15);
		decreaseLifeTime(4);
	}

	/**
	 * 
	 */
	public void isGoingToBathroom() {
		System.out.println(this.name + " : I feel lighter ! Thank you very much");
		System.out.println("");
		changeBathroom(0);
		changeHealth(10);
		changeHunger(6);
		decreaseLifeTime(2);
	}

	/**
	 * 
	 */
	public void isResting() {
		System.out.println(this.name + " : ZZZzzzzzzzzZZZZZzzzzzzzZZZZZzzz");
		System.out.println("");
		changeBathroom(10);
		changeHealth(+15);
		changeHunger(2);
		decreaseLifeTime(4);
	}

	/**
	 * @param food
	 */
	public void isEating(String food) {
		System.out.println(this.name + " : Mmmmmmh ! This " + food + " is deliciouuuus !! ");
		System.out.println("");
		changeBathroom(10);
		changeHealth(+10);
		changeHunger(-15);
		decreaseLifeTime(3);

		if (this.hunger > 50) {
			System.out.println(
					this.name + " : Hum... I feel full, try not to feed me so often, it decrease my health...");
			changeHealth(-10);
		}
		changeHigh(1);
	}

	/**
	 * @param friend
	 */
	public void isMeetingAFriend(Tamagochi friend) {
		System.out.println(this.name + " : What a pleasure hanging out with" + friend.getName() + " !");
		System.out.println("");
		changeHealth(5);
		changeHunger(+2);
		changeBathroom(+5);
		decreaseLifeTime(2);
	}

	/**
	 * @param partner
	 * @param name
	 */
	public void isMakingABaby(Tamagochi partner, String name, int type) {
		

		System.out.println(this.name + " : I'm making a baby named " + name + " with " + partner.getName() + " !");
		System.out.println("");
		Random rand = new Random();

		String babyName = name;

		List<String> colors = Arrays.asList(this.color, partner.color);
		String babyColor = colors.get(rand.nextInt(colors.size()));

		List<String> hairColors = Arrays.asList(this.hairColor, partner.hairColor);
		String babyHairColor = hairColors.get(rand.nextInt(colors.size()));
		
		
		
		
		// TODO list
		switch(type) {
		case 1 : 
		
			allMyBabies.add(new TamagochiDragon(name, babyColor, babyHairColor));
			break;
		case 2 :
			allMyBabies.add(new TamagochiCat(name, babyColor, babyHairColor));
			break;
		case 3 : 
			allMyBabies.add(new TamagochiFish(name, babyColor, babyHairColor));
			break;
		default :
			break;
		}
		
		System.out.println("..•.¸¸•´¯`•.¸¸. CONGRATULATIONS ..•.¸¸•´¯`•.¸¸. ");
		System.out.println("");
		System.out.println(".•°•. A new baby is born ! Its name is " + name + ", his color is " + babyColor
				+ " and his hair is " + hairColor + " .•°•. ");
		System.out.println("");
		System.out.println("Enter 9 to gets all your babies");
		System.out.println("");
		isFeeling("happy");
		changeBathroom(+10);
		changeHealth(-20);
		changeHunger(15);
		decreaseLifeTime(10);

	}

	public void getBabiesList() {
		int blSize = allMyBabies.size();

		for (Tamagochi tamagochi : allMyBabies) {
			System.out.println(" Name " + tamagochi.getName() + ", color : " + tamagochi.color + ", hairColor : "
					+ tamagochi.hairColor);
			System.out.println("");
		}
	}

	/**
	 * 
	 */
	public void isSmoking() {
		System.out.println(this.name + " : Kof, kof! I have to quit smoking !!");
		System.out.println("");
		changeHealth(-20);
		changeBathroom(2);
		changeHunger(2);
		decreaseLifeTime(7);
	}

	// ---------------------- GETTERS & SETTERS ----------------------

	// MODIFIED GETTERS & SETTERS

	public void setHairColor(String hairColor) {
		if (hairColor.equals("roux") || hairColor.equals("red")) {
			System.out.println(this.name + " : Not in red you fool ! My hair color is still + " + this.hairColor);
		} else {
			System.out.println(this.name + " : My hair is now " + this.hairColor);
			this.hairColor = hairColor;
		}
	}
	
	public void setMask(boolean isMask) {
		if (isMask) {
			System.out.println(this.name + " : Really do I have to where these ? I'm a HAMSTER");
			isFeeling("sad");
		} else {
			System.out.println(this.name + " : Whaouh, it really feels better");
			isFeeling("happy");
		}
		this.isMask = isMask;
	}



	// AUTO GENERATED GETTERS AND SETTERS

	/**
	 * @return the isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * @return high
	 */
	public double getHigh() {
		return high;
	}

	/**
	 * @return health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @return
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return
	 */
	public String getHairColor() {
		return hairColor;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public int getLifeTime() {
		return lifeTime;
	}

	/**
	 * @return
	 */
	public boolean isMask() {
		return isMask;
	}

	/**
	 * @return the hunger
	 */
	public int getHunger() {
		return hunger;
	}

	

	public String getType() {
		return type;
	}
	
	// ----------------------LIFE METHODS----------------------

	// ********************* HEALTH *********************

	/**
	 * @param pts
	 */
	public void changeHealth(int pts) {
		if (isAlive) {
			this.health += pts;
			System.out.println(pts > 0 ? "+" : "" + pts + " for health. (" + this.health + ")");
			System.out.println("");
			checkHealth();
		}
	}

	/**
	 * 
	 */
	public void checkHealth() {
		if (this.health <= 0) {
			isDead(true);
		} else if (this.health <= 40) {
			System.out.println("/!\\ CAUTION /!\\");
			System.out.println(this.name + " : Careful, my health level is very low : " + this.health + " !");
			System.out.println(this.name + " : Try something to make it up !");
			System.out.println("");
		} else if (this.health >= 100) {
			System.out.println(this.name + " : Congrats ! my health level is imbelievable : " + this.health + " !");
			System.out.println("");
		}

	}

	// ********************* HUNGER *********************

	/**
	 * @param pts
	 */
	public void changeHunger(int pts) {
		if (isAlive) {
			this.hunger += pts;
			this.hunger = this.hunger < 0 ? 0 : this.hunger;
			String indice = pts > 0 ? "+" : "";
			System.out.println(indice + pts + " of hunger. (" + this.hunger + "). ");
			checkHunger();
		}
	}

	/**
	 * 
	 */
	public void checkHunger() {
		if (this.hunger > 30) {
			isDead(true);
		} else if (this.hunger > 20) {
			System.out.println("/!\\ CAUTION /!\\");
			System.out.println(this.name + " : Careful, your hunger level is very low : " + this.hunger + " !");
			System.out.println(this.name + " : Try something to make it up ! You die at 30");
			isFeeling("sad");
		} else if (this.health <= 0) {
			isFeeling("happy");
		}

	}

	// ********************* LIFETIME *********************

	/**
	 * @param pts
	 */
	public void decreaseLifeTime(int pts) {
		if (isAlive) {
			this.lifeTime -= pts;
			if (lifeTime <= 0) {
				isDead(true);
			} else if (lifeTime < 5) {
				System.out.println(this.name + " : I'm getting old, I have " + this.lifeTime
						+ " pts left... Not much time to say goodbye...");
				isFeeling("sad");
			}
		}
	}

	/**
	 * @param isDead
	 */
	public void isDead(boolean isDead) {
		if (isAlive) {
			if (isDead) {
				System.out.println("Votre Tamagochi est MORT");
				isAlive = false;
			}
		}
	}

	// ********************* FEELINGS *********************

	/**
	 * @param humor
	 */
	public void isFeeling(String humor) {
		if (isAlive) {
			if (humor.equals("happy")) {
				System.out.println(this.name + " : Jumping around because I'm so happpppy !");
			} else if (humor.equals("sad")) {
				System.out.println(this.name + " : Laying down because I'm so saaaaad...");
			}
			System.out.println("");
		}
	}

	// ********************* HIGH *********************

	/**
	 * @param pts
	 */
	public void changeHigh(int pts) {
		if (isAlive) {
			this.high += pts;
			System.out.println(this.name + " : I'm GROOWIIING, i'm now " + high + " meters tall !");
			System.out.println("");
		}
	}

	// ********************* BATHROOM *********************

	/**
	 * @param pts
	 */
	public void changeBathroom(int pts) {
		if (isAlive) {
			if (this.bathroom > 30) {
				System.out.println(
						this.name + " : Careful, I really need to go to the bathroom, my health is getting lower !");
				System.out.println("");
				changeHealth(-10);
			}
		}
	}

}
