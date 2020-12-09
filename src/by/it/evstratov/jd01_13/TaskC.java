package by.it.evstratov.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    static int errors = 0;
    static Scanner scanner;
    static ArrayList<Double> arrayList = new ArrayList<>();

    static void readData(){
        double value;
        try{
            value = Double.parseDouble(scanner.nextLine());
            arrayList.add(value);
        }catch (NumberFormatException e){
            errors++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            for (int i = arrayList.size()-1; i >= 0; i--) {
                System.out.print(arrayList.get(i) + " ");
            }
            System.out.println();
            if(errors == 5){
                throw e;
            }
        }
    }
    public static void main(String[] args){

        scanner = new Scanner(System.in);
        while (true) {
            readData();
        }
    }
}
