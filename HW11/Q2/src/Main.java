import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(11);
        arrayList.add(1);

        arrayList.add(1);
        arrayList.add(12);

        arrayList.add(0);
        arrayList.add(1);

        arrayList.add(1);


        Method method = new Method();

        method.method(arrayList);


    }
}
