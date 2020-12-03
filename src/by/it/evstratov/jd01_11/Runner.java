package by.it.evstratov.jd01_11;

import by.it._khmelov_.jd01_11.ListA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {

        Set<String> set = new SetC<>();
        set.add("3");
        set.add("3");
        set.add("4");
        set.add("3");
        set.add("5");
        set.add("5");
        set.add("5");
        set.add("5");
        set.add("5");
        set.add("6");
        set.add("3");
        set.add("5");
        set.add("7");
        set.remove("3");
        set.remove("9");
        set.remove("3");
        set.remove("5");
        System.out.println(set.size());
        System.out.println(set.toString());
    }
}
