package by.it.evstratov.jd01_15;

/**
 * This is a JavaDoc class comment
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//public class TaskB

public class TaskB {

    //static method getPath

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(".", File.separator);
        return src + path + ".java";
    }


    /*
      Method main
   */

    public static void main(String[] args) {

        try(FileReader fr = new FileReader(getPath(TaskB.class))){

            /*
               Установка флагов для отлавливания комментов
            */

            boolean isCommentOpen;
            while (fr.ready()){
                char character = (char) fr.read();
                String charToString = character+"";
                System.out.println(charToString);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
