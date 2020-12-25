package by.it.plehanova.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static Lang lang = Lang.INSTANCE;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        if(args.length==2){
            lang.setLocale(new Locale(args[0],args[1]));
        }

        Scanner scanner = new Scanner(System.in);
        Parser pars = new Parser();
        Printer printer = new Printer();
        RepoVar.loadVariables();
        String expression;
        while (true) {
            expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            } else if (expression.equals("printvar")) {
                Var.printVar();

            } else if (expression.equals("sortvar")) {
                Var.sortVar();

            } else {
                try {
                    Var result = pars.calc(expression);
                    printer.print(result);

                } catch (CalcException e) {
                    //e.printStackTrace();
                    printer.printErr(e);
                }
            }
        }
    }
}
