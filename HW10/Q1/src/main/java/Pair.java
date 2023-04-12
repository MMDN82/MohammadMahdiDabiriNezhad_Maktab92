import java.util.ArrayList;

public class Pair<T> {
    private T x;
    private T y;
    protected ArrayList<Object> point = new ArrayList<>();

    public Pair() {
    }
    public Pair(T x, T y) {
        this.x = x;
        this.y = y;
        point.add(x);
        point.add(y);
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}
