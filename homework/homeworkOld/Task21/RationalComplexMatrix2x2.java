public class RationalComplexMatrix2x2 {
	
	private RationalComplexNumber[][] arr = new RationalComplexNumber[2][2];
	
	public RationalComplexMatrix2x2() {
		this(new RationalComplexNumber());
	}
	
	public RationalComplexMatrix2x2(RationalComplexNumber num) {
		this(num, num, num, num);
	}
	
	public RationalComplexMatrix2x2(RationalComplexNumber a, RationalComplexNumber b, RationalComplexNumber c, RationalComplexNumber d) {
		arr[0][0] = a;
		arr[0][1] = b;
		arr[1][0] = c;
		arr[1][1] = d;
	}
	
	
	public RationalComplexMatrix2x2 add(RationalComplexMatrix2x2 other) {
		RationalComplexMatrix2x2 result = new RationalComplexMatrix2x2();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				result.arr[i][j] = arr[i][j].add(other.arr[i][j]);
			}
		}
		return result;
	}
	
	public RationalComplexMatrix2x2 mult(RationalComplexMatrix2x2 other) {
		RationalComplexMatrix2x2 result = new RationalComplexMatrix2x2();
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					result.arr[i][j] = result.arr[i][j].add(arr[i][k].mult(other.arr[k][j]));					
				}
			}
		}
		return result;
	}
	
	public RationalComplexNumber det() {
		return (arr[0][0].mult(arr[1][1]).sub(arr[0][1].mult(arr[1][0])));
	}

	public RationalComplexVector2D multVector(RationalComplexVector2D v) {
		RationalComplexNumber x = v.getX().mult(arr[0][0]).add(v.getY().mult(arr[0][1]));
		RationalComplexNumber y = v.getX().mult(arr[1][0]).add(v.getY().mult(arr[1][1]));
		
		return new RationalComplexVector2D(x, y);
	}

}
