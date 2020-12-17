package by.it.kglushchenko.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String FILENAME_SRC_TXT = "TaskB.txt";
    public static final String FILENAME_DST_TXT = "resultTaskB.txt";
/*
    public static void main(String[] args) {
        int words = 0, punctmarks = 0;
//        Map<Integer,String>  hm=new Hashtable<>();
//        for(int i=0; i<1;i++){
//            int key=0;
//            String value="";
//            hm.put(key,value);
//        }
//hm.Entry

/*
        String path = getPath(TaskB.class);
        try (BufferedReader fileRead = new BufferedReader(new FileReader(path + FILENAME_SRC_TXT))) {
            Pattern pattern = Pattern.compile("([а-яА-яёЁ]+)|(-,.:\\s]+)"); // "([а-яА-яёЁ]+)|([^а-яА-яёЁ\\s]+)"
            while (fileRead.ready()) {
                String line = fileRead.readLine();
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    if (matcher.group(1) != null) {
                        words++;
                    }
                    if (matcher.group(2) != null) {
                        punctmarks++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("words=" + words + ", punctuation marks=" + punctmarks);

        try (BufferedWriter fileWrite = new BufferedWriter(new FileWriter(path + FILENAME_DST_TXT))) {
            fileWrite.write("words=" + words + " punctuation marks=" + punctmarks);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        // RESULT
        //System.out.println("words=" + words + ", punctuation marks=" + punctmarks);
    }

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }
*/
///////////////////////////////////////////////////////////////////////////////////////
/*
    public static final String FILENAME_TEXT = "TaskB.txt";
    public static final String FILENAME_TXT_RESULT = "resultTaskB.txt";

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }

    public static void main(String[] args) {

        int countWords = 0;
        int countMarks = 0;
        int lengthWord = 0;

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(getPath(by.it.evstratov.jd01_14.TaskB.class)+FILENAME_TEXT));
            while (inputStreamReader.ready()){
                char character = Character.valueOf((char)inputStreamReader.read());
                String charToString = character+"";

                if((charToString).matches("[!|?|,|.|;|:]|(\\s*(?<!\\.)\\.(?!\\.)\\s*)")){
                    countMarks++;
                }
                if(charToString.matches("[а-яА-ЯёЁ]")){
                    lengthWord++;
                }
                if(charToString.equals(" ") || charToString.matches("[!|?|,|.|;|:]|(\\s*(?<!\\.)\\.(?!\\.)\\s*)") || charToString.equals("\n")){
                    if(lengthWord != 0){
                        lengthWord = 0;
                        countWords++;
                    }
                }
            }
            String result = "words="+ countWords+", punctuation marks="+countMarks;
            System.out.println(result);
            inputStreamReader.close();

            OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(getPath(by.it.evstratov.jd01_14.TaskB.class)+FILENAME_TXT_RESULT));
            outputStream.append(result);
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

 */
////////////////////////////////////////////////////////////////////////////////////
public static void main(String[] args) {
    String path = getPath(TaskB.class);
    int words = 0;
    int marks = 0;
    try (BufferedReader fileRead = new BufferedReader(new FileReader(path + "TaskB.txt"))) {
        Pattern pattern = Pattern.compile("([а-яА-яёЁ]+)|([^а-яА-яёЁ\\s]+)");
        while (fileRead.ready()) {
            String line = fileRead.readLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    words++;
                }
                if (matcher.group(2) != null) {
                    marks++;
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println("words=" + words + " punctuation marks=" + marks);

    try (BufferedWriter fileWrite = new BufferedWriter(new FileWriter(path + "resultTaskB.txt"))) {
        fileWrite.write("words=" + words + " punctuation marks=" + marks);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private static String getPath(Class<?> clazz) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = clazz.getName()
                .replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }

}
