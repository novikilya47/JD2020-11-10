package by.it.evstratov.calc;


import by.it.evstratov.calc.language.ErrorLang;
import by.it.evstratov.calc.language.VarLang;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements OperationAdd, OperationDiv, OperationMul, OperationSub {

    private static final Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var){
        vars.put(name, var);
        RepoVar.saveVariables(vars);
        return var;
    }

    static void printVar(){
        for(Map.Entry entry: vars.entrySet()){
            System.out.printf("%s=%s\n",entry.getKey(),entry.getValue().toString());
        }
    }

    static void sortVar() {
        Map<String, Var> treeMap = new TreeMap<>(vars);
        for(Map.Entry entry: treeMap.entrySet()){
            System.out.printf("%s=%s\n",entry.getKey(),entry.getValue().toString());
        }
    }

    public static Var createVar(String strVar) throws CalcException {
        strVar = strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }else if(strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }else if(strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        }else if(vars.containsKey(strVar)){
            return vars.get(strVar);
        }else{
            throw new CalcException(ErrorLang.CREATE + " "+strVar);
        }
    }

    @Override
    public Var add(Scalar scalar) throws CalcException{
        throw new CalcException(ErrorLang.SUM + " "+ this+" + "+scalar+" " + ErrorLang.IMPOSSIBLE);
    }

    @Override
    public Var add(Vector vector) throws CalcException{
        throw new CalcException(ErrorLang.SUM + " "+ this+" + "+vector+" " + ErrorLang.IMPOSSIBLE);
    }

    @Override
    public Var add(Matrix matrix) throws CalcException{
        throw new CalcException(ErrorLang.SUM + " "+ this+" + "+matrix+" " + ErrorLang.IMPOSSIBLE);
    }

    @Override
    public Var div(Scalar scalar) throws CalcException {
        throw new CalcException(ErrorLang.DIV + " "+ this+" / "+scalar+" " + ErrorLang.IMPOSSIBLE);
    }

    @Override
    public Var div(Vector vector) throws CalcException{
        throw new CalcException(ErrorLang.DIV + " "+ vector+" / "+this+" " + ErrorLang.IMPOSSIBLE);
    }

    @Override
    public Var div(Matrix matrix) throws CalcException{
        throw new CalcException(ErrorLang.DIV + " "+ this+" / "+matrix+" " + ErrorLang.IMPOSSIBLE);
    }

    @Override
    public Var mul(Scalar scalar) throws CalcException{
        throw new CalcException(ErrorLang.MUL + " "+ this+" * "+scalar+" " + ErrorLang.IMPOSSIBLE);
    }

    @Override
    public Var mul(Vector vector) throws CalcException{
        throw new CalcException(ErrorLang.MUL + " "+ this+" * "+vector+" " + ErrorLang.IMPOSSIBLE);
    }

    @Override
    public Var mul(Matrix matrix) throws CalcException{
        throw new CalcException(ErrorLang.MUL + " "+ this+" * "+matrix+" " + ErrorLang.IMPOSSIBLE);
    }

    @Override
    public Var sub(Scalar scalar) throws CalcException{
        throw new CalcException(ErrorLang.SUB + " "+ this+" * "+scalar+" " + ErrorLang.IMPOSSIBLE);
    }

    @Override
    public Var sub(Vector vector) throws CalcException{
        throw new CalcException(ErrorLang.SUB + " "+ this+" * "+vector+" " + ErrorLang.IMPOSSIBLE);
    }

    @Override
    public Var sub(Matrix matrix) throws CalcException{
        throw new CalcException(ErrorLang.SUB + " "+ this+" * "+matrix+" " + ErrorLang.IMPOSSIBLE);
    }

    public abstract Var addWidth(Var right) throws CalcException;

    public abstract Var subWidth(Var right) throws CalcException;

    public abstract Var mulWidth(Var right) throws CalcException;

    public abstract Var divWidth(Var right) throws CalcException;

    @Override
    public String toString() {
        return VarLang.SOME_ABS + " Var{}";
    }

}
