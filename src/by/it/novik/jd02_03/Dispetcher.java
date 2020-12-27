package by.it.novik.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispetcher {
    final static int K_SPEED=10;
    final static int PLAN=100;
    private static final AtomicInteger buyersInMarket= new AtomicInteger(0);
    private static final AtomicInteger buyersCompleted=new AtomicInteger(0);

    public static void reset() {
        buyersCompleted.set(0);
        buyersInMarket.set(0);
    }

    static void addBuyer(){
        buyersInMarket.getAndIncrement();
    }

    static void completeBuyer(){
        buyersInMarket.getAndDecrement();
        buyersCompleted.getAndIncrement();
    }

    static boolean marketIsOpend(){
        return buyersInMarket.get()+buyersCompleted.get()!=PLAN;
    }
    static boolean marketIsClosed(){
        return buyersCompleted.get()==PLAN;
    }


}
