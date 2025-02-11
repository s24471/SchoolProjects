package com.company;

import java.util.Locale;

abstract class Spiewak implements Comparable<Spiewak> {
    String nazwisko;
    static int nr =0;
    int index;

    public Spiewak(String nazwisko) {
        this.nazwisko = nazwisko;
        nr++;
        index = nr;
    }
    abstract protected String spiewaj();



    @Override
    public int compareTo(Spiewak y) {
        if(glosnosc(this)<glosnosc(y)) return 1;
        if(glosnosc(this)>glosnosc(y))return -1;
        if(this.nazwisko.compareTo(y.nazwisko)>0)return 1;
        if(this.nazwisko.compareTo(y.nazwisko)<0)return -1;
        if(this.index>y.index)return 1;
        if(this.index<y.index)return -1;
        return 0;
    }


    @Override
    public String toString() {
        return index + ". " +
                nazwisko + ": " +
                spiewaj() + " " + glosnosc(this);
    }
    static public int glosnosc(Spiewak sp){
        int ilosc =0;
        String n = sp.spiewaj().toLowerCase(Locale.ROOT);
        for (char i = 'a'; i<='z'; i++){
            boolean check = n.contains(""+i);
            if(check)ilosc++;
        }
        return ilosc;
    }
    static public Spiewak najglosniej(Spiewak[] sp)
    {
        int max=0;
        int numer=0;
        for(int i=0; i<sp.length; i++)
        {
            char[] tab=new char[sp[i].spiewaj().length()];
            int ilosc=0;
            String n=sp[i].spiewaj().toLowerCase();
            for (int j = 0; j < n.length(); j++) {
                char holder = n.charAt(j);
                boolean check = true;

                if(holder<'a'||holder>'z')check=false;

                for (int k = 0; k < ilosc; k++) {
                    if(tab[k]==holder)check=false;
                }
                if(check){
                    ilosc++;
                    tab[ilosc]=holder;
                }
            }
            if(ilosc>max){
                numer=i;
                max=ilosc;
            }
        }
        return sp[numer];
    }

}
