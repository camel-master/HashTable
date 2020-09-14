package me.dave;

import java.util.LinkedList;

/**
 * generate hash code --> get index by hash code -> access to LinkedList that contains nodes by index
 * So we need to add fixed size array. That array contain some linked lists.
 *
 * int getHashCode(String key) : Generate hash code by inputted key.
 * int getIndex(int hashCode) : index of key
 * String get(String key) : get key's value
 * void put(String key, String value) : Store value in hash table
 * Node getNode(LinkedList<Node> list, String key) : find node of key and return it.
 */
public class HashTable {
    private class Node {
        private String key;
        private String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String value() {
            return value;
        }

        public void value(String value) {
            this.value = value;
        }
    }
    private LinkedList<Node>[] table;

    public HashTable(int tableSize) {

        table = new LinkedList[tableSize];
        for(int i=0; i < tableSize; i++) {
            table[i] = new LinkedList<Node>();
        }
    }

    private int getHashCode(String data) {

        int hashCode = 0;
        for(char c : data.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }

    private int getIndex(int hashCode) {
        return hashCode%table.length;
    }

    private Node getNode(LinkedList<Node> list, String key) {
        if(list == null) {
            return null;
        }
        for(Node n : list) {
            if(n.key == key) { return n;}
        }
        return null;
    }

    public String get(String key) {
        int hashCode = getHashCode(key);
        int index = getIndex(hashCode);
        Node n = getNode(table[index], key);
        return n == null ? "not found" : n.value();
    }
    public void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = getIndex(hashCode);

        Node node = getNode(table[index], key);
        if(node == null) {
            Node newNode = new Node(key, value);
            table[index].add(newNode);
        } else {
            node.value(value);
        }
    }
}
