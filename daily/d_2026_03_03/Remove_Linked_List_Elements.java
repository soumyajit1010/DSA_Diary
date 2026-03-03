package DSA_Diary.daily.d_2026_03_03;/*
203. Remove Linked List Elements
Difficulty: Easy

Given the head of a linked list and an integer val,
remove all nodes of the linked list that have Node.val == val,
and return the new head.

------------------------------------------------------------

Example 1:
Input:  head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:
Input:  head = [], val = 1
Output: []

Example 3:
Input:  head = [7,7,7,7], val = 7
Output: []

------------------------------------------------------------

Definition:
------------------------------------------------------------
*/
class ListNode {
    int val;
    ListNode next;

    public ListNode(int i) {

    }
}


class Remove_Linked_List_Elements {

    // =========================================================
    // APPROACH 1: USING DUMMY NODE (BEST & CLEAN)
    // =========================================================
    /*
    Idea:
    - Create a dummy node before head.
    - Traverse list.
    - If current node value equals val → delete it.
    - Else move forward.
    - Return dummy.next.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public ListNode removeElements_Dummy(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            if (curr.val == val) {
                prev.next = curr.next;   // delete
            } else {
                prev = curr;             // move prev only if not deleting
            }

            curr = curr.next;
        }

        return dummy.next;
    }


    // =========================================================
    // APPROACH 2: WITHOUT DUMMY NODE
    // =========================================================
    /*
    Step 1: Remove matching values from beginning.
    Step 2: Traverse remaining list.
    Step 3: Delete matching nodes.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public ListNode removeElements_NoDummy(ListNode head, int val) {

        // Remove from head while needed
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (curr.next.val == val) {
                curr.next = curr.next.next;   // delete
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}