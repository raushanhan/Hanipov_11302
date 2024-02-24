public class Task04 {
	
	public static void main (String [] args) {
		
		final double EPS = 1e-8;
		
		double x = Math.PI;
		
		double s = 0;
		long fact = 1;
		long k = 1;
		int sign = 1;
		double deg = 1;
		double a = sign * deg / fact;
		
		while (Math.abs(a) > EPS) {
			s += a;
			k += 1;
			fact *= (2 * k - 2) * (2 * k - 3);
			deg *= x * x;
			sign = -sign;
			a = sign * deg / fact;
			System.out.println("elem a: " + a);
		}
		
		System.out.println("cos pi = " + s);
	}
}