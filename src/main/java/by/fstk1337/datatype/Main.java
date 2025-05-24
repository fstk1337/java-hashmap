package by.fstk1337.datatype;

public class Main {
    public static void main(String[] args) {
        Entry<Integer, String> one = new Entry<>(1, "one");
        Entry<Integer, String> two = new Entry<>(2, "two");
        Entry<Integer, String> three = new Entry<>(3, "three");
        Entry<Integer, String> four = new Entry<>(1, "four");
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
        one.setNext(two);
        two.setNext(three);
        if (one.hasNext()) {
            System.out.println("The next after one:");
            System.out.println(one.getNext());
        }
        if (two.hasNext()) {
            System.out.println("The next after two:");
            System.out.println(two.getNext());
        }
        if (three.hasNext()) {
            System.out.println("The next after three:");
            System.out.println(three.getNext());
        }
        if (four.hasNext()) {
            System.out.println("The next after four:");
            System.out.println(four.getNext());
        }
        one.setValue("over one");
        two.setValue("over two");
        three.setValue("over three");
        four.setValue("over one");
        System.out.println(one.equals(one));
        System.out.println(one.equals(Integer.valueOf(1)));
        System.out.println(one.equals(two));
        System.out.println(one.equals(three));
        System.out.println(one.equals(four));
    }
}
