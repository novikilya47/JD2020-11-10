package by.it.kglushchenko.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TaskB2 {

    public static void main(String[] args) {

        StringBuilder sbText = new StringBuilder(Poem.text); // читаем текст
        String stringText = sbText.toString();               // загоняем текст в строку
        //stringText = stringText.replaceAll("[...]+", " ").trim();
        stringText = stringText.replaceAll(" *[^а-яА-ЯЁё.\n]+ *", " ").trim();// заменяем все кроме букв пробелами
        //stringText = stringText.replaceAll("[^.\n]+", " ").trim();

        // Создаем массив строк
        String[] sentences = stringText.split("\n");

        Comparator<String> stringComparator = new StringSort();

        Arrays.sort(sentences, stringComparator);

        for(String str : sentences){
            System.out.println(str);
        }
    }
}
