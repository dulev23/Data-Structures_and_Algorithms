package Labs5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }
}
public class BubbleSortDLL {
    static Node head;
    public static Node insert(Node head,int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
        }
        return head;
    }

    static void bubbleSort(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        Node previous = null;

        do {
            swapped = false;
            Node current = head;

            while (current.next != previous) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
            previous = current;
        } while (swapped);
    }

    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] line = s.split(" ");
        for (int i = 0 ; i < N ;i++) {
            head = insert(head,Integer.parseInt(line[i]));
        }

        bubbleSort(head);
        printList(head);
    }
}
