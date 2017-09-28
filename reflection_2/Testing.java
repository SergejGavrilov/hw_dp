package reflection_2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Testing {

    static String package_name = "reflection_2.";


    public static void main(String[] args) {

        SortingStrategy sr = new SortingStrategy();
        Method sort = null;
        try {
            sort = sr.getClass().getMethod(args[0], Comparable[].class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        Random random = new Random();
        final int len = random.nextInt(20);

        Integer[] array = new Integer[len];

        for (int i = 0; i < len; i++) {
            array[i] = (Integer)random.nextInt(30);
        }

        Object[] param = {array};
        try {

            sort.invoke( Integer.class, param);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    //    SortingStrategy.bubbleSort(array);



        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}