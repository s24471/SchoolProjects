package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    //Zadanie 1
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        //Zadanie 2
        int wrt=13;
        for (int i = 0; i < 10; i++) {
            System.out.println(wrt*i);
        }
        //Zadanie 3
        int a=6;
        while(a<2){
            System.out.println("while");
        }

        do{
            System.out.println("do-while");
        }while(a<2);
        //Zadanie 4
        Scanner in=new Scanner(System.in);
        int i;
        int ilosc=0, suma=0;
        do{
            i=in.nextInt();
            ilosc++;
            suma+=i;
        }while (i!=0);
        //Zadanie 5
        int nrstud=in.nextInt();
        for (int j = 0; j <nrstud ; j++) {
            System.out.println(j);
        }
        //Zadanie 6
        for (int j = 0; j < 10; j++) {
            System.out.println(1/(Math.pow(2,j)));
        }
        //Zadanie 7
        int miesiac=in.nextInt();
        int dzien=in.nextInt();
        int dni=0;
        for (int j = 0; j < miesiac; j++) {
            switch (j){
                case 1,3,5,7,8,10,12:
                    dni+=31;
                    break;
                case 4,6,9,11:
                    dni+=30;
                    break;
                case 2:
                    dni+=29;
            }
        }
        dni+=dzien;
        //Zadanie 8
        double kwota=in.nextDouble();
        if((int)(kwota/5)!=0){
            System.out.println((int)(kwota/5)+"* 5 zl");
            kwota=kwota%5;
        }
        if((int)(kwota/2)!=0){
            System.out.println((int)(kwota/2)+"* 2 zl");
            kwota=kwota%2;
        }
        if((int)(kwota/1)!=0){
            System.out.println((int)(kwota/1)+"* 1 zl");
            kwota=kwota%1;
        }
        if((int)(100*kwota/50)!=0){
            System.out.println((int)(100*kwota/50)+"* 50 gr");
            kwota=kwota%0.5;
        }
        if((int)(100*kwota/20)!=0){
            System.out.println((int)(100*kwota/20)+"* 20 gr");
            kwota=kwota%0.2;
        }
        if((int)(100*kwota/10)!=0){
            System.out.println((int)(100*kwota/10)+"* 10 gr");
            kwota=kwota%0.1;
        }
        if((int)(100*kwota/5)!=0){
            System.out.println((int)(100*kwota/5)+"* 5 gr");
            kwota=kwota%0.05;
        }
        if((int)(100*kwota/2)!=0){
            System.out.println((int)(100*kwota/2)+"* 2 gr");
            kwota=kwota%0.02;
        }
        if((int)(100*kwota/1)!=0){
            System.out.println((int)(100*kwota/1)+"* 1 gr");
            kwota=kwota%0.01;
        }
    }
}
