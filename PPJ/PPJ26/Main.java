package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        char enter='\n';
        InputStream strumienWe = System.in;
        MojSkaner m= new MojSkaner(strumienWe);
        try {
            System.out.println(m.odczytajLiczbeCalkowita());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        PNWReader pnw=new PNWReader(new FileReader(""), PNWReader.LICZBA_PIERWSZA);
//        try {
//            int a= 0;
//            while ((a=strumienWe.read())!='\n')
//                System.out.println((char)a+ " - "+a);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
