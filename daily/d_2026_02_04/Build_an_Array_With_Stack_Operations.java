package DSA_Diary.daily.d_2026_02_04;

import java.util.ArrayList;
import java.util.List;
/*
Build an Array With Stack Operations

Problem Statement:
You are given an integer array target and an integer n.
You have an empty stack and a stream of integers from 1 to n.

Allowed operations:
1. "Push" – Push the next integer from the stream onto the stack.
2. "Pop"  – Remove the top element from the stack.

Rules:
- Read integers from the stream in increasing order (1 to n).
- If at any moment the stack (from bottom to top) becomes equal to target,
  stop reading further integers and stop performing operations.
- Return the list of operations required to build the target array.

Example:
Input: target = [1,3], n = 3
Output: ["Push","Push","Pop","Push"]

Explanation:
Push 1 → stack = [1]
Push 2 → stack = [1,2]
Pop    → stack = [1]
Push 3 → stack = [1,3]  (target achieved, stop)
*/
public class Build_an_Array_With_Stack_Operations {
    public List<String> buildArray(int[] target, int n) {

        List<String> ls = new ArrayList<>();
        int j=0;

        for(int i=1; i<=n; i++){
            ls.add("Push");

            if(j<target.length && target[j]==i){
                j++;
            }else {
                ls.add("Pop");
            }

            if (j== target.length){
                break;
            }

        }

        return ls;
    }
}
