package Task2;

public class Kitchen implements Runnable {

    Object lockKnife = new Object();
    Object lockBoard = new Object();

    public void doSalad() {
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

    public void doSandwiche() {
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
        while(true) {
            doSalad();
            doSandwiche();
        }
    }
}