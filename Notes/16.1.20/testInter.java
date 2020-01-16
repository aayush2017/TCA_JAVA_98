interface RInter {
	void dis();
}

class RIDemo implements RInter {
	public void dis() {
		System.out.println("Hello from Interface");
	}
}

public class testInter {
	public static void main(String args[]) {
		RIDemo d = new RIDemo();
		d.dis();
	}
}

