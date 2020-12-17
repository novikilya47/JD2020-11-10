package by.it.evstratov.jd02_02;

import java.util.ArrayList;

public class QueueCashiers {

    private static final ArrayList<Thread> deque = new ArrayList<>();


    static synchronized void add(Thread cashier){
        deque.add(cashier);
    }

    static synchronized int getSize(){
        return deque.size();
    }

    public static ArrayList<Thread> getDeque() {
        return deque;
    }
}
