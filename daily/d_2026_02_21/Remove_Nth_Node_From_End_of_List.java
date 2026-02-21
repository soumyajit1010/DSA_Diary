package DSA_Diary.daily.d_2026_02_21;

/*
19. Remove Nth Node From End of List
Difficulty: Medium

Given the head of a singly linked list,
remove the nth node from the end of the list
and return its head.

-------------------------------------------------------

Example 1:
Input:  [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input:  [1], n = 1
Output: []

Example 3:
Input:  [1,2], n = 1
Output: [1]

-------------------------------------------------------
Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
-------------------------------------------------------
*/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Remove_Nth_Node_From_End_of_List {

    // =========================================================
    // APPROACH 1: Using Count (Two Pass Method)
    // =========================================================
    /*
    Idea:
    1. Count total number of nodes.
    2. Find position from start: (length - n).
    3. Traverse again and remove that node.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public ListNode removeNthFromEnd_Count(ListNode head, int n) {

        if (head == null)
            return null;

        // Step 1: Count length
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // If removing head
        if (n == length)
            return head.next;

        // Step 2: Traverse to (length - n - 1)
        temp = head;
        for (int i = 1; i < length - n; i++) {
            temp = temp.next;
        }

        // Step 3: Remove node
        temp.next = temp.next.next;

        return head;
    }


    // =========================================================
    // APPROACH 2: Two Pointer Method (One Pass)
    // =========================================================
    /*
    Idea:
    1. Move fast pointer n steps ahead.
    2. Move slow and fast together.
    3. When fast reaches last node,
       slow will be before the node to delete.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;

        // Move fast n steps ahead
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        // If removing head
        if (fast == null)
            return head.next;

        ListNode slow = head;

        // Move both pointers
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove node
        slow.next = slow.next.next;

        return head;
    }
}

