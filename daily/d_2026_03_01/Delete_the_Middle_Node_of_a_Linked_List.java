package DSA_Diary.daily.d_2026_03_01;


/*
2095. Delete the Middle Node of a Linked List
Difficulty: Medium

Given the head of a linked list,
delete the middle node and return the head.

The middle node is:
⌊n / 2⌋ (0-based index)

For n = 1 → middle index = 0
For n = 2 → middle index = 1
For n = 3 → middle index = 1
For n = 4 → middle index = 2
For n = 5 → middle index = 2

----------------------------------------------------------

Example 1:
Input:  [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]

Example 2:
Input:  [1,2,3,4]
Output: [1,2,4]

Example 3:
Input:  [2,1]
Output: [2]

----------------------------------------------------------

Definition:

class ListNode {
    int val;
    ListNode next;
}
----------------------------------------------------------
*/

public class Delete_the_Middle_Node_of_a_Linked_List {

    // =========================================================
    // APPROACH 1: BRUTE FORCE (2 PASS - COUNTING)
    // =========================================================
    /*
    Step 1: Count total nodes (n)
    Step 2: Find middle index = n / 2
    Step 3: Traverse to (middle - 1)
    Step 4: Delete middle node

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public ListNode deleteMiddle_Brute(ListNode head) {

        if (head == null || head.next == null)
            return null;

        // PASS 1: Count nodes
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int mid = count / 2;

        // PASS 2: Traverse to node before middle
        temp = head;

        for (int i = 0; i < mid - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }


    // =========================================================
    // APPROACH 2: OPTIMAL (SLOW + FAST + PREV)
    // =========================================================
    /*
    Move fast by 2 and slow by 1.
    Maintain prev pointer to delete middle.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public ListNode deleteMiddle_Optimal(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;
    }


    // =========================================================
    // APPROACH 3: OPTIMIZED VARIANT (FAST STARTS AHEAD)
    // =========================================================
    /*
    Initialize:
    slow = head
    fast = head.next.next

    This makes slow stop at node before middle.
    No need for prev pointer.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public ListNode deleteMiddle_OptimizedVariant(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}