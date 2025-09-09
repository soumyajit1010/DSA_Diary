package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Get_minimum_element_from_stack_2;/*
📌 Problem: Get Minimum Element from Stack - 2
------------------------------------------------------
Implement a Stack in which you can get the minimum element in O(1) time and O(1) space.

🧾 Input Format:
- The first line contains an integer 'T' denoting the number of test cases.
- For each test case:
  - The first line contains an integer 'Q' representing the number of queries.
  - The second line contains Q space-separated integers representing the queries.

There are 3 types of queries:
1. 1 x → Push 'x' into the stack
2. 2   → Pop element from the stack and print it (or -1 if the stack is empty)
3. 3   → Print the minimum element in the stack (or -1 if the stack is empty)

🧾 Output Format:
- For each query type 2 or 3, output the result on the same line separated by space.

🧪 Constraints:
1 <= T <= 100  
1 <= Q <= 100  
1 <= x <= 100

🧾 Example Input:
1
6
1 2 1 3 2 3 1 1 3

🧾 Example Output:
3 2 1

Explanation:
- push 2 → stack = [2], min = 2
- push 3 → stack = [2, 3], min = 2
- pop → returns 3
- getMin → returns 2
- push 1 → stack = [2, 1], min = 1
- getMin → returns 1
*/

import java.util.Stack;

class GfG {
    int minEle;
    Stack<Integer> s;

    // Constructor to initialize the stack
    GfG() {
        s = new Stack<>();
    }

    // Returns the minimum element from the stack
    int getMin() {
        if (s.isEmpty()) {
            return -1;
        }
        return minEle;
    }

    // Returns the popped element from the stack
    int pop() {
        if (s.isEmpty()) {
            return -1;
        }

        int top = s.pop();

        if (top >= minEle) {
            return top;
        } else {
            // Decoding previous minimum before this encoded value
            int originalMin = minEle;
            minEle = 2 * minEle - top;
            return originalMin;
        }
    }

    // Push element x into the stack
    void push(int x) {
        if (s.isEmpty()) {
            minEle = x;
            s.push(x);
            return;
        }

        if (x >= minEle) {
            s.push(x);
        } else {
            // Push encoded value
            s.push(2 * x - minEle);
            minEle = x;

        }
    }
}
// O(1) time and O(1) space