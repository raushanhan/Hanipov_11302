public class Round  {
	
	private double x;
	private double y;
	private double r;
	
	/*public static void main(String[] args) {
		Round r1 = new Round(1, 2, 5);
		System.out.println("l = " + r1.length());
		System.out.println("s = " + r1.square());
		System.out.println("S = " + r1.sectorSquare(90));
		r1.changeSquare(50);
		System.out.println("sChanged 1 = " + r1.square());
		r1.changeSquare(-50);
		System.out.println("sChanged 2 = " + r1.square());
		
		r1 = new Round(1, 2, 5);
		Round r2 = new Round(1, -5, 5);
		System.out.println("1 " + r1.relation(r2)); // 
		Round r3 = new Round(1, 2, 5);
		System.out.println("2 " + r1.relation(r3)); // совпадают
		Round r4 = new Round(1, 2, 4);
		System.out.println("3 " + r1.relation(r4)); // 
		Round r5 = new Round(2, 2, 4);
		System.out.println("4 " + r1.relation(r5)); // касаются
		Round r6 = new Round(1, 2, 7);
		System.out.println("5 " + r1.relation(r6)); // не пересекаются внутри
		Round r7 = new Round(2, 3, 5);
		System.out.println("6 " + r1.relation(r7)); // пересекаются
		
		System.out.println(r1);
		//Round r = new Round(, , );
		//r1.relation(r);
	}*/
	
	public Round(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public double length() {
		return 2 * Math.PI * r;
	}
	
	public double square() {
		return Math.PI * r * r;
	}
	
	public void changeSquare(double p) {
		r = r * Math.pow((1 + p / 100), 0.5);
	}
	
	public double sectorSquare(double a) {
		double k = a / 360;
		return this.square() * k;
	}
	
	public boolean equals(Round other) {
		if (Math.abs(r - other.r) < 1e-9) {
			return true;
		}
		return false;
	}
	
	public static double max(double a, double b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
	
	public static double min(double a, double b) {
		if (a > b) {
			return b;
		} else {
			return a;
		}
	}
	
	public double lengthBetween(Round other) {
		return Math.pow(((y - other.y)*(y - other.y) + 
							(x - other.x)*(x - other.x)), 0.5);
	}
	
	public int relation(Round other) {
		double rA = max(r, other.r);
		double rB = min(r, other.r);
		double length = lengthBetween(other);
		
		if (x == other.x & y == other.y & equals(other)) { // совпадают
			return 0;
		} else if (Math.abs(length + rB - rA) < 1e-9) { // касание внутри
			return -2;
		} else if (Math.abs(rB + rA - length) < 1e-9) { // касание снаружи
			return 1;
		} else if (length + rB < rA) { // не перескается, внутри
			return 3;
		} else if (rB + rA > length) { // пересекаются
			return -1;
		} else if (rB + rA < length) { // не пересекается, не находится внутри
			return 2;
		}
		return -100; // если что-то не так
	}
	
	public String toString() {
		return "round on x0 = " + x + " and y0 = " + y + " with radius = " + r;
	}
}