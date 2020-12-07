package by.it.evstratov.calc;

public interface OperationDiv {

    Var div(Scalar scalar);
    Var div(Vector vector);
    Var div(Matrix matrix);

}
