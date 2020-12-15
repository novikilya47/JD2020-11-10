package by.it.soldatenko.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class TaskC {

    public static void main(String[] args) {
        try (PrintWriter ouT = new PrintWriter(new FileWriter("D:/Java/courses/JD2020-11-10-git/src/by/it/soldatenko/jd01_14/resultTaskC.txt")))
        {
            printAll("D:/Java/courses/JD2020-11-10-git/src/by/it/soldatenko", ouT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void printAll(String path, PrintWriter oUt) {
        try {
            File f = new File(path);
            File[] d = f.listFiles();
            for (File file : d) {
                if (file.isFile()) {
                    System.out.println("file:" + file.getName());
                    oUt.println("file:" + file.getName());
                }
                if (file.isDirectory()) {
                    System.out.println("dir:" + file.getName());
                    oUt.println("dir:" + file.getName());
                    printAll(String.valueOf(file),oUt);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

