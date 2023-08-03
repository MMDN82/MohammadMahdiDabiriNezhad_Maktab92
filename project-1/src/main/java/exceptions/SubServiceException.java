package exceptions;

public class SubServiceException extends Exception{
    public SubServiceException() {
    }

    public SubServiceException(String message) {
        super(message);
    }
}
