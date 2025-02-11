package com.company;

public class Main {

    public static void main(String[] args) {
        int a=8;
        int b=9;
        if( ! (a<b) && ! (a>b) ){ //a==b

        }

        int miesiac, rok;
        java.util.Scanner in=new java.util.Scanner(System.in);
        miesiac=in.nextInt();
        rok=in.nextInt();

        switch (miesiac){
            case 1,3,5,7,8,10,12:
                System.out.println("31 dni");
            case 4,6,9,11:
                System.out.println("30 dni");
            case 2:
                if((rok%4==0&&rok%100!=0) || rok%400==0)
                    System.out.println("29 dni");
                else
                    System.out.println("28 dni");
        }

        char ch = in.next().charAt(0);
        boolean czyToLitera=ch>='a'&& ch<='z';
        if(czyToLitera){
            switch (ch){
                case 'a','e','i','o','u','y':
                    System.out.println("samogłoska");
                    break;
                default:
                    System.out.println("spółgłoska");
            }
        }

        //Zadanie 4
        double c,e;
        c=in.nextDouble();
        e=in.nextDouble();
        double roznica=c>e?c-e:e-c;
        if(roznica<0.01)
            System.out.println("takie same");
        else
            System.out.println("różne");

        //Zadanie 5
        int k1=in.nextInt(),k2=in.nextInt(),k3=in.nextInt();
        if(k1+k2+k3==180){
            System.out.println("tojkat moze zaistniec");
            if(k1<90 && k2<90 && k3<90)
                System.out.println("ostrokatny");
        }
        else System.out.println("trójkąt niemoże zaistnieć");

        //Zadanie 6
        double x=in.nextDouble(),y=in.nextDouble(),z=in.nextDouble();
        double delta= y*y-4*x*z;
        if(delta>0){
            System.out.println((Math.sqrt(delta)-y)/(2*x));
            System.out.println((Math.sqrt(delta)+y)/(2*x));
        }else if(delta==0){
            System.out.println(-y/(2*x));
        }else System.out.println("nie ma miejsc zerowych");

        //Zadanie 7
        double ptk=in.nextDouble(), max=in.nextDouble();
        double procent=ptk*100/max;
        if(procent>=87.5) System.out.println(5);
        else if (procent>=81.25) System.out.println(4.5);
        else if (procent>=75) System.out.println(4);
        else if(procent>=62.6) System.out.println(3.5);
        else if(procent>=50) System.out.println(3);
        else System.out.println(2);

    }
}
