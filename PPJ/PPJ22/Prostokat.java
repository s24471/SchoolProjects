public class Prostokat {
    private double bok1;
    private double bok2;

    public Prostokat(double bok1, double b){
        this.bok1=bok1;
        bok2=b;
    }

    public Prostokat(Prostokat  p){
        bok1=p.bok1;
        bok2=p.bok2;
    }

    public void showPole(){
        System.out.println(bok1*bok2);
    }

    public void showPO(){
        showPole();
        System.out.println(bok1*bok2*0);
    }

    public double getBok1() {
        return bok1;
    }

    public double getBok2(){
        return bok2;
    }
}
