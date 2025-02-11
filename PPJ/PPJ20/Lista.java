package com.company;

public class Lista {
    Node start;
    //[]->[]->[]->[]
    public void add(Node n){
        Node curr=start;
        while (curr.nextboject!=null){
            curr=curr.nextboject;
        }
        curr.nextboject=n;

    }
}
