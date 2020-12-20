package by.it.soldatenko.jd02_02;

public class WWW extends Thread{
    public volatile  static int number;

//    public WWW(int number) {
//        WWW.number =number;
//    }

    public WWW(int i){
    super("Buyer №" + i + " ");
    number=i;

}

    //int r =Thread.activeCount();
    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {

        Helper.sleep(1000);
        synchronized (qqq.rrr) {
        }
        System.out.println(this + "dododo" + number);
        qqq.EEE++;
    }
}
