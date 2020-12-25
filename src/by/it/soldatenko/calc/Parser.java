package by.it.soldatenko.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Map<String, Integer> priorityMap = new HashMap<>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);

        }


    };

    public Var calc(String expression) throws CalcException {
        expression = expression.replaceAll("\\s+", "");
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        List<String> operations = new ArrayList<>();
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) {
            int index = getIndex(operations);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String operation = operations.remove(index);
            Var result = calcOneOperation(left, operation, right);
            operands.add(index, result.toString());
        }
        return Var.createVar(operands.get(0));
    }

    private int getIndex(List<String> operations) {
        int index = -1;
        int prior = -1;
        for (int i = 0, operationsSize = operations.size(); i < operationsSize; i++) {
            String operation = operations.get(i);
            if (prior < priorityMap.get(operation)) {
                index = i;
                prior = priorityMap.get(operation);
            }
        }


        return index;
    }


    private Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {

//        if (expression.contains("printvar")) {
//            Var.printVar();
//        }
//        if (expression.contains("sortvar")) {
//            Var.sortVar();
//        }


//        String[] operand = expression.split(Patterns.OPERATION);
//        if (operand.length < 2) {
//            return Var.createVar(expression);
//        }


        Var two = Var.createVar(rightStr);
        if (operation.equals("=")) {
            return Var.save(leftStr, two);

        }

        Var one = Var.createVar(leftStr);
//        if (one == null || two == null)
//            return null; //TODO  create error
//        Pattern p = Pattern.compile(Patterns.OPERATION);
//        Matcher m = p.matcher(expression);
//        if (m.find()) {
//            String operation = m.group();
        switch (operation) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "*":
                return one.mul(two);
            case "/":
                return one.div(two);
        }
//        }
        throw new CalcException("error");
    }


}

