package by.it.soldatenko.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Cashier implements Runnable {
    private final int number;


    public Cashier(int number) {
        this.number = number;
    }


    public static String[] setS = new String[2];

    @Override
    public void run() {
        System.out.println(this + "opened");
        // 2.07.20
        while (!Dispetcher.marketIsClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + "started service for " + buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.sleep(t);
                HashMap<String, Integer> set = new HashMap<>();
                set = Basket.getBasket();
                int sum = 0;
                for (Map.Entry entry : set.entrySet()) {
                    System.out.println(this + " " + entry.getKey() + " by price " + entry.getValue() + " " + buyer);
                    sum = sum + (int) entry.getValue();
                }
                System.out.println(this + " recipe " + sum + " " + buyer);
                System.out.println(this + "finished service for " + buyer);
                synchronized (buyer) {
                    buyer.setRunnable(true);
                    buyer.notify();
                }
            } else {
                //2.42.0
                Helper.sleep(1);
            }
        }
        System.out.println(this + "closed");
    }

    public String toString() {
        return "Cashier №" + number + " ";
    }
}
