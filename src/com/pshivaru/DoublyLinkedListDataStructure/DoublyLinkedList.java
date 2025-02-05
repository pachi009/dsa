package com.pshivaru.DoublyLinkedListDataStructure;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public void addFirst(int data) {
        Node n = new Node(data);
        if(size == 0) {
            head = tail = n;
        } else{
            n.next = head;
            head.prev = n;
            head = n;
        }
        size++;
    }

    public void addLast(int data) {
        Node n = new Node(data);
        if(size == 0) {
            head = tail = n;
        } else{
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        size++;
    }

    public void addAtIndex(int index, int data) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if(index == 0) {
            addFirst(data);
        } else if(index == size) {
            addLast(data);
        } else {
            Node n = new Node(data);
            Node temp = head;
            while(index > 1){
                temp = temp.next;
                index--;
            }
            n.next = temp.next;
            temp.next.prev = n;
            temp.next = n;
            n.prev = temp;
            size++;
        }
    }

    public int getFirst() {
        if(size == 0) {
            System.out.println("List is empty");
        }
        return head.data;
    }

    public int getLast() {
        if(size == 0) {
            System.out.println("List is empty");
        }
        return tail.data;
    }

    public int getAtIndex(int index) {
        if(index < 0 || index >= size) {
            System.out.println("Index out of bounds");
        } else if(index == 0) {
            return getFirst();
        } else if(index == size-1) {
            return getLast();
        } else{
            Node temp = head;
            while(index > 0){
                temp = temp.next;
                index--;
            }
            return temp.data;
        }
        return -1;
    }

    public int removeFirst() {
        int val = -1;
        if(size == 0) {
            System.out.println("List is empty");
        } else if(size == 1) {
            val = head.data;
            head = tail = null;
            size--;
        } else {
            val = head.data;
            Node temp = head;
            head = head.next;
            temp.next = null;
            head.prev = null;
            size--;
        }
        return val;
    }

    public int removeLast() {
        int val = -1;
        if(size == 0) {
            System.out.println("List is empty");
        } else if(size == 1) {
            val = tail.data;
            head = tail = null;
            size--;
        } else {
            val = tail.data;
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
            size--;
        }
        return val;
    }

    public int removeAtIndex(int index) {
        int val = -1;
        if(index < 0 || index >= size) {
            System.out.println("Index out of bounds");
        } else if(index == 0) {
            val = removeFirst();
        } else if(index == size-1) {
            val = removeLast();
        } else {
            Node temp = head;
            while(index > 0){
                temp = temp.next;
                index--;
            }
            val = temp.data;
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp = null;
            size--;
        }

        return val;
    }

    public void display(){
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}
