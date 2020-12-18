package by.it.evstratov.jd02_02;

import java.util.List;

public class Cashier implements Runnable{

    private final int number;
    private volatile static int openCashiers = 0;

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
                for (int i = 0; i < allGoodsInBasket.size(); i++) {
                    System.out.printf("   %s\n",allGoodsInBasket.get(i).toString());
                    sumCheck += allGoodsInBasket.get(i).getPrice();
                }
                System.out.printf("   Сумма чека для %s = %d\n",buyer, sumCheck);
                System.out.println(this + "finished service for " + buyer);

                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer){
                    buyer.setRunnable(true);
                    buyer.notify();
                }
            }else{
                //System.out.println(QueueCashiers.getSize());
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
