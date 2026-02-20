package DSA_Diary.daily.d_2026_02_20;


/*
Sort a Linked List of 0's, 1's and 2's

Given the head of a singly linked list consisting only of 0, 1 or 2.

Task:
Sort the linked list in-place by changing links (not creating new data nodes).

-------------------------------------------------------

Example 1:
Input:  1 -> 0 -> 2 -> 0 -> 1
Output: 0 -> 0 -> 1 -> 1 -> 2

Example 2:
Input:  1 -> 1 -> 1 -> 0
Output: 0 -> 1 -> 1 -> 1
-------------------------------------------------------
*/

//class Node {
//    int data;
//    Node next;
//
//    Node(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}

public class Sort012LinkedList {

    // Utility: Print List
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // =========================================================
    // APPROACH 1: Brute Force (Counting Method)
    // =========================================================
    /*
    Idea:
    - Count number of 0s, 1s, 2s
    - Rewrite list values in sorted order

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    static Node sortListBruteForce(Node head) {

        if (head == null || head.next == null)
            return head;

        int count0 = 0, count1 = 0, count2 = 0;
        Node temp = head;

        // Count occurrences
        while (temp != null) {
            if (temp.data == 0) count0++;
            else if (temp.data == 1) count1++;
            else count2++;
            temp = temp.next;
        }

        // Rewrite values
        temp = head;
        while (count0-- > 0) {
            temp.data = 0;
            temp = temp.next;
        }
        while (count1-- > 0) {
            temp.data = 1;
            temp = temp.next;
        }
        while (count2-- > 0) {
            temp.data = 2;
            temp = temp.next;
        }

        return head;
    }


    // =========================================================
    // APPROACH 2: Optimized (Separate Linked Lists Method)
    // =========================================================
    /*
    Idea:
    - Create three dummy nodes: zeroHead, oneHead, twoHead
    - Traverse list and attach nodes to respective list
    - Connect three lists together
    - Do not create new nodes, just change links

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    static Node sortListOptimized(Node head) {

        if (head == null || head.next == null)
            return head;

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead, one = oneHead, two = twoHead;
        Node temp = head;

        // Separate nodes into 3 lists
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        // Connect lists
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }


    // ================= MAIN =================
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(2);
        head.next.next.next = new Node(0);
        head.next.next.next.next = new Node(1);

        System.out.println("Original List:");
        printList(head);

        // Brute Force
        head = sortListBruteForce(head);
        System.out.println("After Brute Force Sort:");
        printList(head);

        // Recreate list for optimized approach
        head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(2);
        head.next.next.next = new Node(0);
        head.next.next.next.next = new Node(1);

        head = sortListOptimized(head);
        System.out.println("After Optimized Sort:");
        printList(head);
    }
}