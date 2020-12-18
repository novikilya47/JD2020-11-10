package by.it.evstratov.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Dispatcher {

    static final int K_SPEED = 100;
    static final int PLAN = 100;
    volatile static int buyersInMarket = 0;
    volatile static int buyersCompleted = 0;

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
                    Cashier cashier = new Cashier(getNumberForCashier());
                    Thread thread = new Thread(cashier);
                    QueueCashiers.add(thread);
                    thread.start();
                }else{
                    //System.out.println("********************************Нет больше кассиров!****************************");
                    break;
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
}
