package main;

/**
 * Exception générale de MowItNow
 */
public class MowItNowException extends Exception {

    public MowItNowException() { super(); }
    public MowItNowException(String message) { super(message); }
    public MowItNowException(String message, Throwable cause) { super(message, cause); }
    public MowItNowException(Throwable cause) { super(cause); }

}
