package by.it.evstratov.jd02_02;

import java.util.ArrayList;

class Basket {

    private ArrayList<Good> basket = new ArrayList<>();

    public void put(Good good){
     this.basket.add(good);
    }

}
