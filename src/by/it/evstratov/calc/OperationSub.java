package by.it.evstratov.calc;

public interface OperationSub {

    Var sub(Scalar scalar);
    Var sub(Vector vector);
    Var sub(Matrix matrix);

}
