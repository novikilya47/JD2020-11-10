package by.it.novik.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        Dispetcher.reset();
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <=2 ; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
        int n =0;
        while (Dispetcher.marketIsOpend()) {
            int count = Helper.getRandom(0,2);
            for (int j = 1; j <=count && Dispetcher.marketIsOpend(); j++) {
                Buyer buyer = new Buyer(++n);
                threads.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Market closed");
    }
}
