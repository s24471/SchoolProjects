package Overlapping;

interface Movable {
    void move();
}

interface Controllable {
    void control();
}

class Robot implements Movable, Controllable {
    @Override
    public void move() {
        System.out.println("Robot is moving.");
    }

    @Override
    public void control() {
        System.out.println("Controlling the robot.");
    }
}
