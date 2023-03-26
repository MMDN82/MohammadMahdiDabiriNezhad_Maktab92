import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


 ElementArray elementArray = new ElementArray("C",5,  12.01);
        System.out.println(elementArray.toString());
        elementArray.describeElement();
        ElementArray elementArray2 = new ElementArray("Ar",18,  30);
        System.out.println(elementArray2.toString());
        elementArray2.describeElement();


    }
}