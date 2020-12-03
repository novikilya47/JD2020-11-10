package by.it.evstratov.jd01_11;

import by.it._khmelov_.jd01_11.ListA;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list1=new ListB<>();
        List<String> list2=new ListB<>();
        list1.add("One"); //0
        list1.add("Two"); //1
        list1.add("Three"); //2
        list1.add("Four");
        list1.add("Five");
        list2.add("Six");
        list2.add("Seven");
        System.out.println(list1);
        System.out.println(list2);
        list1.addAll(list2);
        System.out.println(list1);
    }
}
