package List;

//Первое задание на тему списков

public class List<E extends Comparable<E>> {

    Node<E> head = null;

    private int size = 0;

    private static class Node<E> {
        E info;
        Node<E> next;

        public Node(E info, Node<E> next) {
            this.info = info;
            this.next = next;

        }
    }

    public int getSize(){
        return size;
    }

    public E getValue(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException();

        return getElement(i).info;
    }

    public void addFirst(E item) {
        head = new Node<E>(item, head);
        size += 1;
    }



    public void swap(int i, int j) {

        if (i > j) {
            int temp = i;
            i = j;
            j = temp;
        }

        if (i == j)
            return;

        if (i < 0 || j >= size)
            throw new IndexOutOfBoundsException();


        Node<E> fst = head;
        Node<E> prev_1 = null;
        for (int k = 0; k < i; k++) {
            prev_1 = fst;
            fst = fst.next;
        }
        //fst = fst.next;


        Node<E> scd = head;
        Node<E> prev_2 = null;
        for (int k = 0; k < j; k++) {
            prev_2 = scd;
            scd = scd.next;
        }
        //scd = scd.next;

        Node<E> next_1 = fst.next;
        Node<E> next_2 = scd.next;

        //In case elements are neighbours
        if (j - 1 == i) {
            fst.next = next_2;
            if (prev_1 != null)
                prev_1.next = scd;
            scd.next = fst;
            if (i == 0)
                head = scd;
            return;
        }

        if (prev_1 != null)
            prev_1.next = scd;

        prev_2.next = fst;

        fst.next = next_2;
        scd.next = next_1;

        if (i == 0)
            head = scd;


    }

    //returns element on position i in list
    public Node<E> getElement(int i) {

        if (i < 0 || i > size)
            return null;

        Node<E> element = head;

        for (int k = 0; k < i; k++)
            element = element.next;
        return element;
    }

    public void sort() {
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {

                if (getElement(j).info.compareTo(getElement(j - 1).info) < 0) {
                    swap(j - 1, j);
                }
            }
        }
    }
}