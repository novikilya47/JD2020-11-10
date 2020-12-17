package by.it.evstratov.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueCashiers {

    private static final Deque<Cashier> deque = new ArrayDeque<>();

    static synchronized void add(Cashier cashier){
        deque.addLast(cashier);
    }

    static synchronized Cashier extract(){
        return deque.pollFirst();
    }

    static synchronized int getSize(){
        return deque.size();
    }

}
