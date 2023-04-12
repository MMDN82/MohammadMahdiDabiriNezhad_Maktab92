import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            throw new ExceptionA();
        }
        catch(Exception exception){
            System.out.println(exception.toString());
        }
        try{
            throw new ExceptionB();
        }
        catch(Exception exception){
            System.out.println(exception.toString());
        }
        try{
            throw new NullPointerException();
        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
        try{
            throw new IOException();
        }
        catch (Exception exception){
            System.out.println(exception.toString());
        }
    }
}



