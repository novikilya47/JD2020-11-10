package by.it.evstratov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Locale locale = new Locale("de", "GE");
        String base = "by.it.evstratov.jd02_05.resources.language";
        ResourceBundle bundle = ResourceBundle.getBundle(base,locale);
        String s = bundle.getString("message.welcome");
        System.out.println(s);
    }

}
