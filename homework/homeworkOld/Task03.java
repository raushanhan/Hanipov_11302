public class Task03 {
	
	public static void main (String [] args) {
		
		final double EPS = 1e-9;
		
		double x = Math.PI / 2;
		
		double s = 0;
		long fact = 1;
		long k = 1;
		int sign = 1;
		double deg = x;
		double a = sign * deg / fact;
		
		while (Math.abs(a) > EPS) {
			s += a;
			k += 1;
			fact *= (2 * k - 1) * (2 * k - 2);
			deg *= x * x;
			sign = -sign;
			a = sign * deg / fact;
			//System.out.println("elem a: " + a);
		}
		
		System.out.println("sin pi/2 = " + s);
	}
}