package by.it.soldatenko.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        printAll("D:/Java/courses/JD2020-11-10-git/src/by/it/soldatenko");
    }

    public static void printAll(String path) {
        try(PrintWriter out = new PrintWriter(new FileWriter("D:/Java/courses/JD2020-11-10-git/src/by/it/soldatenko/jd01_14/resultTaskC.txt"))) {
            File f = new File(path);
            File[] d = f.listFiles();
            for (File file : d) {
                if (file.isFile()) {
                    System.out.println("file:" + file.getName());
                    out.print("file:" + file.getName());
                }
                if (file.isDirectory()) {
                    System.out.println("dir:" + file.getName());
                    out.print("dir:" + file.getName());
                    printAll(String.valueOf(file));
                }
            }
        } catch (IOException |NullPointerException e) {
            e.printStackTrace();
        }
    }
}
