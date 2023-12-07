import java.util.Scanner;

public class Task2 {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		try {
			RationalFraction a = new RationalFraction(n1, n2);
			System.out.println(a);
		} catch (ZeroDenomException e) {
			System.out.println("Denominator must not be zero");
		}
		
		
	}
	
}