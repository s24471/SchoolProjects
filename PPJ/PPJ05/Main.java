package com.company;

import com.sun.security.jgss.GSSUtil;

public class Main {

    public static void main(String[] args) {
        System.out.println("Działa!");
        boolean a=true;
        int b=13;
        double c=4.12;
        char d='a';
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        //Zadanie 2
        int a123;
        //int 1abc;
        //int @abc;
        //int public;
        //int null;
        //Zadanie 3
//        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(b==d);

        //Zadanie 4
        int a1=168;
        double a2=16.3;
        double a3=.2;//0.2
        float a4=15.87f;
        double a5=3d;
        long a6=3l;
        long a7=3_500_000_000L;
        boolean a8=false;
        String a9="Hello";
        char a10='A';
        int a11=0b10101;

        //Zadanie 5
        char charValue='a';
        char charvalue='a';//97

        System.out.println(charvalue>=0?"Należy do A":"");
        System.out.println(charvalue<=1?"Należy do B":"");
        System.out.println(charvalue>=0 && charvalue<=1?"Należy do C":"");
    }
}
