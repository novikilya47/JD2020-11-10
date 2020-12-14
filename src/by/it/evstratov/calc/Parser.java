package by.it.evstratov.calc;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Var calc(String expression) throws CalcException {

        expression = expression.replaceAll("\\s","");
        String[] part = expression.split(Patterns.OPERATION, 2);

        if(part.length < 2){
            return Var.createVar(expression);
        }

        Var right = Var.createVar(part[1]);
        if(expression.contains("=")){
            return Var.saveVar(part[0], right);
        }
        Var left = Var.createVar(part[0]);

        if(Objects.nonNull(left) && Objects.nonNull(right)){
            Pattern compile = Pattern.compile(Patterns.OPERATION);
            Matcher matcher = compile.matcher(expression);
            if(matcher.find()){
                String operation = matcher.group();
                switch (operation){
                    case "+" : return right.addWidth(left);
                    case "-" : return right.subWidth(left);
                    case "*" : return right.mulWidth(left);
                    case "/" : return right.divWidth(left);
                }
            }
        }
        return null;
    }
}
