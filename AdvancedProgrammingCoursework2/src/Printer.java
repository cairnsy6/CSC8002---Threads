/*
The printer class acts as the controller for the Threads and decides when they are
printed and how often the letters are printed
 */
abstract class Printer extends Thread {
    private String text;
    private Semaphore sem;
    protected Count c;
/*
Above are the instance variables that make up the class
 */
    public Printer(String text, Semaphore sem, Count c){
        this.text = text;
        this.sem = sem;
        this.c = c;
    }
/*
Above is the printer class constructor that is made up of a String, a semaphore and the a count
 */
    abstract boolean canPrint();
    abstract void updateCount();
/*
The two methods that allow the threads to print and also update the count
 */
/*
Bellow is the method run that prints out the letters based on the conditions in the other classes
 */
    public void run() {
        while(true) {

            try {
                sem.P();

                if(canPrint()){
                    System.out.println(text);
                    updateCount();
                }
                sem.V();

                Thread.sleep(10);
            }
            catch (InterruptedException ex) {
                System.out.println("Interrupted");
            }
        }
    }
}