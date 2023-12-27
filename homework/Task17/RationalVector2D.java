public class RationalVector2D {
	
	private RationalFraction x;
	private RationalFraction y;

	public RationalVector2D() {
		this(new RationalFraction(), new RationalFraction());
	}
	
	public RationalVector2D(RationalFraction x, RationalFraction y) {
		this.x = x;
		this.y = y;
	}
	
	public RationalVector2D add(RationalVector2D v) {
		return new RationalVector2D(x.add(v.x), y.add(v.y));
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public double length() {
		return Math.sqrt(scalarProduct(this).value());
	}
	
	public RationalFraction scalarProduct(RationalVector2D v) {
		return x.mult(v.x).add(y.mult(v.y));
	}
	
	public boolean equals(RationalVector2D v) {
		return x.equals(v.x) & y.equals(v.y);
	}
	
	public RationalFraction getX() {
		return x;
	}
	
	public RationalFraction getY() {
		return y;
	}
}