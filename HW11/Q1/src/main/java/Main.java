import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Character> treeSet = new TreeSet<Character>();
        treeSet.add('a');
        treeSet.add('b');
        treeSet.add('c');
        treeSet.add('d');
        treeSet.add('e');
        treeSet.add('f');
        treeSet.add('g');
        treeSet.add('h');
        treeSet.add('i');
        treeSet.add('j');
        System.out.println(treeSet);


        TreeSet<Character> treeSet1 = new TreeSet<Character>();
        treeSet1.add('a');
        treeSet1.add('b');
        treeSet1.add('c');
        treeSet1.add('d');
        treeSet1.add('t');
        treeSet1.add('y');
        treeSet1.add('u');
        treeSet1.add('i');
        treeSet1.add('o');
        treeSet1.add('p');
        System.out.println(treeSet1);


        Processes processes = new Processes();
        processes.community(treeSet , treeSet1);



        processes.subscription(treeSet , treeSet1);




    }


}
