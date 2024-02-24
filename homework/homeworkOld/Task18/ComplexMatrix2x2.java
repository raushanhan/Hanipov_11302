public class ComplexMatrix2x2 {
	
	private ComplexNumber[][] arr = new ComplexNumber[2][2];
	
	public ComplexMatrix2x2() {
		this(new ComplexNumber());
	}
	
	public ComplexMatrix2x2(ComplexNumber num) {
		this(num, num, num, num);
	}
	
	public ComplexMatrix2x2(ComplexNumber a, ComplexNumber b, ComplexNumber c, ComplexNumber d) {
		arr[0][0] = a;
		arr[0][1] = b;
		arr[1][0] = c;
		arr[1][1] = d;
	}
	
	
	public ComplexMatrix2x2 add(ComplexMatrix2x2 other) {
		ComplexMatrix2x2 result = new ComplexMatrix2x2();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				result.arr[i][j] = arr[i][j].add(other.arr[i][j]);
			}
		}
		return result;
	}
	
	public ComplexMatrix2x2 mult(ComplexMatrix2x2 other) {
		ComplexMatrix2x2 result = new ComplexMatrix2x2();
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					result.arr[i][j].add2(arr[i][k].mult(other.arr[k][j]));					
				}
			}
		}
		return result;
	}
	
	public ComplexNumber det() {
		return (arr[0][0].mult(arr[1][1]).sub(arr[0][1].mult(arr[1][0])));
	}

	public ComplexVector2D multVector(ComplexVector2D v) {
		ComplexNumber x = v.getX().mult(arr[0][0]).add(v.getY().mult(arr[0][1]));
		ComplexNumber y = v.getX().mult(arr[1][0]).add(v.getY().mult(arr[1][1]));
		
		return new ComplexVector2D(x, y);
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				result += arr[i][j] + "\t";
			}
			result += "\n";
		}
		
		return result;
	}
}
