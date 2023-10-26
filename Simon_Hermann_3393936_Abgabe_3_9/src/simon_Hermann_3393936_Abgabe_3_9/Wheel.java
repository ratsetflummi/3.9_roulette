package simon_Hermann_3393936_Abgabe_3_9;

public class Wheel {
	static int number = 37;
	static boolean isRed = false;
	static boolean isBlack = false;
	static int[] redNumbers = { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };
	static int[] blackNumbers = { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 };

	public static void reset() {
		number = 37;
		isRed = false;
		isBlack = false;
	}

	public static String spin() {
		number = (int) (Math.random() * 36);
		return getColor();
	}

	public static String getColor() {
		if (number == 0) {
			isRed = false;
			isBlack = false;
			return "green";
		} else {
			for (int current : redNumbers) {
				if (current == number) {
					isRed = true;
					return "red";
				}
			}
			isBlack = true;
			return "black";
		}
	}
}
