package by.it.terentyev.jd01_11;


import java.util.Collections;
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
        list.set(3,"Seven");
        System.out.println(list);
        list.add(3, "Six");
        System.out.println(list);
        //list.addAll(2, Collections.singleton("Six","All", "Nine",));
        System.out.println(list);


    }
}
