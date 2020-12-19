package by.it.kglushchenko.jd02_03;

public class Dispatcher {
    final static int K_SPEED = 100000;
    final static int PLAN = 100;

    volatile static int buyersInMarket = 0; // сколько человек в магазине
    volatile static int buyersCompleted = 0; // сколько человек в магазине
    // суммарное количество покупетелей посетивших магазин = в магазине + кто вышел

    static void addBuyer() {
        synchronized (Dispatcher.class) {
            buyersInMarket++;
        }
    }

    static synchronized void completeBuyer() {
        buyersInMarket--;                // в магазине его уже нет, вычелся из магазина
        buyersCompleted++;               // количество завершенных покупателей инкрементируем
    }

    // как понять можно еще впускать покупателей или нет

    static boolean marketIsOpened(){
        // впускать в магазин я могу если количесто в магазине + вышедших из магазина < PLAN
        // переменные volatile, их нет в кэшах. можно без synchronized
        return buyersInMarket + buyersCompleted <= PLAN; // first - < PLAN // 2nd - !=
    }

    // одно поле, одно действие, synchronized можно не делать
    // сэкономим 300 тактов синхронизации, будет 1 такт чтения
    static boolean marketIsClosed(){     // здесь можно не делать
        return buyersCompleted == PLAN;
    }
}
