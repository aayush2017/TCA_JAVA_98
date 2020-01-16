
class xyzz {
	private int a;
	public void setValue(int x) {
		this.a = x;
	}
	public int getValue() {
		return this.a;
	}
}
class encTest extends xyzz {
	public static void main(String[] args) {
		xyzz aa = new xyzz();
		aa.setValue(50);
		System.out.println(aa.getValue());
	}
}
