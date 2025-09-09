package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.PriorityQueue_Inserion_1;/*
PriorityQueue Insertion - 1
Difficulty: Basic    Accuracy: 93.68%    Submissions: 2K+    Points: 1

Given an integer ArrayList arr[], you need to insert the given elements into a PriorityQueue.
Note: PriorityQueue in Java is implemented as a min heap.

Examples:

Input: arr[] = [5, 4, 2, 99, 5, 3]
Output: 2 3 4 5 5 99
Explanation: After inserting given elements in a PQ, they get arranged in a min heap way. 
So when we print it we get in sorted order.

Input: arr[] = [5, 5]
Output: 5 5
Explanation: After inserting given elements in a PQ, they get arranged in a min heap way. 
So when we print it we get in sorted order.
*/

import java.util.*;

class Solution {
    public static PriorityQueue<Integer> insertion(ArrayList<Integer> arr) {
        // Create a min-heap PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Insert each element of the ArrayList into the PriorityQueue
        for (int i : arr) {
            priorityQueue.add(i);
        }

        return priorityQueue;
    }

    // For demonstration purposes (not part of GFG template)
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(5, 4, 2, 99, 5, 3));
        PriorityQueue<Integer> pq = insertion(input);

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
