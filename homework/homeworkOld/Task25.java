import java.util.Scanner;

public class Task25 {
	
	public static int isVowel(char ch) {
		String vowels = "aeiouyAEIOUY";
		int len = vowels.length();
		
		for (int i = 0; i < len; i ++) {
			if (vowels.charAt(i) == ch) {
				return 1;
			}
		}
		return 0;
	}

	public static void main (String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the line");
		String line = sc.nextLine();
		
		int vowelsCount = 0;
		int len = line.length();
		int i = 0;
		while (i < len & vowelsCount < 4) {
			vowelsCount += isVowel(line.charAt(i));
			//System.out.println("" + line.charAt(i) + vowelsCount);
			i++;
		}
		
		if (vowelsCount == 3) {
			System.out.println("3 vowels");
		} else {
			System.out.println("not 3 vowels");
		}
		
	}

}