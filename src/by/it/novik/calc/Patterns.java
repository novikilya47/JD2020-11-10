package by.it.novik.calc;

public interface Patterns {
    String OPERATION = "(?<=[^,{+*/=-])[+=*/-]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
}
