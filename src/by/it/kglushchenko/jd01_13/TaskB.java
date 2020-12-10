package by.it.kglushchenko.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double value=0.0, sum = 0.0, Sq = 0.0;

        String inputString;
        while (!((inputString = scanner.nextLine().trim()).equals("end"))) {
            try {
                value = Double.valueOf(inputString);
            } catch (NumberFormatException e) {
                String name = e.getClass().getName();
                String nameA = TaskB.class.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String className = stackTraceElement.getClassName();
                    int lineNumber = stackTraceElement.getLineNumber();
                    if (className.equals(nameA)) {
                        System.out.printf(" name: %s\n" +
                                "class: %s\n" +
                                " line: %d\n ", name, className, lineNumber);
                        break;
                    }
                }
            }// catch - NumberFormatException
            sum += value;

            try {
                Sq = Math.sqrt(sum);
            } catch (ArithmeticException e) {
                String name = e.getClass().getName();
                String nameA = TaskB.class.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String className = stackTraceElement.getClassName();
                    int lineNumber = stackTraceElement.getLineNumber();
                    if (className.equals(nameA)) {
                        System.out.printf(" name: %s\n" +
                                "class: %s\n" +
                                " line: %d\n ", name, className, lineNumber);
                        break;
                    }
                }
            }// catch - ArithmeticException
            System.out.printf("%f %f \n", value, Sq);
        }
    }
}
