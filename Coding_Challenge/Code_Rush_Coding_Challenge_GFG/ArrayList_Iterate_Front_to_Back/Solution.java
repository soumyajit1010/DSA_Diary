package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.ArrayList_Iterate_Front_to_Back;/*
Question: ArrayList Iterate Front to Back
Difficulty: Easy

Iterators are used to iterate over Java Collections.
Here we will learn to iterate over an ArrayList `arr` from begin to end.

Examples:
Input: 1 2 3 4 5
Output: 1 2 3 4 5

Input: 1 3 31 2
Output: 1 3 31 2
*/

// User function Template for Java
import java.util.Iterator;

class Solution {

    public static void iterateArrayList(Iterator<Integer> iterator) {
        // Answer:
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        // Just print the elements, don't provide new line
    }
}
