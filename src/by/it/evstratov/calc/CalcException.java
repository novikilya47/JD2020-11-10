package by.it.evstratov.calc;

public class CalcException extends Exception{

    public CalcException() {
        super();
        RepoVar.saveToLog(this.getMessage());
    }

    public CalcException(String message) {
        super("ERROR: "+message);
        RepoVar.saveToLog(this.getMessage());
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
        RepoVar.saveToLog(this.getMessage());
    }

    public CalcException(Throwable cause) {
        super(cause);
        RepoVar.saveToLog(this.getMessage());
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: "+ message, cause, enableSuppression, writableStackTrace);
        RepoVar.saveToLog(this.getMessage());
    }
}
