package by.it.novik.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {
    public static void main(String[] args) {
        Dispetcher.reset();
        QueueBuyers queueBuyers=new QueueBuyers(30);
        System.out.println("Market opened");
        ExecutorService threadCashier = Executors.newFixedThreadPool(5);
        for (int i = 1; i <=2 ; i++) {
            Cashier cashier = new Cashier(i, queueBuyers);
            threadCashier.execute(cashier);
        }

        int n =0;
        while (Dispetcher.marketIsOpend()) {
            int count = Helper.getRandom(0,2);
            for (int j = 1; j <=count && Dispetcher.marketIsOpend(); j++) {
                Buyer buyer = new Buyer(++n, queueBuyers);
                buyer.start();
            }
            Helper.sleep(1000);
        }

        threadCashier.shutdown();
        for (;;) {
            try {
                if (threadCashier.awaitTermination(10, TimeUnit.DAYS)){
                    break;
                  }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Market closed");
    }
}
