package by.fstk1337.datatype;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(3);

        map.put("Adam", "The One");
        map.put("Peter", "The Great");
        map.put("Jamie", "The Unstoppable");
        map.put("Adam", "Goat 777");
        map.put("Jacky", "High jumper");
        map.put(null, "Empty");

        System.out.println(map);
        System.out.println(map.size());

        System.out.println(map.get("Adam"));
        System.out.println(map.get("Jamie"));
        System.out.println(map.get("Peter"));
        System.out.println(map.get(null));
        System.out.println(map.get("William"));
    }
}
