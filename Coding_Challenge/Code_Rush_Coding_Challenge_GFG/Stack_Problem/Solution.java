package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Stack_Problem;/*
Stack Problem
Difficulty: Easy
Accuracy: 70.5%
Points: 2

Java provides an inbuilt object type called Stack. It is a collection that is based on the last in first out (LIFO) principle.
Try this problem using Stack.

Given n elements of a stack st where the first value is the bottom-most value of the stack and the last one is the element at top of the stack,
delete the middle element of the stack without using any additional data structure.

Example 1:
Input: n = 5
st = {1, 2, 3, 4, 5}
Output: 5 4 2 1
Explanation: The middle element is 3. If it is deleted and then the values are seen from top, this will be the order.

Example 2:
Input: n = 6
st = {1, 4, 9, 2, 6, 5}
Output: 5 6 2 4 1
Explanation: The middle element is 9 and if it is deleted this will be the stack traversal.

Your Task:
You do not need to read input or print anything.
Your task is to complete the function deleteMid() which takes n and st as input parameters and returns a stack where the middle element is deleted.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
*/

import java.util.Stack;

class Solution {

    // ------------------- Solution 1: Without Recursion (Using remove()) -------------------
    // Time Complexity: O(n) because remove(index) shifts elements internally in Vector.
    // Space Complexity: O(1) extra space.
    static Stack<Integer> deleteMidWithoutRecursion(int n, Stack<Integer> st) {
        int midIndex = (n - 1) / 2; // middle element index (0-based)
        st.remove(midIndex);
        return st;
    }

    // ------------------- Solution 2: With Recursion -------------------
    // Time Complexity: O(n) because each element is pushed and popped once.
    // Space Complexity: O(n) due to recursion call stack.
    static Stack<Integer> deleteMidWithRecursion(int n, Stack<Integer> st) {
        int midIndex = (n - 1) / 2;
        deleteMidUtil(st, midIndex);
        return st;
    }

    // Helper for recursion
    private static void deleteMidUtil(Stack<Integer> st, int midIndex) {
        if (midIndex == 0) {
            st.pop();
            return;
        }
        int top = st.pop();
        deleteMidUtil(st, midIndex - 1);
        st.push(top);
    }

    // ------------------- Driver code example -------------------
    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<>();
        st1.add(1); st1.add(2); st1.add(3); st1.add(4); st1.add(5);

        System.out.println("Without Recursion Output: " + deleteMidWithoutRecursion(st1.size(), st1));

        Stack<Integer> st2 = new Stack<>();
        st2.add(1); st2.add(4); st2.add(9); st2.add(2); st2.add(6); st2.add(5);

        System.out.println("With Recursion Output: " + deleteMidWithRecursion(st2.size(), st2));
    }
}
