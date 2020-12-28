package by.it.novik.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {

    public enum Singleton {
        LOGGER;
        void log(CalcException message){
            try(PrintWriter printWriter = new PrintWriter(new FileWriter(getPath(), true))) {
                Date date = new Date();
                printWriter.println(message);
                printWriter.println(date.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static synchronized String getPath() {
        String src=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String name = Logger.class.getName();
        String path = name.replace(Logger.class.getSimpleName(), "").replace(".", File.separator);
        return src+path+"error.txt";
    }
}
