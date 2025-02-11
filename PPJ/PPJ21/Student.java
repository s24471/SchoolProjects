package com.company;

public class Student {
    int sNumber;
    String name;

    public Student(int sNumber, String name){
        this.sNumber=sNumber;
        this.name=name;
    }

    public void show(){
        System.out.println(sNumber+" "+name);
    }
}
