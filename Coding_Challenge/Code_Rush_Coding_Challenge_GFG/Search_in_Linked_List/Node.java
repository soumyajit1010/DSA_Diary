package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Search_in_Linked_List;/*
    Search in Linked List
    Difficulty: Easy
    Accuracy: 65.4%
    Submissions: 112K+
    Points: 2
    Average Time: 10m

    Problem:
    Given a linked list of n nodes and a key, 
    check if the key is present in the linked list.

    Example:
    Input:
        n = 4, key = 3
        Linked List: 1 -> 2 -> 3 -> 4
    Output:
        true
    Explanation:
        3 is present in the linked list, so return true.

    Constraints:
        1 <= n <= 10^5
        1 <= key <= 10^5

    Expected Time Complexity: O(n)
    Expected Space Complexity: O(1)
*/

// Node of a Linked List
class Node {
    int data;
    Node next;
    Node(int d) { 
        data = d; 
        next = null; 
    }
}

class Solution {
    static boolean searchKey(int n, Node head, int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true; // Key found
            }
            current = current.next;
        }
        return false; // Key not found
    }
}

/*
    Time Complexity: O(n)
    - Traverse the linked list once, checking each node.

    Space Complexity: O(1)
    - No extra space is used apart from a pointer.
*/
