package by.it.novik.calc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class RepoVar {
    private RepoVar() {
    }

    private static String getPath(Class<?> claz) {
        String src=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String name = claz.getName();
        String path = name.replace(claz.getSimpleName(), "").replace(".", File.separator);
        return src+path+ "vars.txt";
    }



    static void loadVariables() {
        Parser parser = new Parser();
        try {
            Files.lines(Paths.get(getPath(RepoVar.class))).forEach(expression -> {
                        try {
                            parser.calc(expression);
                        } catch (CalcException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("SameParameterValue")
    static void saveVariables(Map<String, Var> vars) {
        try (
                PrintWriter printWriter = new PrintWriter(getPath(RepoVar.class))) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                printWriter.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
