package by.it.evstratov.calc;


class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }
    public Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }
    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public Var add(Scalar scalar) {
        double otherValue = scalar.value;
        double result = this.value + otherValue;
        return new Scalar(result);
    }

    @Override
    public Var add(Vector vector) {
        return vector.add(this);
    }

    @Override
    public Var add(Matrix matrix) {
        return matrix.add(this);
    }

    @Override
    public Var div(Scalar scalar) {
        double otherValue = scalar.value;
        if (otherValue==0){
            System.out.println("Division by zero");
            return null; //stub
        }
        double result = this.value / otherValue;
        return new Scalar(result);
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
        double otherValue = scalar.value;
        double result = this.value * otherValue;
        return new Scalar(result);
    }

    @Override
    public Var mul(Vector vector) {
        return vector.mul(this);
    }

    @Override
    public Var mul(Matrix matrix) {
        return matrix.mul(this);
    }

    @Override
    public Var sub(Scalar scalar) {
        double otherValue = scalar.value;
        double result = this.value - otherValue;
        return new Scalar(result);
    }

    @Override
    public Var sub(Vector vector) {
        return vector.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var sub(Matrix matrix) {
        return matrix.sub(this).mul(new Scalar(-1));
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

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public double getValue() {
        return value;
    }
 }
