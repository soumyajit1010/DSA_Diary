package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.ArrayList_Separate_Even_Odd;/*
Problem:
You are given an ArrayList `list` that contains integers. 
You need to return an ArrayList of two ArrayLists:
- One containing all even numbers.
- The other containing all odd numbers.

Examples:

Input: list = [54, 43, 2, 5, 14, 17, 18, 9]
Output:
54 2 14 18
43 5 17 9

Explanation: Returned a list of lists [[54, 2, 14, 18], [43, 5, 17, 9]], even list first then odd list.

Input: list = [5, 6, 7, 2, 4, 8, 9]
Output:
6 2 4 8
5 7 9

Explanation: Returned a list of lists [[6, 2, 4, 8], [5, 7, 9]]
*/

import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> evenOdd(ArrayList<Integer> list) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        
        for (int num : list) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(even); // even numbers first
        result.add(odd);  // then odd numbers
        return result;
    }
}
