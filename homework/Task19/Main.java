public class Main {
	
	public static void main(String[] args) {
		
		RationalFraction a = new RationalFraction(1, 2);
		
		RationalFraction b = new RationalFraction(1, -2);
		
		RationalComplexNumber n = new RationalComplexNumber(a, b);
		
		System.out.println(n);
	}
}