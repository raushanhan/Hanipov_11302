public class ComplexNumber {
	
	private double re;
	private double im;
	
	public ComplexNumber() {
		this(0, 0);
	}
	
	public ComplexNumber(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public ComplexNumber add(ComplexNumber other) {
		return new ComplexNumber(re + other.re, im + other.im);
	}
	
	public void add2(ComplexNumber other) {
		re += other.re;
		im += other.im;
	}
	
	public ComplexNumber sub(ComplexNumber other) {
		return new ComplexNumber(re - other.re, im - other.im);
	}
	
	public void sub2(ComplexNumber other) {
		re -= other.re;
		im -= other.im;
	}
	
	public ComplexNumber multNumber(double num) {
		return new ComplexNumber(re * num, im * num);
	}
	
	public void multNumber2(double num) {
		re *= num;
		im *= num;
	}
	
	public ComplexNumber mult(ComplexNumber other) {
		return new ComplexNumber(re * other.re - im * other.im, re * other.im + im * other.re);
	}
	
	public void mult2(ComplexNumber other) {
		re = re * other.re - im * other.im;
		im = re * other.im + im * other.re;
	}
	
	public ComplexNumber div(ComplexNumber other) {
		ComplexNumber result = new ComplexNumber(other.re, -other.im);
		result.mult2(this);
		result.multNumber2(1 / ((other.re * other.re) + (other.im * other.im)));
		return result;
	}
	
	public void div2(ComplexNumber other) {
		ComplexNumber result = div(other);
		re = result.re;
		im = result.im;
	}
	
	public double length() {
		return re * re + im * im;
	}
	
	public double arg() {
		return Math.atan(im / re);
	}
	
	public ComplexNumber pow(double n) {
		double r = Math.pow(length(), n);
		ComplexNumber result = new ComplexNumber(Math.cos(n * arg()), Math.sin(n * arg()));
		result.multNumber2(r);
		return result;
	}
	
	public boolean equals(ComplexNumber other) {
		if (Math.abs(re - other.re) < 1e-9 & Math.abs(im - other.im) < 1e-9) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String reString;
		String imString;
		if (re == 0) {
			if (im == 0) {
				return "0";
			} else {
				return im + "i";
			}
		} else {
			if (im == 0) {
				return re + "";
			} else if (im < 0) {
				return re + " - " + -im + "i";
			}
		}
		return re + " + " + im + "i";
	}
	
	
}
