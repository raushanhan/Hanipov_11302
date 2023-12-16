public class A {
	
	private Object obj;
	
	public A (Object obj) {
		this.obj = obj;
	}

	public A copy() {
		return new A(obj);
	}

}