import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Map a = new Map();
        Pair<Integer> pair = new Pair<>(1,2);
        Pair<String> pair1 = new Pair<>("3","4");
        a.add(pair);
        a.add(pair1);

        Map b = new Map();
        Pair<Integer> pair2 = new Pair<>(5,6);
        Pair<Integer> pair3 = new Pair<>(7,8);
        b.add(pair2);
        b.add(pair3);
        b.assign(b);







    }
}
