package DSA_Diary.daily.d_2026_02_06;
/*
Rotate a Linked List (Left Rotation)

Problem Statement:
You are given the head of a singly linked list and an integer k.
You have to rotate the linked list to the left by k positions
and return the head of the modified linked list.

Left Rotation Meaning:
- Each rotation moves the first node to the end of the list.

Examples:

Input:
Linked List: 10 -> 20 -> 30 -> 40 -> 50
k = 4

Output:
50 -> 10 -> 20 -> 30 -> 40

Explanation:
After rotating left by 4 positions, the 5th node (50)
becomes the new head.

----------------------------------------------------
Node structure used:
class Node {
    int data;
    Node next;
}
*/

/* Definition of Node */
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}


public class Rotate_a_Linked_List {
    /*
  ====================================================
  Method 1: Naive Approach
  ====================================================
  Idea:
  - Rotate the list left by 1 position, k times
  - Each rotation:
      • Move head node to the end of the list

  Steps for one rotation:
  1. Traverse to the last node
  2. Link last node to head
  3. Move head to head.next
  4. Break the link to make list linear again

  Time Complexity: O(n × k)
  Space Complexity: O(1)
  */
    Node rotateNaive(Node head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        for (int i = 0; i < k; i++) {

            Node curr = head;

            // Traverse to last node
            while (curr.next != null) {
                curr = curr.next;
            }

            // Move first node to the end
            curr.next = head;
            head = head.next;
            curr.next.next = null;
        }

        return head;
    }

    /*
    ====================================================
    Method 2: Expected Optimized Approach
    ====================================================
    Idea:
    - Find the length of the linked list
    - Convert the list into a circular linked list
    - Move to the kth node
    - Make (k+1)th node the new head
    - Break the circular link

    Key Optimization:
    If k >= length, rotating by k positions is same as
    rotating by (k % length)

    Time Complexity: O(n)
    Space Complexity: O(1)
    */
    Node rotateOptimized(Node head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        Node curr = head;
        int len = 1;

        // Step 1: Find length and last node
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }

        // Step 2: Handle large k
        k = k % len;
        if (k == 0)
            return head;

        // Step 3: Make list circular
        curr.next = head;

        // Step 4: Traverse to kth node
        curr = head;
        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }

        // Step 5: Break the circular list
        head = curr.next;
        curr.next = null;

        return head;
    }
}
