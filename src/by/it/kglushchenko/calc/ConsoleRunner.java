package by.it.kglushchenko.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        do{
            String expression = scanner.nextLine();
            if(expression.equals("end")){
                break;
            }
            // добавляем printvar
            if(expression.equals("printvar")){
                // Выводим весь Map

            }
            // добавляем printvar
            if(expression.equals("sortvar")){
                // Выводим весь Map

            }

            Var result = parser.calc(expression);
            printer.print(result);
        }while (true);
    }
}
