package Tamagochi;

import java.util.Date;

/**
 * @author ELO.MOREAU
 *
 */
public class Tamagochi {

	private String name;
	private double high;
	private int health = 100;
	private String color;
	private String hairColor;
	private Date birth;

	public void isMeetingAFriend(Tamagochi friend) {
		System.out.println(this.name + "is hanging out with" + friend.getName());
		changeHealth(5);
	}

	public void isGoingToBathroom() {
		System.out.println(this.name + " is lighter ! Thank you very much");
		changeHealth(10);
	}

	public void changeHealth(int pts) {
		this.health += pts;
		System.out.println(pts > 0 ? "+" : "-" + pts + " for health. Health level is now " + this.health);
		checkHealth();
	}

	public void checkHealth() {
		if (this.health <= 0) {
			isDead(true);
		} else if (this.health < 20) {
			System.out.println("Careful, your health level is very low : " + this.health + " !");
			System.out.println("Try something to make it up !");
		} else if (this.health >= 100) {
			System.out.println("Congrats ! Your health level is imbelievable : " + this.health + " !");
		}
	}

	public void isMakingABaby(Tamagochi partner, String name) {
		// random
	}

	public void isDead(boolean isDead) {
		if (isDead) {
			System.out.println("Votre Tamagochi est MORT");
		}
	}

	public boolean gettingOld(Date date) {
		System.out.println(birth);
		return true;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
