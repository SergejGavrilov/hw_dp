package decorator;

import java.io.PrintStream;

public class NumOfElemDecorator<E> extends SequenceDecorator<E> {


    public NumOfElemDecorator(Sequence<E> sequenceToBeDecorated) {
        super(sequenceToBeDecorated);
    }

    @Override
    public void print(String delimiter, PrintStream ps) {
        super.print(delimiter, ps);
        ps.print(" всего " + super.size() + " элементов");
    }
}
