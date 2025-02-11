package com.company;

public class Main {

    public static void main(String[] args) {
        Student a1=new Student(1,"A");
        Student b2=new Student(2,"B");
        Student c3=new Student(3,"C");

        MyStack stackk=new MyStack(2);
        stackk.push(a1);
        stackk.push(b2);
        //stackk.push(c3);
        stackk.pop().show();
        stackk.pop().show();
        stackk.pop().show();

        MyQueue q=new MyQueue();
        q.put("PSG");
        q.put("Atletico Madryt");
        q.put("Sporting CP");

        MyQueue q2=new MyQueue();
        q2.put("Manchesteer City");
        q2.put("Liverpool");
        q2.put("Ajax Amsrterdam");

        MyQueue nowaKolejka=new MyQueue();

        String a=q.get();
        String b=q2.get();
        while(a!=null && b!=null){
            nowaKolejka.put(a);
            nowaKolejka.put(b);
            a=q.get();
            b=q2.get();
        }

        String nowa=nowaKolejka.get();
        while (nowa!=null){
            System.out.print(nowa+" ");
            nowa=nowaKolejka.get();
            System.out.println(nowa);
            nowa=nowaKolejka.get();
        }

    }
}
