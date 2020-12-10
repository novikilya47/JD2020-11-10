package by.it.evstratov.calc;

public interface OperationAdd {

    Var add(Scalar scalar);
    Var add(Vector vector);
    Var add(Matrix matrix);

}
