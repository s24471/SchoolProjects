package com.company;

public class Main {

    public static void main(String[] args) {
//        double tab1[] = new double[10];
//
//        for (int i = 0; i < tab1.length; i++) {
//            tab1[i] = Math.random() * 100;
//        }
//        for (int i = 0; i < tab1.length; i++) {
//            System.out.println(tab1[i]);
//        }
//        System.out.println();
//        for (int i = 2; i < tab1.length; i += 2) {
//            System.out.println(tab1[i]);
//        }
//        System.out.println();
//        for (int i = 0; i < tab1.length; i++) {
//            if (((int) tab1[i]) % 2 != 0)
//                System.out.println(tab1[i]);
//        }
//
//        char tab2[] = new char[3];
//        for (int i = 0; i < tab2.length; i++) {
//            tab2[i] = (char) (Math.random() * 120);
//            System.out.println(tab2[i] + " " + (int) tab2[i]);
//        }
//        int index = 0;
//        for (int i = 1; i < tab2.length; i++) {
//            if (tab2[index] > tab2[i]) {
//                index = i;
//            }
//        }
//        System.out.println(index + " " + tab2[index]);
//
//
//        char tab3[] = new char[5];
//        for (int i = 0; i < tab3.length; i++) {
//            tab3[i] = (char) (Math.random() * ('Z' - 'A') + 'A');
//        }
//        System.out.println(tab3);
//        java.util.Scanner in = new java.util.Scanner(System.in);
//        int zera=0;
//        int wystapienia;
//        while (zera<tab3.length){
//            char c=in.next().charAt(0);
//            wystapienia=0;
//            for (int i = 0; i < tab3.length; i++) {
//                if(c==tab3[i]){
//                    tab3[i]=0;
//                    zera++;
//                    wystapienia++;
//                }
//            }
//            System.out.println(c+" "+wystapienia);
//            System.out.println(tab3);
//        }

        int tab4[]=new int[(int)(Math.random()*5+10)];
        for (int i = 0; i < tab4.length; i++) {
            tab4[i]=i;
        }
        for (int i = 0; i < tab4.length; i++) {
            System.out.print(tab4[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < tab4.length; i++) {
            int losowyIndex=(int)(Math.random()*tab4.length);
            int tmp=tab4[i];
            tab4[i]=tab4[losowyIndex];
            tab4[losowyIndex]=tmp;
        }
        for (int i = 0; i < tab4.length; i++) {
            System.out.print(tab4[i]+" ");
        }
        System.out.println();
        for(int wiersz=0;wiersz< tab4.length;wiersz++){
            for(int kolumnaIndex=0;kolumnaIndex< tab4.length;kolumnaIndex++){
                if(wiersz==tab4[kolumnaIndex]){
                    System.out.print("*");
                }else
                    System.out.print(".");
            }
            System.out.println();
        }

    }
}

