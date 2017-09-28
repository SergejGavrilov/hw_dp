package decorator;

import java.io.PrintStream;

public class PlainSequence implements Sequence<Integer>{
    private Integer[] array;

    public PlainSequence(Integer... elements) {
        array = elements;
    }

    @Override
    public void print(String delimiter, PrintStream ps) {
        for (int i = 0; i < array.length - 1; i++) {
            ps.print(array[i].toString() + delimiter);
        }
        ps.print(array[array.length - 1].toString());

    }

    public int size() { return array.length; }

}
