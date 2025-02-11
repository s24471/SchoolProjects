package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        //Zadanie 1
//        for(int i=75;i<=150;i++){
//            char c=(char)i;
//            System.out.println(c+" - "+i);
//        }
        //Zadanie 2
        byte b=15;
        char hex=' ';
        if(b<10){
            hex=(char) ('0'+b);
        }else if(b<=15)
            hex=(char)('A'+(b%10));
        System.out.println(hex);

        double a=Math.random()*3;
        System.out.println(a);
        //Zadanie 3
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for (int i=1;i<=n;i++){
            for(int j=2;j<=4;j++){
                System.out.print(" "+(int)Math.pow(i,j));
            }
            System.out.println();
        }

        //Zadanie 4
        for(int wiersz=1;wiersz<=6;wiersz++) {
            for (int kolumny = 1; kolumny <= 9; kolumny++) {
                if(wiersz%2!=0)
                System.out.print(kolumny % 2 != 0 ? "*" : " ");
                else
                System.out.print(kolumny % 2 != 0 ? " " : "*");
            }
            System.out.println();
        }

        //Zadanie 5
        char gracz=in.next().charAt(0);//
        char komputer=' ';
        int los=(int)(Math.random()*3);
        if(los==0)
            komputer='p';
        else if(los==1)
            komputer='k';
        else
            komputer='n';

        int wynik=gracz-komputer;
        if(wynik==0)
            System.out.println("remis");
        else if(wynik=='p'-'k' || wynik=='k'-'n' || wynik == 'n'-'p')
            System.out.println("wygrywa gracz");
        else
            System.out.println("wygrał kompuer");


    }


}
