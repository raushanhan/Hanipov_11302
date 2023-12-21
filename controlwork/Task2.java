// variant 2
import java.util.Scanner;

public class Task2 {
	
	public static double[][] input(Scanner sc) {
		
		System.out.println("enter the amount of lines of the matrix");
		int m = sc.nextInt();
		
		double[][] matrix = new double[m][m];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				System.out.println("Enter A[" + (i + 1) + "][" + (j + 1) + "]");
				matrix[i][j] = sc.nextDouble();
			}
		}
		
		return matrix;
	}
	
	public static double[][] makeMatrixOfOnes(int m) {
		
		double[][] matrix = new double[m][m];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (i == j) {
					matrix[i][j] = 1;
				} else {
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}
	
	public static double[][] matrixMult(double[][] a, int m) {
		double[][] result = new double[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				double sum = 0.0;
				for (int k = 0; k < m; k++) {
					sum += a[i][k] * a[k][j];
				}
				result[i][j] = sum;
			}
		}
		return result;
	}
	
	public static double[][] matrixPlus(double[][] a, double[][] b, int m) {
		double[][] result = new double[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		return result;
	}
	
	public static double[][] matrixNumMult(double[][] a, double num, int m) {
		double[][] result = new double[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = a[i][j] * num;
			}
		}
		return result;
	}
	
	public static double[][] findResult(double[][] a, double[][] ones, double[] p, int m, int n) {
		double[][] result = new double[m][m];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = 0;
			}
		}
		
		double[][] deg = ones;
		for (int i = 0; i < n; i++) {
			double[][] next = matrixNumMult(deg, p[i], m);
			result = matrixPlus(result, next, m);
			deg = matrixMult(a, m);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the amount of lines of the matrix");
		int m = sc.nextInt();
		
		double[][] a = input(sc);
		double[][] ones = makeMatrixOfOnes(m);
		
		System.out.println("enter the amount of p's");
		int n = sc.nextInt();
		
		double[] p = new double[n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("Enter p[" + (i + 1) + "]");
			p[i] = sc.nextDouble();
		}
		
		double[][] result = findResult(a, ones, p, m, n);
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}