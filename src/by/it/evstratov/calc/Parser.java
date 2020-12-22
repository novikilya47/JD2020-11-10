package by.it.evstratov.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Map<String, Integer> priorityMap = new HashMap<>(){
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    public Var calc(String ex) throws CalcException{
        ex = ex.replaceAll("\\s","");
        List<String> operands = new ArrayList<>(Arrays.asList(ex.split(Patterns.OPERATION)));
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(ex.replace(" ",""));
        List<String> operations = new ArrayList<>();
        while (matcher.find()){
            operations.add(matcher.group());
        }
        while (operations.size() > 0){
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

    public Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {
        Var right = Var.createVar(rightStr);
        if(operation.equals("=")){
            return Var.saveVar(leftStr, right);
        }
        Var left = Var.createVar(leftStr);

        switch (operation){
            case "+" :
                RepoVar.saveToLog(right + " + " + left +" = "+right.addWidth(left));
                return right.addWidth(left);
            case "-" : RepoVar.saveToLog(right + " - " + left+" = "+right.subWidth(left));
                return right.subWidth(left);
            case "*" : RepoVar.saveToLog(right + " * " + left+" = "+right.mulWidth(left));
                return right.mulWidth(left);
            case "/" : RepoVar.saveToLog(right + " / " + left+" = "+right.divWidth(left));
                return right.divWidth(left);
        }
        throw new CalcException("err");
    }
}
