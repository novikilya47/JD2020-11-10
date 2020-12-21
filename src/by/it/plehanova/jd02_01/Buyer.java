package by.it.plehanova.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {
    private Basket basket = new Basket();
    private boolean pensioner;

    public Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.enter();
    }

    public boolean isPensioner() {
        return pensioner;
    }

    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
        Dispatcher.goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " Started choose goods");
        for (int i = 1; i < Helper.getRandom(1, 4); i++) {
            putGoodsToBasket();
            double timeout = Helper.getRandom(500, 2000);
            if (this.isPensioner()) {
                timeout = timeout * 1.5;
            }
            Helper.sleep((int) timeout);
        }
        System.out.println(this + " finished choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " leaves the Market");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " take a basket");

    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " put a good in the basket");
        Good good = ListGoods.randomGood();
        basket.putGoods(good);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
