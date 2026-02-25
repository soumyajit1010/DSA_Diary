package DSA_Diary.daily.d_2026_02_25;

    /*
Add 1 to a Linked List Number
Difficulty: Medium

You are given a linked list where each node contains a single digit.
The digits together represent a number.

Add 1 to the number and return the head of the modified linked list.

-------------------------------------------------------------

Example 1:
Input:  4 -> 5 -> 6
Output: 4 -> 5 -> 7
Explanation: 456 + 1 = 457

Example 2:
Input:  1 -> 2 -> 3
Output: 1 -> 2 -> 4
Explanation: 123 + 1 = 124

-------------------------------------------------------------

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
-------------------------------------------------------------
-------------------------------------------------------------
*/
class Node{
    int data;
    Node next;
    Node(int x){
        data = x;
        next = null;
    }
}


    class Add_1_to_a_Linked_List_Number {

        // =========================================================
        // APPROACH 1: Iterative (Reverse + Add + Reverse Back)
        // =========================================================
    /*
    Idea:
    1. Reverse the linked list.
    2. Add 1 like normal addition.
    3. Handle carry.
    4. Reverse again to restore order.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

        public Node addOneIterative(Node head) {

            Node newHead = reverse(head);
            Node temp = newHead;

            int carry = 1;   // we are adding 1

            while (temp != null) {
                int sum = temp.data + carry;
                temp.data = sum % 10;
                carry = sum / 10;

                if (carry == 0)
                    break;

                temp = temp.next;
            }

            newHead = reverse(newHead);

            // If carry remains (e.g., 999 + 1 = 1000)
            if (carry != 0) {
                Node newNode = new Node(carry);
                newNode.next = newHead;
                newHead = newNode;
            }

            return newHead;
        }


        // =========================================================
        // APPROACH 2: Recursive (Backtracking Carry)
        // =========================================================
    /*
    Idea:
    - Go to the last node recursively.
    - Return carry while coming back.
    - Update digits.
    - If carry remains at head, create new node.

    Time Complexity: O(n)
    Space Complexity: O(n)  (due to recursion stack)
    */

        public Node addOneRecursive(Node head) {

            int carry = addCarry(head);

            if (carry == 1) {
                Node newNode = new Node(1);
                newNode.next = head;
                return newNode;
            }

            return head;
        }

        private int addCarry(Node head) {

            if (head == null)
                return 1;  // initial carry = 1

            int carry = addCarry(head.next);

            int sum = head.data + carry;
            head.data = sum % 10;

            return sum / 10;
        }


        // Utility function to reverse linked list
        private Node reverse(Node head) {

            Node prev = null;
            Node curr = head;

            while (curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
        }
    }
