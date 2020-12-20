package by.it.plehanova.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Buyer> buyers = new ArrayList<>();

        int n = 0;
        int range = 30; //диапазон покупателей (амплитуда)
        for (int t = 1; t < 120; t++) {
            int buyersExpectedInMarket = Math.abs(Math.abs(t - 2*range) - 2*range) + 10;
            int count = buyersExpectedInMarket - Dispatcher.getBuyersInMarket();
            for (int i = 0; i <Helper.getRandom(count); i++) {
                Buyer buyer = new Buyer(++n);
                if (Dispatcher.getAllBuyers() % 4 == 0) {
                    buyer.setPensioner(true);
                }
                buyers.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        try {
            for (Buyer buyer : buyers) {
                buyer.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Market closed");

    }
}

