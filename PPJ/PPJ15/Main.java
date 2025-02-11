package com.company;

public class Main {

    public static void main(String[] args) {
        int b=10;
        show(b);
        int wrt=5;
        modifyValue(wrt);
        System.out.println(wrt);
        char []tab={'A','l','a','a'};
        findCharacters(tab);
        System.out.println(findMax(1,2,3));
    }
    public static boolean areTheSame(int t1[][],int t2[][]){
        if(t1.length!=t2.length) return false;
        for (int i = 0; i < t1.length; i++) {
            if(t1[i].length!=t2[i].length)
                return false;
        }
        for (int i = 0; i < t1.length; i++) {
            for (int j = 0; j < t1[i].length; j++) {
                if(t1[i][j]!=t2[i][j])
                    return false;
            }
        }
        return true;
    }

    public static int[] valueCounter(int []t1,
                                     int []t2,
                                     int flaga){
        int minLen=t1.length<t2.length?t1.length:t2.length;
        if(flaga<0){
            int[] wynikowa=new int[minLen];
            for (int i = 0; i < wynikowa.length; i++) {
                wynikowa[i]=t1[i]+t2[i];
            }
            return wynikowa;
        } else if (flaga>0){
            if(t1.length==t2.length)
                return new int[1];

            int []tabLarger=t1.length>t2.length?t1:t2;
            int[] wynikowa=new int[tabLarger.length-minLen];

            for (int i = 0; i < wynikowa.length; i++) {
                wynikowa[i]=tabLarger[i+minLen];
            }
            return wynikowa;
        }
        return new int[1];
    }

    public static void findCharacters(char [] str){
        for (char i = 'A'; i <='z' ; i++) {
            int counter=0;
            for (int j = 0; j < str.length; j++) {
                if(i==str[j])
                    counter++;
            }
            if(counter>0)
                System.out.println(i+" "+counter);
        }
    }

    public static int findMax(int a, int b, int c){
        if(a>=b&&a>=c) return a;
        if(b>=a&&b>=c) return b;
        return c;
    }

    public static void modifyValue(int a){
        System.out.println(a);
        a*=5;
        System.out.println(a);
    }


    public static void show(int a){
        System.out.println(a);
    }
}
