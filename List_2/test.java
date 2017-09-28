package List_2;

import java.util.ArrayList;

public class test {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);


        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(1);
        arr1.add(4);
        arr1.add(3);
        arr1.add(2);

        ListCyclic<Integer> l1 = new ListCyclic<Integer>(arr);
        ListCyclic<Integer> l2 = new ListCyclic<Integer>(arr1);

        System.out.print(ListCyclic.listsEqual(l1, l2));


    }
}
