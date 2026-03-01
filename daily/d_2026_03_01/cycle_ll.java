/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
Do not modify the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 */
package DSA_Diary.daily.d_2026_03_01;

import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class cycle_ll {
    public ListNode detectCycle_HashMap(ListNode head) {

        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;
        int index = 0;

        while (temp != null) {

            if (map.containsKey(temp)) {
                return temp;  // first repeated node → start of cycle
            }

            map.put(temp, index);
            temp = temp.next;
            index++;
        }

        return null;
    }
}


