import java.util.ArrayList;

public class Method {
    public Method() {
    }

    public void method(ArrayList<Integer> arrayList) {

        if (arrayList.size() == 0) {
            throw new NullPointerException("ArrayList is empty");
        } else {

            if (arrayList.size() % 2 != 0) {
                arrayList.remove(arrayList.size() - 1);
                Method method = new Method();
                method.method(arrayList);
            } else {
                ArrayList<Integer> ans = new ArrayList<>();

                for (int i = 1; i < arrayList.size(); i += 2) {
                    if (arrayList.get(i - 1) >= arrayList.get(i)) {
                        ans.add(arrayList.get(i - 1));
                        ans.add(arrayList.get(i));
                    }
                }

                System.out.println(ans);

            }

        }

    }
}
