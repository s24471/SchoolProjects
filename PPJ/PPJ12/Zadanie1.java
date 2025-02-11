package com.company;

public class Zadanie1 {
    public static void main(String[] args) {
        int[] tab = {1,2,3,4,4,4,2,1};
        boolean czy_spelnia=true;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i]!=tab[tab.length-1-i])
                czy_spelnia=false;
        }
        System.out.println(czy_spelnia);

        boolean b[]=new boolean[20];
        for (int i = 0; i < b.length; i++) {
            b[i]=Math.random()<0.5 ? true : false;
        }

        boolean tabTrue[], tabFalse[];
        int ileTrue=0, ileFalse=0;
        for (int i = 0; i < b.length; i++) {
            if(b[i])
                ileTrue++;
            else
                ileFalse++;
        }
        tabTrue=new boolean[ileTrue];
        tabFalse=new boolean[ileFalse];

        long arr[]=new long[20];
        long start=78;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=start+i;
        }
        boolean posortowane;
        do{
            int i1=(int) (Math.random()*arr.length);
            int i2=(int) (Math.random()*arr.length);

            long tmp=arr[i1];
            arr[i1]=arr[i2];
            arr[i2]=tmp;
            posortowane=false;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i+1]==arr[i]+1)
                    posortowane=true;
            }
        }while (posortowane);
    }
}
