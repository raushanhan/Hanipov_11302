import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task07reg {
	
	public static void main (String [] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the line you want to check");
		String line = scn.nextLine();
		
		Pattern reg = Pattern.compile("[A-Za-z_][A-Za-z_0-9]+");
		Matcher mtc = reg.matcher(line);
		
		if (mtc.matches()) {
			System.out.println("The line is a good name");
		} else {
			System.out.println("That's sort of a bad name :(");
		}
	}
}