import java.util.Iterator;

public class LinkedDeque<E> implements Deque<E> {
    private class Node {
        E item;
        Node next;
        Node previous;
    }


    private int size = 0;
    private Node first = null;
    private Node last = null;

    public LinkedDeque(){}

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }


    @Override
    public void addFirst(E elem) {
        Node newFirst = new Node();
        newFirst.item = elem;

        if (first != null) {
            newFirst.next = first;
            first.previous = newFirst;
        }
        first = newFirst;
        if (last == null) last = first;

        size++;

    }

    @Override
    public E first() {
        return first.item;
    }

    @Override
    public E removeFirst() {
        Node oldFirst = first;
        first = first.next;

        if (first == null)
            last = null;
        else
            first.previous = null;

        size--;

        return oldFirst.item;
    }

    @Override
    public void addLast(E elem) {
        Node newLast = new Node();
        newLast.item = elem;

        if (last != null) {
            newLast.previous = last;
            last.next = newLast;
        }
        last = newLast;
        if (first == null) first = last;

        size++;

    }

    @Override
    public E last() {
        return last.item;
    }

    @Override
    public E removeLast() {
        Node oldLast = last;
        last = oldLast.previous;

        if (last == null)
            first = null;
        else
            last.next = null;

        size--;

        return oldLast.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E item = current.item;
                current = current.next;
                return item;
            }
        };
    }
}
