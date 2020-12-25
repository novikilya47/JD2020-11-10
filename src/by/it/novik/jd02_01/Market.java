package by.it.novik.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Buyer> buyers = new ArrayList<>();
        int n =0;
        for (int i = 1; i <=120 ; i++) {
            int count = Helper.getRandom(0,2);
            for (int j = 1; j <=count ; j++) {
                Buyer buyer = new Buyer(++n);
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
            e.printStackTrace();
        }
        System.out.println("Market closed");
    }
}
