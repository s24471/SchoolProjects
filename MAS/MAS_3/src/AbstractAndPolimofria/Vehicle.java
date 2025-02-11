package AbstractAndPolimofria;

abstract class Vehicle {
    abstract void startEngine();

    public void showType() {
        System.out.println("This is a vehicle.");
    }
}

class Car extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Car engine started.");
    }
}

class Motorcycle extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Motorcycle engine started.");
    }
}
