package by.it.plehanova.jd02_02;

import java.util.LinkedList;

public class QueueCashiers {
    private static final LinkedList<Cashier> listCashiers = new LinkedList<>();

    static {
        listCashiers.add(new Cashier(1));
        listCashiers.add(new Cashier(2));
        listCashiers.add(new Cashier(3));
        listCashiers.add(new Cashier(4));
        listCashiers.add(new Cashier(5));
    }
    static synchronized void add(Cashier cashier) {
        listCashiers.add(cashier);
    }

    static synchronized Cashier extract() {
        return listCashiers.poll();
    }

    public static LinkedList<Cashier> getListCashiers() {
        return listCashiers;
    }
}