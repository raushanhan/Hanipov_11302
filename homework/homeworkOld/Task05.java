public class Task05 {

	public static void main(String [] args) {
		
		int k = 1;
		double x = Double.parseDouble(args[0]);
		
		final double EPS = 1e-9;
		double s = 0;
		double deg = x;
		int sign = 1;
		double a = deg / k;
		
		while (Math.abs(a) > EPS) {
			s += a;
			k += 1;
			deg *= x;
			sign = -sign;
			a = sign * deg / k;
			//System.out.println(a);
		}
		System.out.println("ln(" + (1 + x) + ") = " + s);
	}
}