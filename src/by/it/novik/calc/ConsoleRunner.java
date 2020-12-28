package by.it.novik.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        RepoVar.loadVariables();
        for (; ; ) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            }
            try {
                Var result = parser.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                printer.printErr(e);
                Logger.Singleton.LOGGER.log(e);
            }
        }
    }
}
