package com.pshivaru.DoublyLinkedListDataStructure;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(10);
        list.addLast(30);
//        IndexOutOfBoundsException
//        list.addAtIndex(-3, 50);
//        list.addAtIndex(5, 50);
        list.addAtIndex(0,20);
        list.addAtIndex(3, 40);
        list.addAtIndex(2, 50);
//        20->10->50->30->40
        list.display();
        System.out.println("List Size: " +list.getSize());

        System.out.println("getFirst: " +list.getFirst());
        System.out.println("getLast: " +list.getLast());
        System.out.println("getAtIndex 3 : " +list.getAtIndex(3));

        System.out.println("Remove first: " +list.removeFirst());
        list.display();
        System.out.println(list.getSize());

        System.out.println("Remove last: " +list.removeLast());
        list.display();
        System.out.println(list.getSize());

        System.out.println("Remove at Index 1: " +list.removeAtIndex(1));
        list.display();
        System.out.println(list.getSize());
    }
}
