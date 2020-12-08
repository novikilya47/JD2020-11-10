package by.it.evstratov.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str;
        ArrayList<Double> doubleArrayList = new ArrayList<>();

        while (!(str = scanner.nextLine()).equals("END")){

            Double num = Double.parseDouble(str);
            doubleArrayList.add(num);
            System.out.println(num);

        }

    }

}
