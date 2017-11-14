import java.util.Scanner;
import java.util.Stack;
/***
 * Program to check if a given string is obtained by repeating any of its substring any number of times
 * without using substring method.
 * @author mathunika_r
 *
 */
public class SubStringChecker {

	public static void main(String[] args) {
		boolean finalResult = false;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		String subString = "";

		for (int i = 1; i < inputString.length(); i++) {
			if (scheckIfSubstirn(i, inputString)) {
				finalResult = true;
				count = i;
				for (int k = 0; k < i; k++) {
					subString = subString + inputString.charAt(k);
				}
				break;
			}

		}
		if(finalResult){
		System.out.println("Output : " +finalResult + " The string is " + subString
				+ " repeated " + count + " times.");
		}
		else{
			System.out.println("Output : " + finalResult);
		}

	}

	private static boolean scheckIfSubstirn(int SubStringLength,
			String inputString) {
		Stack<Character> inputStringStack = new Stack();
		boolean result = true;
		for (int i = 0; i < inputString.length(); i++) {
			inputStringStack.push(inputString.charAt(i));

		}
		String s1 = "";
		String s2 = "";
		for (int j = 0; j < inputString.length(); j = j + SubStringLength) {

			for (int k = 0; k < SubStringLength; k++) {
				if (!inputStringStack.isEmpty())
					s1 = s1 + inputStringStack.pop();
			}
			if (j == 0) {
				s2 = s1;
			}
			if (!s1.equals(s2)) {
				return false;
			}
			s2 = s1;
			s1 = "";
		}

		return result;
	}

}
