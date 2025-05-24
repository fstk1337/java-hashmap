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

        System.out.println(map.containsKey(null));
        System.out.println(map.containsKey("Peter"));
        System.out.println(map.containsKey("Jamie"));
        System.out.println(map.containsKey("Howard"));

        System.out.println(map.containsValue(null));
        System.out.println(map.containsValue("The Unstoppable"));
        System.out.println(map.containsValue("Goat 777"));
        System.out.println(map.containsValue("Very good"));

        map.clear();
        System.out.println(map);
    }
}
