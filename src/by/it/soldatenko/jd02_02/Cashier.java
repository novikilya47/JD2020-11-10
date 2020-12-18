package by.it.soldatenko.jd02_02;

public class Cashier implements Runnable {
    private final int number;

    public Cashier(int number) {
        this.number = number;
    }


    @Override
    public void run() {
        System.out.println(this+"opened");
        // 2.07.20
        while (!Dispetcher.marketIsClosed()){
            Buyer buyer = QueueBuyers.extract();
            if (buyer!=null){
                System.out.println(this+"started service for"+buyer);
                int t =Helper.getRandom(2000,5000);
                Helper.sleep(t);
                System.out.println(this+"finished service for"+buyer);
            synchronized (buyer){
                buyer.setRunnable(true);
                buyer.notify();
            }
            }else{
                //2.42.0
                Helper.sleep(1);
            }
        }
        System.out.println(this+"closed");
    }
    public String toString(){
        return "Cashier №"+ number+" ";
    }
}
