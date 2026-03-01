package DSA_Diary.daily.d_2026_03_01;


/*
Find Length of Loop in Linked List
Difficulty: Medium

Given the head of a linked list,
determine whether the list contains a loop.

If a loop is present,
return the number of nodes in the loop.

If no loop is present,
return 0.

------------------------------------------------------------

Example 1:
Input: pos = 2
Output: 4

Example 2:
Input: pos = 3
Output: 3

Example 3:
Input: pos = 0
Output: 0

------------------------------------------------------------

Definition:
------------------------------------------------------------
*/
import java.util.*;

class Node {
    int data;
    Node next;
}



public class Find_Length_of_Loop_in_Linked_List {

    // =========================================================
    // METHOD 1: Floyd’s Cycle Detection (Optimal)
    // =========================================================
    /*
    Idea:
    1. Use slow and fast pointer to detect cycle.
    2. If they meet, loop exists.
    3. From meeting point, traverse until coming back
       to same node and count nodes.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public int lengthOfLoop(Node head) {

        Node slow = head;
        Node fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return countLoopLength(slow);
            }
        }

        return 0;
    }

    private int countLoopLength(Node meetingPoint) {

        int count = 1;
        Node temp = meetingPoint.next;

        while (temp != meetingPoint) {
            count++;
            temp = temp.next;
        }

        return count;
    }


    // =========================================================
    // METHOD 2: Using HashSet (Extra Space)
    // =========================================================
    /*
    Idea:
    1. Traverse list.
    2. Store each node in HashSet.
    3. If node already exists → loop detected.
    4. Count loop length by traversing until coming
       back to same node.

    Time Complexity: O(n)
    Space Complexity: O(n)
    */

    public int lengthOfLoop_HashMap(Node head) {

        HashSet<Node> visited = new HashSet<>();

        Node temp = head;

        while (temp != null) {

            if (visited.contains(temp)) {
                // Loop detected
                return countLoopLength(temp);
            }

            visited.add(temp);
            temp = temp.next;
        }

        return 0;
    }
}