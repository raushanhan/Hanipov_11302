import java.util.Scanner;

public class Task08 {
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the line");
		String line = scn.nextLine();
		
		int openedBracketsCount = 0;
		int i = 0;
		
		while (i < line.length() & openedBracketsCount >= 0) {
			char s = line.charAt(i);
			if (s == '(') {
				openedBracketsCount++;
			} else if (s == ')') {
				openedBracketsCount--;
			}
			
			i++;
		}
		
		if (openedBracketsCount == 0) {
			System.out.println("Good");
		} else {
			System.out.println("Bad");
		}
	}
}