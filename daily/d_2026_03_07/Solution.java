package DSA_Diary.daily.d_2026_03_07;/*
LeetCode 82. Remove Duplicates from Sorted List II
Difficulty: Medium

Problem:
Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:
Input:  head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input:  head = [1,1,1,2,3]
Output: [2,3]

Constraints:
0 <= number of nodes <= 300
-100 <= Node.val <= 100
The list is sorted in ascending order.

Approach (Optimal):
Since the list is sorted, duplicates appear consecutively.
We use a dummy node before head to easily handle cases where the first nodes are duplicates.

Steps:
1. Create a dummy node pointing to head.
2. Use two pointers:
   - prev : last confirmed unique node
   - curr : current node
3. If curr has duplicates (curr.val == curr.next.val),
   skip all nodes with that value.
4. Connect prev.next to the first non-duplicate node.
5. If no duplicate is found, move prev forward.

Time Complexity: O(n)
Space Complexity: O(1)
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

class Remove_Duplicates_from_ll_2 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // Check if current node is start of duplicate block
            if (curr.next != null && curr.val == curr.next.val) {

                int duplicateVal = curr.val;

                // Skip all nodes with this value
                while (curr != null && curr.val == duplicateVal) {
                    curr = curr.next;
                }

                prev.next = curr;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}