package com.pshivaru.DoublyLinkedListDataStructure;

public class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        next = prev = null;
    }
}
