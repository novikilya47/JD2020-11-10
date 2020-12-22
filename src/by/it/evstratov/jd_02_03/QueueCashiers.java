package by.it.evstratov.jd_02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueCashiers {

    private static final BlockingDeque<Cashier> openCashiers = new LinkedBlockingDeque<>();
    private static final BlockingDeque<Cashier> waitCashiers = new LinkedBlockingDeque<>();

    public static BlockingDeque<Cashier> getOpenCashiers() {
        return openCashiers;
    }

    public static BlockingDeque<Cashier> getWaitCashiers() {
        return waitCashiers;
    }
}
