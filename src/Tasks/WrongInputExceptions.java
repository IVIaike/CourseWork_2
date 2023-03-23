package Tasks;

public class WrongInputExceptions extends Exception {
    public WrongInputExceptions() {
    }

    public WrongInputExceptions(String message) {
        super(message);
    }

    public WrongInputExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongInputExceptions(Throwable cause) {
        super(cause);
    }

    public WrongInputExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
