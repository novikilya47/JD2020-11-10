package by.it.evstratov.jd_02_03;

import java.util.ArrayList;

public class QueueCashiers {

    private static final ArrayList<Thread> allCashiers = new ArrayList<>();

    static synchronized void add(Thread cashier){
        allCashiers.add(cashier);
    }

    static synchronized int getSize(){
        return allCashiers.size();
    }

    public static ArrayList<Thread> getAllCashiers() {
        return allCashiers;
    }
}
