package by.it.evstratov.calc;

public interface OperationMul {

    Var mul(Scalar scalar);
    Var mul(Vector vector);
    Var mul(Matrix matrix);

}
