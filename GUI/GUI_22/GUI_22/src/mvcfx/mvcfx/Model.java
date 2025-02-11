package mvcfx.mvcfx;

public class Model {

	private double a1;
	private double b1;
	private double c1;
	private double x;
	private double x1;
	private double x2;
	private String a;
	private String b;
	private String c;


	public Model() {
		a1=0;
		b1=0;
		c1=0;
	}

	public int solve(){
		if(check(a) == false) return -1;
		if(check(b) == false) return -1;
		if(check(c) == false) return -1;
		a1=Integer.valueOf(a);
		if(a1 == 0) return 0;
		b1=Integer.valueOf(b);
		c1=Integer.valueOf(c);
		double delta = delta();
		if(delta < 0) return 0;
		if(delta==0){
			x = (-b1)/2*a1;
			return 1;
		}
		x1 = ((-b1) + Math.sqrt(delta)) / 2*a1;
		x2 = ((-b1) - Math.sqrt(delta)) / 2*a1;
		return 2;
	}

	private boolean check(String n){
		if(n=="")return false;
		if(n.charAt(0) != '-' && (n.charAt(0) > '9' || n.charAt(0)<'0'))
			return false;
		for (int i = 1; i < n.length(); i++) {
			if(n.charAt(i)>'9' || n.charAt(i)<'0')
				return false;
		}
		return true;
	}

	private double delta(){
		return b1*b1 - 4 * a1 * c1;
	}


	public double getX() {
		return x;
	}

	public double getX1() {
		return x1;
	}

	public double getX2() {
		return x2;
	}

	public void setA(String a) {
		this.a = a;
	}

	public void setB(String b) {
		this.b = b;
	}

	public void setC(String c) {
		this.c = c;
	}
}
