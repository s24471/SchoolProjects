package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);//1101
//        int originalLiczba=in.nextInt();//00...0001111111
//        int maskaBin=0b1;//00...000001
//        int liczba=originalLiczba;
//        int bit=liczba & maskaBin;
//        String liczbaBin="";
//        for (int i = 0; i < 32; i++) {
//            bit=liczba & maskaBin;
//            liczbaBin= bit + liczbaBin;
//            System.out.println(liczbaBin);
//            liczba=liczba>>1;
//        }
//
//        liczba=originalLiczba;
//        String liczbaQuad="";
//        int maskaQuad=0b1111;
//        for (int i = 0; i < 32/4; i++) {
//            bit=liczba & maskaQuad;
//            if(bit<=9)
//                liczbaQuad= bit + liczbaQuad;
//            else{
//                char hex=(char)('A'+bit%10);
//                liczbaQuad= hex + liczbaQuad;
//            }
//            System.out.println(liczbaQuad);
//            liczba=liczba>>4;
//        }
//
        String szablon="^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$";//yyyy-mm-dd
        //regexr.com lub regex101.com
        //[a-zA-Z0-9] - znaki ktore mogasie pojawic
        //* - 0 do inf, + 1 do inf, {val} - dokładnie tyle powótrzeń,
        // {val1, val2} - od val1 do val2 powtórzeń
        //\s - znaki białe. \w - wszystkie słowa \d - liczby
        //\S - NIE znaki białe \W - NIE słowa \D - NIE liczby
        Pattern p=Pattern.compile(szablon);
        Matcher m=p.matcher("Tekst do sprawdzenia");
        if(m.find())//boolean
            System.out.println(m.group());//String

        if(m.find())//boolean
            System.out.println(m.group());//String
    }

    public boolean findHex(String hex){
        Pattern p=Pattern.compile("^[0-9A-F]+$");
        Matcher m=p.matcher(hex);
        return m.find();
    }
}
