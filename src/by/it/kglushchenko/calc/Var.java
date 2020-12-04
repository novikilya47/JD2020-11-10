package by.it.kglushchenko.calc;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    // сохраняем пару ключ значение в карту
    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    // Возвращаем все записи карты
    public static void loadVar(){
        if(!vars.isEmpty()){
            //for (Map<String, Var> v: vars) {
            Set<Map.Entry<String, Var>> setv = vars.entrySet();
            Iterator<Map.Entry<String, Var>> iterator = setv.iterator();
            while(iterator.hasNext()){
                //
                Map.Entry<String, Var> me = iterator.next();
                System.out.println(me.getKey()+"="+me.getValue());
            }
            //return
        }
    }

    public static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else if (vars.containsKey(strVar)) { // Если ввести A=9 в Map сохраняется пара ключ-значение
            return vars.get(strVar);    // если ввести B=A А будет искаться, при условии что эта переменная была ранее создана
        }
        return null; // exception
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s not found\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s not found\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s not found\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s not found\n", this, other);
        return null;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Some abstract Var{}";
    }
}
