package by.fstk1337.datatype;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map1 = new HashMap<>(5);
        HashMap<String, String> map2 = new HashMap<>();

        System.out.println(map1);
        System.out.println(map2);

        System.out.println(map1.size());
        System.out.println(map1.isEmpty());

        System.out.println(map2.size());
        System.out.println(map2.isEmpty());
    }
}
