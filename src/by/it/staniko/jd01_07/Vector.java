package by.it.staniko.jd01_07;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }
/*    public Vector(String strvalue) {
        this.value = Double[].parseDouble(strvalue);
    }
*/
    public Vector(Vector otherVector) {
        this.value = otherVector.value;
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double element : value ){
            joiner.add(Double.toString(element));
        }
        return joiner.toString();
    }
}
