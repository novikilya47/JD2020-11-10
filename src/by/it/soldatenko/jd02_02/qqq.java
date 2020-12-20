package by.it.soldatenko.jd02_02;

public class qqq {
    public static final Integer rrr=0;
    public static Integer EEE=0;

    public static void main(String[] args) {

        for (int i = 0; i < 1000000; i++) {
            WWW www= new WWW(i);
            www.start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( 1000000 + " "+ EEE);
    }
}
