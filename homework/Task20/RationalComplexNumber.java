public class RationalComplexNumber {
	
	private RationalFraction re;
	private RationalFraction im;
	
	public RationalComplexNumber() {
		this(new RationalFraction(), new RationalFraction());
	}
	
	public RationalComplexNumber(RationalFraction re, RationalFraction im) {
		this.re = re;
		this.im = im;
	}
	
	public RationalComplexNumber add(RationalComplexNumber other) {
		return new RationalComplexNumber(re.add(other.re), im.add(other.im));
	}
	
	public RationalComplexNumber sub(RationalComplexNumber other) {
		return new RationalComplexNumber(re.sub(other.re), im.sub(other.im));
	}
		
	public RationalComplexNumber mult(RationalComplexNumber other) {
		return new RationalComplexNumber(re.mult(other.re).sub(im.mult(other.im)), re.mult(other.im).sub(im.mult(other.re)));
	}
		
	public String toString() {
		String reString;
		String imString;
		if (re.isZero()) {
			if (im.isZero()) {
				return "0";
			} else {
				return im + "i";
			}
		} else {
			if (im.isZero()) {
				return re + "";
			} else if (im.lessThanZero()) {
				return re + " - " + im.mult(new RationalFraction(-1, 1)) + "i";
			}
		}
		return re + " + " + im + "i";
	}
	
	
}
