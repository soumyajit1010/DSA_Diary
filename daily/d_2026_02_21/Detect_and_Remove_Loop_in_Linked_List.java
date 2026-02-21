package DSA_Diary.daily.d_2026_02_21;
import java.util.HashSet;


/*
Detect and Remove Loop in Linked List
Difficulty: Medium

Given the head of a linked list that may contain a loop.
A loop means the last node points back to a node in the list.

Task:
Detect and remove the loop (if it exists).

------------------------------------------------------------

Example 1:
Input: 1 -> 3 -> 4
       ^        |
       |________|

Output: 1 -> 3 -> 4
Explanation: Loop removed.

Example 2:
Input: 1 -> 8 -> 3 -> 4 -> NULL
Output: 1 -> 8 -> 3 -> 4
Explanation: No loop exists.

------------------------------------------------------------
*/

/* Definition for singly linked list */
//class Node {
//    int data;
//    Node next;
//
//    Node(int x) {
//        data = x;
//        next = null;
//    }
//}


class Detect_and_Remove_Loop_in_Linked_List {

    // =========================================================
    // APPROACH 1: Naive Method Using HashSet
    // =========================================================
    /*
    Idea:
    - Traverse list and store nodes in HashSet
    - Keep track of previous node
    - If node already exists → break loop by setting prev.next = null

    Time Complexity: O(n)
    Space Complexity: O(n)
    */

    static void removeLoop_HashSet(Node head) {

        if (head == null)
            return;

        HashSet<Node> set = new HashSet<>();
        Node curr = head;
        Node prev = null;

        while (curr != null) {

            if (set.contains(curr)) {
                prev.next = null;  // remove loop
                return;
            }

            set.add(curr);
            prev = curr;
            curr = curr.next;
        }
    }


    // =========================================================
    // APPROACH 2: Floyd’s Cycle Detection Algorithm (Optimal)
    // =========================================================
    /*
    Step 1: Detect loop using slow & fast pointers
    Step 2: Find starting node of loop
    Step 3: Traverse to last node of loop and break it

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    static void removeLoop(Node head) {

        if (head == null || head.next == null)
            return;

        Node slow = head;
        Node fast = head;

        // Step 1: Detect loop
        boolean loopExists = false;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        if (!loopExists)
            return;

        // Step 2: Find start of loop
        slow = head;

        if (slow != fast) {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            // fast.next is start of loop
            fast.next = null;
        }
        else {
            // Special case: loop starts at head
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        }
    }


    // Utility function to print list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}

