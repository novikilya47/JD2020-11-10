package by.it.evstratov.jd02_01;

class Buyer extends Thread{

     public Buyer(int number){
        super("Buyer №"+number);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {
        System.out.println(this + " do something");
    }
}
