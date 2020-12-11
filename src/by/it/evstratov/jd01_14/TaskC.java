package by.it.evstratov.jd01_14;

import java.io.File;

public class TaskC {

    public static final String FILENAME_TXT_RESULT = "resultTaskC.txt";

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }

    public static void main(String[] args) {

        String path = getPath(TaskC.class);
        String secondName = "evstratov";
        String nameMyPath = path.split(secondName)[0];
        File myPath = new File(nameMyPath+secondName+File.separator);
        if(myPath.isDirectory()){
            File[] files = myPath.listFiles();
            for (File file : files) {
                System.out.println(file.getName());
            }

        }

    }

}
