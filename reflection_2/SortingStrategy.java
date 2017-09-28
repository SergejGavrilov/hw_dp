package reflection_2;

public class SortingStrategy {


    public int size() {
        return 4;
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    E t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }

    public static <E extends Comparable<E>> void insertionSort(E[] array) {
        E temp;
        int j;
        for(int i = 0; i < array.length - 1; i++){
            if (array[i].compareTo(array[i + 1]) > 0) {
                temp = array[i + 1];
                array[i + 1] = array[i];
                j = i;
                while (j > 0 && temp.compareTo(array[j - 1]) < 0) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }
        }
    }

    public static <E extends Comparable<E>> void quickSort(E[] array) {
        qSort(array, 0, array.length);
    }

    private static <E extends Comparable<E>> int partition(E[] array, int left, int right)
    {
        int i = left, j = right;
        E tmp;
        E pivot = array[(left + right) / 2];

        while (i <= j) {
            while (array[i].compareTo(pivot) < 0)
                i++;
            while (array[j].compareTo(pivot) > 0)
                j--;
            if (i <= j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

    private static <E extends Comparable<E>> void qSort(E array[], int left, int right) {
        int index = partition(array, left, right);
        if (left < index - 1)
            qSort(array, left, index - 1);
        if (index < right)
            qSort(array, index, right);
    }

}
