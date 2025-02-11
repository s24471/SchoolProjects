public class Owoc {
    private String name;
    private double weight;

    public Owoc(){
        weight=Math.random()*150+100;
    }

    public void setName(String name){this.name=name;}

    public String getName(){return name;}
    public double getWeight(){return weight;}
}
