import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Map extends Pair{
    private ArrayList<ArrayList<Object>> pairs = new ArrayList<>();

    public Map() {
    }
    public void add( Pair a){
       pairs.add(a.point);
    }
    public void assign(Map map){
        if (pairs.equals(map.pairs)){
            System.out.println("false");
        }
        else {
        pairs = map.pairs;
        System.out.println(pairs);

        }
    }


}
