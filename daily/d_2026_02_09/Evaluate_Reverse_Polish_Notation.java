package DSA_Diary.daily.d_2026_02_09;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
 /*
    Q2. Evaluate Reverse Polish Notation

    Given an array of strings tokens representing a Reverse Polish Notation,
    evaluate and return the integer result.

    Operators: +, -, *, /
    Division truncates toward zero.
    */
          /*
    Time Complexity: O(n)
    Space Complexity: O(n)
    */
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());

            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);

            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());

            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();

    }
}
