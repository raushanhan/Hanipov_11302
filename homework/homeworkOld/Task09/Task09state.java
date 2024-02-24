import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task09state {
	
	public static boolean okVariable (int state, char sym) {
		if (state == 0) {
			return ('a' <= sym & sym <= 'z' | 'A' <= sym & sym <= 'Z' | sym == '_');
			
		} else if (state == 1) {
			return ('a' <= sym & sym <= 'z' | 'A' <= sym & sym <= 'Z' | sym == '_' |
			'0' <= sym & sym <= '9');
			
		}
		return false;
	}
	
	public static boolean okOperation(char sym) {
		return (sym == '+' |
				sym == '-' |
				sym == '/' |
				sym == '*' );
	}
	
	public static boolean okNum (char sym) {
		return '0' <= sym & sym <= '9';
	}
	
	public static void main (String [] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the expression you want to check");
		String line = scn.nextLine();
		
		int i = 0;
		int s = 0;
		
		while (s != 9 & i < line.length()) {
			char sym = line.charAt(i);
			if (s == 0) {
				if (okVariable(0, sym)) {
					s = 1;
				} else {
					s = 9;
				}
			} else if (s == 1) {
				if (okVariable(1, sym)) {
					s = 1;
				} else if (sym == ' ') {
					s = 10;
				} else {
					s = 9;
				}
			} else if (s == 10) {
				if (sym == ' ') {
					s = 10;
				} else if (sym == '=') {
					s = 2;
				} else {
					s = 9;
				}
			} else if (s == 2) {
				if (sym == ' ') {
					s = 2;
				} else if (okNum(sym)) {
					s = 3;
				} else if (okVariable(0, sym)) {
					s = 4;
				} else {
					s = 9;
				}
			} else if (s == 3) {
				if (okNum(sym)) {
					s = 3;
				} else if (sym == ' ') {
					s = 12;
				} else {
					s = 9;
				}
			} else if (s == 4) {
				if (okVariable(1, sym)) {
					s = 4;
				} else if (sym == ' ') {
					s = 12;
				} else {
					s = 9;
				}
			} else if (s == 12) {
				if (sym == ' ') {
					s = 12;					
				} else if (okOperation(sym)) {
					s = 5;
				}
			} else if (s == 5) {
				if (sym == ' ') {
					s = 5;
				} else if (okVariable(0, sym)) {
					s = 7;
				} else if (okNum(sym)) {
					s = 6;
				} else {
					s = 9;
				}
			} else if (s == 6) {
				if (okNum(sym)) {
					s = 6;
				} else {
					s = 9;
				}
			} else if (s == 7) {
				if (okVariable(1, sym)) {
					s = 7;
				} else {
					s = 9;
				}
			}
			i++;
		}
		
		if (s == 9) {
			System.out.println("The expression is bad");
		} else {
			System.out.println("The expression is ok");
		}
	}
}