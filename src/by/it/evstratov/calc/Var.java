package by.it.evstratov.calc;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements OperationAdd, OperationDiv, OperationMul, OperationSub {

    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var){
        vars.put(name, var);
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

        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }else if(strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }else if(strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        }else if(vars.containsKey(strVar)){
            return vars.get(strVar);
        }else{
            throw new CalcException("Невозможно создать "+strVar);
        }
    }

    @Override
    public Var add(Scalar scalar) throws CalcException{
        throw new CalcException("Операция сложения "+ this+" + "+scalar+" невозможна");
    }

    @Override
    public Var add(Vector vector) throws CalcException{
        throw new CalcException("Операция сложения "+ this+" + "+vector+" невозможна");
    }

    @Override
    public Var add(Matrix matrix) throws CalcException{
        throw new CalcException("Операция сложения "+ this+" + "+matrix+" невозможна");
    }

    @Override
    public Var div(Scalar scalar) throws CalcException {
        throw new CalcException("Операция деления "+ this+" / "+scalar+" невозможна");
    }

    @Override
    public Var div(Vector vector) throws CalcException{
        throw new CalcException("Операция деления "+ this+" / "+vector+" невозможна");
    }

    @Override
    public Var div(Matrix matrix) throws CalcException{
        throw new CalcException("Операция деления "+ this+" / "+matrix+" невозможна");
    }

    @Override
    public Var mul(Scalar scalar) throws CalcException{
        throw new CalcException("Операция умножения "+ this+" * "+scalar+" невозможна");
    }

    @Override
    public Var mul(Vector vector) throws CalcException{
        throw new CalcException("Операция умножения "+ this+" * "+vector+" невозможна");
    }

    @Override
    public Var mul(Matrix matrix) throws CalcException{
        throw new CalcException("Операция умножения "+ this+" * "+matrix+" невозможна");
    }

    @Override
    public Var sub(Scalar scalar) throws CalcException{
        throw new CalcException("Операция вычитания "+ this+" * "+scalar+" невозможна");
    }

    @Override
    public Var sub(Vector vector) throws CalcException{
        throw new CalcException("Операция вычитания "+ this+" * "+vector+" невозможна");
    }

    @Override
    public Var sub(Matrix matrix) throws CalcException{
        throw new CalcException("Операция вычитания "+ this+" * "+matrix+" невозможна");
    }

    public abstract Var addWidth(Var right) throws CalcException;

    public abstract Var subWidth(Var right) throws CalcException;

    public abstract Var mulWidth(Var right) throws CalcException;

    public abstract Var divWidth(Var right) throws CalcException;

    @Override
    public String toString() {
        return "some abstract Var{}";
    }

}
