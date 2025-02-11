package com.company;

public class Main {

    public static void main(String[] args) {
	    //Zadanie 1
        boolean czyPada=true;
        if(czyPada)
            System.out.println("Pada");
        else
            System.out.println("Nie Pada");

        //Zadanie 2
        int x;
        if(czyPada)
            x=5;
        else
            x=8;

        //Zadanie 3
        boolean czySwieciSlonce=false;
        if(czyPada&&czySwieciSlonce)
            System.out.println("tęcza");
        else if(czyPada&&!czySwieciSlonce)
            System.out.println("plucha");
        else if(!czyPada&&czySwieciSlonce)
            System.out.println("słonecznie");
        else
            System.out.println("pochmurno");

        //Zadanie 4
        if(3 < 5*2.0)
            System.out.print("Hello") ;
        System.out.print(" PPJ") ;

        //Zadanie 5
        java.util.Scanner in=new java.util.Scanner(System.in);
        int a,b;
        a=in.nextInt();
        b=in.nextInt();
        if(b%a==0)
            System.out.println(b+" jest wielokrotnością "+a);

        //Zadanie 6
        double c,d;
        c=in.nextDouble();
        d=in.nextDouble();
        if(c<0&&d<0)
            System.out.println(c+d);
        else if(c>0&&d>0)
            System.out.println(c-d);

        //Zadanie 8
        double los;
        boolean l1=false,l2=false,l3=false,l4=false,l5=false;
        los=Math.random();
        if(los>0.2)
            l1=true;
        los=Math.random();
        if(los>0.2)
            l2=true;
        los=Math.random();
        if(los>0.2)
            l3=true;
        if(l1&&l2&&l3)
            System.out.println("są wieksze od 0.2");
        los=Math.random();
        if(los>0.2)
            l4=true;
        if(l4&&l2&&l3)
            System.out.println("są wieksze od 0.2");
        los=Math.random();
        if(los>0.2)
            l5=true;
        if(l4&&l5&&l3)
            System.out.println("są wieksze od 0.2");


        //Zadanie 9
        int wrt=in.nextInt();

        if((wrt>-15&&wrt<=-10) || (wrt>-5&&wrt<-0) || (wrt>5&&wrt<10)){
            if( wrt<=-13 || (wrt>-8&&wrt<=-3)){
                if(wrt>=-4){
                    System.out.println(wrt+" jest częścią wspólną zbiorów A, B i C");
                }
            }
        }
    }
}
