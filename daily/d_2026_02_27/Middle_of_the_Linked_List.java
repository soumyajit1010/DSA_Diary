package DSA_Diary.daily.d_2026_02_27;
/*
876. Middle of the Linked List
Difficulty: Easy

Given the head of a singly linked list,
return the middle node of the linked list.

If there are two middle nodes,
return the SECOND middle node.

------------------------------------------------------------

Example 1:
Input:  [1,2,3,4,5]
Output: Node with value 3

Example 2:
Input:  [1,2,3,4,5,6]
Output: Node with value 4
(Because we return the second middle)

------------------------------------------------------------

Definition:
------------------------------------------------------------
*/
class ListNode {
    int val;
    ListNode next;
}


class Middle_of_the_Linked_List {

    // =========================================================
    // METHOD 1: Count + Traverse (Two Pass Approach)
    // =========================================================
    /*
    Idea:
    1. Count total number of nodes.
    2. Move (count / 2) steps from head.
    3. Return that node.

    Why count/2 works?
    - If count is odd → gives exact middle.
    - If count is even → gives second middle.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public ListNode middleNode_Count(ListNode head) {

        int count = 0;
        ListNode temp = head;

        // Count nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Move to middle
        int steps = count / 2;
        temp = head;

        while (steps > 0) {
            temp = temp.next;
            steps--;
        }

        return temp;
    }


    // =========================================================
    // METHOD 2: Slow & Fast Pointer (Optimal)
    // =========================================================
    /*
    Idea:
    - Move slow by 1 step.
    - Move fast by 2 steps.
    - When fast reaches end,
      slow will be at middle.

    Why does this return second middle?
    - For even length:
      fast becomes null,
      slow lands on second middle automatically.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

