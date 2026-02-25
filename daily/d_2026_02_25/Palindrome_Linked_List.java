package DSA_Diary.daily.d_2026_02_25;

import java.util.ArrayList;
  /*
234. Palindrome Linked List
Difficulty: Easy

Given the head of a singly linked list,
return true if it is a palindrome, otherwise false.

---------------------------------------------------------

Example 1:
Input:  [1,2,2,1]
Output: true

Example 2:
Input:  [1,2]
Output: false

---------------------------------------------------------

Follow-up:
Can you do it in O(n) time and O(1) space?

---------------------------------------------------------
Definition:

   */

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
//---------------------------------------------------------

public class Palindrome_Linked_List {

    // =========================================================
    // APPROACH 1: Brute Force (Using ArrayList)
    // =========================================================
    /*
    Idea:
    - Store all node values in an ArrayList
    - Use two pointers to check palindrome

    Time Complexity: O(n)
    Space Complexity: O(n)
    */

    public boolean isPalindromeBrute(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;

        // Store values
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int n = list.size();

        // Check palindrome
        for (int i = 0; i < n / 2; i++) {
            if (!list.get(i).equals(list.get(n - 1 - i)))
                return false;
        }

        return true;
    }


    // =========================================================
    // APPROACH 2: Optimized (Reverse Second Half)
    // =========================================================
    /*
    Idea:
    1. Find middle using slow & fast pointer.
    2. Reverse second half.
    3. Compare first half and reversed second half.
    4. Restore the list (optional but recommended).

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public boolean isPalindromeOptimized(ListNode head) {

        if (head == null || head.next == null)
            return true;

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow.next);

        // Step 3: Compare both halves
        ListNode p1 = head;
        ListNode p2 = secondHalf;

        boolean isPalindrome = true;

        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Step 4: Restore original list
        slow.next = reverse(secondHalf);

        return isPalindrome;
    }


    // Utility function to reverse linked list
    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
