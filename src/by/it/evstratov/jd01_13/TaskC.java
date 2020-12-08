package by.it.evstratov.jd01_13;

import java.util.ArrayDeque;
import java.util.Scanner;

public class TaskC {

    static ArrayDeque<Double> arrayDeque = new ArrayDeque<>();
    static int errors = 0;

    static Scanner createScanner(){
        return new Scanner(System.in);
    }

    static void readData(String line) throws InterruptedException{
        double value = 0;
        try{
            value = Double.parseDouble(line);
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

        Scanner scanner = createScanner();

        while (true) {
            readData(scanner.nextLine());
        }

    }

}
