package List_2;
//Второе задание на тему списков

import List.List;

import java.util.ArrayList;
import java.util.Iterator;

public class ListCyclic<E> implements CycList<E> {

    private Node<E> head = null;

    public ListCyclic(ArrayList<E> arr) {
        if (arr.size() == 0) {
            head = null;
            return;
        }
        head = new Node<E>();
        Node<E> curr = head;
        for (int i = 0; i < arr.size() - 1; i++) {
            curr.info = arr.get(i);
            curr.next = new Node();
            curr = curr.next;
        }
        curr.info = arr.get(arr.size() - 1);
        curr.next = head;
    }


    private static class Node<E> {
        E info;
        Node<E> next;

    }


    @Override
    public void shift(int delta) {
        for (int index = 0; index < delta; index++) {
            head = head.next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> current = head;

            @Override
            public boolean hasNext() {
                return (current != null);
            }

            @Override
            public E next() {
                E t = current.info;
                current = current.next;
                return t;
            }
        };
    }



    public int length() {
        //проверка на наличие элементов в списке
        if (head == null)
            return 0;
        int count = 1;
        Iterator<E> it = this.iterator();
        Object fst = it.next();
        Object t = it.next();
        // equals заменено на !=, теперь проверяем неравенство объектов, а не значений
        while (fst != t && it.hasNext()) {
            t = it.next();
            count++;
        }
        return count;
    }

    public static <E> boolean listsEqual(CycList<E> list1, CycList<E> list2) {
        int len = ((ListCyclic<E>)list1).length();
        if (len != ((ListCyclic<E>)list2).length()) {
            return false;
        }
        if (len == 0) {
            return true;
        }

        for (int i = 0; i < len; i++) {
            Iterator it1 = list1.iterator();
            Iterator it2 = list2.iterator();

            boolean isEqual = true;

            int counter = 0;
            while (it1.hasNext() && isEqual && (counter != len)){
                isEqual = it1.next() == it2.next();
                counter++;
            }
            if (isEqual)
                return true;


            list1.shift(1);

        }
        return false;
    }


}
