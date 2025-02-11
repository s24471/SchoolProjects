package com.company;

public class Test {
    int testowa;
    private double prywatna;

    public Test(){
        testowa=0;
        prywatna=0;
    }
    public Test(int a, double b){
        prywatna=b;
        testowa=a;
    }

    public void alterPrywatna(double p) {
        prywatna = p;
        System.out.println(prywatna);
    }

}
