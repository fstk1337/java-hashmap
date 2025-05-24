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

        System.out.println(map.get(null));
        System.out.println(map.get("Adam"));
        System.out.println(map.get("Jamie"));
        System.out.println(map.get("Rocky"));

        System.out.println(map.keySet());
        System.out.println(map.values());
        map.entrySet().forEach(System.out::println);

        map.remove(null);
        map.remove("Peter");
        map.remove("Jamie");
        map.remove("Christopher");
        System.out.println(map);

        map.clear();
        System.out.println(map);
    }
}
