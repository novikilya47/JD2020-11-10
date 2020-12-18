package by.it.evstratov.jd02_02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dispatcher {

    static final Object lock = new Object();
    static final Object lockForTotal = new Object();
    static final int K_SPEED = 100;
    static final int PLAN = 100;
    volatile static int buyersInMarket = 0;
    volatile static int buyersCompleted = 0;
    volatile static int total = 0;

    private static final Map<Integer, Boolean> numbers = new HashMap<>();

    static {
        numbers.put(1,true);
        numbers.put(2,true);
        numbers.put(3,true);
        numbers.put(4,true);
        numbers.put(5,true);
    }

    static synchronized void addBuyer(){
        buyersInMarket++;
    }

    static synchronized void addTotal(int sum){
        total += sum;
    }

    static synchronized void completeBuyer(){
        buyersInMarket--;
        buyersCompleted++;
    }

    static boolean marketIsOpened(){
        return buyersInMarket+buyersCompleted < PLAN;
    }

    static boolean marketIsClosed(){
        return buyersCompleted == PLAN;
    }

    static synchronized void openNeedCashiers(){
        int max = 5;
        int openCashiers = Cashier.getOpenCashiers();
        int buyersInQueue = QueueBuyers.getSize();
        int needToOpenCashiers =(int) Math.ceil((double) buyersInQueue / 5.0);
        if(openCashiers < needToOpenCashiers){
            for (int i = 0; i < needToOpenCashiers - openCashiers; i++) {
                if(openCashiers < max){
                    int num = getNumberForCashier();
                    Cashier cashier = new Cashier(num);
                    Thread thread = new Thread(cashier, String.valueOf(num));
                    QueueCashiers.add(thread);
                    thread.start();
                }
            }
        }
    }

    static synchronized int getNumberForCashier(){
        for (Map.Entry<Integer, Boolean> entry : numbers.entrySet()){
            if(entry.getValue()){
                entry.setValue(false);
                return entry.getKey();
            }
        }
        return 0;
    }

    static synchronized void clearNumberForCashier(int num){
        for (Map.Entry<Integer, Boolean> entry : numbers.entrySet()){
            if(entry.getKey() == num){
                entry.setValue(true);
            }
        }
    }

    public synchronized static int getTotal() {
        return total;
    }

    public static synchronized void printInfo(Cashier cashier, Buyer buyer){
        synchronized (Dispatcher.lockForTotal){
            String spaceLeft = ".".repeat(40).repeat(cashier.getNumber()-1) + " ";
            String spaceRight = ".".repeat(40).repeat(5-cashier.getNumber()-1) + " ";
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
            result.append(spaceLeft).append(cashier).append("finished service for ").append(buyer).append(spaceRight).append(Dispatcher.getTotal()).append(" ").append(QueueBuyers.getSize()).append("\n");
            System.out.println(result);
        }
    }
}
