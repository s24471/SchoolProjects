package com.company;

public class Main {

    public static void main(String[] args) {
        Osoba o1=new Osoba("A",1991);
        Osoba o2=new Osoba("B",1981);
        Osoba o3=new Osoba("C",2002);
        Osoba o4=new Osoba("D",1978);
        Osoba[] os=new Osoba[]{o1,o2,o3,o4};

        for (int i = 0; i < os.length; i++) {
            for (int j = i; j < os.length; j++) {
                Osoba starsza=Osoba.zwrocStarszaOsobe(os[i],os[j]);
                if(starsza==os[j]){
                    os[j]=os[i];
                    os[i]=starsza;
                }
            }
        }

        for (int i = 0; i < os.length; i++) {
            System.out.println(os[i].zwrocImie());
        }

        PhraseList p=new PhraseList();
        Word w1=new Word();
        w1.addChar('a');
        Word w2=new Word();
        w2.addChar('b');
        p.addWordAtEnd(w1);
        p.addWordAtEnd(w2);
        p.show();

        //[a]->[b]->
    }
}
