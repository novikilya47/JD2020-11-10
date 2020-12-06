package by.it.evstratov.jd01_12;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TaskC1 {

    public static void main(String[] args) {

        Map<Long,String> namesObjects = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);
        String str;

        while (!(str = scanner.next()).equals("end")){
            namesObjects.put(System.nanoTime(), str);
        }

        System.out.println(namesObjects.toString());

    }

}
