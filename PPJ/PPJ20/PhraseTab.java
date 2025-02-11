package com.company;

public class PhraseTab {
    private Word[] words;
    int length;

    public PhraseTab(){
        words=new Word[50];
        length=0;
    }

    public void addWordAtEnd(Word w){
        if(length>=50){
            Word[] newtab=new Word[length+1];
            for (int i = 0; i < words.length; i++) {
                newtab[i]=words[i];
            }
            words=newtab;
        }
        words[length]=w;
        length++;
    }

    public void show(){
        for (int i = 0; i < length; i++) {
            words[i].show();
        }
    }

}
