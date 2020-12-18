package by.it.evstratov.jd02_02;

public class Dispatcher {

    static final int K_SPEED = 100;
    static final int PLAN = 100;
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

    static synchronized void openNeedCashiers(){
        int openCashiers = Cashier.getOpenCashiers();
        int buyersInQueue = QueueBuyers.getSize();
        int needToOpenCashiers =(int) Math.ceil((double) buyersInQueue / 5.0);
        if(openCashiers < needToOpenCashiers){
            for (int i = 0; i < needToOpenCashiers - openCashiers; i++) {
                if(openCashiers < 5){
                    Cashier cashier = new Cashier(QueueCashiers.getSize());
                    Thread thread = new Thread(cashier);
                    QueueCashiers.add(thread);
                    thread.start();
                }
            }
        }
    }
}
