package by.it.novik.jd02_01;

class Buyer extends Thread implements IBuyer {
    public Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();

        chooseGoods();

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
        System.out.println(this + " star choose");
        int time = Helper.getRandom(500, 2000);
        Helper.sleep(time);
        System.out.println(this + " end choose");
    }

    @Override
    public void goOut() {
        System.out.println(this + " leaved the market");
    }
}



