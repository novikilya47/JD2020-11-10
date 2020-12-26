package by.it.novik.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {
    public Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start choose");
        int time = Helper.getRandom(500, 2000);
        Helper.sleep(time);
        System.out.println(this + " end choose");
    }

    @Override
    public void goOut() {
        System.out.println(this + " leaved the market");
    }

    @Override
    public void takeBasket() {
        int time = Helper.getRandom(500, 2000);
        Helper.sleep(time);
        System.out.println(this + " take basket");
    }

    @Override
    public void putGoodsToBasket() {
        int time = Helper.getRandom(500, 2000);
        Helper.sleep(time);
        for (int i = 1; i < Helper.getRandom(2, 4); i++) {
            System.out.println(this + Good.randomGood());
        }
    }
}



