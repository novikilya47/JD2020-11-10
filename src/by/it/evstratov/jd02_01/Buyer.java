package by.it.evstratov.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket{

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

    }

    @Override
    public void putGoodsToBasket() {

    }
}
