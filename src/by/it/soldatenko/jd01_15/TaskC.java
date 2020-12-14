package by.it.soldatenko.jd01_15;

import java.io.File;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        String ss = "D:\\Java\\courses\\JD2020-11-10-git\\src\\by\\it\\soldatenko\\jd01_15";
        File f = new File(ss);
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.print(f.getAbsolutePath() + ">");
            String s = scanner.nextLine();
            if (s.equals(("end"))) {
                break;
            }
            if (s.equals("cd..")) {
                f = new File(f.getParent());
            }
            if (!s.equals("cd..") && !s.equals("dir")) {
                sb = sb.append(s);
                sb = sb.replace(0, 3, "");
                f = new File(f.getAbsolutePath() + "\\" + sb);
            }
            if (s.equals("dir")) {
                File[] d = f.listFiles();
                for (File file : d) {
                    System.out.println(file.getName());
                }
            }
            sb.delete(0, sb.capacity());

        }


    }
}