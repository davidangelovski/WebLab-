package mk.ukim.finki.lab.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("This user is already registered");
    }
}
