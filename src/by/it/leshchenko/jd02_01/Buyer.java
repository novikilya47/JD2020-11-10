package by.it.leshchenko.jd02_01;

class Buyer extends Thread implements IBuyer {

    public Buyer(int i) {
        super("Buyer #" + i);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.getName() + " entered to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this.getName() + " started to choose goods");
        Helper.sleep(Helper.randomTime(ControlCentre.BUYER_CHOOSE_TIME_MIN, ControlCentre.BUYER_CHOOSE_TIME_MAX));
        System.out.println(this.getName() + " finished to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this.getName() + " go out");
    }
}