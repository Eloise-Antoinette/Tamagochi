package Tamagochi;

public class Cat {

	private String name;
	private String color;
	private int age;
	
	public Cat(String name, String color, int age) {
		this.name = name;
		this.color = color;
		this.age = age;
	}

	public Cat(String color) {
		this.color = color;
	}

	public void show() {
		System.out.println("Cat named " + this.name + " of the color "+" of "+ this.age + " years old");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
