public class Drzewo {
    public Owoc zerwijOwoc(){
        double rand=Math.random()*3;
        if(rand<1) return new Jablko();
        else if(rand<2) return new Pomarancza();
        else return new Gruszka();
    }
}
