package List;

public class Test {

    public static void main(String[] args) {

        List<Integer> list = new List<Integer>();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(2);

        list.swap(0, 1);
        list.sort();
        for (int i = 0; i < list.getSize(); i++) {
            System.out.print(list.getValue(i) + " ");
        }
    }
}
