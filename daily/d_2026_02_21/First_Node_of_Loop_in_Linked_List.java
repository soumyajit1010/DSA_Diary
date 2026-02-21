package DSA_Diary.daily.d_2026_02_21;
/*
Find First Node of Loop in Linked List
Difficulty: Medium

Given the head of a singly linked list,
determine the starting node of the loop if a cycle exists.

A loop occurs when the last node points back to an earlier node.

If no loop exists, return -1.

------------------------------------------------------------

Example 1:
Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6
       ^                   |
       |___________________|

Output: 3
Explanation: Loop starts at node with value 3.

Example 2:
Input: 1 -> 2 -> 3 -> 4 -> NULL
Output: -1
Explanation: No loop exists.

------------------------------------------------------------
*/

import java.util.HashSet;

/* Definition of Node */
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class First_Node_of_Loop_in_Linked_List {

    // =========================================================
    // APPROACH 1: Naive Method Using HashSet
    // =========================================================
    /*
    Idea:
    - Traverse the list
    - Store visited nodes in HashSet
    - If a node is already present → it is start of loop

    Time Complexity: O(n)
    Space Complexity: O(n)
    */

    static int cycleStart_HashSet(Node head) {

        HashSet<Node> set = new HashSet<>();
        Node curr = head;

        while (curr != null) {

            if (set.contains(curr)) {
                return curr.data;   // first repeated node
            }

            set.add(curr);
            curr = curr.next;
        }

        return -1;   // no loop
    }


    // =========================================================
    // APPROACH 2: Floyd’s Cycle Detection Algorithm (Optimal)
    // =========================================================
    /*
    Step 1: Detect if loop exists using slow & fast pointers
    Step 2: If they meet, reset slow to head
    Step 3: Move both one step at a time
    Step 4: Meeting point is start of loop

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    static int cycleStart(Node head) {

        if (head == null)
            return -1;

        Node slow = head;
        Node fast = head;

        // Step 1: Detect loop
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Step 2: Reset slow to head
                slow = head;

                // Step 3: Move both one step at a time
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Step 4: slow (or fast) is loop start
                return slow.data;
            }
        }

        return -1;  // No loop
    }
}

