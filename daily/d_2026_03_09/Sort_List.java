package DSA_Diary.daily.d_2026_03_09;
/*
LeetCode 148. Sort List
Difficulty: Medium

Problem:
Given the head of a singly linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
Output: []

Constraints:
• The number of nodes in the list is in the range [0, 5 * 10^4]
• -10^5 <= Node.val <= 10^5

Goal:
Sort the linked list in ascending order.

----------------------------------------------------------------
Approach 1: Brute Force (Convert to Array / List and Sort)
----------------------------------------------------------------

Idea:
1. Traverse the linked list and store all values in an ArrayList.
2. Sort the list using Collections.sort().
3. Traverse the linked list again and update node values.

This approach works but does not respect the constraint of not modifying nodes
and uses extra space.

Time Complexity:
O(n log n)

Explanation:
Sorting the array/list takes O(n log n).

Space Complexity:
O(n)
Extra space used for the ArrayList.
*/

import java.util.*;
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


class Solution {
    public ListNode sortList(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(list);

        temp = head;
        int i = 0;

        while(temp != null){
            temp.val = list.get(i++);
            temp = temp.next;
        }

        return head;
    }
}


/*
----------------------------------------------------------------
Approach 2: Optimal (Merge Sort on Linked List)
----------------------------------------------------------------

Idea:
Linked lists are best sorted using Merge Sort because:
• We can easily split the list using slow & fast pointers.
• Merging two sorted lists is efficient.

Steps:
1. Find the middle of the linked list using slow & fast pointers.
2. Split the list into two halves.
3. Recursively sort both halves.
4. Merge the two sorted lists.

Time Complexity:
O(n log n)

Explanation:
The list is divided log n times and each merge takes O(n).

Space Complexity:
O(log n)

Explanation:
Recursion stack for merge sort.
*/

public class Sort_List {

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode mid = findMiddle(head);
        ListNode right = mid.next;
        mid.next = null;

        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);

        return merge(leftSorted, rightSorted);
    }

    private ListNode findMiddle(ListNode head){

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode a, ListNode b){

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(a != null && b != null){

            if(a.val <= b.val){
                temp.next = a;
                a = a.next;
            }
            else{
                temp.next = b;
                b = b.next;
            }

            temp = temp.next;
        }

        if(a != null) temp.next = a;
        if(b != null) temp.next = b;

        return dummy.next;
    }
}

