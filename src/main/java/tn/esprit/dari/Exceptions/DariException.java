package tn.esprit.dari.Exceptions;

public class DariException extends RuntimeException{

    public DariException(String s, Exception e) {
        super(s);
    }
    public DariException(String s) {
        super(s);
    }
}
