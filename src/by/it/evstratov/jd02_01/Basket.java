package by.it.evstratov.jd02_01;

import java.util.ArrayList;

class Basket {

    private ArrayList<Good> goods = new ArrayList<>();

    public void put(Good good){
     this.goods.add(good);
    }

}
