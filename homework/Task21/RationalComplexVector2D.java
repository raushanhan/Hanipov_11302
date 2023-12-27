public class RationalComplexVector2D {
	
	private RationalComplexNumber x;
	private RationalComplexNumber y;

	public RationalComplexVector2D() {
		this(new RationalComplexNumber(), new RationalComplexNumber());
	}
	
	public RationalComplexVector2D(RationalComplexNumber x, RationalComplexNumber y) {
		this.x = x;
		this.y = y;
	}
	
	public RationalComplexVector2D add(RationalComplexVector2D v) {
		return new RationalComplexVector2D(x.add(v.x), y.add(v.y));
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public RationalComplexNumber scalarProduct(RationalComplexVector2D v) {
		return x.mult(v.x).add(y.mult(v.y));
	}
	
	public RationalComplexNumber getX() {
		return x;
	}
	
	public RationalComplexNumber getY() {
		return y;
	}
}