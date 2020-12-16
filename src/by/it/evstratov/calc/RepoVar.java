package by.it.evstratov.calc;

import by.it.evstratov.jd01_14.TaskC;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class RepoVar {

    private RepoVar() {
    }

    private static String getFilename() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = RepoVar.class.getName()
                .replace(RepoVar.class.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }

    static void loadVariables() {
        Parser parser = new Parser();
        try {
            Files.lines(Paths.get(getFilename()+"vars.txt")).forEach(expression -> {
                        try {
                            parser.calc(expression);
                        } catch (CalcException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }


    @SuppressWarnings("SameParameterValue")
    static void saveVariables(Map<String, Var> vars) {
        try (
                PrintWriter printWriter = new PrintWriter(getFilename()+"vars.txt")) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                printWriter.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void saveErrors(String message) {
        OutputStreamWriter outputStream;
        try {
            outputStream = new OutputStreamWriter(new FileOutputStream(getFilename()+"log.txt",true));

            outputStream.write(message+"\n");
            outputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void saveCalculating(String expression) {
        OutputStreamWriter outputStream;
        try {
            outputStream = new OutputStreamWriter(new FileOutputStream(getFilename()+"log.txt",true));

            outputStream.write(expression);
            outputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
