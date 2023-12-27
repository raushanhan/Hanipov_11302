public class RationalFraction {
	
	private int a;
	private int b;
	
	public static int euclid(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		while (a != 0 & b != 0) {
			if (a > b) {
				a = a % b;
			} else {
				b = b % a;
			}
		}
		return a + b;
	}
	
	public RationalFraction() {
		this(0, 1);
	}
	
	public RationalFraction(int a, int b) {
		if (b < 0) {
			a = -a;
			b = -b;
		}
		if (a == 0) {
			b = 1;
		}
		if (a == b) {
			a = 1;
			b = 1;
		}
		this.a = a;
		this.b = b;
	}
	
	public void reduce() {
		int gcd = euclid(a, b);
		while (gcd != 1) {
			a /= gcd;
			b /= gcd;
			gcd = euclid(a, b);
		}
	}
	
	public RationalFraction add(RationalFraction fraction) {
		
		int b1 = b;
		int b2 = fraction.b;
		
		int gcd = euclid(b1, b2);
		int multiply2 = b1 / gcd;
		int multiply1 = b2 / gcd;
		
		int a1 = a * multiply1;
		int a2 = fraction.a * multiply2;
		
		RationalFraction summedF = new RationalFraction(a1 + a2, b1 * multiply1);
		summedF.reduce();
		return summedF;
	}
	
	public void add2(RationalFraction fraction) {
		RationalFraction summedF = this.add(fraction);
		a = summedF.a;
		b = summedF.b;
	}
	
	public RationalFraction sub(RationalFraction fraction) {
		return this.add(new RationalFraction(-fraction.a, fraction.b));
	}
	
	public void sub2(RationalFraction fraction) {
		this.add2(new RationalFraction(-fraction.a, fraction.b));
	}
	
	public RationalFraction mult(RationalFraction fraction) {
		RationalFraction multipliedF = new RationalFraction(a * fraction.a, b * fraction.b);
		multipliedF.reduce();
		return multipliedF;
	}
	
	public void mult2(RationalFraction fraction) {
		RationalFraction multipliedF = this.mult(fraction);
		a = multipliedF.a;
		b = multipliedF.b;
	}
	
	public RationalFraction div(RationalFraction fraction) {
		return this.mult(new RationalFraction(fraction.b, fraction.a));
	}
	
	public void div2(RationalFraction fraction) {
		this.mult2(new RationalFraction(fraction.b, fraction.a));
	}
	
	public double value() {
		return (double) a / b;
	}
	
	public boolean equals(RationalFraction f) {
		RationalFraction origFraction = new RationalFraction(a, b);
		origFraction.reduce();
		RationalFraction secondFraction = new RationalFraction(f.a, f.b);
		secondFraction.reduce();
		if (origFraction.a == secondFraction.a & origFraction.b == secondFraction.b) {
			return true;
		} else {
			return false;
		}
	}
	
	public int numberPart() {
		return a / b;
	}
		
	public String toString() {
		if (a == 0) {
			return "0";
		} else if (a == b) {
			return "1";
		}
		return a + "/" + b;
	}

}