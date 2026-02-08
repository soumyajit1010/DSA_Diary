package DSA_Diary.daily.d_2026_02_08;
/*
Merge Two Sorted Linked Lists

Problem Statement:
You are given the heads of two sorted singly linked lists.
Merge them into a single sorted linked list and return the head
of the merged list.

Example 1:
List1: 5 -> 10 -> 15 -> 40
List2: 2 -> 3 -> 20
Output:
2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40

Example 2:
List1: 1 -> 1
List2: 2 -> 4
Output:
1 -> 1 -> 2 -> 4
*/

/* Definition of singly linked list node */

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


public class Merge_Two_Sorted_Linked_Lists {
    /*
   ====================================================
   Approach 1: Naive Approach (Using Array + Sort)
   ====================================================
   Idea:
   - Traverse both linked lists and store all values in an array
   - Sort the array
   - Create a new linked list from the sorted values

   Time Complexity: O((n + m) log(n + m))
   Space Complexity: O(n + m)
   */
    Node sortedMergeNaive(Node head1, Node head2) {

        java.util.ArrayList<Integer> arr = new java.util.ArrayList<>();

        while (head1 != null) {
            arr.add(head1.data);
            head1 = head1.next;
        }

        while (head2 != null) {
            arr.add(head2.data);
            head2 = head2.next;
        }

        java.util.Collections.sort(arr);

        Node dummy = new Node(-1);
        Node curr = dummy;

        for (int val : arr) {
            curr.next = new Node(val);
            curr = curr.next;
        }

        return dummy.next;
    }

    /*
    ====================================================
    Approach 2: Better Approach (Recursive Merge)
    ====================================================
    Idea:
    - Compare head nodes of both lists
    - Pick the smaller node and recursively merge the rest
    - Base case: if one list becomes empty, return the other

    Time Complexity: O(n + m)
    Space Complexity: O(n + m)  (recursive call stack)
    */
    Node sortedMergeRecursive(Node head1, Node head2) {

        // Base cases
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        // Recursive merge based on smaller value
        if (head1.data <= head2.data) {
            head1.next = sortedMergeRecursive(head1.next, head2);
            return head1;
        } else {
            head2.next = sortedMergeRecursive(head1, head2.next);
            return head2;
        }
    }

    /*
    ====================================================
    Approach 3: Efficient Approach (Iterative Merge)
    ====================================================
    Idea:
    - Use a dummy node to simplify pointer handling
    - Compare nodes from both lists
    - Append the smaller node to the merged list
    - Attach remaining nodes once one list ends

    Time Complexity: O(n + m)
    Space Complexity: O(1)
    */
    Node sortedMergeIterative(Node head1, Node head2) {

        Node dummy = new Node(-1);
        Node tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes
        if (head1 != null)
            tail.next = head1;
        else
            tail.next = head2;

        return dummy.next;
    }
}
