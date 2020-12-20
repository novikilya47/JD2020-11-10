package by.it.kglushchenko.jd02_03;


class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean isRunnable;

    private final QueueBuyers queueBuyers;

    private boolean isPensioneer;

    private Basket basket;

    public void setRunnable(boolean runnable) {
        this.isRunnable = runnable;
    }

    private static final boolean pensioneer = false;

    // Передаем в конструктор Имя посетителя и очередь
    public Buyer(int visitor_number, QueueBuyers queueBuyers) {
        super("Buyer " + visitor_number);
        this.queueBuyers = queueBuyers; // добавляем покупателя в очередь
        Dispatcher.addBuyer();
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
     */
    @Override
    public void run() {

        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        Dispatcher.completeBuyers();
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
        System.out.println(this + " started choose goods");
        int k = 1;
        if (buyerIsPensioneer()) {
            k = Helper.getRandom(1, 2); // коэффициент пенсионера, в среднем 1,5
        }
        Helper.sleepRandom(500 * k, 2000 * k); // выбирает товар
        System.out.println(this + " finished choose goods");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " goes to queue");
        // метод wait нельзя вызвать пока мы не обладаем каким либо монитором
        // не все покупатели хотят стазу заснуть
        // нужно ли им иметь один общий монитор? не нужно
        // монитор нужен для того чтобы прислать notify
        // и у каждого покупателя он может быть свой собственный
        synchronized (this) {
            // в очередь покупатель добавляет сам себя
            queueBuyers.add(this);
            // покупатель не должен занимать ресурсы процессора
            // можно перейти в состояние wait и ждать notify
            // в этой точке покупатель говорит что он перестает быть активным
            this.setRunnable(false);
            // даем команду не покупателю а монитору
            // wait длится пока наш this не runnable
            while (!this.isRunnable)
                try {
                    this.wait();        // пока кто-нибудь 1) не изменит isRunnable на true, 2) не пришлет notify
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println(this + " left to queue");
    }

    public Object getMonitor() {
        return this;
    }

    @Override
    public void goOut() {
        System.out.println(this + " left Market");
    }

    @Override
    public boolean buyerIsPensioneer() {
        return this.isPensioneer;
    }

    @Override
    public void setPensioneer(boolean state) {
        this.isPensioneer = state;
    }

    @Override
    public void takeBasket() {
        // взял корзину
        System.out.println(this + " takes a basket");
        basket = new Basket();
    }

    @Override
    public void putGoodsToBasket() {
        int thisBuyerGoodsCount = Helper.getRandom(1, 4); // покупатель выбирает от 1 до 4 товаров
        for (int i = 0; i < thisBuyerGoodsCount; i++) {
            int itemIndex = Helper.getRandom(0, Market.goods.size() - 1);
            Good item = Market.goods.get(itemIndex);


            int k = 1;
            if (buyerIsPensioneer()) {
                k = Helper.getRandom(1, 2); // коэффициент пенсионера, в среднем 1,5
            }
            Helper.sleepRandom(500 * k, 2000 * k); // берет товар

            basket.add(item, 1);

            System.out.println(this + " has put " + item.getName() + " into the basket");
        }
        System.out.println(this + " has finished putting goods into the basket");
    }
}
