package exceptions;

public class MailException extends NullPointerException{
    public MailException() {
        super("this e-mail is exist");
    }

}
