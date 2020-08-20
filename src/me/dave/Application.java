package me.dave;

public class Application {
    public static void main(String[] args) {
        HashTable ht = new HashTable(3);
        ht.put("dave", "nice guy");
        ht.put("cloe", "beautiful");

        System.out.println(ht.get("dave"));
        System.out.println(ht.get("cloe"));
        System.out.println(ht.get("noel"));
    }
}
