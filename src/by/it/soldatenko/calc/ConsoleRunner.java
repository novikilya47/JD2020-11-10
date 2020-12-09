package by.it.soldatenko.calc;

import java.util.Scanner;

public class ConsoleRunner {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();

        Printer printer = new Printer();
        while (!(line = scanner.nextLine()).equals("end")){
            Var result= null;
            try {
                result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
//                e.printStackTrace();
                printer.print(e);
            }
        }
    }
}

