package by.it.evstratov.calculator;

public interface Patterns {

    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{"+SCALAR+"(," + SCALAR +")*}";
    String MATRIX = "\\{"+VECTOR+"(," + VECTOR +")*}";


    String OPERATION = "[-+*/]";
}
