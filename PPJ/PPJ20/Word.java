package com.company;

public class Word {
    private char[] characters;
    int length;

    public Word(){
        characters=new char[100];
        length=0;
    }

    public void addChar(char c){
        characters[length]=c;
        length++;
    }

    public void show(){
        for (int i = 0; i < length; i++) {
            System.out.print(characters[i]);
        }
    }

    public int length(){return length;}

}
