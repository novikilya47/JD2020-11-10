package by.it.evstratov.jd01_13;

import java.util.ArrayDeque;
import java.util.Scanner;

public class TaskC {

    static int errors = 0;
    static Scanner scanner = new Scanner(System.in);
    static ArrayDeque<Double> arrayDeque = new ArrayDeque<>();

    static void readData() throws InterruptedException{
        double value = 0;
        try{
            value = Double.parseDouble(scanner.nextLine());
            arrayDeque.add(value);
        }catch (NumberFormatException e){
            errors++;
            Thread.sleep(100);
            Double[] doubles = arrayDeque.toArray(new Double[arrayDeque.size()]);
            for (int i = doubles.length-1; i >= 0; i--) {
                System.out.print(doubles[i] + " ");
            }
            System.out.println();
            if(errors == 5){
                throw e;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = TaskC.scanner;
        while (true) {
            readData();
        }

    }

}
