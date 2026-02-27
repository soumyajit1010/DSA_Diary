package DSA_Diary.daily.d_2026_02_27;
/*
141. Linked List Cycle
Difficulty: Easy

Given the head of a linked list,
determine if the linked list has a cycle.

A cycle exists if some node can be reached again
by continuously following the next pointer.

Return true if there is a cycle, otherwise false.

------------------------------------------------------------

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true

Example 2:
Input: head = [1,2], pos = 0
Output: true

Example 3:
Input: head = [1], pos = -1
Output: false

------------------------------------------------------------

Definition:
------------------------------------------------------------
*/
import java.util.*;

public class Linked_List_Cycle {

    // =========================================================
    // METHOD 1: Using Data Structure (ArrayList / HashSet)
    // =========================================================
    /*
    Idea:
    - Traverse the list.
    - Store each visited node in a data structure.
    - If a node is already present → cycle exists.

    NOTE:
    HashSet is better than ArrayList (O(1) lookup).

    Time Complexity: O(n)
    Space Complexity: O(n)
    */

    public boolean hasCycle_DataStructure(ListNode head) {

        HashSet<ListNode> visited = new HashSet<>();
        ListNode temp = head;

        while (temp != null) {
            if (visited.contains(temp))
                return true;

            visited.add(temp);
            temp = temp.next;
        }

        return false;
    }


    // =========================================================
    // METHOD 2: Floyd's Cycle Detection (Slow & Fast Pointer)
    // =========================================================
    /*
    Idea:
    - Move slow pointer by 1 step.
    - Move fast pointer by 2 steps.
    - If they meet → cycle exists.
    - If fast reaches null → no cycle.

    Why it works?
    - Inside a cycle, fast moves 1 step more than slow each round.
    - Eventually they must meet.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public boolean hasCycle(ListNode head) {

        if (head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;           // 1 step
            fast = fast.next.next;      // 2 steps

            if (slow == fast)
                return true;
        }

        return false;
    }
}

