/**
 *
 *  @author Gocławski Filip S24471
 *
 */

package utp7_3;


import javax.swing.*;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    JList<Thread> arr = new JList<>();
    Letters letters = new Letters("ABCD");
    for (Thread t : letters.getThreads()) {
      arr.add(t);
      System.out.println(t.getName());
    }
    letters.start();/*<- tu uruchomić
         wszystkie kody w wątkach
     */

    Thread.sleep(5000);

    letters.stop();/*<- tu trzeba zapisać
       fragment, który kończy działanie kodów, wypisujących litery
    */
    System.out.println("\nProgram skończył działanie");
  }

}