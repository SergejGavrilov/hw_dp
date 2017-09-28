package List;

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
        return getElement(i).info;
    }

    public void addFirst(E item) {
        head = new Node<E>(item, head);
        size += 1;
    }


    public void addLast(E item) {
        if (head == null) addFirst(item);
        else {
            Node<E> tmp = head;
            while (tmp.next != null) tmp = tmp.next;

            tmp.next = new Node<E>(item, null);
        }
        size++;
    }

    public void insertAfter(E key, E toInsert) {
        Node<E> tmp = head;
        while (tmp != null && !tmp.info.equals(key)) tmp = tmp.next;

        if (tmp != null)
            tmp.next = new Node<E>(toInsert, tmp.next);

        size++;
    }

    public void insertBefore(E key, E toInsert) {
        if (head == null) return;
        if (head.info.equals(key)) {
            addFirst(toInsert);
            return;
        }

        Node<E> prev = null;
        Node<E> cur = head;

        while (cur != null && !cur.info.equals(key)) {
            prev = cur;
            cur = cur.next;
        }
        //insert between cur and prev
        if (cur != null) prev.next = new Node<E>(toInsert, cur);
        size++;
    }

    public void remove(E key) {
        if (head == null) throw new RuntimeException("cannot delete");

        if (head.info.equals(key)) {
            head = head.next;
            return;
        }

        Node<E> cur = head;
        Node<E> prev = null;

        while (cur != null && !cur.info.equals(key)) {
            prev = cur;
            cur = cur.next;
        }

        if (cur == null) throw new RuntimeException("cannot delete");

        //delete cur node
        prev.next = cur.next;
        size--;
    }

    public void swap(int i, int j) {

        if (i > j) {
            int temp = i;
            i = j;
            j = i;
        }

        if (i == j)
            return;

        if (i < 0 || j > size)
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
        Node<E> temp;
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                Node<E> fst = getElement(j);
                Node<E> scnd = getElement(j - 1);

                Node<E> next_1 = getElement(j + 1);
                Node<E> next_2 = fst;

                Node<E> prev_1 = scnd;
                Node<E> prev_2 = getElement(j - 2);

                if (fst.info.compareTo(scnd.info) < 0) {
                    if (prev_2 != null)
                        prev_2.next = fst;
                    fst.next = scnd;
                    scnd.next = next_1;

                    if (j - 1 == 0)
                        head = fst;
                }
            }
        }
    }
}