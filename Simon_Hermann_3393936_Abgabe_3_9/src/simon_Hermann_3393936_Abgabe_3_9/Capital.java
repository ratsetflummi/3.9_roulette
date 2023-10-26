package simon_Hermann_3393936_Abgabe_3_9;

public class Capital {
	//starting capital
	static int amount = 1000;

	//increases capital by the amount of money the player won
	public static void increase(int addition) {
		amount = amount + addition;
	}
	
	//decreases capital by the amount of money the player wagered
	public static void decrease(int subtraction) {
		amount = amount - subtraction;
	}
}
