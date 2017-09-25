import java.lang.reflect.Array;
import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {


    private E[] arr;
    private int size;
    private int front = -1, rear = 0;

    public ArrayDeque(int n) {

        E[] arr = (E[]) Array.newInstance(Object.class, n);
        this.arr = arr;
        size = n;
    }


    boolean isFull() {
        return ((front == 0 && rear == size - 1) ||
                front == rear + 1);
    }

    boolean isEmpty() {
        return (front == -1);
    }

    @Override
    public void addFirst(E elem) {

        if (isFull()) {
            System.out.println("Overflow");
            return;
        }

        // If queue is initially empty
        if (front == -1) {
            front = 0;
            rear = 0;
        }

        // front is at first position of queue
        else if (front == 0)
            front = size - 1;

        else // decrement front end by '1'
            front = front - 1;

        // insert current element into Deque
        arr[front] = elem;
    }

    @Override
    public E first() {
        return arr[front];
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return null;
        }

        E temp = first();

        // Deque has only one element
        if (front == rear) {
            front = -1;
            rear = -1;
        } else
            // back to initial position
            if (front == size - 1)
                front = 0;

            else // increment front by '1' to remove current
                // front value from Deque
                front = front + 1;


        return temp;
    }


    @Override
    public void addLast(E elem) {
        if (isFull())
        {
            System.out.println(" Overflow ");
            return;
        }

        // If queue is initially empty
        if (front == -1)
        {
            front = 0;
            rear = 0;
        }

        // rear is at last position of queue
        else if (rear == size-1)
            rear = 0;

            // increment rear end by '1'
        else
            rear = rear+1;

        // insert current element into Deque
        arr[rear] = elem; ;
    }


    @Override
    public E last() {
        return arr[rear];
    }

    @Override
    public E removeLast() {
        // check whether Deque is empty or not
        if (isEmpty())
        {
            System.out.println("Queue Underflow\n");
            return null;
        }

        E temp = last();
        // Deque has only one element
        if (front == rear)
        {
            front = -1;
            rear = -1;
        }
        else
            // back to initial position
            if (front == size -1)
                front = 0;

            else // increment front by '1' to remove current
                // front value from Deque
                front = front+1;
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int currElem = front;
            @Override
            public boolean hasNext() {
                return (currElem != rear);
            }

            @Override
            public E next() {
                if (currElem == size -1)
                    currElem = 0;

                else // increment front by '1' to remove current
                    // front value from Deque
                    currElem = currElem + 1;
                return arr[currElem];
            }
        };
    }
}
