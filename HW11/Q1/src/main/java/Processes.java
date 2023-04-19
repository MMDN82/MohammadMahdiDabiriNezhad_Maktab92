import java.util.Iterator;
import java.util.TreeSet;

public class Processes {
    public Processes() {
    }

    public void community(TreeSet treeSet, TreeSet treeSet1) {
        Iterator<Character> iterator = treeSet.iterator();
        Iterator<Character> iterator1 = treeSet1.iterator();
        TreeSet<Character> sum = new TreeSet<Character>();

        Character c;
        while (iterator.hasNext()) {
            c = iterator.next();
            sum.add(c);
        }
        while (iterator1.hasNext()) {
            c = iterator1.next();
            sum.add(c);
        }
        System.out.println("community : " + sum);
    }
    public void subscription(TreeSet treeSet , TreeSet treeSet1){
        TreeSet<Character> commonElements = new TreeSet<>(treeSet);
        commonElements.retainAll(treeSet1);
        System.out.println( "subscription : " +commonElements);
    }
}
