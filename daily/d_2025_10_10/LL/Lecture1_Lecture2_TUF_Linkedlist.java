package DSA_Diary.daily.d_2025_10_10.LL;

// https://youtu.be/Nq7ok-OyEpg?si=rLvbgXhM5CN8R5ht

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Lecture1_Lecture2_TUF_Linkedlist {

    // Convert array to Linked List
    public static Node convertArr_to_LL(int[] arr) {
        Node head = new Node(arr[0]);
        Node point = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            point.next = temp;
            point = temp;
        }
        return head;
    }

    // Find length of Linked List
    public static int lengthOfLL(Node head) {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Print Linked List
    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Remove head node
    public static Node removeHead(Node head) {
        if (head == null) return null;
        return head.next;
    }

    // Remove tail node
    public static Node removeTail(Node head) {
        if (head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    // Delete K-th node (1-based index)
    public static Node deleteKthNode(Node head, int k) {
        if (head == null) return null;
        if (k == 1) return head.next;

        Node temp = head;
        int count = 1;

        while (temp != null && count < k - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) return head;
        temp.next = temp.next.next;
        return head;
    }

    // Remove node by value
    public static Node removeByValue(Node head, int value) {
        if (head == null) return null;

        if (head.data == value) return head.next;

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }

    // Insert node at head
    public static Node insertAtHead(Node head, int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        return newNode;
    }

    // Insert node at tail
    public static Node insertAtTail(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    // Insert node at given position (1-based index)
    public static Node insertAtPosition(Node head, int position, int value) {
        Node newNode = new Node(value);

        if (position == 1) {
            newNode.next = head;
            return newNode;
        }

        Node temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of range!");
            return head;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    // Insert node before a given value
    public static Node insertBeforeValue(Node head, int value, int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) return null;

        // If inserting before head
        if (head.data == value) {
            newNode.next = head;
            return newNode;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value " + value + " not found!");
            return head;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    // Main method to test all
    public static void main(String[] args) {
        int[] arr = {23, 44, 54, 77, 87};
        Node head = convertArr_to_LL(arr);

        System.out.println("Original List:");
        printLL(head);

        head = removeHead(head);
        System.out.println("After removing head:");
        printLL(head);

        head = removeTail(head);
        System.out.println("After removing tail:");
        printLL(head);

        head = deleteKthNode(head, 2);
        System.out.println("After deleting 2nd node:");
        printLL(head);

        head = removeByValue(head, 77);
        System.out.println("After removing node with value 77:");
        printLL(head);

        head = insertAtHead(head, 10);
        System.out.println("After inserting 10 at head:");
        printLL(head);

        head = insertAtTail(head, 99);
        System.out.println("After inserting 99 at tail:");
        printLL(head);

        head = insertAtPosition(head, 3, 33);
        System.out.println("After inserting 33 at position 3:");
        printLL(head);

        head = insertBeforeValue(head, 87, 66);
        System.out.println("After inserting 66 before 87:");
        printLL(head);
    }
}
