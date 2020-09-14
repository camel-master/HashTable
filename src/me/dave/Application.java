package me.dave;

public class Application {
    public static void main(String[] args) {
        HashTable ht = new HashTable(3);
        ht.put("dave", "nice guy");
        ht.put("cloe", "beautiful");

        System.out.println("dave: " + ht.get("dave"));
        System.out.println("cloe: " + ht.get("cloe"));
        System.out.println("noel: " + ht.get("noel"));
    }
}
