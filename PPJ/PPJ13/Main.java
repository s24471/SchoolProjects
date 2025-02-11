package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//
//        for (int i = -size; i <= size; i++) {
//            for (int j = -size; j <= size; j++) {
//                if (Math.abs(i) + Math.abs(j) <= size)
//                    System.out.print("* ");
//                else
//                    System.out.print(". ");
//            }
//            System.out.println();
//        }
        int[] arr = {153, 333, 370, 515, 407, 80};

        for (int i = 0; i < arr.length; i++) {
            int tmp=arr[i];
            int suma=0;
            int powers=0;
            while (tmp>0){
                tmp=tmp/10;
                powers++;
            }
            tmp=arr[i];
            while (tmp>0){
                int cyfra=tmp%10;
                tmp=tmp/10;
                suma+=Math.pow(cyfra,powers);
            }
            if(suma==arr[i])
                System.out.println(suma+" jest liczba narcystyczna");
        }

        int size = in.nextInt();
        int tab1[]=new int[size];
        double tab2[]=new double[size];
        for (int i = 0; i < size; i++) {
            tab1[i]=(int)(Math.random()*100);
            tab2[i]=Math.random()*100;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(tab1[i]+tab2[i]<tab2[j]+tab1[j]){
                    int tmp1=tab1[i];
                    double tmp2=tab2[i];
                    tab1[i]=tab1[j];
                    tab2[i]=tab2[j];
                    tab1[j]=tmp1;
                    tab2[j]=tmp2;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(tab1[i]+tab2[i]+" ");
        }

        int[ ] [ ]tab= {
                {1 ,  0 ,  0 ,  0 ,  0} ,
                {0 ,  1 ,  0 ,  0} ,
                {0 ,  0 ,  1}};

        int elementy=0;
        for (int i = 0; i < tab.length; i++) {
            elementy+=tab[i].length;
        }
        int tab_el[]=new int[elementy];
        int index=0;

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab_el[index++]=tab[i][j];
            }
        }

        for (int i = 0; i < tab_el.length; i++) {
            System.out.println(tab_el[i]);
        }
    }


}
