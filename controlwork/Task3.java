// variant 2
import java.util.Scanner;

public class Task3 {
	
	public static boolean containsElem(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public static int howMuch(int[] arr, int[] arr2, int num) {
		int res = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (arr[i] == num) {
				res++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter n");
		int n = sc.nextInt();
		
		int[] numbers = new int[n*n];
		int[] numInside = new int[n*n];
		
		int c = 0;
		int c1 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("enter [" + i + "][" + j + "] elem");
				numbers[c] = sc.nextInt();
				c++;
				if (!containsElem(numInside, numbers[c])) {
					numInside[c1] = numbers[c];
					c1++;
				}
			}
		}
		
		
	}
}