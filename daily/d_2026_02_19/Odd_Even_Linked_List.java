package DSA_Diary.daily.d_2026_02_19;

/*
328. Odd Even Linked List
Difficulty: Medium

Given the head of a singly linked list,
group all nodes with odd indices together
followed by nodes with even indices.

NOTE:
- Indexing is 1-based.
- First node is odd.
- Relative order inside odd and even groups must remain same.
- Required: O(n) time and O(1) space.

------------------------------------------------------

Example 1:
Input:  [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:
Input:  [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]

------------------------------------------------------
Definition for singly-linked list.

 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}


class Odd_Even_Linked_List {

    // ======================================================
    // APPROACH 1: Brute Force (Using Extra Array/List)
    // ======================================================
    /*
    Idea:
    - Traverse list and store odd index values in one list
    - Store even index values in another list
    - Rewrite linked list using combined values

    Time Complexity: O(n)
    Space Complexity: O(n)
    */

    public ListNode oddEvenList_BruteForce(ListNode head) {

        if (head == null || head.next == null)
            return head;

        java.util.ArrayList<Integer> arr = new java.util.ArrayList<>();
        ListNode temp = head;

        // Step 1: Store odd index nodes
        while (temp != null) {
            arr.add(temp.val);
            if (temp.next != null)
                temp = temp.next.next;
            else
                break;
        }

        // Step 2: Store even index nodes
        temp = head.next;
        while (temp != null) {
            arr.add(temp.val);
            if (temp.next != null)
                temp = temp.next.next;
            else
                break;
        }

        // Step 3: Rewrite linked list
        temp = head;
        int i = 0;
        while (temp != null) {
            temp.val = arr.get(i++);
            temp = temp.next;
        }

        return head;
    }


    // ======================================================
    // APPROACH 2: Optimized (Expected O(1) Space)
    // ======================================================
    /*
    Idea:
    - Maintain two pointers: odd and even
    - Separate odd and even indexed nodes
    - Attach even list after odd list

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
