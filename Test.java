import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

@SuppressWarnings("ALL")
public class Test {


    public static void main(String[] args) {


        ClassLoader classLoader = Test.class.getClassLoader();
        Class<Deque> dequeClass = null;
        try {
            dequeClass = (Class<Deque>) classLoader.loadClass(args[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Deque<Integer> deque = null;
        if (dequeClass.getName().equals("ArrayDeque")) {
            Constructor constructor = null;

            try {
                constructor = dequeClass.getConstructor(int.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            try {
                deque = (Deque<Integer>) constructor.newInstance(Integer.parseInt(args[1]));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        } else {

            try {
                deque = dequeClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            Integer r1 = random.nextInt(10);
            deque.addFirst(r1);
            System.out.println(r1);
        }

        int sum = 0;
        for (Integer item : deque) {
            sum = sum + item;
        }
        System.out.println(sum);

        try {
            Method size = dequeClass.getMethod("size");
            System.out.println("elements count: " + size.invoke(deque).toString());
        } catch (NoSuchMethodException e) {
            System.out.println("size() not exist");
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}


