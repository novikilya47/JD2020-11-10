package by.it.evstratov.calc;


import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    public Vector(String strVector) {
        String str = strVector.replaceAll("[{}]","");
        String[] arrayStrings = str.split(",");
        this.value = new double[arrayStrings.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(arrayStrings[i].trim());
        }

    }

    @Override
    public Var add(Scalar scalar) {
        double otherValue = scalar.getValue();
        double[] arr = Arrays.copyOf(value, value.length);
        for (int i = 0; i < arr.length; i++) {
            arr[i]+=otherValue;
        }
        return new Vector(arr);
    }

    @Override
    public Var add(Vector vector) {
        double[] arr = Arrays.copyOf(value, value.length);
        for (int i = 0; i < arr.length; i++) {
            arr[i]+=vector.value[i];
        }
        return new Vector(arr);
    }

    @Override
    public Var add(Matrix matrix) {
        return super.add(matrix);
    }

    @Override
    public Var div(Scalar scalar) {
        if (scalar.getValue()==0){
            System.out.println("Division by zero");
            return null; //stub
        }else{
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / scalar.getValue();
            }
            return new Vector(res);
        }
    }

    @Override
    public Var div(Vector vector) {
        return super.div(vector);
    }

    @Override
    public Var div(Matrix matrix) {
        return super.div(matrix);
    }

    @Override
    public Var mul(Scalar scalar) {
        double[] res = Arrays.copyOf(value, value.length);
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] * scalar.getValue();
        }
        return new Vector(res);
    }

    @Override
    public Var mul(Vector vector) {
        if(this.value.length == vector.value.length){
            double res = 0;
            for (int j = 0; j < this.value.length; j++) {
                res = res + vector.value[j] * this.value[j];
            }
            return new Scalar(res);
        }else{
            System.out.println("Вектора разной длинны");
            return null;
        }
    }

    @Override
    public Var mul(Matrix matrix) {
        return matrix.mul(this);
    }

    @Override
    public Var sub(Scalar scalar) {
        return this.add((Scalar) new Scalar(-1).mul(scalar));
    }

    @Override
    public Var sub(Vector vector) {
        if(this.value.length == vector.value.length){
            return this.add(new Vector((Vector) vector.mul(new Scalar(-1))));
        }else{
            System.out.println("Вектора разной длинны");
            return null;
        }
    }

    @Override
    public Var sub(Matrix matrix) {
        return super.sub(matrix);
    }

    public Var addWidth(Var var){
        return var.add(this);
    }

    public Var mulWidth(Var var){
        return var.mul(this);
    }

    public Var divWidth(Var var){
        return var.div(this);
    }

    public Var subWidth(Var var){
        return var.sub(this);
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (double v : value) {
            stringJoiner.add(Double.toString(v));
        }
        return stringJoiner.toString();
    }
}
