package DSA_Diary.daily.d_2026_02_20;

import java.util.ArrayList;

import java.util.HashSet;

    /*
Detect Cycle in Linked List
Difficulty: Medium

Given the head of a singly linked list,
determine whether the list contains a cycle.

A cycle exists if, while traversing the list through next pointers,
you encounter a node that has already been visited instead of
eventually reaching NULL.

------------------------------------------------------------

Example 1:
Input: 1 -> 3 -> 4 -> 3
Output: true
Explanation: The last node points back to node with value 3.

Example 2:
Input: 1 -> 8 -> 3 -> 4 -> NULL
Output: false
Explanation: The last node points to NULL.

------------------------------------------------------------
*/

    /* Definition for singly-linked list */
    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }


public class Detect_Loop_in_linked_list {


    // =========================================================
        // APPROACH 1: Naive Method Using HashSet
        // =========================================================
    /*
    Idea:
    - Traverse the list
    - Store each visited node reference in a HashSet
    - If a node is already present in set → cycle detected

    Time Complexity: O(n)
    Space Complexity: O(n)
    */

        public boolean detectLoop_HashSet(Node head) {

            HashSet<Node> set = new HashSet<>();

            while (head != null) {

                if (set.contains(head)) {
                    return true;   // cycle found
                }

                set.add(head);
                head = head.next;
            }

            return false;   // reached NULL → no cycle
        }


        // =========================================================
        // APPROACH 2: Floyd’s Cycle Detection Algorithm (Optimal)
        // =========================================================
    /*
    Idea:
    - Use two pointers: slow and fast
    - slow moves 1 step
    - fast moves 2 steps
    - If they meet → cycle exists

    Why it works:
    If a cycle exists, fast pointer gains 1 node per step over slow.
    Eventually, they meet inside the loop.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

        public boolean detectLoop(Node head) {

            if (head == null)
                return false;

            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {

                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast)
                    return true;   // cycle detected
            }

            return false;   // no cycle
        }
    }