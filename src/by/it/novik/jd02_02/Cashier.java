package by.it.novik.jd02_02;

public class Cashier implements Runnable{

    private final int number;

    public Cashier(int number){
        this.number=number;
    }

    @Override
    public String toString() { return "Cashier № " + number + " "; }

    @Override
    public void run() {
        System.out.println(this+"opened");
        while (!Dispetcher.marketIsClosed()){
            Buyer buyer = QueueBuyers.extract();
            if (buyer!=null){
                System.out.println(this+" started service for "+buyer);
                int t=Helper.getRandom(2000, 5000);
                Helper.sleep(t);
                System.out.println(this+" finished service for "+buyer);
                synchronized (buyer){
                    buyer.setRunnable(true);
                    buyer.notify();
                }
            }else{
                Helper.sleep(1);
            }
        }
        System.out.println(this+"closed");
    }
}
