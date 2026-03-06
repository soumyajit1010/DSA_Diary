package DSA_Diary.daily.d_2026_03_06;/*
LeetCode 83. Remove Duplicates from Sorted List
Difficulty: Easy

Problem:
Given the head of a sorted linked list, delete all duplicates such that each element
appears only once. Return the linked list sorted as well.

Since the list is already sorted in ascending order, duplicate values will always
appear consecutively.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
*/


// ------------------------------------------------------------
// Approach 1: Brute Force (Using Extra Data Structure)
// ------------------------------------------------------------
/*
Idea:
1. Traverse the linked list and store unique values in a HashSet.
2. Build a new linked list using the unique values.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashSet;

class Remove_Duplicates_from_ll {
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) return head;

        HashSet<Integer> set = new HashSet<>();

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(head != null){

            if(!set.contains(head.val)){
                set.add(head.val);
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }

            head = head.next;
        }

        return dummy.next;
    }
}



// ------------------------------------------------------------
// Approach 2: Optimal (Single Pointer Traversal)
// ------------------------------------------------------------
/*
Idea:
Since the list is sorted, duplicates appear next to each other.

Steps:
1. Traverse the list using one pointer.
2. If current node value equals next node value, skip the next node.
3. Otherwise move forward.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while(curr != null && curr.next != null){

            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }

        return head;
    }
}