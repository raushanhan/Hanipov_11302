import java.util.Scanner;

public class Task29 {
	
	private static Scanner sc = new Scanner(System.in);
	private static int n;
	private static int m;
	private static int[][] arr;
	
	public static void readArray() {
		System.out.println("Enter how many strings");
		n = sc.nextInt();
		
		System.out.println("Enter how many columns");
		m = sc.nextInt();
		
		arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.println("Enter [" + i + ", " + j + "] elem");
				arr[i][j] = sc.nextInt();
			}
		}
	}
	
	public static int getIntCapacity(int n) {
		int i = 1;
		while (n / i >= 10) {
			i *= 10;
		}
		return i;
	}
	
	public static boolean allDigitsEven(int n) {
		boolean allEven = true;
		int i = getIntCapacity(n);
		
		while (allEven & i >= 1) {
			allEven = ((n / i % 10) % 2 == 0);
			i /= 10;
		}
		
		return allEven;
	}
	
	public static void main (String [] args) {
		
		readArray();
		
		boolean everyLineHasEven = true;
		boolean lineHasEven;
		int i = 0;
		int j;
		while(i < n & everyLineHasEven) {
			j = 0;
			lineHasEven = false;
			while(j < m & !lineHasEven) {
				lineHasEven = allDigitsEven(arr[i][j]);
				j++;
			}
			everyLineHasEven = lineHasEven;
			i++;
		}
		
		if (everyLineHasEven) {
			System.out.println("good");
		} else {
			System.out.println("bad");
		}
		
	}

}