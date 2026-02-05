package DSA_Diary.daily.d_2026_02_05;
/*
Reverse a Linked List

Problem Statement:
You are given the head of a singly linked list.
Reverse the linked list and return the new head.

Example:
Input:
1 -> 2 -> 3 -> 4 -> 5

Output:
5 -> 4 -> 3 -> 2 -> 1
*/

/* Definition for singly-linked list node */
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Reverse_a_Linked_List {
    /*
   ------------------------------------------------
   Approach 1: Iterative Method
   ------------------------------------------------
   Idea:
   - Use three pointers: prev, curr, next
   - Reverse the direction of links one by one
   - Move pointers forward until the list ends

   Steps:
   1. Initialize prev = null, curr = head
   2. Store next node
   3. Reverse curr.next to point to prev
   4. Move prev and curr forward
   5. Return prev as new head

   Time Complexity: O(n)
   Space Complexity: O(1)
   */
    Node reverseListIterative(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next; // store next
            curr.next = prev;      // reverse link
            prev = curr;           // move prev
            curr = next;           // move curr
        }

        return prev;
    }

    /*
    ------------------------------------------------
    Approach 2: Recursive Method
    ------------------------------------------------
    Idea:
    - Reach the last node using recursion
    - While returning, reverse the links
    - Last node becomes the new head

    Steps:
    1. Base case: if head is null or single node
    2. Recursively reverse the rest of the list
    3. Make next node point back to current node
    4. Set current node's next to null

    Time Complexity: O(n)
    Space Complexity: O(n)  (due to recursion stack)
    */
    Node reverseListRecursive(Node head) {

        if (head == null || head.next == null)
            return head;

        Node rest = reverseListRecursive(head.next);

        head.next.next = head; // reverse link
        head.next = null;      // set next to null

        return rest;
    }

    /*
    ------------------------------------------------
    Approach 3: Using Stack
    ------------------------------------------------
    Idea:
    - Push all nodes into a stack
    - Pop nodes one by one to rebuild reversed list
    - Last popped node becomes the new head

    Time Complexity: O(n)
    Space Complexity: O(n)
    */
    Node reverseListUsingStack(Node head) {

        java.util.Stack<Node> stack = new java.util.Stack<>();
        Node temp = head;

        // Push all nodes into stack
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // New head is the last node
        if (stack.isEmpty())
            return head;

        head = stack.pop();
        temp = head;

        // Rebuild reversed list
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }

        temp.next = null; // terminate list

        return head;
    }
}
/*
🧠 Time & Space Complexity Summary

| Approach  | Technique           | Time Complexity | Space Complexity |
| --------- | ------------------- | --------------- | ---------------- |
| Iterative | Pointer reversal    | O(n)            | O(1)             |
| Recursive | Function call stack | O(n)            | O(n)             |
| Stack     | Explicit stack      | O(n)            | O(n)             |

 */