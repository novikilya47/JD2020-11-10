package by.it.novik.jd01_15;

import java.io.*;
//коммент 1
/*коммент 2*/
/*коммент тр
и*/
/**коммент 4*/


public class TaskB {
    public static final String FILE_JAVA = "TaskB.java";
    public static final String FILE_TXT = "TaskB.txt";
    public static void main(String[] args) {
        String java = getPath(TaskB.class) + FILE_JAVA;
        String txt = getPath(TaskB.class) + FILE_TXT;
        StringBuilder textnew = textNew(java);
        printToFile(txt, textnew);
        System.out.println(textnew);
    }

    private static StringBuilder textNew (String javaPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(javaPath))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (reader.ready()) {
                char a = (char) reader.read();
                if (a!= '/') {
                    stringBuilder.append(a);
                } else {
                    char b = (char) reader.read();
                    if (b != '/' && b != '*') {
                        stringBuilder.append(a).append(b);
                    } else if (b == '/') {
                        while (reader.read() != '\n') {}
                        stringBuilder.append('\n');
                    } else {
                        while (reader.ready()) {
                            char c = (char) reader.read();
                            if (c == '*') {
                                char d = (char) reader.read();
                                if (d=='/') {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return stringBuilder;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToFile (String Path, StringBuilder txt) {
        try (PrintWriter printWriter = new PrintWriter(Path)) {
            printWriter.print(txt);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath(Class<?> claz) {
        String src=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String name = claz.getName();
        String path = name.replace(claz.getSimpleName(), "").replace(".", File.separator);
        return src+path;
    }

}
