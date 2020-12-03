package by.it.terentyev.jd01_08.oop;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String str1="Аарон";
        String str2="АAPOH";
        String str3="аарон";
        String str4="ААрон";
        String str5="аАрон";
        String str6="Берта";
        String str7="берта";
        String[] allStr=new String[]{str1,str2,str3,str4, str5,str6, str7};
        Arrays.sort(allStr);
        for (String s:allStr){
            System.out.println(s);
        }
    }
}

