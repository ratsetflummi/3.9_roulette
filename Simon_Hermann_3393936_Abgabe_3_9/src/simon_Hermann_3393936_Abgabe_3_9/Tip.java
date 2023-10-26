package simon_Hermann_3393936_Abgabe_3_9;

public class Tip {
	static boolean isRed;
	static boolean isBlack;
	static int number;

	public static void reset() {
		isRed = false;
		isBlack = false;
		number = 38;
	}

	public static void getColor() {
		int input = Roulette.oneCheck("Red(0) or Black(1)?");
		if (input == 0) {
			isRed = true;
			return;
		} else if (input == 1) {
			isBlack = true;
			return;
		}
	}

	public static void getNumber() {
		number = Roulette.getInput("Which Number?");
	}

	public static int numberCheck(String text) {
		int input = -1;
		while (input < 0 || input > 36) {
			input = Roulette.getInput(text);
			if (input != 1 && input != 0) {
				System.out.println("Input an integer between 0 and 36.");
			}
		}
		return input;
	}
}
