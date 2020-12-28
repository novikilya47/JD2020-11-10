package by.it.novik.jd02_04;

import java.util.Objects;

public class Printer {
    void print (Var var){
        if(Objects.nonNull(var)){
            System.out.println(var);
        }
    }

    public void printErr(CalcException e) {
        System.out.println(e.getMessage());
    }
}
