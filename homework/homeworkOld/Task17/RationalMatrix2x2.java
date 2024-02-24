public class RationalMatrix2x2 {
	
	private RationalFraction[][] arr = new RationalFraction[2][2];
	
	public RationalMatrix2x2() {
		this(new RationalFraction());
	}
	
	public RationalMatrix2x2(RationalFraction num) {
		this(num, num, num, num);
	}
	
	public RationalMatrix2x2(RationalFraction a, RationalFraction b, RationalFraction c, RationalFraction d) {
		arr[0][0] = a;
		arr[0][1] = b;
		arr[1][0] = c;
		arr[1][1] = d;
	}
	
	
	public RationalMatrix2x2 add(RationalMatrix2x2 other) {
		RationalMatrix2x2 result = new RationalMatrix2x2();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				result.arr[i][j] = arr[i][j].add(other.arr[i][j]);
			}
		}
		return result;
	}
	
	public RationalMatrix2x2 mult(RationalMatrix2x2 other) {
		RationalMatrix2x2 result = new RationalMatrix2x2();
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					result.arr[i][j].add2(arr[i][k].mult(other.arr[k][j]));					
				}
			}
		}
		return result;
	}
	
	public RationalFraction det() {
		return (arr[0][0].mult(arr[1][1]).sub(arr[0][1].mult(arr[1][0])));
	}

	public RationalVector2D multVector(RationalVector2D v) {
		RationalFraction x = v.getX().mult(arr[0][0]).add(v.getY().mult(arr[0][1]));
		RationalFraction y = v.getX().mult(arr[1][0]).add(v.getY().mult(arr[1][1]));
		
		return new RationalVector2D(x, y);
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
