package by.it.evstratov.jd01_12;

import java.util.*;

public class TaskC2 {

    private static Set<Number> getUnion(Set<? extends Number>... sets){
        Set<Number> result = new HashSet<>();
        for (Set<? extends Number> set : sets) {
            System.out.println(set.toString());
        }
        return result;
    }

    public static void main(String[] args) {

        TreeSet<Double> treeSetDb = new TreeSet<>(Arrays.asList(1.0,3.1,4.3,6.0,7.1,8.5,7.0));
        HashSet<Integer> hashSetInt = new HashSet<>(Arrays.asList(1,2,9,6,7,1));
        LinkedHashSet<Float> linkedHashSetFl = new LinkedHashSet<>(Arrays.asList(1.2f,2.0f,9.0f,6.3f,7.0f,1.0f,6f));


    }

}
