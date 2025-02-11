public class PPJ04{
	public static void main(String [] args){
		//Operatory matematyczne: +, -, *, /, %
		//Operatory porównania: <, >, <=, >=, ==, !=
		//Operatory logiczne: &&, ||
		
		int a=7,b=4;
		double a2=6.7, b2=9.3;
		char a3='g', b3='E';
		System.out.println("CALKOWITE");
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
		
		System.out.println("RZECZYWISTE");
		System.out.println(a2+b2);
		System.out.println(a2-b2);
		System.out.println(a2*b2);
		System.out.println(a2/b2);
		System.out.println(a2%b2);
		
		System.out.println("ZNAKOWE");
		System.out.println(a3+b3);
		System.out.println(a3-b3);
		System.out.println(a3*b3);
		System.out.println(a3/b3);
		System.out.println(a3%b3);
		
		//System.out.println(true+true);
		
		// && true false
		//true true&&true true&&false
		//false false&&true false&&false
		int licz=13, dziel=2;
		System.out.println(licz/dziel!=0);
		System.out.println(dziel > licz/2+1);
		dziel=dziel+1;
		System.out.println(licz/dziel!=0);
		System.out.println(dziel > licz/2+1);
		dziel=dziel+1;
		System.out.println(licz/dziel!=0);
		System.out.println(dziel > licz/2+1);
		dziel=dziel+1;
		System.out.println(licz/dziel!=0);
		System.out.println(dziel > licz/2+1);
		dziel=dziel+1;
		System.out.println(licz/dziel!=0);
		System.out.println(dziel > licz/2+1);
		dziel=dziel+1;
		System.out.println(licz/dziel!=0);
		System.out.println(dziel > licz/2+1);
		dziel=dziel+1;
		System.out.println(licz/dziel!=0);
		System.out.println(dziel > licz/2+1);
		
		System.out.println("&& | true | false");
		System.out.println(true+" | "+(true&&true)+" | "+(true&&false));
		System.out.println(false+" | "+(false&&true)+" | "+(false&&false));
		
		System.out.println("|| | true | false");
		System.out.println(true+" | "+(true||true)+" | "+(true||false));
		System.out.println(false+" | "+(false||true)+" | "+(false||false));

		System.out.println(0x123456);
		System.out.println(0b0001_0010_0011_0100_0101_0110);

	}
}