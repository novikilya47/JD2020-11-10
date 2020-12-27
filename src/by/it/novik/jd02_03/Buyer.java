package by.it.novik.jd02_03;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean isRunnable;

    private QueueBuyers queueBuyers;

    public void setRunnable(boolean runnable) {
        this.isRunnable = runnable;
    }

    public Buyer(int number, QueueBuyers queueBuyers) {
        super("Buyer №" + number);
        this.queueBuyers=queueBuyers;
        Dispetcher.addBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
        Dispetcher.completeBuyer();
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
    public void goToQueue() {
        System.out.println(this+" added to Queue");
        synchronized (this){
            queueBuyers.add(this);
            this.setRunnable(false);
            while(!this.isRunnable)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println(this+ " left the Queue");
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



