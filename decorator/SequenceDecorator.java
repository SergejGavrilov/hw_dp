package decorator;

import java.io.PrintStream;

public abstract class SequenceDecorator<E> implements Sequence<E>{

    protected Sequence<E> sequenceToBeDecorated;

  /*  public <E> SequenceDecorator(Sequence<E> sequenceToBeDecorated) {
    }
*/
    public  SequenceDecorator(Sequence<E> sequenceToBeDecorated){
        this.sequenceToBeDecorated = sequenceToBeDecorated;
    }

    public void print(String delimiter, PrintStream ps) {
        sequenceToBeDecorated.print(delimiter, ps);
    }

    public int size() {
        return sequenceToBeDecorated.size();
    }
}
