package by.it.evstratov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {

        System.out.println("Marked opened");

        List<Buyer> buyers = new ArrayList<>();
        int n = 0;
        for (int t = 1; t < 120; t++) {
            int count = Helper.getRandom(2);
            for (int i = 1; i <= count; i++) {
                Buyer buyer = new Buyer(++n);
                if(Dispatcher.allBuyersInMarket % 4 == 0){
                    buyer.setPensioneer(true);
                }
                buyers.add(buyer);
                buyer.start();
                Dispatcher.buyersInMarket++;
                Dispatcher.allBuyersInMarket++;
                System.out.println(Dispatcher.allBuyersInMarket);
            }
            Helper.sleep(1000);
        }
        System.out.println(Dispatcher.allBuyersInMarket);
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
