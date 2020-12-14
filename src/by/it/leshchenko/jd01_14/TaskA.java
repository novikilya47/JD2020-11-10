package by.it.leshchenko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TaskA {

    private static final Random random = new Random();
    public static final String FILENAME_BIN = "dataTaskA.bin";
    public static final String FILENAME_TXT = "resultTaskA.txt";

    public static void main(String[] args) {
        String path = getPath(TaskA.class);
        writeToFile(path + FILENAME_BIN);
        final List<Integer> list = readToList(path + FILENAME_BIN);
        printToConsole(list);

        try (final PrintWriter printWriter = new PrintWriter(path + FILENAME_TXT)) {
            double sum = 0;
            for (Integer integer : list) {
                printWriter.print(integer + " ");
                sum += integer;
            }
            printWriter.print("\navg=" + sum / list.size() + "\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer integer : list) {
            System.out.printf(Locale.ENGLISH, "%d ", integer);
            sum += integer;
        }
        System.out.printf(Locale.ENGLISH, "\navg=%f\n", sum / list.size());
    }

    private static List<Integer> readToList(String filename) {
        List<Integer> list = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename)
                )
        )) {
            while (dataInputStream.available() > 0) {
                list.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private static void writeToFile(String filename) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filename)
                )
        )) {
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt(random.nextInt(1000));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath(Class<?> clazz) {
        String userDir = System.getProperty("user.dir");
        String classDir = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return userDir + File.separator + "src" + File.separator + classDir;
    }
}


//    public static final String FILENAME_BIN = "dataTaskA.bin";
//    private static Random random = new Random();

//        String path = getPath(TaskA.class);
//        String filename = path + FILENAME_BIN;
//        try (
////        FileOutputStream fileOutputStream = new FileOutputStream(path + "dataTaskA.bin");
////        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
////        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
//                DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
//        ) {
////            outputStream.writeInt((90) + (89 * 256) + (88 * 256 * 256) + (87 * 256 * 256 * 256));
//            for (int i = 0; i < 20; i++) {
//                int value = 123 + random.nextInt(1000);
//                outputStream.writeInt(value);
//            }
//        } catch (IOException e) {
////            throw new RuntimeException(e);
//            e.printStackTrace();
//        }
//        //readIntList
//        List<Integer> list = new ArrayList<>();
//        DataInputStream dataInputStream = null;
//        try {
//            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
//            while (dataInputStream.available() > 0) {
//                int value = dataInputStream.readInt();
//                list.add(value);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (Objects.nonNull(dataInputStream)) {
//                try {
//                    dataInputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        //printListToConsole
//        double sum = 0;
//        for (Integer integer : list) {
//            System.out.print(integer + " ");
//            sum += integer;
//        }
//        double avg = sum / list.size();
//        System.out.println();
//        System.out.println("avg=" + avg);
//    }
//
//    private static String getPath(Class<?> clazz) {
//        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
//        String className = clazz.getName();
//        String path = className.replace(clazz.getSimpleName(), "").replace(".", File.separator);
//        path = src + path;
//        return path;

