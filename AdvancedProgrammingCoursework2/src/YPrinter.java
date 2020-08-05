/*
The Y Printer class that produces the thread Y.
 */
class YPrinter extends Printer{
    public YPrinter(Semaphore sem, Count c) {
        super("Y", sem, c);
    }
/*
The method that makes sure Y always prints when it is equal to the number of X's and always that the number of X's and Y's
are always less than the number of W's
 */
    public boolean canPrint() {
        synchronized(c) {
            return c.z >= c.y && (c.y+c.z) <= c.w;
        }
    }
    public void updateCount() {
        c.y++;
    }
}