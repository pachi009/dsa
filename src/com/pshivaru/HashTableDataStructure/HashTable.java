package com.pshivaru.HashTableDataStructure;

public class HashTable {

    class HashNode {
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private HashNode[]  buckets;
    private static final int DEFAULT_CAPACITY = 10;
    private static final float LOAD_FACTOR = 0.75f;
    private int size;

    HashTable() {
        this(DEFAULT_CAPACITY);
    }

    HashTable(int capacity) {
        buckets = new HashNode[capacity];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void put(Integer key, String value){
        if(key == null || value == null){
            throw new NullPointerException();
        }
        int index = findHashIndex(key);
        HashNode head = buckets[index];
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        HashNode n = new HashNode(key, value);
        head = buckets[index];
        n.next = head;
        buckets[index] = n;
        size++;
    }

    // Modular hash function
    private int findHashIndex(Integer key) {
        return key % buckets.length;
    }

    public String get(Integer key){
        int index = findHashIndex(key);
        HashNode head = buckets[index];
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public String remove(Integer key){
        int index = findHashIndex(key);
        HashNode head = buckets[index];
        HashNode prev = null;
        while(head != null){
            if(head.key.equals(key)){ // key exists and update next node if any
                String val = head.value;
                if(prev == null){  // Node to be deleted is first one in the chain
                    buckets[index] = head.next;
                } else { // Node to be deleted is not the first one in the chain
                    prev.next = head.next;
                }
                head.next = null;
                size--;
                return val;
            } else {
                prev = head;
                head = head.next;
            }
        }
        return null; // key does not exist
    }



    public static void main(String[] args) {
        HashTable ht = new HashTable(5);
        ht.put(1, "One");
        ht.put(2, "Two");
        ht.put(21, "Twenty One");
        ht.put(2, "2");
        ht.put(31, "Thirty One");
        System.out.println("HashTable Size: " +ht.size());
        System.out.println("getValue: " +ht.get(21));
        System.out.println("getValue: " +ht.get(2));
        System.out.println("getValue: " +ht.get(5));

        System.out.println("Remove Key: " +ht.remove(21));
        System.out.println("HashTable Size after removal: " +ht.size());
        System.out.println("getValue: " +ht.get(21));

        System.out.println("Remove Key: " +ht.remove(31));
        System.out.println("HashTable Size after removal: " +ht.size());
        System.out.println("getValue: " +ht.get(31));

        System.out.println("Remove Key: " +ht.remove(1));
        System.out.println("HashTable Size after removal: " +ht.size());
        System.out.println("getValue: " +ht.get(1));
    }
}


