package by.it.leshchenko.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
        List<String> list = new ListB<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        System.out.println(list);

//        list.remove(2);
//        System.out.println(list);
//
//        String s = list.get(2);
//        System.out.println(s);

//        String test = list.set(3, "Six");
//        System.out.println(list.toString());
//        System.out.println(test);

        list.add(2, "Seven");
        System.out.println(list);
//
//        List<String> list2 = new ArrayList<>();
//        list2.add("11");
//        list2.add("22");
//        list2.add("33");
//        list2.add("44");
//        list2.add("55");
//        list.addAll(list2);
//        System.out.println(list);
    }
}
