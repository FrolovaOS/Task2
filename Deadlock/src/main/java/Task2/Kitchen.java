package Task2;

import static java.lang.Thread.sleep;

public class Kitchen implements Runnable {

    Object lockKnife = new Object();
    Object lockBoard = new Object();

    public synchronized void doSalad() {
        synchronized (lockKnife) {
            System.out.println(Thread.currentThread().getName()
                    + " взяла нож");

            synchronized (lockBoard) {
                System.out.println(Thread.currentThread().getName()
                        + " взяла разделочную доску");
                System.out.println(Thread.currentThread().getName()
                        + " делает салат");
            }

        }
    }

    public synchronized void doSandwiche() {
        synchronized (lockBoard) {
            System.out.println(Thread.currentThread().getName()
                    + " взяла разделочную доску");
            synchronized (lockKnife) {
                System.out.println(Thread.currentThread().getName()
                        + " взяла нож");
                System.out.println(Thread.currentThread().getName()
                        + " делает бутерброды");
            }

        }
    }

    public void run() {
        int t = 0;
        while (t < 10) {
            doSalad();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doSandwiche();
            t++;
        }
    }
}