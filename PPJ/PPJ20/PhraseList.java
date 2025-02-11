package com.company;

public class PhraseList {
    Node start;

    public PhraseList(){
        start=new Node();
    }

    public void addWordAtEnd(Word w){
        if(start.word==null){
            start.word=w;
        }else {
            Node current=start;
            while (current.nextboject!=null){
                current=current.nextboject;
            }
            current.nextboject=new Node(w);
        }
    }

    public void show(){
        Node current=start;
        while (current.nextboject!=null){
            current.word.show();
            System.out.print(" ");
            current=current.nextboject;
        }
        current.word.show();
    }
}
