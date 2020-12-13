package by.it.evstratov.jd01_15;

import java.io.*;

public class TaskC {

    private static final String CD = "cd";
    private static final String DIR = "dir";
    private static final String END = "end";

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }

    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String line;
            while (!(line = reader.readLine()).equals(END)){
                //System.out.println(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
