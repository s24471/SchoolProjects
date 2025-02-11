package com.company;

import java.io.InputStream;

public class MojSkaner {
    private InputStream skaner;

    public MojSkaner(InputStream skaner){
        this.skaner=skaner;
    }

    public String odczytajSlowo(){
        int znak=0;
        String napis="";
        try {
            while ((znak=skaner.read())>' '){
                napis+=(char)znak;
            }
        }catch (Exception e){}
        return napis;
    }
    public String odczytajLinie(){
        int znak=0;
        String napis="";
        try {
            while ((znak=skaner.read())!='\n'){
                napis+=(char)znak;
            }
        }catch (Exception e){}
        return napis;
    }
    public int odczytajLiczbeCalkowita() throws Exception{
        String liczba = odczytajSlowo();
        char znaki[]=liczba.toCharArray();
        boolean czyJestLiczba=true;
        if(znaki[0]=='-' || znaki[0]<='9' && znaki[0]>='0') {
            for (int i = 1; i < znaki.length; i++) {
                if (znaki[i] <= '9' && znaki[i] >= '0')
                    czyJestLiczba = true;
                else
                    czyJestLiczba = false;
            }
        }

        if(czyJestLiczba)
            return Integer.parseInt(liczba);
        else
            throw new Exception("Wartosc nie jest liczbą");
    }
    int odczytajDodatniaLiczbeCalkowita() throws Exception{
        int liczba=odczytajLiczbeCalkowita();
        if(liczba>=0)
            return liczba;
        else
            throw new Exception("Liczba nie jest dodatnia");
    }

}
