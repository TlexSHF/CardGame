import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        int a = 0;
        int b = a;

        int[] array = new int[4];
        ArrayList<String> arr2 = new ArrayList<String>();

        t.addOne(a);
        t.addArray(array);
        t.addArrList(arr2);

        System.out.println(array[0]);
        System.out.println(arr2.get(0));
        System.out.println(a);
    }
    public void addOne(int nr) { nr++; }
    public void addArray(int[] a) {
        a[0] = 4;
    }
    public void addArrList(ArrayList<String> a) {
        a.add("henlo");
    }
}
