package simon_Hermann_3393936_Abgabe_3_9;

public class Wheel {
	static int number = 37;
	static Color color = null;
	static int[] redNumbers = { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };
	static int[] blackNumbers = { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 };

	//resets color, and sets number to a value that can't be rolled for testing purposes
	public static void reset() {
		number = 37;
		color = null;
	}
	
	//rolls a random number between 0 and 36
	//stores color for comparing with the player's tip later
	public static void spin() {
		number = (int) (Math.random() * 36);
		color = getColor();
	}

	//checks whether the rolled number is red, black, or 0 (green)
	public static Color getColor() {
		if (number == 0) {
			return Color.GREEN;
		} else {
			for (int current : redNumbers) {
				if (current == number) {
					return Color.RED;
				}
			}
			return Color.BLACK;
		}
	}
}
