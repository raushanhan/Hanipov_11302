import java.util.Scanner;

public class Task24 {
	
	public static void main (String [] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("how many numbers do you want to enter");
		int n = sc.nextInt();
		int[] ar = new int[n];
		
		for (int i = 0; i < n; i ++) {
			System.out.println("enter the " + (i + 1) + " number");
			ar[i] = sc.nextInt();
		}
		
		int negNumsCount = 0;
		int i = 0;
		
		while (negNumsCount < 2 & i < n) {
			if (ar[i] < 0) {
				negNumsCount ++;
			}
			i ++;
		}
		
		if (negNumsCount >= 2) {
			System.out.println("the array contains 2 or more negative numbers");
		} else {
			System.out.println("the array contains less than 2 negative numbers");
		}
	}
}