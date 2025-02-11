package utp7_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class Letters {
    List<Future> arr;

    public Letters(String n) {
        this.arr = new ArrayList<>();
        for (char a : n.toCharArray()) {
            Future tmp = new Future(new my(a));
            tmp.setName("Thread " + a);
            arr.add(tmp);
        }
    }
    public List<Future> getThreads(){
        return arr;
    }
    public void start(){
        for (Thread t:arr) {
            t.start();
        }
    }
    public void stop(){
        for (Thread t:arr) {
            t.stop();
        }
    }

}
class my implements Runnable {
    char n;
    boolean work;

    public my(char n) {
        this.n = n;
        work = true;
    }

    @Override
    public void run() {
        while (work) {
            System.out.print(n);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop() {
        work = false;
    }
}
