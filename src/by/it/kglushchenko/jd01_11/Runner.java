package by.it.kglushchenko.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list=new ListA<>();
        list.add("One"); //0
        list.add("Two"); //1
        list.add("Three"); //2
        list.add("Four");
        list.add("Five");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);

        List<String> listb = new ListB<>();
        listb.add("Ptivet");
        listb.add("Hello");
        listb.add("Zdraste");
        listb.add("poka");
        System.out.println(listb);
        listb.remove(3);
        System.out.println(listb);

    }
}
