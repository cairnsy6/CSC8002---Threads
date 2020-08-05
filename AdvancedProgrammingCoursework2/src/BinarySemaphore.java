/*
The Binary Semaphore Class extends the Semaphore class and changes it into a binary one.
 */
public class BinarySemaphore extends Semaphore
{
/*
The method BinarySemaphore that takes into account inheritance from the Semaphore class with the super method
 */
    public BinarySemaphore(){
        super();
    }
/*
The below method makes sure that any letter amount may only be worth 0 or 1
 */
    public BinarySemaphore(int letter) {
        value = (letter >= 1) ? 1 : 0;
        }

/*
This makes the value 1 when signalling the method
 */
    public synchronized void V() {
        value = 1;
        notify();
    }
}
