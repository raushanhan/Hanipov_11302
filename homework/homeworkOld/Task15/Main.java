public class Main {
	
	public static void main(String[] args) {
		
		RationalFraction a = new RationalFraction(1, 2);
		
		RationalFraction b = new RationalFraction(1, 2);
		
		RationalVector2D v = new RationalVector2D(a, b);
		
		System.out.println(v);
	}
}