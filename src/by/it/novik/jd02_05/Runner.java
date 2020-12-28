package by.it.novik.jd02_05;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Language lang = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);
        Date date = new Date();
        while (true) {
            System.out.println("Введите раскладку");
            String yaz = scanner.nextLine();
            if (yaz.equals("ru")) {
                lang.setLocale(new Locale("ru", "RU"));
                System.out.println(lang.get(Messages.WELCOME));
                System.out.println(lang.get(Messages.QUESTION));
                System.out.println(lang.get(User.FIRST_NAME));
                System.out.println(lang.get(User.LAST_NAME));
                System.out.printf("%1$s %2$td %2$tm %2$tY\n", "Сегодняшняя дата:", date);
            }
            else if (yaz.equals("be")) {
                lang.setLocale(new Locale("be", "BY"));
                System.out.println(lang.get(Messages.WELCOME));
                System.out.println(lang.get(Messages.QUESTION));
                System.out.println(lang.get(User.FIRST_NAME));
                System.out.println(lang.get(User.LAST_NAME));
                System.out.printf("%1$s %2$td %2$tm %2$tY\n", "Сённяшняя дата:", date);
            }
            else if(yaz.equals("close")) {
                break;
            }
            else {
                lang.setLocale(new Locale("en", "US"));
                System.out.println(lang.get(Messages.WELCOME));
                System.out.println(lang.get(Messages.QUESTION));
                System.out.println(lang.get(User.FIRST_NAME));
                System.out.println(lang.get(User.LAST_NAME));
                System.out.printf("%1$s %2$tD\n", "Today's date:", date);
            }
        }
    }
}
