package by.it.evstratov.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {

        System.out.println("Marked opened");

        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i < 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        int n = 0;
        int expectedNumberBuyers = 0;
        for (int t = 0; t < 120; t++) {
            expectedNumberBuyers = Math.abs((t-(t/30)*30) - 30 * ((t/30) % 2)) + 10;
            int count = Helper.getRandom((expectedNumberBuyers - Dispatcher.buyersInMarket));
            for (int i = 1; i <= count; i++) {
                Buyer buyer = new Buyer(++n);
                if(Dispatcher.buyersCompleted % 4 == 0){
                    buyer.setPensioneer(true);
                }
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
            throw new RuntimeException(e);
        }
        System.out.println("Marked closed");

    }

}
