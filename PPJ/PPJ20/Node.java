package com.company;

public class Node {
    Word word;
    Node nextboject;

    public Node(Word w){
        word=w;
        nextboject=null;
    }

    public Node(){
        word=null;
        nextboject=null;
    }
}
