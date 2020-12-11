package by.it.evstratov.jd01_14;

import java.io.*;

public class TaskC {

    public static final String FILENAME_TXT_RESULT = "resultTaskC.txt";

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }

    private static void viewPath(File file) {

        OutputStreamWriter outputStream;
        try {
            outputStream = new OutputStreamWriter(new FileOutputStream(getPath(TaskC.class)+FILENAME_TXT_RESULT,true));
            if(file.isFile()){
                System.out.println("file:"+file.getName());
                outputStream.write("file:"+file.getName()+"\n");
            }
            if(file.isDirectory()){
                System.out.println("dir:"+file.getName());
                outputStream.write("dir:"+file.getName()+"\n");
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    viewPath(files[i]);
                }
            }
            outputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String path = getPath(TaskC.class);
        String secondName = "evstratov";
        String nameMyPath = path.split(secondName)[0];
        File myPath = new File(nameMyPath+secondName+File.separator);
        viewPath(myPath);

    }

}
