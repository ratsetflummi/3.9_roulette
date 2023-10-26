package simon_Hermann_3393936_Abgabe_3_9;

public class Tip {
	static Color color = null;
	static int number;
	static TipType tipType;

	//resets tipType and color, and sets number to a value that can't be rolled for testing purposes
	public static void reset() {
		tipType = null;
		color = null;
		number = 38;
	}

	//asks whether the player wants to bet on a number or a color
	public static void getTip() {
		boolean invalidInput = true;
		String text = "\nColour or Number?";
		//keeps asking for input until valid input is given
		while (invalidInput) {
			String input = Roulette.getInput(text);
			//accepts various spellings of the words "color" and "number"
			if (input.toLowerCase().equals("color") || input.toLowerCase().equals("colour")
					|| input.toLowerCase().equals("col") || input.toLowerCase().equals("c")) {
				//stops the while loop once a valid answer is given
				invalidInput = false;
				tipType = TipType.COLOR;
				getColor();
			//accepts various spellings of the words "color" and "number"
			} else if (input.toLowerCase().equals("number") || input.toLowerCase().equals("num")
					|| input.toLowerCase().equals("n")) {
				//stops the while loop once a valid answer is given
				invalidInput = false;
				tipType = TipType.NUMBER;
				getNumber();
			}
			//error message
			if (invalidInput) {
				text = "\nType \"color\" or \"number\".";
			}
		}
	}

	//asks whether the player wants to bet on red or black
	public static void getColor() {
		boolean invalidInput = true;
		String text = "\nRed or Black?";
		//repeats until the player gives a valid answer
		while (invalidInput) {
			String input = Roulette.getInput(text);
			if (input.toLowerCase().equals("red") || input.toLowerCase().equals("r")) {
				color = Color.RED;
				invalidInput = false;
			} else if (input.toLowerCase().equals("black") || input.toLowerCase().equals("b")) {
				color = Color.BLACK;
				invalidInput = false;
			}
			//error message
			if (invalidInput) {
				text = "\nType \"red\" or \"black\".";
			}
		}
	}

	//asks which number the player wants to bet on
	public static void getNumber() {
		boolean invalidInput = true;
		String text = "\nWhich Number?";
		//repeats until player inputs a valid integer between 0 and 36
		while ((number < 0 || number > 36) || invalidInput) {
			//tries to convert the input string into an integer
			try {
				number = Integer.parseInt(Roulette.getInput(text));
				//stops while loop when the player inputs an integer
				invalidInput = false;
			} catch (Exception e) {
				invalidInput = true;
			}
			
			if (number < 0 || number > 36) {
				text = "\nInput an integer between 0 and 36.";
			}
		}
	}

}
