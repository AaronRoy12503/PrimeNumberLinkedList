/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primenumberlinkedlist;

// Node class for the linked list
class Node {
    int value;
    Node next;

    // Constructor for Node
    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

// SinglyLinkedList class
class SinglyLinkedList {
    Node head;

    // Method to add a new node with the given value to the linked list
    void append(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
        }
    }
}

public class PrimeNumberLinkedList {
    // Method to check if a given number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Method to check if a given number contains the digit '3'
    public static boolean hasDigitThree(int n) {
        return String.valueOf(n).contains("3");
    }

    public static void main(String[] args) {
        int n = 100;

        // Create a linked list for prime numbers with the digit '3'
        SinglyLinkedList threesList = new SinglyLinkedList();

        // Populate the linked list
        for (int i = 2; i < n; i++) {
            if (isPrime(i) && hasDigitThree(i)) {
                threesList.append(i);
            }
        }

        int sum = 0;
        Node current = threesList.head;
        // Generate the output string
        StringBuilder output = new StringBuilder("The sum of the prime numbers (with 3 digit) between 0 and n=" + n + " is (");
        while (current != null) {
            sum += current.value;
            output.append(current.value);
            if (current.next != null) {
                output.append(" + ");
            }
            current = current.next;
        }
        output.append(") = ").append(sum);

        // Print the output
        System.out.println(output.toString());
    }
}



