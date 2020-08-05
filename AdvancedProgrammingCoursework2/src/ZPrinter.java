/*
The Z Printer class that produces the Z thread
 */
class ZPrinter extends Printer{
    public ZPrinter(Semaphore sem, Count c) {
        super("Z", sem, c);
    }
/*
The method that makes sure X always prints when it is less than the number of Y's and always that the number of X's and Y's
are always less than the number of W's
 */
    public boolean canPrint() {
        synchronized(c) {
            return c.y > c.z && (c.z+c.y) <= c.w;
        }
    }
    public void updateCount() {
        c.z++;
    }
}