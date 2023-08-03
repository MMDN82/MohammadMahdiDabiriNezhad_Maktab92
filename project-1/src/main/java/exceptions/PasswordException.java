package exceptions;

public class PasswordException extends Exception{
    public PasswordException(String message) {
        super("Invalid password: " + message);
    }

    public PasswordException() {
    }
}
