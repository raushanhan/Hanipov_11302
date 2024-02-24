import java.util.Scanner;

public class Task27 {
	
	public static int[][] readArray(Scanner sc, int n, int m) {
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.println("Enter [" + i + ", " + j + "] elem");
				arr[i][j] = sc.nextInt();
			}
		}
		
		return arr;
	}
	
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter how many strings");
		int n = sc.nextInt();
		
		System.out.println("Enter how many columns");
		int m = sc.nextInt();
		
		int[][] arr = readArray(sc, n, m);
		
		int i = 0;
		boolean lineAllDiv3 = false;
		while (i < n & !lineAllDiv3) {
			int j = 0;
			boolean allDiv3 = true;
			while (j < m & allDiv3) {
				allDiv3 = arr[i][j] % 3 == 0;
				j++;
			}
			lineAllDiv3 = allDiv3;
			i++;
		}
		
		
		System.out.println(lineAllDiv3);
	}
}