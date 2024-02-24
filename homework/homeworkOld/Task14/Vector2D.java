public class Vector2D {

	private double x;
	private double y;
	
	private static boolean compare(double num1, double num2) {
		return (Math.abs(num1 - num2) < 1e-9);
	}
	
	public Vector2D() {
		this(0, 0);
	}
	
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2D add(Vector2D vector) {
		return new Vector2D(x + vector.x, y + vector.y);
	}
	
	public void add2(Vector2D vector) {
		x += vector.x;
		y += vector.y;
	}
	
	public Vector2D sub(Vector2D vector) {
		return new Vector2D(x - vector.x, y - vector.y);
	}
	
	public void sub2(Vector2D vector) {
		x -= vector.x;
		y -= vector.y;
	}
	
	public Vector2D mult(double num) {
		return new Vector2D(x * num, y * num);
	}
	
	public void mult2(double num) {
		x *= num;
		y *= num;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public double length() {
		return Math.sqrt(x*x + y*y);
	}
	
	public double scalarProduct(Vector2D vector) {
		return x * vector.x + y * vector.y;
	}
	
	public double cos(Vector2D vector) {
		return scalarProduct(vector) / (this.length() * vector.length());
	}
	
	public boolean equals(Vector2D vector) {
		return compare(x, vector.x) & compare(y, vector.y);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

}

