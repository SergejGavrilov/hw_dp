package decorator;

import java.io.PrintStream;

public class TitleDecorator<E> extends SequenceDecorator<E> {

    protected String title;

    public TitleDecorator(Sequence<E> sequenceToBeDecorated, String title) {
        super(sequenceToBeDecorated);
        this.title = title;
    }

    @Override
    public void print(String delimiter, PrintStream ps) {
        ps.print(title + " ");
        super.print(delimiter, ps);
    }
}
