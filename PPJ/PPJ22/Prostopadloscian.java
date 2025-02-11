public class Prostopadloscian extends Prostokat{
    private double wysokosc;

    public Prostopadloscian(double bok1,double bok2, double wysokosc){
        super(bok1,bok2);
        this.wysokosc=wysokosc;
    }

    public Prostopadloscian(Prostokat p, double wysokosc){
        super(p);
        this.wysokosc=wysokosc;
    }

    @Override
    public void showPole(){
        System.out.println(2*getBok1()*getBok2()+
                2*wysokosc*getBok2()+
                2*wysokosc*getBok1());
    }

    @Override
    public void showPO(){
        showPole();
        System.out.println(wysokosc*getBok1()*getBok2());
    }
}
