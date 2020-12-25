package by.it.novik.jd01_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class TaskA {

    public static final String MATRIX_TXT = "matrix.txt";
    public static void main(String[] args) {
        String path = getPath(TaskA.class) + MATRIX_TXT;
        int[][] matrix = matrix();
        printToFile(path,matrix);
        printFromFile(path);
    }

    private static int [][] matrix() {
        int[][] arr = new int[6][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int a = (int) (Math.random() * (15 + 15 + 1)) - 15;
                arr[i][j] = a;
            }
        }
        return arr;
    }

    private static String getPath(Class<?> claz) {
        String src=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String name = claz.getName();
        String path = name.replace(claz.getSimpleName(), "").replace(".", File.separator);
        return src+path;
    }

    private static void printToFile (String path, int[][] matrix) {
        try (PrintWriter write = new PrintWriter(path)) {
            for (int[] rowElement : matrix) {
                Arrays.stream(rowElement).forEach(element -> write.printf("%3d ", element));
                write.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printFromFile(String path) {
        try {
            Files.lines(Paths.get(path)).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

