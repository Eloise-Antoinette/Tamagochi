package Tamagochi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author ELO.MOREAU
 *
 */
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

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param color
	 * @param hairColor
	 */
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
	 * Gets all Status parameters in console
	 */
	public void getStatus() {
		JOptionPane.showMessageDialog(null, "Lifetime Level : " + this.lifeTime + "\n Health Level : " + this.health
				+ " \n Hunger Level : " + this.hunger + "\n Bathroom Level : " + this.bathroom, "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
	}

	/**
	 * Make the Tamagochi wash itself
	 * 
	 */
	public void isWashingItself() {
		JOptionPane.showMessageDialog(null, this.name + " : Whaouh ! I'm all CLEAN Now !", "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
		changeBathroom(2);
		changeHealth(+5);
		changeHunger(2);
		decreaseLifeTime(4);
	}

	/**
	 * Make the Tamagochi practise
	 * 
	 */
	public void isPractising() {
		JOptionPane.showMessageDialog(null, this.name + " : Whaouh ! Practising makes me feel so STRONG !", "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
		changeBathroom(3);
		changeHealth(+5);
		changeHunger(15);
		decreaseLifeTime(4);
	}

	/**
	 * Make the Tamagochi go to the bathrooms
	 * 
	 */
	public void isGoingToBathroom() {
		JOptionPane.showMessageDialog(null, this.name + " : I feel lighter ! Thank you very much", "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
		changeBathroom(0);
		changeHealth(10);
		changeHunger(6);
		decreaseLifeTime(2);
	}

	/**
	 * Make the Tamagochi rest
	 * 
	 */
	public void isResting() {
		JOptionPane.showMessageDialog(null, this.name + " : ZZZzzzzzzzzZZZZZzzzzzzzZZZZZzzz", "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
		changeBathroom(10);
		changeHealth(+15);
		changeHunger(2);
		decreaseLifeTime(4);
	}

	/**
	 * Make the Tamagochi eat
	 * 
	 * @param food
	 */
	public void isEating(String food) {
		JOptionPane.showMessageDialog(null, this.name + " : Mmmmmmh ! This " + food + " is deliciouuuus !! ", "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
		changeBathroom(10);
		changeHealth(+10);
		changeHunger(-15);
		decreaseLifeTime(3);

		if (this.hunger > 50) {
			JOptionPane.showMessageDialog(null,
					this.name + " : Hum... I feel full, try not to feed me so often, it decrease my health...", "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
			changeHealth(-10);
		}
		changeHigh(1);
	}

	/**
	 * Make the Tamagochi meets another Tamagochi
	 * 
	 * @param friend
	 */
	public void isMeetingAFriend(Tamagochi friend) {
		JOptionPane.showMessageDialog(null,
				this.name + " : What a pleasure hanging out with" + friend.getName() + " !", "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
		changeHealth(5);
		changeHunger(+2);
		changeBathroom(+5);
		decreaseLifeTime(2);
	}

	/**
	 * Make the Tamagochi have a baby with another Tamagochi
	 * 
	 * @param partner
	 * @param name
	 */
	public void isMakingABaby(Tamagochi partner, String name, int type) {

		JOptionPane.showMessageDialog(null,
				this.name + " : I'm making a baby named " + name + " with " + partner.getName() + " !", "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );

		// Make the baby gets random features from both its parents

		Random rand = new Random();

		List<String> colors = Arrays.asList(this.color, partner.color);
		String babyColor = colors.get(rand.nextInt(colors.size()));

		List<String> hairColors = Arrays.asList(this.hairColor, partner.hairColor);
		String babyHairColor = hairColors.get(rand.nextInt(colors.size()));

		// Create the babyTamagochi regarding the type wanted
		switch (type) {
		case 1:
			TamagochiDragon babyD = new TamagochiDragon(name, babyColor, babyHairColor);
			allMyBabies.add(babyD);
			partner.allMyBabies.add(babyD);
			break;
		case 2:
			TamagochiCat babyC = new TamagochiCat(name, babyColor, babyHairColor);
			allMyBabies.add(babyC);
			partner.allMyBabies.add(babyC);
			break;
		case 3:
			TamagochiFish babyF = new TamagochiFish(name, babyColor, babyHairColor);
			allMyBabies.add(babyF);
			partner.allMyBabies.add(babyF);
			break;
		default:
			break;
		}

		// Congratulations message
		JOptionPane.showMessageDialog(null,
				"..•.¸¸•´¯`•.¸¸. CONGRATULATIONS ..•.¸¸•´¯`•.¸¸. \n" + "\n" + ".•°•. A new baby is born ! Its name is "
						+ name + ", his color is " + babyColor + " and his hair is " + hairColor + " .•°•.\n " + "\n"
						+ "You can enter the 9 command to gets all your babies\n", "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
		isFeeling("happy");
		changeBathroom(+10);
		changeHealth(-20);
		changeHunger(15);
		decreaseLifeTime(10);

	}

	/**
	 * Gets all the Babies features in console
	 */
	public String getBabiesList() {
		int blSize = allMyBabies.size();
		String allBabies = "";
		for (Tamagochi tamagochi : allMyBabies) {
			allBabies += " Name " + tamagochi.getName() + ", color : " + tamagochi.color + ", hairColor : "
					+ tamagochi.hairColor + "\n";

		}
		return allBabies;

	}

	/**
	 * Make the Tamagochi smoke
	 */
	public void isSmoking() {

		JOptionPane.showMessageDialog(null,
				this.name + " : Kof, kof! I have to quit smoking !! \n", "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
		changeHealth(-20);
		changeBathroom(2);
		changeHunger(2);
		decreaseLifeTime(7);
	}

	// ---------------------- GETTERS & SETTERS ----------------------

	// MODIFIED GETTERS & SETTERS

	/**
	 * Dye Hair color
	 * 
	 * @param hairColor "red" or "roux" denied
	 */
	public void setHairColor(String hairColor) {
	
		if (hairColor.equals("roux") || hairColor.equals("red")) {
			JOptionPane.showMessageDialog(null, this.name + " : Not in red you fool ! My hair color is still + " + this.hairColor, "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
		} else {
			JOptionPane.showMessageDialog(null,this.name + " : My hair is now " + this.hairColor, "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
			this.hairColor = hairColor;
		}
	}

	/**
	 * Put on / off Tamagochi's mask
	 * 
	 * @param isMask
	 */
	public void setMask(boolean isMask) {
		
		if (isMask) {
			JOptionPane.showMessageDialog(null,this.name + " : Really do I have to where these ? I'm a HAMSTER", "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
			isFeeling("sad");
		} else {
			JOptionPane.showMessageDialog(null, this.name + " : Whaouh, it really feels better");
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

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	

	// ----------------------LIFE METHODS----------------------

	// ********************* HEALTH *********************

	/**
	 * Modify Health Level and Launches Checks
	 * 
	 * @param pts
	 */
	public void changeHealth(int pts) {
		if (isAlive) {
			this.health += pts;
			JOptionPane.showMessageDialog(null, (pts > 0 ? "+" : "") + pts + " for health. (" + this.health + ") \n", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			checkHealth();

		}
	}

	/**
	 * Checks if the Tamagochi dies
	 * 
	 * Warns if health level is low
	 * 
	 */
	public void checkHealth() {
		if (this.health <= 0) {
			isDead(true);
		} else if (this.health <= 40) {
			JOptionPane.showMessageDialog(null,
					"/!\\ CAUTION /!\\ \n" + this.name + " : Careful, my health level is very low : " + this.health
							+ " ! \n" + this.name + " : Try something to make it up ! \n");
		} else if (this.health >= 100) {
			JOptionPane.showMessageDialog(null,
					this.name + " : Congrats ! my health level is imbelievable : " + this.health + " !", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
		}

	}

	// ********************* HUNGER *********************

	/**
	 * 
	 * Modify Hunger Level and Launches Checks
	 * 
	 * @param pts
	 */
	public void changeHunger(int pts) {
		if (isAlive) {
			this.hunger += pts;
			this.hunger = this.hunger < 0 ? 0 : this.hunger;
			String indice = pts > 0 ? "+" : "";
			JOptionPane.showMessageDialog(null, indice + pts + " of hunger. (" + this.hunger + "). ", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			checkHunger();
		}
	}

	/**
	 * Checks if the Tamagochi dies
	 * 
	 * Warns if health level is high
	 * 
	 */
	public void checkHunger() {
		if (this.hunger > 30) {
			isDead(true);
		} else if (this.hunger > 20) {
			JOptionPane.showMessageDialog(null,
					"/!\\ CAUTION /!\\ \n" + this.name + " : Careful, your hunger level is very low : " + this.hunger
							+ " ! \n" + this.name + " : Try something to make it up ! You die at 30", "Tamagochi",
							JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			isFeeling("sad");
		} else if (this.health <= 0) {
			isFeeling("happy");
		}

	}

	// ********************* LIFETIME *********************

	/**
	 * 
	 * Decreases life time / Launches death if it's time...
	 * 
	 * @param pts
	 */
	public void decreaseLifeTime(int pts) {
		if (isAlive) {
			this.lifeTime -= pts;
			if (lifeTime <= 0) {
				isDead(true);
			} else if (lifeTime < 5) {
				JOptionPane.showMessageDialog(null, this.name + " : I'm getting old, I have " + this.lifeTime
						+ " pts left... Not much time to say goodbye...", "Tamagochi",
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
				isFeeling("sad");
			}
		}
	}

	/**
	 * 
	 * Makes Tamagochi die
	 * 
	 * @param isDead
	 */
	public void isDead(boolean isDead) {
		if (isAlive) {
			if (isDead) {
				JOptionPane.showMessageDialog(null, "Votre Tamagochi est MORT", "Tamagochi",
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
				isAlive = false;
			}
		}
	}

	// ********************* FEELINGS *********************

	/**
	 * 
	 * Make the Tamagochi reacts to feeling
	 * 
	 * @param humor
	 */
	public void isFeeling(String humor) {
		if (isAlive) {
			if (humor.equals("happy")) {
				JOptionPane.showMessageDialog(null, this.name + " : Jumping around because I'm so happpppy !", "Tamagochi",
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			} else if (humor.equals("sad")) {
				JOptionPane.showMessageDialog(null, this.name + " : Laying down because I'm so saaaaad...", "Tamagochi",
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			}
		}
	}

	// ********************* HIGH *********************

	/**
	 * 
	 * Make your Tamagochi grows
	 * 
	 * @param pts
	 */
	public void changeHigh(int pts) {
		if (isAlive) {
			this.high += pts;
			JOptionPane.showMessageDialog(null, this.name + " : I'm GROOWIIING, i'm now " + high + " meters tall !", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));

		}
	}

	// ********************* BATHROOM *********************

	/**
	 * 
	 * Change your need to go to the bathroom
	 * 
	 * @param pts
	 */
	public void changeBathroom(int pts) {
		if (isAlive) {
			if (this.bathroom > 30) {
				JOptionPane.showMessageDialog(null,
						this.name + " : Careful, I really need to go to the bathroom, my health is getting lower !", "Tamagochi",
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
				changeHealth(-10);
			}
		}
	}

	public void popupTypeInformation() {

		JOptionPane.showMessageDialog(null, "Type :" + this.getType() + " \n High :" + this.getHigh() + " \n Health : "
				+ this.getHealth() + "\n Life time" + this.getLifeTime() + "\n Hunger " + this.getLifeTime(), "Tamagochi",
				JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));

	}

}
