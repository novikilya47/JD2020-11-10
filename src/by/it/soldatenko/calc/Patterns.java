package by.it.soldatenko.calc;

public interface Patterns {

    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    static final String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
    static final String OPERATION= "[-+/*=]";

//1,2,2.5, -8 -9
}
