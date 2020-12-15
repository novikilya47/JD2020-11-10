package by.it.evstratov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {

        System.out.println("Marked opened");

        List<Buyer> buyers = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            Buyer buyer = new Buyer(i);
            buyers.add(buyer);
            buyer.start();
        }
        try {
            for (Buyer buyer : buyers) {
                buyer.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Marked closed");

    }

}
