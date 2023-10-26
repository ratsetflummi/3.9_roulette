package simon_Hermann_3393936_Abgabe_3_9;

public class Dealer {
	static Wheel wheel;
	static Wager wager;
	static Tip tip;
	static Capital capital;
	static int winnings;

	public Dealer() {
		Wheel wheel = new Wheel();
		Wager wager = new Wager();
		Tip tip = new Tip();
		Capital capital = new Capital();
		int winnings = 0;
	}

	public static void play() {
		int roundCount = 1;
		//repeats the game loop until the player is out of money
		while (capital.amount > 0) {
			System.out.println("Round " + roundCount + "\n");
			roundCount += 1;
			reset();
			getWager();
			tip.getTip();
			wheel.spin();
			match();
		}
	}

	//deletes old player inputs and previous wheel spin
	public static void reset() {
		winnings = 0;
		wheel.reset();
		tip.reset();
	}

	//deals with the player's wager
	public static void getWager() {
		//tells player how much money they have left
		System.out.println("Capital: " + capital.amount + "\n");
		wager.amount = capitalCheck("Input wager:");
		//subtracts the amount of money the player bets from the player's capital
		capital.decrease(wager.amount);
	}

	//asks the player how much money they want to wager and checks whether the answer is valid
	public static int capitalCheck(String text) {
		boolean invalidInput = true;
		int input = 0;
		//repeats until the player gives a valid answer between 0 and all their money
		while ((input <= 0 || input > capital.amount) || invalidInput) {
			//tries to convert the input into an integer
			try {
				input = Integer.parseInt(Roulette.getInput(text));
				invalidInput = false;
			} catch (Exception e) {
				invalidInput = true;
			}
			//error message
			if (input > capital.amount || input <= 0) {
				text = "\nInput an integer between 0 and your capital.";
			}
		}
		return input;
	}

	//calculates how much money will be added to the player's capital if they win
	public static void getWinnings() {
		if (tip.tipType == TipType.COLOR) {
			winnings = wager.amount * wager.colorModifier;
		} else {
			winnings = wager.amount * wager.numberModifier;
		}
	}

	//compares the player's tip to the rolled result
	public static void match() {
		if (tip.tipType == TipType.COLOR) {
			//reads back what color the player bet on
			System.out.println("\n\nYou bet on the color " + tip.color.toString().toLowerCase() + ".");
			if (tip.color == wheel.color) {
				win();
				return;
			}
		} else if (tip.tipType == TipType.NUMBER) {
			//reads back what number the player bet on
			System.out.println("\n\nYou bet on the number " + tip.number + ".");
			if ((tip.number == wheel.number)) {
				win();
				return;
			}
		}
		lose();
	}

	//tells the player what the rolled result was and how much money they won, and adds the winnings to their capital
	public static void win() {
		getWinnings();
		capital.increase(winnings);
		System.out.println("\nThe result was a " + wheel.color.toString().toLowerCase() + " " + wheel.number + ".\n\n");
		System.out.println("You win " + winnings + " Euros.\n");
	}

	//tells the player what the rolled result was and how much money they lost
	public static void lose() {
		System.out.println("\nThe result was a " + wheel.color.toString().toLowerCase() + " " + wheel.number + ".\n");
		System.out.println("You lose " + wager.amount + " Euros.\n\n");
	}
}
