package com.company;

import java.io.FileReader;

public class PNWReader {
    static final int LICZBA_PIERWSZA=0;
    static final int LICZBA_NARCYSTYCZNA=1;
    static final int WYRAZ=2;
    int typ;
    FileReader fr;
    boolean czyUruchomiona=false;

    public PNWReader(FileReader fr, int typ){
        if(typ!=1 && typ!=2 && typ!=0)
            throw new IllegalArgumentException();
        this.fr=fr;
        this.typ=typ;
    }

    void show(){
        if(czyUruchomiona)
            throw new IllegalStateException();

        if(typ==LICZBA_PIERWSZA){
            //wypisanie liczb pierwszych
        }
        else if(typ==LICZBA_NARCYSTYCZNA) {
            //wypisani liczb narcystycznych
        }
        else {
              //wypisanie wyrazów
        }
        czyUruchomiona=true;
    }
}
