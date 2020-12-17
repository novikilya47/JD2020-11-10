package by.it.evstratov.jd02_02;

public class Dispatcher {

    static final int K_SPEED = 100;
    static final int PLAN = 30;
    volatile static int buyersInMarket = 0;
    volatile static int buyersCompleted = 0;

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
}
