package Tamagochi;

import java.util.Scanner;

public class MainScript {

	public static void main(String[] args) {

		TamagochiDragon elysia = new TamagochiDragon("Elysia", "blue", "green");
		System.out.println(elysia.getType());
		TamagochiCat carol = new TamagochiCat("Carol", "silver", "gold");
		TamagochiFish charles = new TamagochiFish("Charles", "green", "red");

		Tamagochi tamagochiPlayer = createYourTamagochi();

		// tamagochiPlayer.getT

		do {
			commandListener(tamagochiPlayer, elysia, carol, charles);
		} while (tamagochiPlayer.isAlive());

	}

	/**
	 * Creating a new Tamagochi with the user
	 * 
	 * @author ELO.MOREAU
	 * @return Tamagochi
	 */
	public static Tamagochi createYourTamagochi() {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("·**·.¸(¯`·.¸*. WELCOME .*¸.·´¯)¸.·**·. ");
		System.out.println("");
		System.out
				.println("You're going to create your new Tamagochi ! Make sure to keep it happy, healthy and ALIVE !");
		System.out.println("");
		System.out.println("What kind of Tamagochi do you want ?");
		System.out.println("Press 1 for a Dragon,");
		System.out.println("Press 2 for a Cat");
		System.out.println("Press 3 for a Fish");

		String typeLine = sc.nextLine();
		int type = 0;
		
		try {
			type = Integer.parseInt(typeLine);
		} catch (NumberFormatException NaN) {
			System.out.println("Wrong entry, please, do it again...");
			System.out.println("Please, press any key to continue.");
			String ok = sc.nextLine();
			createYourTamagochi();
		}
		
		System.out.println("Please enter the name of your Tamagochi :");
		String name = sc.nextLine();
		String nameUp = name.substring(0, 1).toUpperCase() + name.substring(1);

		System.out.println("Please enter the color of your Tamagochi :");
		String color = sc.nextLine();
		System.out.println("Please enter the hair color of your Tamagochi :");
		String hairColor = sc.nextLine();

		Tamagochi tamagochiPlayer = null;

		switch (type) {
		case 1:
			tamagochiPlayer = new TamagochiDragon(nameUp, color, hairColor);
			break;
		case 2:
			tamagochiPlayer = new TamagochiCat(nameUp, color, hairColor);
			break;
		case 3:
			tamagochiPlayer = new TamagochiFish(nameUp, color, hairColor);
			break;
		default:
			System.out.println("Wrong entry, please, do it again...");
			createYourTamagochi();
		}

		if (tamagochiPlayer != null) {
			System.out.println("..•.¸¸•´¯`•.¸¸. CONGRATULATIONS ..•.¸¸•´¯`•.¸¸. ");
			System.out.println("");
			System.out.println("°•. °•. °•. °•. " + tamagochiPlayer.getName() + " is born !  .•° .•° .•° .•° ");
			System.out.println("");
			System.out.println("It's a " + tamagochiPlayer.getType() + ", it's" + tamagochiPlayer.getColor()
					+ " and has " + tamagochiPlayer.getHairColor() + " hair");
			System.out.println("It's " + tamagochiPlayer.getHigh() + " tall");
			tamagochiPlayer.getStatus();
			System.out.println("");
			System.out.println("Please, press any key to continue.");
			String ok = sc.nextLine();
		}

		return tamagochiPlayer;

	}

