/*
The main class that takes into account the four threads by using two binary semaphores to print the letters out based
on the conditions set out in the other classes.
 */
public class Main {
    public static void main (String[] args) {
        BinarySemaphore semaphoreX = new BinarySemaphore(1);
        BinarySemaphore semaphoreY = new BinarySemaphore(1);

        new Thread(() -> {

        }).start();

        Thread thread = new Thread(() -> {
            Count c = new Count();
/*
The count is initially set to 0 for all and the Semaphore to 1. As the threads are printer and the Semaphore
switches between 1 and 0 the count of each thread goes up to give a final count at the end.
 */
            Printer w = new WPrinter(semaphoreX, c);
            Printer x = new XPrinter(semaphoreX, c);

            Printer y = new YPrinter(semaphoreY, c);
            Printer z = new ZPrinter(semaphoreY, c);

            w.start();
            x.start();
            y.start();
            z.start();
/*
The thread stops after 5000 milliseconds
 */
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

            w.stop();
            x.stop();
            y.stop();
            z.stop();

            System.out.println("X: " + c.x + "; W: " + c.w + "; Y: " + c.y + "; z: " + c.z);
        });


        try {
            thread.start();
            thread.join();
        }
        catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
    }
}