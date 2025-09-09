package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.PriorityQueue_Inserion_2;/*
🧩 Problem: PriorityQueue Insertion - 2 (Max-Heap)
---------------------------------------------------
Given an integer ArrayList `arr`, insert the elements into a `PriorityQueue`
such that they follow **max-heap** order.

Note:
- By default, Java's PriorityQueue is a **min-heap**.
- You need to **customize** it as a **max-heap**.

✏️ Examples:

Input: arr = [5, 4, 2, 99, 5, 3]
Output: 99 5 5 4 3 2

Input: arr = [5, 5]
Output: 5 5
*/

import java.util.*;

class Solution {
    public static PriorityQueue<Integer> insertion(ArrayList<Integer> arr) {
        // Custom comparator for max-heap (larger elements come first)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements from ArrayList to max-heap
        for (int num : arr) {
            priorityQueue.add(num);
        }

        return priorityQueue;
    }

    // Example usage (not needed for GFG submission)
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 4, 2, 99, 5, 3));
        PriorityQueue<Integer> pq = insertion(arr);

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        // Output: 99 5 5 4 3 2
    }
}

/*
🕒 Time Complexity: O(n log n)
   - Each insertion into the PriorityQueue takes O(log n)
   - n elements = O(n log n)

🧠 Space Complexity: O(n)
   - For storing n elements in the PriorityQueue
*/
