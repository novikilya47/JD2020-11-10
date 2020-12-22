package by.it.evstratov.jd_02_03;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Cashier implements Runnable{

    private final int number;
    private static final AtomicInteger openCashiers = new AtomicInteger(0);
    static final Object lock = new Object();
    private final QueueBuyers queueBuyers;

    public Cashier(int number, QueueBuyers queueBuyers) {
        this.number = number;
        this.queueBuyers = queueBuyers;
        openCashiers.getAndIncrement();
    }

    @Override
    public void run() {
        System.out.println(this + "opened");

        while (!Dispatcher.marketIsClosed()){
            Buyer buyer = queueBuyers.extract();
            if(buyer != null){
                int t = Helper.getRandom(2000,5000);
                Helper.sleep(t);
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer){
                    printCheck(this,buyer);
                    buyer.setRunnable(true);
                    buyer.notify();
                }
            }else{
                try {
                    synchronized (this){
                        System.out.println(this + "закрывается - нет очереди");
                        QueueCashiers.getWaitCashiers().putLast(this);
                        QueueCashiers.getOpenCashiers().remove(this);
                        openCashiers.getAndDecrement();
                        while (true){
                            wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return "Cashier №" + number + " ";
    }

    public static int getOpenCashiers() {
        return openCashiers.get();
    }

    public int getNumber() {
        return number;
    }

    public void printCheck(Cashier cashier, Buyer buyer){
        synchronized (Cashier.lock){
            StringBuilder space = new StringBuilder();
            for (int i = 0; i < 40; i++) {
                space.append(".");
            }
            StringBuilder spaceLeft = new StringBuilder();
            StringBuilder spaceRight = new StringBuilder();
            for (int i = 0; i < cashier.getNumber()-1; i++) {
                spaceLeft.append(space);
            }
            for (int i = 0; i < 5-cashier.getNumber()-1; i++) {
                spaceRight.append(space);
            }
            spaceRight.append(" ");

            StringBuilder result = new StringBuilder();
            result.append(spaceLeft).append(cashier).append("started service for ").append(buyer).append("\n");
            int sumCheck = 0;
            List<Good> allGoodsInBasket = buyer.getBasket().getGoods();
            for (Good good : allGoodsInBasket) {
                result.append(spaceLeft).append(good.toString()).append("\n");
                sumCheck += good.getPrice();
            }
            Dispatcher.addTotal(sumCheck);
            result.append(spaceLeft).append("Сумма чека для ").append(cashier).append(" = ").append(sumCheck).append("\n");
            result.append(spaceLeft).append(cashier).append("finished service for ").append(buyer).append(spaceRight).append(Dispatcher.getTotal()).append(" ").append(queueBuyers.getSize()).append("\n");
            System.out.println(result);
        }
    }
}