	/**
	 * 
	 * Listen to the user command and activate the rights methods of the object tam
	 * 
	 * @author ELO.MOREAU
	 * @param tam
	 * @param elysia
	 * @param carol
	 * @param charles
	 */
	public static void commandListener(Tamagochi tam, TamagochiDragon elysia, TamagochiCat carol,
			TamagochiFish charles) {

		Scanner sc = new Scanner(System.in);
		System.out.println("***************************************************");
		System.out.println("Can I take your command ?");
		System.out.println("You will find all the possibilities in the command system");

		String commandLine = sc.nextLine();
		int command = 0;

		
		try {
			command = Integer.parseInt(commandLine);
		} catch (NumberFormatException NaN) {
		}
		
		System.out.println("");

		switch (command) {
		// GET STATUS
		case 1:
			System.out.println("1. " + tam.getName() + " is getting Status : ");
			tam.getStatus();
			break;
		// WASH ITSELF
		case 2:
			System.out.println("2. " + tam.getName() + " is washing itself : ");
			tam.isWashingItself();
			break;
		// WASH ITSELF
		case 3:
			System.out.println("3. " + tam.getName() + " is practising : ");
			tam.isPractising();
			break;
		// GO TO THE BATHROOM
		case 4:
			System.out.println("4.  " + tam.getName() + " is going to the bathroom: ");
			tam.isWashingItself();
			break;

		// REST
		case 5:
			System.out.println("5.  " + tam.getName() + " is resting : ");
			tam.isResting();
			break;

		// EAT
		case 6:
			System.out.println("6. " + tam.getName() + " is eating / Please enter the food you want " + tam.getName()
					+ " to eat : ");
			String food = sc.nextLine();
			tam.isEating(food);
			break;

		// MEET A FRIEND
		case 7:
			System.out.println("7. " + tam.getName() + " is going to meet a friend : ");
			System.out.println("There's 3 Tamagochis near you");
			System.out.println("1. " + elysia.getName() + ", it's " + elysia.getColor() + " and has "
					+ elysia.getHairColor() + " hair,");
			System.out.println("2. " + carol.getName() + ", it's " + carol.getColor() + " and has "
					+ carol.getHairColor() + " hair,");
			System.out.println("3. " + charles.getName() + ", it's " + charles.getColor() + " and has "
					+ charles.getHairColor() + " hair,");
			System.out.println("Please enter the number (1, 2 or 3) of the Tamagochi you want to hang out with");
			
	
			String friendLine = sc.nextLine();
			int friend = 0;

			try {
				friend = Integer.parseInt(friendLine);
			} catch (NumberFormatException NaN) {
				
			}
			
			switch (friend) {
			case 1:
				tam.isMeetingAFriend(elysia);
				break;
			case 2:
				tam.isMeetingAFriend(carol);
				break;
			case 3:
				tam.isMeetingAFriend(charles);
				break;
			default:
				System.out.println("I didn't understant... Enter Try again...");
			}
			break;

		// MAKE A BABY
		case 8:
			System.out.println("8. " + tam.getName() + " is wanting to have a baby : ");
			System.out.println("There's 3 Tamagochis near you !");
			System.out.println("Choose it well, your baby is gonna randomly gets both of your features !");
			System.out.println("1. " + elysia.getName() + ", it's " + elysia.getColor() + " and has "
					+ elysia.getHairColor() + " hair,");
			System.out.println("2. " + carol.getName() + ", it's " + carol.getColor() + " and has "
					+ carol.getHairColor() + " hair,");
			System.out.println("3. " + charles.getName() + ", it's " + charles.getColor() + " and has "
					+ charles.getHairColor() + " hair,");
			String parentLine = sc.nextLine();
			int parent = Integer.parseInt(parentLine);

			System.out.println("Please enter the number (1, 2 or 3) of the Tamagochi you want to have a baby with");
			System.out.println("1. Dragon");
			System.out.println("1. Cat");
			System.out.println("1. Fish");
			String babyTypeLine = sc.nextLine();
			int babyType = Integer.parseInt(babyTypeLine);

			System.out.println("Please enter your new born's name : ");
			String babyName = sc.nextLine();

			switch (parent) {
			case 1:
				tam.isMakingABaby(elysia, babyName, babyType);
				break;
			case 2:
				tam.isMakingABaby(carol, babyName, babyType);
				break;
			case 3:
				tam.isMakingABaby(charles, babyName, babyType);
				break;
			default:
				System.out.println("I didn't understant... Enter 8 to try again...");
			}
			break;

		// GET BABY LIST
		case 9:
			System.out.println("9. Here is " + tam.getName() + "'s babies list : ");
			tam.getBabiesList();
			break;

		// SMOKE
		case 10:
			System.out.println("10. " + tam.getName() + " is smoking a cigaret : ");
			tam.isSmoking();
			break;

		// DYE HAIR
		case 11:
			System.out.println("11. " + tam.getName()
					+ "is willing to dye its hair / Please enter the name of the color you want it : ");
			String dyeingColor = sc.nextLine();
			tam.setHairColor(dyeingColor);
			break;

		// PUT MASK ON / OFF
		case 12:
			boolean mask = tam.isMask() ? false : true;
			System.out.println("12. " + tam.getName() + "is putting is mask " + (mask ? "on" : "off"));
			tam.setMask(mask);
			break;

		// WRONG ENTRY
		default:
			System.out.println("I didn't understant... Try again...");
			break;
		}

		System.out.println("");
		System.out.println("Please, press any key to continue.");
		String ok = sc.nextLine();
	}

}
