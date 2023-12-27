public class Matrix2x2 {
	
	private double[][] arr = new double[2][2];
	
	public Matrix2x2() {
		this(0);
	}
	
	public Matrix2x2(double num) {
		this(num, num, num, num);
	}
	
	public Matrix2x2(double[][] arr) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				this.arr[i][j] = arr[i][j];
			}
		}
	}
	
	public Matrix2x2(double a, double b, double c, double d) {
		arr[0][0] = a;
		arr[0][1] = b;
		arr[1][0] = c;
		arr[1][1] = d;
	}
	
	
	public Matrix2x2 add(Matrix2x2 other) {
		Matrix2x2 result = new Matrix2x2();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				result.arr[i][j] = arr[i][j] + other.arr[i][j];
			}
		}
		return result;
	}
	
	public void add2(Matrix2x2 other) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] += other.arr[i][j];
			}
		}
	}
	
	public Matrix2x2 sub(Matrix2x2 other) {
		Matrix2x2 result = new Matrix2x2();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				result.arr[i][j] = arr[i][j] - other.arr[i][j];
			}
		}
		return result;
	}
	
	public void sub2(Matrix2x2 other) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] -= other.arr[i][j];
			}
		}
	}
	
	public Matrix2x2 multNumber(double n) {
		Matrix2x2 result = new Matrix2x2();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				result.arr[i][j] = arr[i][j] * n;
			}
		}
		return result;
	}
	
	public void multNumber2(double n) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] *= n;
			}
		}
	}
	
	public Matrix2x2 mult(Matrix2x2 other) {
		Matrix2x2 result = new Matrix2x2();
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					result.arr[i][j] += arr[i][k] * other.arr[k][j];					
				}
			}
		}
		return result;
	}
	
	public void mult2(Matrix2x2 other) {
		Matrix2x2 result = mult(other);
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = result.arr[i][j];
			}
		}
	}
	
	public double det() {
		return (arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0]);
	}
	
	public void transpon() {
		double num01 = arr[0][1];
		arr[0][1] = arr[1][0];
		arr[1][0] = num01;
	}
	
	public Matrix2x2 inverseMatrix() {
		if (Math.abs(det()) < 1e-9) {
			System.out.println("невозможно найти обратную матрицу");
			return new Matrix2x2();
		}
		Matrix2x2 result = new Matrix2x2(1, 0, 0, 1);
		Matrix2x2 orig = new Matrix2x2(arr);
				
		for (int j = 0; j < 2; j++) {
			int j1 = 1 - j;
			double k = (double) -orig.arr[j1][j] / orig.arr[j][j];
			for (int i = 0; i < 2; i++) {
				result.arr[j1][i] = result.arr[j][i] * k + result.arr[j1][i];
				orig.arr[j1][i] = orig.arr[j][i] * k + orig.arr[j1][i];
			}
		}
		
		for (int i = 0; i < 2; i++) {
			result.arr[i][0] /= orig.arr[i][i];
			result.arr[i][1] /= orig.arr[i][i];
		}
		
		return result;
		
	}
	
	public Matrix2x2 equivalentDiagonal() {
		Matrix2x2 result = new Matrix2x2(arr);
		
		for (int j = 0; j < 2; j++) {
			int j1 = 1 - j;
			double k = (double) -result.arr[j1][j] / result.arr[j][j];
			for (int i = 0; i < 2; i++) {
				result.arr[j1][i] = result.arr[j][i] * k + result.arr[j1][i];
			}
		}
		
		return result;
	}
	
	public Vector2D multVector(Vector2D v) {
		double x = v.getX() * arr[0][0] + v.getY() * arr[0][1];
		double y = v.getX() * arr[1][0] + v.getY() * arr[1][1];
		
		Vector2D result = new Vector2D(x, y);
		
		return result;
	}
	
	public double[][] getArr() {
		return arr;
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
