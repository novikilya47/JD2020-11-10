package by.it.evstratov.jd02_02;

public class Cashier implements Runnable{

    private final int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.marketIsClosed()){
            Buyer buyer = QueueBuyers.extract();
            if(buyer != null){
                int t = Helper.getRandom(2000,5000);
                Helper.sleep(t);
                System.out.println(this + "started service for " + buyer);
                for (int i = 0; i < buyer.getBasket().getGoods().size(); i++) {
                    System.out.printf("   %s\n",buyer.getBasket().getGoods().get(i).toString());
                }
                System.out.println(this + "finished service for " + buyer);

                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer){
                    buyer.setRunnable(true);
                    buyer.notify();
                }
            }else{
                Helper.sleep(1);
                //PCP
            }
        }
        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return "Cashier №" + number + " ";
    }
}
