package DSA_Diary.daily.d_2026_03_04;/*
Pair Sum in Doubly Linked List

Difficulty: Easy
Accuracy: 66.01%
Points: 2

Problem:
Given a sorted doubly linked list of positive distinct elements, 
the task is to find pairs in the doubly linked list whose sum is 
equal to a given target value.

Example 1:
Input:
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7

Output:
(1,6), (2,5)

Explanation:
There are two pairs whose sum is equal to 7.

Example 2:
Input:
1 <-> 5 <-> 6
target = 6

Output:
(1,5)

Explanation:
There is one pair whose sum is equal to 6.

Approach:
Since the list is sorted, we can use the two-pointer technique.
1. One pointer starts from the head.
2. Another pointer starts from the tail.
3. Move pointers based on the sum comparison.

Time Complexity: O(N)
Space Complexity: O(1) (excluding result storage)
*/

import java.util.ArrayList;

class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

class Pair_Sum_in_Doubly_Linked_List
{

    // Function to find tail of DLL
    Node findTail(Node head) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (head == null) return ans;

        Node left = head;
        Node right = findTail(head);

        while (left.data < right.data) {

            int sum = left.data + right.data;

            if (sum == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                ans.add(pair);

                left = left.next;
                right = right.prev;
            }
            else if (sum < target) {
                left = left.next;
            }
            else {
                right = right.prev;
            }
        }

        return ans;
    }
}