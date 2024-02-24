public class Main {
	
	public static void main(String[] args) {
		
		ComplexNumber a = new ComplexNumber(1, 2);
		
		ComplexNumber b = new ComplexNumber(1, 2);
		
		ComplexVector2D v = new ComplexVector2D(a, b);
		
		System.out.println(v);
	}
}