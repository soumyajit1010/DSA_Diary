package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Average_of_an_ArrayList;// Question:
// You are given an ArrayList `list` that contains integers.
// You need to return the average of the non-negative integers (i.e., integers >= 0).

// Examples:
//
// Input: list = [-12, 8, -7, 6, 12, -9, 14]
// Output: 10.0
// Explanation: The positive numbers are 8, 6, 12, 14. Their sum = 40, count = 4, so average = 40 / 4 = 10.0
//
// Input: list = [1, 2, 3]
// Output: 2.0
// Explanation: Sum = 6, Count = 3, Average = 6 / 3 = 2.0

// User function Template for Java
import java.util.ArrayList;

class Solution {
    // function should calculate and return the
    // average of all the non negative integers
    // from the arraylist provided in the parameter
    public static double posAverage(ArrayList<Integer> list) {
        int sum = 0;
        int count = 0;
        for (int num : list) {
            if (num >= 0) {
                sum += num;
                count++;
            }
        }

        // Avoid division by zero
        if (count == 0) return 0.0;

        return (double) sum / count;
    }
}
