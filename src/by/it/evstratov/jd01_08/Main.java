package by.it.evstratov.jd01_08;


import java.util.Objects;

public class Main {

    private static void print(Var var) {
        if (Objects.nonNull(var)) {
            System.out.println(var);
        }
    }
    public static void main(String[] args) {
        Var s = new Scalar(3.0);
        Var s2 = new Scalar(4.0);
        Var v = new Vector(new double[]{1, 2, 3}); // закомментируйте вектор и/или
        Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");// матрицу, если вы их не реализовали
        /* Уровень сложности B (векторные операции) закомментируйте, если не реализовали */
        /* Уровень сложности C (матричные операции и умножение на вектор)
        закомментируйте, если не реализовали */
        print(m.mul(m)); //{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}
        print(m.mul(v)); //{14.0, 32.0, 50.0}
    }

}
