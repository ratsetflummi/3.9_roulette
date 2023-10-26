package simon_Hermann_3393936_Abgabe_3_9;

import java.util.Scanner;

public class Roulette {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		//starts the game
		//game is largely handled by dealer
		dealer.play();
		System.out.println("You're out of money.");
		//trying to close the scanner in the getInput method permanently disables it, so it gets to stay open the entire time
		sc.close();
	}

	//handles wager input for the dealer class and tip input for the tip class
	//all inputs are read as strings and converted where necessary
	public static String getInput(String text) {
		boolean invalidInput = true;
		String input = "";
		while (invalidInput) {
			System.out.println(text);
			//try catch is technically not necessary here, but probably doesn't hurt to have anyway
			try {
				input = sc.next();
				invalidInput = false;
			} catch (Exception e) {
				invalidInput = true;
			}
		}
		return input;
	}


}