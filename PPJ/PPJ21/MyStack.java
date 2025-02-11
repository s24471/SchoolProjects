package com.company;

public class MyStack {
    Element start;
    int maxElem;
    int currElem;

    public MyStack(int maxElem){
        start=null;
        this.maxElem=maxElem;
        currElem=0;
    }

    public void push(Student s){
        if(currElem<maxElem) {
            if (start == null) {
                start = new Element(s);
                currElem++;
            } else {
                Element curr = start;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = new Element(s);
                currElem++;
            }
        }else {
            System.out.println("nie mozna wstawic elemntu do stosu.");
        }
    }
    //[]->[]->
    public Student pop(){
        if(currElem>0) {
            Element curr = start;
            Element prev = start;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            Student s = curr.student;
            curr = null;
            prev.next = null;
            currElem--;
            return s;
        }
        System.out.println("Nie ma obiktow w stosie");
        return new Student(0,"0");
    }
}
