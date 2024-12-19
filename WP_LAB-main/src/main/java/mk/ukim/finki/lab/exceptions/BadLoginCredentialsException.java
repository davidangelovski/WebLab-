package mk.ukim.finki.lab.exceptions;

public class BadLoginCredentialsException extends RuntimeException {
    public BadLoginCredentialsException() {
        super("Entered wrong username or password");
    }
}
