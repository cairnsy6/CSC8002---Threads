/*
The W printer class that produces the W thread
 */
class WPrinter extends Printer{
    public WPrinter(Semaphore sem, Count c) {
        super("W", sem, c);
    }
/*
The method that makes sure W can only print when it is equal to the number of X therefore it always goes first
 */
    public boolean canPrint() {
        synchronized(c) {
            if (c.x >= c.w) {
                return true;
            } else {
                return false;
            }
        }
    }
    public void updateCount() {
        c.w++;
    }
}