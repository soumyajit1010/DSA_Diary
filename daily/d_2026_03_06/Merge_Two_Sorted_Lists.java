package DSA_Diary.daily.d_2026_03_06;

import java.util.*;

public class Merge_Two_Sorted_Lists {
    /*
LeetCode 21. Merge Two Sorted Lists
Difficulty: Easy

Problem:
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by
splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input:
list1 = [1,2,4]
list2 = [1,3,4]

Output:
[1,1,2,3,4,4]

Example 2:
Input:
list1 = []
list2 = []

Output:
[]

Example 3:
Input:
list1 = []
list2 = [0]

Output:
[0]

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
*/


// ---------------------------------------------------------
// Approach 1: Brute Force (Store values → Sort → Rebuild)
// ---------------------------------------------------------
/*
Idea:
1. Traverse both linked lists and store values in an ArrayList.
2. Sort the list.
3. Create a new linked list from the sorted values.

Time Complexity: O((n + m) log(n + m))
Space Complexity: O(n + m)
*/


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        List<Integer> arr = new ArrayList<>();

        while (list1 != null) {
            arr.add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            arr.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(arr);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for (int val : arr) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }

        return dummy.next;
    }


// ---------------------------------------------------------
// Approach 2: Optimal Two Pointer Approach
// ---------------------------------------------------------
/*
Idea:
Since both lists are already sorted:

1. Compare the current nodes of both lists.
2. Attach the smaller node to the result list.
3. Move the pointer of that list forward.
4. Continue until one list finishes.
5. Attach the remaining nodes.

Time Complexity: O(n + m)
Space Complexity: O(1)
*/


    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        ListNode t1 = list1;
        ListNode t2 = list2;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (t1 != null && t2 != null) {

            if (t1.val <= t2.val) {
                temp.next = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                t2 = t2.next;
            }

            temp = temp.next;
        }

        if (t1 != null)
            temp.next = t1;
        else
            temp.next = t2;

        return dummy.next;
    }

}
