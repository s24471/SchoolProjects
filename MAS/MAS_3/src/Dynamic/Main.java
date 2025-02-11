package Dynamic;

interface Behavior {
    void perform();
}

class AggressiveBehavior implements Behavior {
    @Override
    public void perform() {
        System.out.println("Performing aggressive behavior.");
    }
}

class DefensiveBehavior implements Behavior {
    @Override
    public void perform() {
        System.out.println("Performing defensive behavior.");
    }
}

class PassiveBehavior implements Behavior {
    @Override
    public void perform() {
        System.out.println("Performing passive behavior.");
    }
}

class Context {
    private Behavior behavior;

    public Context(Behavior behavior) {
        this.behavior = behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public void performBehavior() {
        behavior.perform();
    }
}

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new AggressiveBehavior());
        context.performBehavior();  // Wykonuje zachowanie agresywne

        context.setBehavior(new DefensiveBehavior());
        context.performBehavior();  // Wykonuje zachowanie obronne

        context.setBehavior(new PassiveBehavior());
        context.performBehavior();  // Wykonuje zachowanie pasywne
    }
}
