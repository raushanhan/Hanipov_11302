public class Main {
	
	public static void main(String[] args) {
		
		Matrix2x2 m1 = new Matrix2x2(1, 2, 2, 1);
		
		Matrix2x2 m2 = new Matrix2x2(1, 2, 2, 1);
		
		System.out.println(m1.mult(m2));
		
		System.out.println(m1.add(m2));
		
		System.out.println(m1.sub(m2));
		
		System.out.println(m1.multNumber(5));
		
		System.out.println(m1.det());
		
		System.out.println(m1.inverseMatrix());
		
		System.out.println(m1.equivalentDiagonal());
		
		Vector2D v = new Vector2D(1, 2);
		System.out.println(m1.multVector(v));
	}
}