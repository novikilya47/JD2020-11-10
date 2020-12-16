package by.it.evstratov.calc;

public class CalcException extends Exception{

    public CalcException() {
        super();
        RepoVar.saveErrors(this.getMessage());
    }

    public CalcException(String message) {
        super("ERROR: "+message);
        RepoVar.saveErrors(this.getMessage());
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
        RepoVar.saveErrors(this.getMessage());
    }

    public CalcException(Throwable cause) {
        super(cause);
        RepoVar.saveErrors(this.getMessage());
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: "+ message, cause, enableSuppression, writableStackTrace);
        RepoVar.saveErrors(this.getMessage());
    }
}
