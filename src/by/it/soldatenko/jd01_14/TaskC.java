package by.it.soldatenko.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;





public class TaskC {
    public static PrintWriter out;

    public static void main(String[] args) {
        try {
            out = new PrintWriter(new FileWriter("D:/Java/courses/JD2020-11-10-git/src/by/it/soldatenko/jd01_14/resultTaskC.txt"));
            printAll("D:/Java/courses/JD2020-11-10-git/src/by/it/soldatenko");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printAll(String path) {
        try {
            File f = new File(path);
            File[] d = f.listFiles();
            for (File file : d) {
                if (file.isFile()) {
                    System.out.println("file:" + file.getName());
                    out.println("file:" + file.getName());
                }
                if (file.isDirectory()) {
                    System.out.println("dir:" + file.getName());
                    out.println("dir:" + file.getName());
                    printAll(String.valueOf(file));
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

}

