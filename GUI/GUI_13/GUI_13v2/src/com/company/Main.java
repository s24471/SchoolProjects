package com.company;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        StringTask task = new StringTask("ABC", 50000);
        System.out.println("Task " + task.getState());
        task.start();
        if (args.length > 0 && args[0].equals("abort")) {

            Thread t = new Thread() {
                public void run() {
                    try {
                        Thread.sleep(10000);
                        task.abort();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        while (!task.isDone()) {
            Thread.sleep(500);
            switch (task.getState()) {
                case RUNNING:
                    System.out.print("R.");
                    break;
                case ABORTED:
                    System.out.println(" ... aborted.");
                    break;
                case READY:
                    System.out.println(" ... ready.");
                    break;
                default:
                    System.out.println("uknown state");
            }

        }
        System.out.println("Task " + task.getState());
        System.out.println(task.getTxt().length());
        System.out.println(task.getTxt().substring(0, task.getTxt().length()));
    }

}

