package by.it.kglushchenko.jd02_02;


class Buyer extends Thread implements IBuyer, IUseBasket {

    private static final boolean pensioneer = false;

    // Передаем в конструктор Имя посетителя
    public Buyer(int visitor_number) {
        super("Buyer " + visitor_number);
    }

    // Чтобы Buyer стал потоком ему нужно переопроеделить метод run()
    /**
     * If this thread was constructed using a separate
     * {@code Runnable} run object, then that
     * {@code Runnable} object's {@code run} method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of {@code Thread} should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        //super.run();
        //System.out.println(this + " do smth");
        enterToMarket();
        chooseGoods();
        goOut();
        Dispatcher.buyersInMarket--;
    }

    /**
     * Returns a string representation of this thread, including the
     * thread's name, priority, and thread group.
     *
     * @return a string representation of this thread.
     */
    @Override
    public String toString() {      // Здесь будем возвращать name
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int timeout = Helper.getRandom(500,2000);
        Helper.sleep(timeout);
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " left Market");
    }

    @Override
    public void takeBasket() {
        // взял корзину
    }

    @Override
    public void putGoodsToBasket() {
        //
    }
}
