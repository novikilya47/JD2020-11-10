package by.it.evstratov.jd02_02;

import java.util.List;

public class Cashier implements Runnable{

    private final int number;
    private volatile static int openCashiers = 0;
    private static final Object lock = new Object();

    public Cashier(int number) {
        this.number = number;
        addCashier();
    }

    private static void addCashier(){
        synchronized (Cashier.class){
            openCashiers++;
        }
    }

    @Override
    public void run() {
        System.out.println(this + "opened");

        while (!Dispatcher.marketIsClosed()){
            Buyer buyer = QueueBuyers.extract();
            if(buyer != null){
                int t = Helper.getRandom(2000,5000);
                Helper.sleep(t);
                System.out.println(this + "started service for " + buyer);
                int sumCheck = 0;
                List<Good> allGoodsInBasket = buyer.getBasket().getGoods();
                for (Good good : allGoodsInBasket) {
                    System.out.printf("   %s\n", good.toString());
                    sumCheck += good.getPrice();
                }
                System.out.printf("   Сумма чека для %s = %d\n",buyer, sumCheck);
                System.out.println(this + "finished service for " + buyer);

                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer){
                    buyer.setRunnable(true);
                    buyer.notify();
                }
            }else{
                synchronized (lock){
                    if(openCashiers == 1){
                        for (int i = 0; i < QueueCashiers.getAllCashiers().size(); i++) {
                            if(QueueCashiers.getAllCashiers().get(i).getName().equals(number+"")){
                                System.out.println("Единственная открытая касса " + QueueCashiers.getAllCashiers().get(i).getName());
                                synchronized (this){
                                    try {
                                        wait();
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }
                        }
                    }else{
                        openCashiers--;
                        Dispatcher.clearNumberForCashier(number);
                        System.out.println(this + "закрывается. Осталось открытых касс - "+openCashiers);
                        break;
                    }
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
        synchronized (Cashier.class){
            return openCashiers;
        }
    }
}
