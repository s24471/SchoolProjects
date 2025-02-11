package com.company;

public class Rakieta {
    String nazwa;
    int wagaPaliwa;
    Rakieta(){
        nazwa="rakieta";
        wagaPaliwa=0;
    }

    void zatankuj(){
        wagaPaliwa+=(int)(Math.random()*90);
    }

    void start() throws Exception
    {
        if(wagaPaliwa<1000)
            throw new Exception("brak możliwosci startu - za mało paliwa");
        else
            System.out.println("wystartowano");
    }
}
