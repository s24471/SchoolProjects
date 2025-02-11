package com.company;

public class Main {

    public static void main(String[] args) {
    	//1111 1111
		byte b1=0b0111_1111;//1 bajt = 8 bit 0x7F
		short s1=0x7F_FF;
		int i1=0x7F_FF_FF_FF;
		long l1=0x7F_FF_FF_FF_FF_FF_FF_FFl;
		char c1=0xFF;
		float f1=3.4028234664e+38f;
		double d1=1.7*Math.pow(10,308);

		//Wynik == 0
		double sqTwo = Math.sqrt(2);
		System.out.println(sqTwo*sqTwo);
		System.out.println(sqTwo*sqTwo - 2);
		//4.440892098500626E-16 == 0.000000000000000044

		int x = 2 * ((5 + 3) * 4 - 8);
		System.out.println(x);

		int x2 = 5 ;
		System.out.println ( (x2=4) * x2 ) ;

		int a = 10 , b = 5 , c = 1 , res ;
		//res = a - ++c - ++b ;//preinkrementacja
		res = a - c++ - b++ ;//postinkrementacja
		System . out . println ( "Wynik : " + res );

		java . util . Scanner in = new java . util . Scanner ( System . in ) ;
		int r = in . nextInt ( ) ;

		System.out.println(r<10?"Mniejsze od 10":"Wieksze od 10");
		System.out.println(r<100?"Mniejsze od 100":"Wieksze od 10");
		System.out.println(r<1000?"Mniejsze od 1000":"Wieksze od 10");

		System.out.println(r<10?"Mniejsze od 10":r<100? "Mniejsze od 100":
				r< 1000 ? "Mniejsze od 1000":"Wikesze od 1000");

		int rok=in.nextInt();
		System.out.println((rok%4==0 && rok%100!=0)|| rok%400==0 ? "Przestępny":"Nieprzestępny");

    	double fahr = in.nextDouble();
    	double cel = (fahr-32)*(5.0/9);
		System.out.println(cel);
    }
}
