package by.it.soldatenko.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
//    static int quantityOut = 0;
//    static int quantityIn = 0;

    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
        int n = 0;
//        int x = 2;
//        int p = 0;
        for (; Dispetcher.marketIsOpened(); ) {
//            double sin = Math.sin(Math.toRadians(t * 6));
//            if (sin > 0) {
//                p++;
//            }
//            if (sin < 0) {
//                p--;
//            }
//            int nN = quantityIn - quantityOut;
//            if (nN < p + 10) {
//                x = 10;
//            }//
//            if (nN > p + 10) {
//                x = 0;
//            }
//            System.out.println(p + " " + t + " nN " + nN + " " + x);
            int count = Helper.getRandom(2);
            for (int i = 1; i <= count && Dispetcher.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++n);
                threads.add(buyer);
                buyer.start();
//                Dispetcher.addBuyer(); //под вопросом
            }
            Helper.sleep(1000 / Dispetcher.K_SPEED);
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" Market closed");
//        System.out.println("customers " + n);
    }
}