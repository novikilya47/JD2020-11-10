package by.it.plehanova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <=2 ; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
        int n = 0;
        int range = 30;
        int t = 1;
        while (Dispatcher.marketIsOpened()){
            int buyersExpectedInMarket = Math.abs(Math.abs(t - 2 * range) - 2 * range) + 10;
            int count = Helper.getRandom(buyersExpectedInMarket - Dispatcher.getBuyersInMarket());
            for (int i = 1; i <= count && Dispatcher.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++n);
                if (Dispatcher.getAllBuyers() % 4 == 0) {
                    buyer.setPensioner(true);
                }
                threads.add(buyer);
                buyer.start();
            }
            t++;
            Helper.sleep(1000);
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Market closed");

    }
}

