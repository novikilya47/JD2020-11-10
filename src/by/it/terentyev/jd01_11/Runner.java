package by.it.terentyev.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list =new ListB<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.set(2, "Six");
        System.out.println(list);

    }
}
