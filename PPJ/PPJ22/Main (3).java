//A->B
class A{
    private int a;

    public A(int a){
        this.a=a;
    }
    void fun(){
        System.out.println(a);
    }
}
class B extends A{
    double b;

    public B(int a, double b){
        super(a);//wywołanie konstruktora z klasy A
        this.b=b;
    }
    void f2(){
        System.out.println("Hello");
    }

    @Override
    void fun(){
        super.fun();
        System.out.println(b);
    }

    @Override
    public String toString(){
        return "B-"+b;
    }
}

public class Main {
    public static void main(String[] args) {
        B b=new B(2,3);
        A a=new A(4);
        //a.f2();
        System.out.println(b);

        Prostopadloscian p1=new Prostopadloscian(2,3,4);
        Prostopadloscian p2=new Prostopadloscian(new Prostokat(2,3),4);

    }
}
