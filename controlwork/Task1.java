// task1 variant 1

import java.util.Scanner;

public class Task1 {
	
	public static String strReverse(String str) {
		String result = "";
		
		for (int i = str.length() - 1; i > -1; i--) {
			result += str.charAt(i);
		}
		return result;
	}
	
	public static boolean isPalindrome(String str) {
		String rev = strReverse(str);
		
		int n = str.length() / 2;
		if (str.length() % 2 != 0) {
			n++;
		}
		
		boolean pal = true;
		
		int i = 0;
		while (i < n & pal) {
			pal = str.charAt(i) == rev.charAt(i);
			i++;
		}
		
		return pal;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the array length");
		int n = sc.nextInt();
		sc.nextLine();
		
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			System.out.println("enter " + (i + 1) + " elem of array");
			arr[i] = sc.nextLine();
		}
		
		int palCount = 0;
		
		int i = 0;
		while (i < n & palCount < 3) {
			if (isPalindrome(arr[i])) {
				palCount++;
			}
			i++;
		}
		
		if (palCount == 2) {
			System.out.println("Good");
		} else {
			System.out.println("the amount of palindromes is not equal to 2");
		}
		
	}
	
}