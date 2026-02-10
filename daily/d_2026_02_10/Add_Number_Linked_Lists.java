package DSA_Diary.daily.d_2026_02_10;
/*
Add Number Linked Lists
Difficulty: Medium

You are given the head of two singly linked lists head1 and head2
representing two non-negative integers.

Each node contains a single digit.
The digits are stored in forward order.

Task:
Return the head of the linked list representing the sum of the two numbers.

Notes:
- Input lists may contain leading zeros
- Output list must NOT contain leading zeros
- 1 ≤ Number of nodes ≤ 10^5
- 0 ≤ node.data ≤ 9

------------------------------------------------
Example 1:
Input:
head1 = 1 -> 2 -> 3
head2 = 9 -> 9 -> 9
Output:
1 -> 1 -> 2 -> 2
Explanation:
123 + 999 = 1122

------------------------------------------------
Example 2:
Input:
head1 = 6 -> 3
head2 = 7
Output:
7 -> 0
Explanation:
63 + 7 = 70
*/


class Node {
    public Node prev;
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}


class Add_Number_Linked_Lists {

    // ======================================================
    // WAY 1: Number Conversion Method (NOT RECOMMENDED)
    // ======================================================
    /*
    Approach:
    - Convert linked lists into numbers
    - Add the numbers
    - Convert sum back to linked list

    WARNING:
    - This fails for large inputs due to overflow
    - Use ONLY for learning / small inputs
    */

    public Node addTwoLists_NumberMethod(Node head1, Node head2) {

        long n = 0, m = 0;

        while (head1 != null) {
            n = n * 10 + head1.data;
            head1 = head1.next;
        }

        while (head2 != null) {
            m = m * 10 + head2.data;
            head2 = head2.next;
        }

        long sum = n + m;

        if (sum == 0)
            return new Node(0);

        Node head = null, tail = null;

        while (sum > 0) {
            int digit = (int) (sum % 10);
            Node newNode = new Node(digit);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            sum /= 10;
        }

        // reverse result
        return reverse(head);
    }

    /*
    Time Complexity: O(n + m)
    Space Complexity: O(n + m)
    Limitation: ❌ Overflow for large inputs
    */


    // ======================================================
    // WAY 2: Correct Linked List Digit-by-Digit Method
    // ======================================================
    /*
    Approach:
    - Reverse both linked lists
    - Add digits with carry
    - Build result list
    - Remove leading zeros

    This is the EXPECTED and ACCEPTED approach.
    */

    public Node addTwoLists(Node head1, Node head2) {

        head1 = reverse(head1);
        head2 = reverse(head2);

        Node sum = null;
        int carry = 0;

        while (head1 != null || head2 != null || carry > 0) {

            int newVal = carry;

            if (head1 != null) {
                newVal += head1.data;
                head1 = head1.next;
            }

            if (head2 != null) {
                newVal += head2.data;
                head2 = head2.next;
            }

            carry = newVal / 10;
            newVal %= 10;

            Node newNode = new Node(newVal);
            newNode.next = sum;
            sum = newNode;
        }

        // Remove leading zeros
        while (sum != null && sum.data == 0 && sum.next != null) {
            sum = sum.next;
        }

        return sum;
    }

    /*
    Time Complexity: O(n + m)
    Space Complexity: O(n + m)
    This method works for VERY LARGE numbers.
    */


    // ======================================================
    // Utility: Reverse Linked List
    // ======================================================
    static Node reverse(Node head) {
        Node prev = null, curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

