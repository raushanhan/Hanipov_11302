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
	
	public RationalFraction() throws ZeroDenomException {
		this(0, 1);
	}
	
	public RationalFraction(int a, int b) throws ZeroDenomException {
		if (b == 0) 
			throw new ZeroDenomException();
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
	
	public RationalFraction add(RationalFraction fraction) throws ZeroDenomException {
		
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
	
	public void add2(RationalFraction fraction) throws ZeroDenomException {
		RationalFraction summedF = this.add(fraction);
		a = summedF.a;
		b = summedF.b;
	}
	
	public RationalFraction sub(RationalFraction fraction) throws ZeroDenomException {
		return this.add(new RationalFraction(-fraction.a, fraction.b));
	}
	
	public void sub2(RationalFraction fraction) throws ZeroDenomException {
		this.add2(new RationalFraction(-fraction.a, fraction.b));
	}
	
	public RationalFraction mult(RationalFraction fraction) throws ZeroDenomException {
		RationalFraction multipliedF = new RationalFraction(a * fraction.a, b * fraction.b);
		multipliedF.reduce();
		return multipliedF;
	}
	
	public void mult2(RationalFraction fraction) throws ZeroDenomException {
		RationalFraction multipliedF = this.mult(fraction);
		a = multipliedF.a;
		b = multipliedF.b;
	}
	
	public RationalFraction div(RationalFraction fraction) throws ZeroDenomException {
		return this.mult(new RationalFraction(fraction.b, fraction.a));
	}
	
	public void div2(RationalFraction fraction) throws ZeroDenomException {
		this.mult2(new RationalFraction(fraction.b, fraction.a));
	}
	
	public double value() {
		return (double) a / b;
	}
	
	public boolean equals(RationalFraction fraction) {
		RationalFraction origFraction = this;
		origFraction.reduce();
		fraction.reduce();
		if (origFraction.a == fraction.a & origFraction.b == fraction.b) {
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
		} else if (b == 1) {
			return a;
		}
		return a + "/" + b;
	}

}