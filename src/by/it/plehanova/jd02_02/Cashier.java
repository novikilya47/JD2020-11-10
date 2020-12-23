package by.it.plehanova.jd02_02;

import java.util.ArrayList;

public class Cashier implements Runnable {
    private final int number;
    private static int count = 5;

    public Cashier(int number) {
        this.number = number;
        Dispatcher.addCashier();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.markedIsClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {

                System.out.println(this + "Started service for" + buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.sleep(t);
                printReceipt(buyer);
                System.out.println(this + "finished service for" + buyer);
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer) {
                    buyer.setRunnable(true);
                    buyer.notify();
                }

            } else {
                synchronized (Dispatcher.cashierMonitor) {
                    if (Dispatcher.getOpenCashier() == 1) {
                        try {
                            Dispatcher.closeCashier();
                            Dispatcher.cashierMonitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public synchronized void printReceipt(Buyer buyer) {

        ArrayList<Good> goods = buyer.getBasket().getGoodsInBasket();
        String nameOfGood;
        double priceOfGood;
        double totalSum = 0;
        System.out.printf("%25s\n", "---------------------");
        System.out.printf("%25s\n", "Receipt of " + buyer);
        System.out.printf("%25s\n", "---------------------");
        for (Good good : goods) {
            nameOfGood = good.getName();
            priceOfGood = good.getPrice();
            totalSum += priceOfGood;
            System.out.printf("%15s | %-3.2f\n", nameOfGood, priceOfGood);
        }
        System.out.printf("%25s\n", "---------------------");
        System.out.printf("%15s | %-3.2f\n", "total sum", totalSum);
        System.out.printf("%25s\n", "---------------------");
    }

    @Override
    public String toString() {
        return "\tCashier №" + number + " ";
    }
}
