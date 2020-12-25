package by.it.evstratov.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Language lang = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        switch (str){
            case "ru":
                lang.setLocale(new Locale("ru","RU"));
                break;
            case "be": lang.setLocale(new Locale("be","BY"));
                break;
            default: lang.setLocale(new Locale("en","EN"));
                break;
        }
        System.out.println(Time.getTime(lang.getLocale()) + ":" + lang.get(Messages.WELCOME));
        System.out.println(Time.getTime(lang.getLocale()) + ":" + lang.get(Messages.QUESTION));
        System.out.println(Time.getTime(lang.getLocale()) + ":" + lang.get(User.FIRST_NAME));
        System.out.println(Time.getTime(lang.getLocale()) + ":" + lang.get(User.LAST_NAME));
    }

}
