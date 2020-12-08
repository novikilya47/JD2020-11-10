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

    public static Var createVar(String strVar) {

        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }else if(strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }else if(strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        }else if(vars.containsKey(strVar)){
            return vars.get(strVar);
        }else{
            return null; //exception
        }
    }

    @Override
    public Var add(Scalar scalar) {
        System.out.printf("Operation %s + %s not found\n", this, scalar);
        return null;
    }

    @Override
    public Var add(Vector vector) {
        System.out.printf("Operation %s + %s not found\n", this, vector);
        return null;
    }

    @Override
    public Var add(Matrix matrix) {
        System.out.printf("Operation %s + %s not found\n", this, matrix);
        return null;
    }

    @Override
    public Var div(Scalar scalar) throws CalcException {
        System.out.printf("Operation %s + %s not found\n", this, scalar);
        return null;
    }

    @Override
    public Var div(Vector vector) {
        System.out.printf("Operation %s + %s not found\n", this, vector);
        return null;
    }

    @Override
    public Var div(Matrix matrix) {
        System.out.printf("Operation %s + %s not found\n", this, matrix);
        return null;
    }

    @Override
    public Var mul(Scalar scalar) {
        System.out.printf("Operation %s + %s not found\n", this, scalar);
        return null;
    }

    @Override
    public Var mul(Vector vector) {
        System.out.printf("Operation %s + %s not found\n", this, vector);
        return null;
    }

    @Override
    public Var mul(Matrix matrix) {
        System.out.printf("Operation %s + %s not found\n", this, matrix);
        return null;
    }

    @Override
    public Var sub(Scalar scalar) {
        System.out.printf("Operation %s + %s not found\n", this, scalar);
        return null;
    }

    @Override
    public Var sub(Vector vector) {
        System.out.printf("Operation %s + %s not found\n", this, vector);
        return null;
    }

    @Override
    public Var sub(Matrix matrix) {
        System.out.printf("Operation %s + %s not found\n", this, matrix);
        return null;
    }

    public abstract Var addWidth(Var right);

    public abstract Var subWidth(Var right);

    public abstract Var mulWidth(Var right);

    public abstract Var divWidth(Var right) throws CalcException;

    @Override
    public String toString() {
        return "some abstract Var{}";
    }

}
