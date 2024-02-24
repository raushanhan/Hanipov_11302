import java.util.Scanner;

public class Task07state {
	
	public static boolean isOk (int state, char sym) {
		if (state == 0) {
			return ('a' <= sym & sym <= 'z' | 'A' <= sym & sym <= 'Z' | sym == '_');
			
		} else if (state == 1) {
			return ('a' <= sym & sym <= 'z' | 'A' <= sym & sym <= 'Z' | sym == '_' |
			'0' <= sym & sym <= '9');
			
		}
		return false;
	}
		
	public static void main (String [] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the line you want to check");
		String line = scn.nextLine();
		
		int len = line.length();
		int s = 0;
		int i = 0;
		
		while (s != 2 & i < len) {
			if (isOk(s, line.charAt(i))) {
				s = 1;
			} else {
				s = 2;
			}
			i++;
		}
		
		if (s == 1) {
			System.out.println("The name is good");
		} else {
			System.out.println("The name's bad");
		}
	}
}