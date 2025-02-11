package com.company;

public class Main {

    public static void main(String[] args) {
        String a;
        getPerm(new int[]{1,2,3},0,2);
        Test t=new Test();
        Test t2=new Test(3,4.2);
        t.testowa=0;
        t.alterPrywatna(3.14);
        System.out.println(t2.testowa);

        Person person=new Person();
        person.name="Giovanni";
        person.surname="Krolock";
        person.birtYear=1789;

        Fruit f=new Fruit("orange");
        f.show();

        Donkey d=new Donkey(6);
        d.addBaloon(new Baloon());
        d.addBaloon(new Baloon());

        if(d.isFlying()) System.out.println("Ja latam!");
    }

    public static void swap(int []tab,int source, int destination){
        int tmp=tab[source];
        tab[source]=tab[destination];
        tab[destination]=tmp;
    }


//    123 -> 213 -> 312
//    123 -> 321
    public static void getPerm(int [] number,int idStart, int idEnd){
        if(idEnd==idStart){
            for (int i = 0; i < number.length; i++) {
                System.out.print(number[i]);
            }
            System.out.println();
        }else{
            for (int i = idStart; i <= idEnd; i++) {
                swap(number,idStart,i);
                getPerm(number,idStart+1,idEnd);
                swap(number,i,idStart);
            }
        }
    }

//    6 2 9 0 1
//    2 6 0 1 | 9
//    2 0 1 | 6 9

    public static void sortBubble(int [] tab){
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length-1-i; j++) {
                if(tab[j]>tab[j+1]) swap(tab,j,j+1);
            }
        }
    }
    public static  void bubbleRek(int []tab, int maxId){
        if(maxId==1) return;

        for (int i = 0; i < maxId-1; i++) {
            if(tab[i]>tab[i+1]) swap(tab,i,i+1);
        }
        bubbleRek(tab,maxId-1);
    }

}
