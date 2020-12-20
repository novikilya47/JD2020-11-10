package by.it.kglushchenko.jd02_02;

public class Cashier implements Runnable{

    private final int number;

    public Cashier(int number){
        this.number=number;
    }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println(this+ " opened");
        // do smth
        while (!Dispatcher.marketIsOpened())
        System.out.println(this+ " opened");
    }
}
