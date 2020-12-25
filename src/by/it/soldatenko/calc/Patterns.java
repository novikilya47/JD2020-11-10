package by.it.soldatenko.calc;

public interface Patterns {
    //      (?<=[^,{+*/=-])[+=*/-]
//    static final String SCALAR = "(?<=[^,{+*/=-])[+=*/-]";
//    static final String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+}";
//    static final String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
//    static final String OPERATION= "[-+/*=]";

    String OPERATION = "(?<=[^,{+*/=-])[+=*/-]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
//-1*{1,2,3,4,1,2,2.5,-8,-9}-{-1,2,3,4}
}
