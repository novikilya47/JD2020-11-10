package by.it.evstratov.jd01_12;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class TaskC3 {

    static boolean checkBrackets(String expression){

        ArrayDeque<Character> states = new ArrayDeque<Character>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(']', '[');
        brackets.put('}', '{');
        brackets.put(')', '(');

        boolean result = true;

        for (char c : expression.toCharArray()){

        }
        return result;

    }

    public static void main(String[] args) {

        String str = "{[{()}][()]{()}}";
        System.out.println(checkBrackets(str));

    }

}
