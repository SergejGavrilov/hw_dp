package decorator;

public class Test {
    public static void main(String[] args) {
        new PlainSequence(1,2,3,4,5).print(",", System.out);
        Sequence<Integer> fst = new BracketsDecorator<Integer>(new PlainSequence(1,2,3,4), "{","}" );


        Sequence<Integer> sec = new NumOfElemDecorator<Integer>(new BracketsDecorator<Integer>(new PlainSequence(1,2,3,4), "{","}" ));


        Sequence<Integer> thir = new TitleDecorator<Integer>(new NumOfElemDecorator<Integer>
                                            (new BracketsDecorator<Integer>
                                            (new PlainSequence(1,2,3,4), "{","}" )), "Элементы: ");




        System.out.println();
        fst.print(",", System.out);
        System.out.println();
        sec.print(",", System.out);
        System.out.println();
        thir.print(",", System.out);
    }
}
