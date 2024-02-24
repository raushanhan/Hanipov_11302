import java.util.Scanner;

public class Task26 {
	
	public static int getIntCapacity(int num) {
		int i = 1;
		while (num / i >= 10) {
			i *= 10;
		}
		return i;
	}
	
	public static boolean isEvenDigit(int n) {
		boolean hasEven = false;
		int i = getIntCapacity(n);
		
		while (!hasEven & i >= 1) {
			hasEven = ((n / i % 10) % 2 == 0);
			i /= 10;
		}
		
		return hasEven;
	}
	
	public static void main (String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("how many numbers do you want to enter");
		int n = sc.nextInt();
		int[] ar = new int[n];
		
		for (int i = 0; i < n; i ++) {
			System.out.println("enter the " + (i + 1) + " number");
			ar[i] = sc.nextInt();
		}
		
		int i = 0;
		boolean evenDigitNums = true;
		
		while (i < n & evenDigitNums) {
			if (ar[i] >= 0) {
				evenDigitNums = isEvenDigit(ar[i]);
			}
			i++;
		}
		
		if (evenDigitNums) {
			System.out.println("Good");
		} else {
			System.out.println("Bad");
		}
		
	}
	
}