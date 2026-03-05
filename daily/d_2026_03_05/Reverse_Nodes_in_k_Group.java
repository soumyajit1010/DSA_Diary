package DSA_Diary.daily.d_2026_03_05;
/*
LeetCode 25. Reverse Nodes in k-Group
Difficulty: Hard

Problem:
Given the head of a linked list, reverse the nodes of the list k at a time
and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes at the end
should remain as they are.

You may not change the node values, only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Approach:
1. Find the kth node from the current node.
2. Break the list temporarily.
3. Reverse the k nodes.
4. Connect the previous group with the reversed group.
5. Move to the next group.

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

public class Reverse_Nodes_in_k_Group {


    private ListNode getKthNode(ListNode temp, int k) {

        k -= 1;

        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }

        return temp;
    }

    // Reverse a linked list
    private ListNode reverseList(ListNode head) {

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

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {

            ListNode kthNode = getKthNode(temp, k);

            if (kthNode == null) {
                if (prevLast != null)
                    prevLast.next = temp;
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            reverseList(temp);

            if (temp == head) {
                head = kthNode;
            } else {
                prevLast.next = kthNode;
            }

            prevLast = temp;
            temp = nextNode;
        }

        return head;
    }





    // ********** I want to solve in this way **************
//    public ListNode reverseKGroup(ListNode head, int k) {
//
//        ListNode curr = head;
//        ListNode prevGroupTail = null;
//        ListNode newHead = null;
//
//        while(isPossibleNode(curr, k-1)) {
//
//            ListNode groupHead = curr;
//
//            // reverse k nodes
//            ListNode prev = null;
//            int count = k;
//
//            while(count > 0){
//                ListNode next = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = next;
//                count--;
//            }
//
//            // connect previous group
//            if(prevGroupTail != null){
//                prevGroupTail.next = prev;
//            } else {
//                newHead = prev;
//            }
//
//            // connect tail to next group
//            groupHead.next = curr;
//
//            prevGroupTail = groupHead;
//        }
//
//        return newHead;
//
//
//    }
//
//    private boolean isPossibleNode(ListNode t, int k) {
//        while (k > 0) {
//            t = t.next;
//            if (t == null) return false;
//            k--;
//
//        }
//        return true;
//    }
}
