package by.it.kglushchenko.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

//    public static void main(String[] args) {
//        for (int i = 0; i < 1000; i++) {
//            mainOne(args);
//        }
//    }

    public static void main(String[] args) {
        Dispatcher.buyersInMarket = 0;              // DANGER
        // Открыли магазин
        System.out.println("Market opened");

        // Создали список покупателей
        List<Buyer> buyers = new ArrayList<>();     // ArrayList не потокобезопасный но доступ к неиу только из потока main

        int n = 0;
        // время от 1 секунды до 120
        for (int t = 1; t <= 120; t++) {            // мат ожидание дает в среднем заход 120 человек
            // количество покупателей
            int count = Helper.getRandom(2);   // каждую секунду заходит 0 или 1 или 2 человека +
            for (int i = 1; i <= count; i++) {      //                                               |
                Buyer buyer = new Buyer(++n);       //                                               |
                buyers.add(buyer);                  // добавляем нового посетителя в коллекцию       |
                buyer.start();                      // cтартуем поток посетителя                     |
                //noinspection NonAtomicOperationOnVolatileField
                Dispatcher.buyersInMarket++;        //                                               |
            }                                       //                                               |
            Helper.sleep(1000);              //                                         <-----|
        }

        // чтобы магазин закрылся после последнего покупателя
        try {
            for (Buyer buyer : buyers) {
                buyer.join();                   // join-им Thread main-а ко всем потокам созданным покупателям
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        while (Dispatcher.buyersInMarket > 0) {     // пока в магазине кто-то есть ожидаем не теряя ни секунды
            Thread.yield();
        }

        System.out.println("Market closed");
    }
}
