package by.it.kglushchenko.jd01_06;

import java.lang.String;
import java.util.Arrays;

public class TaskB1 {

    public static void main(String[] args) {

        StringBuilder sbText = new StringBuilder(Poem.text); // читаем текст
        String stringText = sbText.toString();               // загоняем текст в строку
        stringText = stringText.replaceAll("[^а-яА-ЯЁё]+", " ").trim();// заменяем все кроме букв пробелами


        // Создаем строку из слов и пробелов
        //String stringTextClear = Arrays.toString(chars);

        // Создаем массив слов
        String[] word = stringText.split(" ");



        // Выводим список слов по очереди

        for (int i = 0; i < word.length; i++) {
            //System.out.println(word[i]);
            comparator(word[i]);
        }




    }


    private static void comparator(String word) {
        char[] s = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};
        char[] g = {'а', 'о', 'у', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е'};
        String lowerCase = word.toLowerCase();
        char start = lowerCase.charAt(0);
        char end = lowerCase.charAt(word.length() - 1);
        for (int i = 0; i < s.length; i++) {
            if (start == s[i]) {
                for (int j = 0; j < g.length; j++) {
                    if (end == g[j]) {
                        System.out.println(word);
                    }
                }
            }
        }
    }


}
