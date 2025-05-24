package by.fstk1337.datatype;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(3);

        map.put("Adam", "The One");
        map.put("Peter", "The Great");
        map.put("Jamie", "The Unstoppable");
        map.put("Adam", "Goat 777");
        map.put("Jacky", "High jumper");

        System.out.println(map);
        System.out.println(map.size());

        System.out.println(map.remove("Jamie"));
        System.out.println(map.remove("Peter"));
        System.out.println(map);
        System.out.println(map.size());
    }
}
