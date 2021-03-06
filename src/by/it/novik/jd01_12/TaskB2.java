package by.it.novik.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String>peoples1=new ArrayList<>();
        LinkedList<String>peoples2=new LinkedList<>();
        System.out.println(process(peoples1));
        System.out.println(process(peoples2));
    }

    static String process(ArrayList<String> peoples){
        int count=0;
        while (peoples.size()>1){
            Iterator<String> iter = peoples.iterator();
            while (iter.hasNext()){
                iter.next();
                count++;
                if(count%2==0){
                    iter.remove();
                }
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        int count=0;
        while (peoples.size()>1){
            Iterator<String> iter = peoples.iterator();
            while (iter.hasNext()){
                iter.next();
                count++;
                if (count%2==0){
                    iter.remove();
                }
            }
        }
        return peoples.get(0);
    }
}
