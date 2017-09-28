package decorator;

import java.io.PrintStream;

public class BracketsDecorator<E> extends SequenceDecorator<E>{

    protected String left, right;

    public BracketsDecorator(Sequence<E> sequenceToBeDecorated, String left, String right) {
        super(sequenceToBeDecorated);
        this.left= left;
        this.right = right;

    }

    @Override
    public void print(String delimiter, PrintStream ps) {
        ps.print(left);
        super.print(delimiter, ps);
        ps.print(right);
    }
}
