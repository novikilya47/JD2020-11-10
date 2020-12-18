package by.it.kglushchenko.jd02_02;

public class Dispatcher {
    final static int K_SPEED = 100000;
    final static int PLAN = 100000;

    volatile static int buyersInMarket = 0; // сколько человек в магазине
    volatile static int buyersCompleted = 0; // сколько человек в магазине

    static void addBuyer() {
        synchronized (Dispatcher.class) {
            buyersInMarket++;
        }
    }

    static synchronized void completeBuyer() {
        buyersInMarket--;
        buyersCompleted++;
    }

    static boolean marketIsOpened(){        // здесь можно не делать
        return buyersInMarket + buyersCompleted != PLAN;
    }

    static boolean marketIsClosed(){     // здесь можно не делать
        return buyersCompleted == PLAN;
    }
}
