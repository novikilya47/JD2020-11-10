package by.it.leshchenko.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static final Map<String, Var> variables = new HashMap<>();

    public static Var save(String name, Var value) {
        variables.put(name, value);
        return value;
    }

    public static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches((Patterns.VECTOR))) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else {
            if (variables.containsKey(strVar)) {
                return variables.get(strVar);
            }
        }
        throw new CalcException(); // return exception
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw  new CalcException(String.format("Операция сложения " + this + " + " + other + " невозможна"));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        System.out.println("Операция вычитания " + this + " - " + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + " * " + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) throws CalcException {
        System.out.println("Операция деления " + this + " / " + other + " невозможна");
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
