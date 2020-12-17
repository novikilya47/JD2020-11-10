package by.it.leshchenko.jd02_01;

import java.util.Random;

class Helper {
    final static Random random = new Random();

    public static int randomBuyers(int max) {
        return random.nextInt(max + 1);
    }

    static int randomTime(int min, int max) {
        return random.nextInt((max - min + 1) + min);
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/ControlCentre.MARKET_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
