import java.util.Scanner;

public class Task28 {
	
	public static String[][] readArray(Scanner sc, int n, int m) {
		String[][] arr = new String[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.println("Enter [" + i + ", " + j + "] elem");
				arr[i][j] = sc.nextLine();
			}
		}
		
		return arr;
	}
	
	public static boolean isVowel(char ch) {
		String vowels = "aeiouyAEIOUY";
		int len = vowels.length();
		
		for (int i = 0; i < len; i ++) {
			if (vowels.charAt(i) == ch) {
				return true;
			}
		}
		return false;
	}
	
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter how many strings");
		int n = sc.nextInt();
		
		System.out.println("Enter how many columns");
		int m = sc.nextInt();
		sc.nextLine();
		
		String[][] arr = readArray(sc, n, m);
		
		int i = 0;
		boolean allColsVowLine = true;
		while (i < n & allColsVowLine) {
			allColsVowLine = false;
			int j = 0;
			while (j < m & !allColsVowLine) {
				allColsVowLine = isVowel(arr[j][i].charAt(0));
				j++;
			}
			i++;
		}
		
		System.out.println(allColsVowLine);
	}
	
}