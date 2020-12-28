package by.it.novik.jd02_06;

import java.io.*;

class Logger {
    private final String logname="log.txt";


    private static volatile Logger logger;

    private Logger(){

    }

    static Logger getLogger(){
        Logger local=logger;
        if (logger==null){
            synchronized (Logger.class) {
                local = logger;
                if (logger==null){
                    local=logger=new Logger();
                }
            }
        }
        return local;
    }

    void log(String message){
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(getPath(), true))) {
            printWriter.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized String getPath() {
        String src=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String name = Logger.class.getName();
        String path = name.replace(Logger.class.getSimpleName(), "").replace(".", File.separator);
        return src+path+logname;
    }
}
