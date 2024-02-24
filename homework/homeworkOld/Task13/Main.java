public class Main {
	
	public static void main(String[] args) {
		
		ComplexNumber num1 = new ComplexNumber(-2, 1);
		
		ComplexNumber num2 = new ComplexNumber(1, -1);
		
		ComplexNumber num3 = num1.div(num2);
		
		num1.div2(num2);
		
		System.out.println(num1 + " \\\\ " + num3);
		
		ComplexNumber num4 = new ComplexNumber(0.5, Math.pow(3, 0.5) / 2);
		
		ComplexNumber num5 = num4.pow(20);
		
		System.out.println(num4 + "      " + num5);
		
		ComplexNumber num6 = new ComplexNumber(1, 2);
		ComplexNumber num7 = new ComplexNumber(1, 2);
		System.out.println(num6.equals(num7));
	}
}