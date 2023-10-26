package simon_Hermann_3393936_Abgabe_3_9;

public class Dealer {
	static Wheel wheel;
	static Wager wager;
	static Tip tip;
	static Capital capital;
	static int winnings;
	static boolean colorTip;
	static boolean numberTip;
	static String color;

	public Dealer() {
		Wheel wheel = new Wheel();
		Wager wager = new Wager();
		Tip tip = new Tip();
		Capital capital = new Capital();
		int winnings = 0;
	}

	public static void play() {
		while (capital.amount > 0) {
			reset();
			getWager();
			getTip();
			spin();
			match();
		}
	}

	public static void reset() {
		colorTip = false;
		numberTip = false;
		winnings = 0;
		wheel.reset();
		tip.reset();
	}

	public static void spin() {
		color = wheel.spin();
	}

	public static void getWager() {
		System.out.println("Capital: " + capital.amount);
		wager.amount = capitalCheck("Wager:");
		capital.decrease(wager.amount);
	}

	public static int capitalCheck(String text) {
		int input = -1;
		while (input < 0 || input > capital.amount) {
			input = Roulette.getInput(text);
			if (input != 1 && input != 0) {
				System.out.println("Input an integer between 0 and your capital.");
			}
		}
		return input;
	}

	public static void getTip() {
		int input = Roulette.oneCheck("Colour(0) or Number(1)?");
		if (input == 0) {
			colorTip = true;
			tip.getColor();
		} else if (input == 1) {
			numberTip = true;
			tip.getNumber();
		}
	}

	public static void getWinnings() {
		if (colorTip) {
			winnings = wager.amount * wager.colorModifier;
		} else {
			winnings = wager.amount * wager.numberModifier;
		}
	}

	public static void match() {
		if (colorTip) {
			if ((tip.isRed && wheel.isRed) || (tip.isBlack && wheel.isBlack)) {
				win();
				return;
			}
		} else if (numberTip) {
			if ((tip.number == wheel.number)) {
				win();
				return;
			}
		}
		lose();
	}

	public static void win() {
		getWinnings();
		capital.increase(winnings);
		System.out.println("The result was a " + color + " " + wheel.number + ".\n");
		System.out.println("You win " + winnings + " Euros.\n");
	}

	public static void lose() {
		System.out.println("The result was a " + color + " " + wheel.number + ".\n");
		System.out.println("You lose " + wager.amount + " Euros.\n");
	}
}
