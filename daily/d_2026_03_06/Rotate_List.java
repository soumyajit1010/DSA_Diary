package DSA_Diary.daily.d_2026_03_06;/*
LeetCode 61. Rotate List
Difficulty: Medium

Problem:
Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input:
head = [1,2,3,4,5], k = 2

Output:
[4,5,1,2,3]

Example 2:
Input:
head = [0,1,2], k = 4

Output:
[2,0,1]

Approach:
1. Find the length of the linked list.
2. Find the last node (tail).
3. Connect the tail to the head to form a circular list.
4. Find the new tail at position (len - k % len - 1).
5. Break the circle to get the rotated list.

Time Complexity: O(n)
Space Complexity: O(1)
*/
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Rotate_List {

    // Find the nth node from head
    private ListNode findNthNode(ListNode temp, int k) {

        int cnt = 1;

        while (temp != null) {
            if (cnt == k) return temp;
            cnt++;
            temp = temp.next;
        }

        return temp;
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        ListNode tail = head;
        int len = 1;

        // Find length and tail
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        if (k % len == 0) return head;

        k = k % len;

        // Make circular linked list
        tail.next = head;

        // Find new last node
        ListNode newLastNode = findNthNode(head, len - k);

        head = newLastNode.next;

        // Break the cycle
        newLastNode.next = null;

        return head;
    }
}