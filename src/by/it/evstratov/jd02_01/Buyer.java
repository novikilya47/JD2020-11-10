package by.it.evstratov.jd02_01;


class Buyer extends Thread implements IBuyer, IUseBasket{

    private Basket basket;

    public Buyer(int number){
        super("Buyer №"+number);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choose goods");
        int timeOut = Helper.getRandom(500,2000);
        putGoodsToBasket();
        Helper.sleep(timeOut/Dispatcher.K_SPEED);
        System.out.println(this + " finish choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " left to market");
        Dispatcher.buyersInMarket--;
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " take a basket");
        this.basket = new Basket();
    }

    @Override
    public void putGoodsToBasket() {
        for (int i = 1; i <= 4; i++) {
            int timeOut = Helper.getRandom(500,2000);
            Helper.sleep(timeOut/Dispatcher.K_SPEED);
            Good good = Good.takeRandomGood();
            System.out.println(this + " put in basket "+good.getName());
            this.basket.put(good);
        }
    }
}
