package by.it.evstratov.jd_02_03;

import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    static Semaphore buyersChooseGoods = new Semaphore(20);
    static private final BlockingDeque<Basket> dequeBasket = new LinkedBlockingDeque<>(10);
    static final int K_SPEED = 100;
    static final int PLAN = 100;
    static final AtomicInteger buyersInMarket = new AtomicInteger(0);
    static final AtomicInteger buyersCompleted = new AtomicInteger(0);
    static final AtomicInteger total = new AtomicInteger(0);

    private static final Map<Integer, Boolean> numbers = new ConcurrentHashMap<>();

    static {
        numbers.put(1,true);
        numbers.put(2,true);
        numbers.put(3,true);
        numbers.put(4,true);
        numbers.put(5,true);

        for (int i = 0; i < 10; i++) {
            try {
                dequeBasket.putLast(new Basket());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void addBuyer(){
        buyersInMarket.getAndIncrement();
    }

    static void addTotal(int sum){
        total.addAndGet(sum);
    }

    static void completeBuyer(){
        buyersInMarket.getAndDecrement();
        buyersCompleted.getAndIncrement();
    }

    static boolean marketIsOpened(){
        return buyersInMarket.get() + buyersCompleted.get() < PLAN;
    }

    static boolean marketIsClosed(){
        return buyersCompleted.get() == PLAN;
    }

    static synchronized void openNeedCashiers(){

    }

    static int getNumberForCashier(){
        for (Map.Entry<Integer, Boolean> entry : numbers.entrySet()){
            if(entry.getValue()){
                entry.setValue(false);
                return entry.getKey();
            }
        }
        return 0;
    }

    static void clearNumberForCashier(int num){
        for (Map.Entry<Integer, Boolean> entry : numbers.entrySet()){
            if(entry.getKey() == num){
                entry.setValue(true);
            }
        }
    }

    public static int getTotal() {
        return total.get();
    }

    public static BlockingDeque<Basket> getBasket() {
        return dequeBasket;
    }
}
