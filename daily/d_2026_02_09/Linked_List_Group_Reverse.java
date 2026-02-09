package DSA_Diary.daily.d_2026_02_09;
/*
Linked List Group Reverse
Difficulty: Hard

You are given the head of a Singly Linked List.
You have to reverse every k nodes in the linked list
and return the head of the modified list.

Note:
- If the number of nodes is not a multiple of k,
  the remaining nodes at the end must ALSO be reversed.

--------------------------------------------------
Examples:

Input:
Linked List: 1 -> 2 -> 3 -> 4 -> 5 -> 6
k = 2

Output:
2 -> 1 -> 4 -> 3 -> 6 -> 5

Explanation:
The linked list is reversed in groups of size k = 2.

--------------------------------------------------
Input:
Linked List: 1 -> 2 -> 3 -> 4 -> 5 -> 6
k = 4

Output:
4 -> 3 -> 2 -> 1 -> 6 -> 5

Explanation:
The linked list is reversed in groups of size k = 4,
and the remaining nodes are also reversed.
*/
/*
    Time Complexity:
    O(n)
    - Each node is visited exactly once.

    Space Complexity:
    O(1)
    - No extra space is used apart from variables.
    */

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Linked_List_Group_Reverse {

    public Node reverseKGroup(Node head, int k) {

        if (head == null || k <= 1)
            return head;

        Node curr = head;
        Node prevGroupTail = null;
        Node newHead = null;

        while (curr != null) {

            // Mark the start of the current group
            Node groupHead = curr;

            // Reverse k nodes
            Node prev = null;
            int count = 0;

            while (curr != null && count < k) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            // prev is the new head of this reversed group
            if (newHead == null) {
                newHead = prev; // first group
            }

            // Connect previous group with current group
            if (prevGroupTail != null) {
                prevGroupTail.next = prev;
            }

            // groupHead becomes the tail after reversal
            prevGroupTail = groupHead;
        }

        return newHead;
    }
}
