package by.it.novik.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class Good {

    private static HashMap <String, Integer> goods = new HashMap<>();

    static {
        goods.put("хлеб", 100);
        goods.put("молоко", 200);
        goods.put("рис", 300);
        goods.put("конфеты", 400);
        goods.put("сигареты", 500);
        goods.put("кофе", 600);
        goods.put("ананас", 700);
        goods.put("йогурт", 800);
    }

    public static String randomGood() {
        Random random = new Random();
        List <String> keys = new ArrayList<>(goods.keySet());
        String randomKey = keys.get(random.nextInt(keys.size()));
        int price = goods.get(randomKey);
        return (" put " + randomKey + " по цене " + price + " to basket");
    }

}
