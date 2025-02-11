
class A{//klasa A
    private int a;// prywatne pole klasy, widoczne tylko w klasie (nie można się do niego odwołać poza klasą A)
    public int b;//publiczne pole klasu, jest widoczne poza klasą A.

    public A(){ // konstruktor domyślny
        a=0;
    }

    public A(int a){ //konstruktor jednoagrumentowy
        this.a=a;//przypisanie do pola klasy o nazwie a, argumentu podanego w konstruktorze (o nazwie a)
    }

    void fun(){//funkcja bezargumentowa niestatyczna, istnieje tylko gdzy stworzy sięobiekt typu A
        System.out.println(a);
    }

    void fun(int a){ // funkcja PRZECIĄŻONA, ma taką samą nazwę i typ zwracany, lecz inne argumenty podane
        System.out.println(a+a);
    }

    static void fun2(){//funkcja bezargumentowa statyczna, istnieje ZANIM stworzy się obiekt typu A. Można w niej uzywać tylko statycznych pól i metod
        System.out.println("Statyczne");
    }

    int fun3(){//metoda zwracająca warość całkowitą
        return a;
    }

    void funREK(int a){//REKURENCYJNA metoda jednoargumentowa wypisująca wartość a, dopóki a jest większa od 10.
        if(a<=10) //warunek wyjścia z rekurencji
            return;
        System.out.println(a);
        funREK(--a); //wywołanie funkcji rekurencyjnej
    }
}

class B extends A{//klasa B dziedziczy po klasie A
    double b;

    public B(int a,double b){
        super(a);
        this.b=b;
    }

    @Override //nadpisanie metody istniejącej w klase A
    void fun(){
        super.fun(); // wywołanie metody z klasy dziedziczonej
        System.out.println(b);
    }
}

public class Powtorzenie {
    public static void main(String[] args) {
        A.fun2(); // wywołanie metody statycznej

        A newVar=new A();//wywołanie konstruktora domyślnego
        A a2=new A(2);//wywołanie konstruktora jenoargumentowego
        //a2.a=2 - próba wywołania pola prywatnego a - nie działa
        newVar.b=3; // wywołanie pola publicznego
        newVar.funREK(19); //wywołanie metody rekurencyjnej
        newVar.fun(); //wywołanie metody niestatycznej
        newVar.fun(10); //wywołanie metody przeciążonej
        int newA=newVar.fun3(); //przypisanie do warości newA, liczby zwróconej przez metodę fun3


        B b = new B(1,2);
        b.fun(); //wywołanie nadpisanej metody
    }
}
