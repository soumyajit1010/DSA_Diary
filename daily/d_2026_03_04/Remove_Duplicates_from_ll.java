package DSA_Diary.daily.d_2026_03_04;/*
Remove Duplicates from a Sorted Doubly Linked List

Difficulty: Easy
Accuracy: 50.36%
Points: 2

Problem:
Given a doubly linked list of n nodes sorted by values, 
remove duplicate nodes from the linked list.

Example 1:
Input:
n = 6
1 <-> 1 <-> 1 <-> 2 <-> 3 <-> 4

Output:
1 <-> 2 <-> 3 <-> 4

Explanation:
Only the first occurrence of node with value 1 is retained.

Example 2:
Input:
n = 7
1 <-> 2 <-> 2 <-> 3 <-> 3 <-> 4 <-> 4

Output:
1 <-> 2 <-> 3 <-> 4

Explanation:
Only the first occurrence of nodes with values 2,3,4 are retained.

Approach:
Since the doubly linked list is sorted, duplicate values will appear consecutively.
1. Traverse the list using a pointer temp.
2. Compare temp.data with the next node's data.
3. Skip all nodes with the same value.
4. Connect temp.next to the next unique node.
5. Update the prev pointer properly.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/*
class Node{
    int data;
    Node next, prev;

    Node(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}
*/

class Remove_Duplicates_from_ll {

    Node removeDuplicates(Node head) {

        Node temp = head;

        while (temp != null && temp.next != null) {

            Node nextNode = temp.next;

            // Skip all duplicate nodes
            while (nextNode != null && nextNode.data == temp.data) {
                nextNode = nextNode.next;
            }

            // Link current node to next unique node
            temp.next = nextNode;

            if (nextNode != null) {
                nextNode.prev = temp;
            }

            temp = temp.next;
        }

        return head;
    }
}