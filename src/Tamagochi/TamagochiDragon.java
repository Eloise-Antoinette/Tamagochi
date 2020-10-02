package Tamagochi;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		
		//Dragon's parameters initialisation
		this.health = 120;
		this.hunger = 10;
		this.lifeTime = 60;
		
		this.type = "dragon";
		this.high = 200;
	}
	

	

}
