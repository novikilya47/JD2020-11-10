package by.it.evstratov.jd01_12;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class TaskC3 {

    static void checkBrackets(String expression){

        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
        Map<Character, Integer> openBrackets = new HashMap<>();
        Map<Character, Integer> closeBrackets = new HashMap<>();
        
        char[] chars = expression.toCharArray();
        
        openBrackets.put('{',0);
        openBrackets.put('(',1);
        openBrackets.put('[',2);

        closeBrackets.put('}',0);
        closeBrackets.put(')',1);
        closeBrackets.put(']',2);

        for (int i = 0; i < chars.length; i++) {
            if(openBrackets.containsKey(chars[i])){
                arrayDeque.add(chars[i]);
            }else if(closeBrackets.containsKey(chars[i])){
                if(arrayDeque.isEmpty()){
                }else if(openBrackets.get(arrayDeque.getLast()) == closeBrackets.get(chars[i])){
                    arrayDeque.removeLast();
                }
            }
        }
        if(arrayDeque.isEmpty()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }

    public static void main(String[] args) {

        String str = "{[{()}][()]{()))";
        checkBrackets(str);

    }

}
