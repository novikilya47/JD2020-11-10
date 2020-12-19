package by.it.kglushchenko.jd02_03;


class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean isRunnable;

    public void setRunneble(boolean runnable){
        this.isRunnable = runnable;
    }

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
    public void goToQueue() {
        QueueBuyers.add(this); // в очередь покупатель добавляет сам себя
        System.out.println(this+ " add to queue");
        // покупатель не должен занимать ресурсы процессора
        // можно перейти в состояние wait и ждать notify

        // в этой точке покупатель говорит что он перестает быть активным
        this.setRunneble(false);

        // метод wait нельзя вызвать пока мы не обладаем каким либо монитором
        // не все покупатели хотят стазу заснуть нужно ли им иметь один общий монитор?
        // не нужно
        // монитор нужен для того чтобы прислать notify
        // и у каждого покупателя он может быть свой собственный
        synchronized (this){
            // даем команду не покупателю а монитору
            // wait длится пока наш this не runnable
            while (!this.isRunnable)
            try {
                this.wait(); // пока кто-нибудь 1) не изменит isRunnable на true, 2) не пришлет notify
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this+ " left to queue");

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
