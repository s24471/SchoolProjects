package com.company;

public class Main {

    public static void main(String[] args) {
        //A n n a
        //0 1 2 3
        //n A a n
        //1 0 3 2
        char[] str=new char[]{'A','n','j','n','a'};
        writePal(str);
        System.out.println();
        int [][] a=new int[9][9];
        fillArray(a,0,0,1);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
        System.out.println(
        );
        printCalendar(2,2020);
        System.out.println(
        );
        perm(new int[]{1,2,3});
    }

    public static void writePal(char [] str){
        writePal(str,str.length/2-1,0);
        if(str.length%2==0)
            writePal(str,str.length-1,str.length/2);
        else
            writePal(str,str.length-1,str.length/2-1);
    }

    public static void writePal(char[] str, int indexStart, int indexEnd){
        if(indexStart>=indexEnd){
            System.out.print(str[indexStart]);
            indexStart--;
            writePal(str,indexStart,indexEnd);
        }
    }

    public static void fillArray(int[][]arr,int rowStart, int colStart, int number){
        for (int i = rowStart; i <arr.length-rowStart ; i++) {
            for (int j = colStart; j < arr[i].length-colStart; j++) {
                arr[i][j]=number;
            }
        }
        if(rowStart<arr.length-rowStart && colStart<arr[0].length-colStart)
            fillArray(arr,++rowStart,++colStart,++number);
    }

    public static void printCalendar(int month, int year){
        for (int i = 1; i < calcWeekday(month,year,1); i++) {
            System.out.print("  ");
        }
        int days=31;
        if(month==2) {
            days=28;
            if((year%4==0 && year%100!=0) || year%400==0) days=29;
        }
        else if (month==3||month==6||month==9||month==11) days=30;

        for (int i = 1; i <= days ; i++) {
            System.out.print(i+" ");
            if(calcWeekday(month,year,i)==0)
                System.out.println();
        }
    }

    //123
    //132
    //321
    //312
    //213
    //231

    public static int calcWeekday(int month, int year,int day){
        int yearCode=(year%100+year%100/4)%7;
        int monthCode=-1;
        switch (month){
            case 1: monthCode=0; break;
            case 2: monthCode=3; break;
            case 3: monthCode=3; break;
            case 4: monthCode=6; break;
            case 5: monthCode=1; break;
            case 6: monthCode=4; break;
            case 11: monthCode=3; break;
        }

        int centuryCode=6;
        if(year<2000)centuryCode=0;

        int leapYearCode=0;
        if((year%4==0 && year%100!=0) || year%400==0){
            if(month==1 || month==2)
                leapYearCode=1;
        }

        int weekday=(yearCode+monthCode+day+centuryCode-leapYearCode)%7;
        return weekday;
    }

    public static void swap(int[]tab, int source, int destination){
        int tmp=tab[source];
        tab[source]=tab[destination];
        tab[destination]=tmp;
    }

    public static void perm(int tab[]){
        int [] indexes=new int [tab.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i]=0;
        }

        int i=0;
        while (i<tab.length){
            if(indexes[i]<i) {
                swap(tab, i % 2 == 0 ? 0 : indexes[i], i);
                for (int j = 0; j < tab.length; j++) {
                    System.out.print(tab[j]);
                }
                System.out.println();
                indexes[i]++;
                i = 0;
            }else {
                indexes[i]=0;
                i++;
            }
        }
    }

}
