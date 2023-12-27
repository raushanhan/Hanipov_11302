public class ComplexVector2D {
	
	private ComplexNumber x;
	private ComplexNumber y;
	
	public ComplexVector2D() {
		this(new ComplexNumber(), new ComplexNumber());
	}
	
	public ComplexVector2D(ComplexNumber x, ComplexNumber y) {
		this.x = x;
		this.y = y;
	}
	
	public ComplexVector2D add(ComplexVector2D v) {
		return new ComplexVector2D(x.add(v.x), y.add(v.y));
	}
	
	public ComplexNumber scalarProduct(ComplexVector2D v) {
		return x.mult(v.x).add(y.mult(v.y));
	}
	
	public boolean equals(ComplexVector2D v) {
		return x.equals(v.x) & y.equals(v.y);
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public ComplexNumber getX() {
		return x;
	}
	
	public ComplexNumber getY() {
		return y;
	}
}