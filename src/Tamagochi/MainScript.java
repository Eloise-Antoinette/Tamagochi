package Tamagochi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class MainScript {

	public static void main(String[] args) {
		
		
		//Managing User Interface
			Color myColor = new Color(212, 239, 223);
			Color colorText = new Color( 17, 122, 101 );
			Color lighterColor = new Color( 234, 250, 241 );
			Color darkColor = new Color(14, 102, 85);
			
		  UIManager UI=new UIManager();
		  UI.put("OptionPane.background", myColor);
		  UI.put("Panel.background", myColor);
		  UI.put("Button.foreground", colorText);
		  UI.put("Button.highlight", myColor);
		  UI.put("Button.font", Font.getFont("Helvetica"));
		  UI.put("Button.background", lighterColor );
		  UI.put("OptionPane.inputDialogTitle", "Tamagochi" );
		  UI.put("Label.font",new Font("Verdana",Font.TYPE1_FONT, 15));
		  
		
		// Creating others Tamagochi to meet
			TamagochiDragon elysia = new TamagochiDragon("Elysia", "blue", "green");
			TamagochiCat carol = new TamagochiCat("Carol", "silver", "gold");
			TamagochiFish charles = new TamagochiFish("Charles", "green", "red");
		  
		  //Greetings		  
		JOptionPane.showMessageDialog(null, " \n  ·**·.¸(¯`·.¸*. WELCOME .*¸.·´¯)¸.·**·.   \n ", "Tamagochi", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg") );
		

		// Creating the player Tamagochi
		Tamagochi tamagochiPlayer = createYourTamagochi();

		// While the Tamagochi is alive, ask for a command
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

		// Greetings
		JOptionPane.showMessageDialog(null,
				"You're going to create your new Tamagochi ! Make sure to keep it happy, healthy and ALIVE !  \n",
				"Tamagochi", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));

		// Ask for the type

		int box = 0;

		do {
			String boxLine = (String) JOptionPane.showInputDialog(null,
					"You're gonna choose your Tamagochi type : Do you want to discover wich features each type gets ?  \n "
							+ "Press 1 for a Dragon \n" + "Press 2 for a Cat \n" + "Press 3 for a Fish \n"
							+ "Press any other key to pass",
					"Tamagochi",
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"), null,"");

			try {
				box = Integer.parseInt(boxLine);
			} catch (NumberFormatException NaN) {
				box = 0;
			}

			switch (box) {
			case 1:
				TamagochiDragon dragon = new TamagochiDragon("dragon", "red", "red");
				dragon.popupTypeInformation();
				break;
			case 2:
				TamagochiCat cat = new TamagochiCat("cat", "red", "red");
				cat.popupTypeInformation();
				break;
			case 3:
				TamagochiFish fish = new TamagochiFish("fish", "red", "red");
				fish.popupTypeInformation();
				break;
			default:
				box = 0;
				break;
			}

		} while (box == 1 || box == 2 || box == 3);

		/*
		 * System.out.println("You can now choose your Tamagochi's type");
		 * System.out.println("Press 1 for a Dragon,");
		 * System.out.println("Press 2 for a Cat");
		 * System.out.println("Press 3 for a Fish");
		 * 
		 * String typeLine = sc.nextLine();
		 */
		String typeLine = (String) JOptionPane.showInputDialog(null, "You can now choose your Tamagochi's type  \n "
				+ "Press 1 for a Dragon \n" + "Press 2 for a Cat \n" + "Press 3 for a Fish \n",
				"Tamagochi",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"), null, "");
		int type = 0;

		try {
			type = Integer.parseInt(typeLine);
		} catch (NumberFormatException NaN) {
			JOptionPane.showMessageDialog(null,
					"Wrong entry, please, do it again...  \n" + "Please, press any key to continue", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			createYourTamagochi();
		}

		// Ask for the name

		String name = (String) JOptionPane.showInputDialog(null, "Please enter the name of your Tamagochi",
				"Tamagochi",
				JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"), null,"");
		// Turn the first letter in uppercase
		String nameUp = name.substring(0, 1).toUpperCase() + name.substring(1);

		// Ask for color & hair color
		String color = JOptionPane.showInputDialog(null, "Please enter the color of your Tamagochi");
		String hairColor = JOptionPane.showInputDialog(null, "Please enter the haircolor of your Tamagochi");

		// Instanciate the new Tamagochi
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
			JOptionPane.showMessageDialog(null, "Wrong entry, please, do it again...  \n", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			createYourTamagochi();
		}

		// Recap all Tamagochi's information
		if (tamagochiPlayer != null) {
			popUpImage(tamagochiPlayer.getType());
			JOptionPane.showMessageDialog(null,
					"..•.¸¸•´¯`•.¸¸. CONGRATULATIONS ..•.¸¸•´¯`•.¸¸.  \n" + "\n" + "°•. °•. °•. °•. "
							+ tamagochiPlayer.getName() + " is born !  .•° .•° .•° .•°" + "\n" + "It's a "
							+ tamagochiPlayer.getType() + ", it's" + tamagochiPlayer.getColor() + " and has "
							+ tamagochiPlayer.getHairColor() + " hair\n" + "It's " + tamagochiPlayer.getHigh()
							+ " tall\n" + "\n" + "Please, press OK to continue.",
					"Tamagochi", JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));

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

		String commandLine = JOptionPane.showInputDialog(null, "*************************************************** \n "
				+ "Can I take your command ? \n" + "You will find all the possibilities in the command system");
		int command = 0;

		try {
			command = Integer.parseInt(commandLine);
		} catch (NumberFormatException NaN) {
		}

		System.out.println("");

		// Treat Command
		switch (command) {
		// GET STATUS
		case 1:
			JOptionPane.showMessageDialog(null, "1. " + tam.getName() + " is getting Status : ", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			tam.getStatus();
			break;
		// WASH ITSELF
		case 2:
			JOptionPane.showMessageDialog(null, "2. " + tam.getName() + " is washing itself : ", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			tam.isWashingItself();
			break;
		// WASH ITSELF
		case 3:
			JOptionPane.showMessageDialog(null, "3. " + tam.getName() + " is practising : ", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			tam.isPractising();
			break;
		// GO TO THE BATHROOM
		case 4:
			JOptionPane.showMessageDialog(null, "4.  " + tam.getName() + " is going to the bathroom: ", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			tam.isWashingItself();
			break;

		// REST
		case 5:
			JOptionPane.showMessageDialog(null, "5.  " + tam.getName() + " is resting : ", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			tam.isResting();
			break;

		// EAT
		case 6:
			String food = (String) JOptionPane.showInputDialog(null, "6. " + tam.getName()
					+ " is eating / Please enter the food you want " + tam.getName() + " to eat : ",
					"Tamagochi",
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"), null,"");
			tam.isEating(food);
			break;

		// MEET A FRIEND
		case 7:
			JOptionPane.showMessageDialog(null, "7. " + tam.getName() + " is going to meet a friend : ", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));

			String friendLine = (String) JOptionPane.showInputDialog(null,
					"There's 3 Tamagochis near you\n " + "1. " + elysia.getName() + ", it's " + elysia.getColor()
							+ " and has " + elysia.getHairColor() + " hair,\n" + "2. " + carol.getName() + ", it's "
							+ carol.getColor() + " and has " + carol.getHairColor() + " hair \n" + "3. "
							+ charles.getName() + ", it's " + charles.getColor() + " and has " + charles.getHairColor()
							+ " hair, \n"
							+ "Please enter the number (1, 2 or 3) of the Tamagochi you want to hang out with",
							"Tamagochi",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"), null,"");

			int friend = 0;

			try {
				friend = Integer.parseInt(friendLine);
			} catch (NumberFormatException NaN) {

			}

			// Launches with Tamagochi selected
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
				JOptionPane.showMessageDialog(null, "I didn't understand, try again ! ", "Tamagochi",
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			}
			break;

		// MAKE A BABY
		case 8:
			JOptionPane.showMessageDialog(null, "8. " + tam.getName() + " is wanting to have a baby : ", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));

			// Choose Tamagochi to have a baby with
			String parentLine = (String) JOptionPane.showInputDialog(null,
					"There's 3 Tamagochis near you\n "
							+ "Choose it well, your baby is gonna randomly gets both of your features !\n" + "1. "
							+ elysia.getName() + ", it's " + elysia.getColor() + " and has " + elysia.getHairColor()
							+ " hair,\n" + "2. " + carol.getName() + ", it's " + carol.getColor() + " and has "
							+ carol.getHairColor() + " hair \n" + "3. " + charles.getName() + ", it's "
							+ charles.getColor() + " and has " + charles.getHairColor() + " hair, \n"
							+ "Please enter the number (1, 2 or 3) of the Tamagochi you want to hang out with",
							"Tamagochi",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"), null,"");

			int parent = Integer.parseInt(parentLine);

			// Choose baby type
			String babyTypeLine = (String) JOptionPane.showInputDialog(null,
					"Please enter the number (1, 2 or 3) of the Tamagochi you want to have a baby with \n "
							+ "1. Dragon \n" + "2. Cat \n" + "3. Fish \n",
							"Tamagochi",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"), null,"");

			int babyType = Integer.parseInt(babyTypeLine);

			// Choose baby name
			String babyName = (String) JOptionPane.showInputDialog(null, "Please enter your new baby's name",
					"Tamagochi",
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"), null,"");

			// launches method to create baby with all parameters
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
				JOptionPane.showMessageDialog(null, "I didn't understant... Enter 8 to try again...", "Tamagochi",
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			}
			break;

		// GET BABY LIST
		case 9:
			JOptionPane.showMessageDialog(null,
					"9. Here is " + tam.getName() + "'s babies list : " + tam.getBabiesList(), "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));

			break;

		// SMOKE
		case 10:
			JOptionPane.showMessageDialog(null, "10. " + tam.getName() + " is smoking a cigaret : \n", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			tam.isSmoking();

			break;

		// DYE HAIR
		case 11:
			JOptionPane.showMessageDialog(null, "11. " + tam.getName()
					+ "is willing to dye its hair / Please enter the name of the color you want it : ", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));

			String dyeingColor = (String) JOptionPane.showInputDialog(null, "11. \" + tam.getName()\r\n"
					+ "					+ \"is willing to dye its hair / Please enter the name of the color you want it :",
					"Tamagochi",
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"), null,"");
			tam.setHairColor(dyeingColor);
			break;

		// PUT MASK ON / OFF
		case 12:
			boolean mask = tam.isMask() ? false : true;
			JOptionPane.showMessageDialog(null,
					"12. " + tam.getName() + "is putting is mask " + (mask ? "on \n" : "off \n"), "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			tam.setMask(mask);
			break;

		// WRONG ENTRY
		default:
			JOptionPane.showMessageDialog(null, "I didn't understant... Try again...", "Tamagochi",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
			break;
		}

		// end of command
		JOptionPane.showMessageDialog(null, "Please, press any key to continue.", "Tamagochi",
				JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/tamagochi.jpg"));
	}

	public static void popUpImage(String type) {

		JFrame f = new JFrame(); // creates jframe f
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // this is your screen size
		f.setBackground(Color.red);
		f.setUndecorated(true); // removes the surrounding border

		ImageIcon image = new ImageIcon("C:/Users/ELO.MOREAU/Documents/git/Tamagochi/" + type + ".jpg"); // imports the
																											// image

		JLabel lbl = new JLabel(image); // puts the image into a jlabel

		f.getContentPane().add(lbl); // puts label inside the jframe

		f.setSize(image.getIconWidth(), image.getIconHeight()); // gets h and w of image and sets jframe to the size

		int x = (screenSize.width - f.getSize().width) / 2; // These two lines are the dimensions
		int y = (screenSize.height / 2 - f.getSize().height) / 2;// of the center of the screen

		f.setLocation(x, y); // sets the location of the jframe
		f.setVisible(true); // makes the jframe visible

	}

}
