package DSA_Diary.daily.d_2026_02_19;

import java.util.HashMap;
import java.util.Map;
/*
Clone a Linked List with Random Pointer
Difficulty: Medium

Given the head of a linked list where each node contains:
- next pointer → points to next node
- random pointer → points to any node in the list (or null)

Task:
Create a deep copy (clone) of this linked list.

------------------------------------------------------------

Example:

Original:
1(3) -> 2(1) -> 3(5) -> 4(3) -> 5(2)

Cloned:
1(3) -> 2(1) -> 3(5) -> 4(3) -> 5(2)

------------------------------------------------------------

Approaches:
1. Using HashMap (Iterative)        → O(n) Time, O(n) Space
2. Using HashMap + Recursion        → O(n) Time, O(n) Space
3. In-Place Insertion (Expected)    → O(n) Time, O(1) Space
*/

/* Node Definition */
class Node {
    int data;
    Node next, random;

    Node(int x) {
        data = x;
        next = random = null;
    }
}



class Clone_a_Linked_List_with_Random_Pointer {

    // =========================================================
    // APPROACH 1: Using HashMap (Iterative)
    // =========================================================
    /*
    Idea:
    - Create a mapping from original node → cloned node.
    - First pass: create cloned nodes.
    - Second pass: update next and random pointers.
    */

    public Node cloneUsingHashMap(Node head) {

        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node curr = head;

        // First pass: create cloned nodes
        while (curr != null) {
            map.put(curr, new Node(curr.data));
            curr = curr.next;
        }

        curr = head;

        // Second pass: assign next and random
        while (curr != null) {
            Node clone = map.get(curr);
            clone.next = map.get(curr.next);
            clone.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    /*
    Time Complexity: O(n)
    Space Complexity: O(n)
    */


    // =========================================================
    // APPROACH 2: Using HashMap + Recursion
    // =========================================================
    /*
    Idea:
    - Recursively create clone of current node.
    - Store visited nodes in HashMap to avoid duplication.
    */

    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneUsingRecursion(Node head) {

        if (head == null) return null;

        if (visited.containsKey(head))
            return visited.get(head);

        Node clone = new Node(head.data);
        visited.put(head, clone);

        clone.next = cloneUsingRecursion(head.next);
        clone.random = cloneUsingRecursion(head.random);

        return clone;
    }

    /*
    Time Complexity: O(n)
    Space Complexity: O(n)  (HashMap + recursion stack)
    */


    // =========================================================
    // APPROACH 3: In-Place Node Insertion (Expected Approach)
    // =========================================================
    /*
    Idea:
    Step 1: Insert cloned nodes between original nodes
    Step 2: Assign random pointers for cloned nodes
    Step 3: Separate original and cloned lists

    This avoids extra HashMap space.
    */

    public Node cloneLinkedList(Node head) {

        if (head == null) return null;

        Node curr = head;

        // Step 1: Insert cloned nodes
        while (curr != null) {
            Node clone = new Node(curr.data);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Step 2: Set random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        // Step 3: Separate cloned list
        curr = head;
        Node clonedHead = head.next;
        Node clone = clonedHead;

        while (curr != null) {
            curr.next = curr.next.next;
            if (clone.next != null)
                clone.next = clone.next.next;

            curr = curr.next;
            clone = clone.next;
        }

        return clonedHead;
    }

    /*
    Time Complexity: O(n)
    Space Complexity: O(1)  ← Optimal
    */

}

