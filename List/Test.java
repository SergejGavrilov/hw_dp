package List;

public class Test {

    public static void main(String[] args) {

        List<Integer> list = new List<Integer>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(6);

        list.swap(1, 0);
        list.sort();
        for (int i = 0; i < list.getSize(); i++) {
            System.out.print(list.getValue(i) + " ");
        }
    }
}
