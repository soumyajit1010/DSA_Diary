package DSA_Diary.daily.d_2026_02_10;
/*
Reverse a Doubly Linked List
Difficulty: Easy

You are given the head of a doubly linked list.
You have to reverse the doubly linked list and return its head.

A doubly linked list node contains:
- data
- next pointer
- prev pointer

--------------------------------------------------
Examples:

Input:
3 <-> 4 <-> 5

Output:
5 <-> 4 <-> 3

Explanation:
After reversing the given doubly linked list,
the new list will be 5 <-> 4 <-> 3.

--------------------------------------------------
Input:
75 <-> 122 <-> 59 <-> 196

Output:
196 <-> 59 <-> 122 <-> 75
*/
import java.util.Stack;


//class Node {
//    int data;
//    Node next;
//    Node prev;
//
//    Node(int data) {
//        this.data = data;
//        this.next = null;
//        this.prev = null;
//    }
//}



public class Reverse_a_Doubly_Linked_List {
    // ======================================================
    // METHOD 1: Brute Force Using Stack
    // ======================================================
    /*
    Approach:
    - Traverse the list and push all node values into a stack
    - Traverse again and replace node data by popping from stack
    - Links are NOT changed, only data is reversed

    Time Complexity: O(n)
    Space Complexity: O(n)
    */

    public Node reverseUsingStack(Node head) {

        if (head == null || head.next == null)
            return head;

        Stack<Integer> stack = new Stack<>();
        Node curr = head;

        // Push all values
        while (curr != null) {
            stack.push(curr.data);
            curr = curr.next;
        }

        // Replace values
        curr = head;
        while (curr != null) {
            curr.data = stack.pop();
            curr = curr.next;
        }

        return head;
    }


    // ======================================================
    // METHOD 2: Optimal Pointer Swapping (Expected Approach)
    // ======================================================
    /*
    Approach:
    - Traverse the list
    - For each node, swap prev and next pointers
    - Return the new head after traversal

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public Node reverse(Node head) {

        if (head == null || head.next == null)
            return head;

        Node curr = head;
        Node temp = null;

        while (curr != null) {
            // swap prev and next
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            // move to next node
            curr = curr.prev;
        }

        // temp points to previous node of new head
        return temp.prev;
    }
}
