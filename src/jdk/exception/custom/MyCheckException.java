package jdk.exception.custom;

public class MyCheckException extends Exception{

    public MyCheckException() {
        super();
    }

    public MyCheckException(String message) {
        super(message);
    }

    public MyCheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyCheckException(Throwable cause) {
        super(cause);
    }

    protected MyCheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
