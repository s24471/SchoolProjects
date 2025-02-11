package com.company;

public class MyQueue {
    ElString start;

    public MyQueue(){
        start=null;
    }

//    []->[]->[]->
    public void put(String s){
        if(start==null){
            start=new ElString(s);
        }else{
            ElString curr=start;
            while (curr.next!=null){
                curr=curr.next;
            }
            curr.next=new ElString(s);
        }
    }

    public String get(){
        if(start!=null) {
            String stringStart = start.text;
            start = start.next;
            return stringStart;
        }return null;
    }
}
