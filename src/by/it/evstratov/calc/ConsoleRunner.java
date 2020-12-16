package by.it.evstratov.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);

        for (;;) {
            String expression = scanner.nextLine();
            if(expression.equals("end")){
                break;
            }else if(expression.equals("printvar")){
                Var.printVar();
            }else if(expression.equals("sortvar")){
                Var.sortVar();
            }
            try {
                Var result = parser.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
