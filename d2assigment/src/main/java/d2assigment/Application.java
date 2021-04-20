package d2assigment;

public class Application {

	public static void main(String[] args) {
		System.out.println(printNumberInWord(3));
		
		System.out.println(reverse("bigpapa"));

	}
	
	public static String printNumberInWord(int number) {
		if (number == 0) {
			return "ZERO";
		}
		else if (number == 1) {
			return "ONE";
		}
		else if (number == 2) {
			return "TWO";
		}
		else if (number == 3) {
			return "THREE";
		}
		else if (number == 4) {
			return "FOUR";
		}
		else if (number == 5) {
			return "FIVE";
		}
		else if (number == 6) {
			return "SIX";
		}
		else if (number == 7) {
			return "SEVEN";
		}
		else if (number == 8) {
			return "EIGHT";
		}
		else if (number == 9) {
			return "NINE";
		}
		return null;
	}
	
	public static String reverse(String string) {
		char [] str = string.toCharArray();
		String reverse = "";
		for (int i= string.length() -1 ; 0 <= i; i--) {
			reverse += str[i];
		}
		return reverse;
		
	}

}
