/*
The XPrinter class that produces the thread X
 */
class XPrinter extends Printer{
    public XPrinter(Semaphore sem, Count c) {
        super("X", sem, c);
    }
/*
The method below determines the conditions set out in the coursework that X must be printed after W
 */
    public boolean canPrint() {
        synchronized(c) {
            if(c.w > c.x){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public void updateCount() {
        c.x++;
    }
}