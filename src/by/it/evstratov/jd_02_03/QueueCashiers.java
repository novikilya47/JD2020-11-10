package by.it.evstratov.jd_02_03;

import java.util.concurrent.CopyOnWriteArrayList;

public class QueueCashiers {

    private static final CopyOnWriteArrayList<Cashier> allCashiers = new CopyOnWriteArrayList<>();

    static void add(Cashier cashier){
        allCashiers.add(cashier);
    }

    public static CopyOnWriteArrayList<Cashier> getAllCashiers() {
        return allCashiers;
    }

}
