package simon_Hermann_3393936_Abgabe_3_9;

import java.util.Scanner;

public class Roulette {

	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		dealer.play();
		System.out.println("You're out of money.");
	}

	public static int getInput(String text) {
		Scanner sc = new Scanner(System.in);
		System.out.println(text);
		int input = sc.nextInt();
		return input;
	}

	public static int oneCheck(String text) {
		int input = 3;
		while (input != 1 && input != 0) {
			input = Roulette.getInput(text);
			if (input != 1 && input != 0) {
				System.out.println("Type either 1 or 2.");
			}
		}
		return input;
	}

}